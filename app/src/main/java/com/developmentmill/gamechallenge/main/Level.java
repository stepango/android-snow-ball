package com.developmentmill.gamechallenge.main;

import java.io.IOException;
import java.util.LinkedList;

import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Level implements Screen { // implements ApplicationListener {

	Box2dObjectsFactory factory;
	Stage stage;
	Ball snowBall;
	Target target;
	Score score;
	LinkedList<Bomb> destroyList;
	int wallsCount, bombsCount, resId;
	boolean isDone = false;
	
	Sprites sprites;

	public static final float PIXELS_IN_METER = 10f;

	// public static final String GREMLINS_GROUP_NAME = "gremlins";
	// public static final String BALLS_GROUP_NAME = "balls";
	// public static final String BONUSES_GROUP_NAME = "bonuses";

	// private Group ballsGroup = new Group(BALLS_GROUP_NAME);
	// private Group gremlinsGroup = new Group(GREMLINS_GROUP_NAME);
	// private Group bonusesGroup = new Group(BONUSES_GROUP_NAME);

	public Vector2 worldVector = new Vector2(0, 0);
	// protected OrthographicCamera camera;
	// protected Box2DDebugRenderer renderer;
	protected World world;

	protected void createWorld(World world) {
		factory = new Box2dObjectsFactory(world);
		{
			factory.createDownWall();
			factory.createUpWall();
			factory.createLeftWall();
			factory.createRightWall();
		}
	}

	// protected abstract void applyForce(float delta, Vector2 force);

	/** temp vector **/
	// protected Vector2 tmp = new Vector2();

	public Level(Application app, int resId) {
		// setup the camera. In Box2D we operate on a
		// meter scale, pixels won't do it. So we use
		// an orthographic camera with a viewport of
		// 48 meters in width and 32 meters in height.
		// We also position the camera so that it
		// looks at (0,16) (that's where the middle of the
		// screen will be located).
		// camera = new OrthographicCamera();
		// camera.setViewport(48, 32);
		// camera.getPosition().set(24, 16, 0);
		//
		// // create the debug renderer
		// renderer = new Box2DDebugRenderer();

		// create the world
		world = new World(worldVector, true);
		Fonts.init();

		// call abstract method to populate the world
		createWorld(world);
		destroyList = new LinkedList<Bomb>();
		world.setContactListener(new MyContactListener());
		// sprites = new Sprites();

		stage = new Stage(480, 320, true);
		sprites = new Sprites();
		stage.addActor(new BackGround(sprites.getBackGround()));
		LevelParser parser = new LevelParser(this);
		try {
			parser.parseXMLFromRes(resId);
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// snowBall = createBall(15f, 15f);
		// stage.addActor(target = new Target(Sprites.getTarget()));
		// snowBall.setTarget(target);
		// stage.addActor(createWall1(20, 20, 1));
		// stage.addActor(createWall1(22, 22, 3));
		// stage.addActor(snowBall);
		stage.addActor(score = new Score());
		stage.addActor(new Timer(this, 60));
	}

	private Ball createBall(float x, float y) {
		return new Ball("snowBall", sprites.getBall(), factory.createCircle(x,
				y, sprites.getBall().getHeight() / PIXELS_IN_METER / 2, 0.5f));
	}

	private Wall createWall1(float x, float y, int size) {
		wallsCount++;
		Sprite sprite = null;
		switch (size) {
		case 1:
			sprite = sprites.getWall1();
			break;
		case 2:
			sprite = sprites.getWall2();
			break;
		case 3:
			sprite = sprites.getWall3();
			break;
		}
		return new Wall("Wall" + wallsCount, sprite, factory.createStaticBox(x,
				y, size, size), size);
	}

	@Override
	public void dispose() {
		// renderer.dispose();
		world.dispose();

		// renderer = null;
		world = null;
		sprites.dispose();
	}

	public void pause() {
//		Sprites.dispose();
		Fonts.dispose();
	}

	public void resume() {
		sprites.init();
		Fonts.init();
	}

	public void resize(int width, int height) {
	}

	@Override
	public void update(Application app) {
	}

	@Override
	public void render(Application app) {
		float x, y;
		Input input = Gdx.input;
		x = input.getAccelerometerX();
		y = input.getAccelerometerY();
		snowBall.applyLinearImpulse(new Vector2(y, -x));

		// update the world with a fixed time step
		world.step(Gdx.app.getGraphics().getDeltaTime(), 6, 3);

		// clear the screen and setup the projection matrix
		// GL10 gl = Gdx.app.getGraphics().getGL10();
		// gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		// camera.setMatrices();
		// renderer.render(world);
		stage.render();
		if (!destroyList.isEmpty()) {
			for (Bomb gremlin : destroyList) {
				world.destroyBody(gremlin.gremlinBody);
				gremlin.remove();
				gremlin = null;
			}
			destroyList.clear();
		}
		double distance = snowBall.distanceToTarget();
		if (distance > 0)
			if (distance < 100) {
				score.score += 1;
			} else if (distance < 50) {
				score.score += 2;
			} else if (distance < 10) {
				score.score += 4;
			}

		Log.i("Distance", "" + distance);
	}

	@Override
	public boolean isDone() {
		return isDone;
	}

	public void addSnowBall(float x, float y) {
		snowBall = createBall(x, y);
		stage.addActor(snowBall);
		if (target != null)
			snowBall.setTarget(target);
	}

	public void addTarget(float x, float y) {
		target = new Target(sprites.getTarget(), x, y);
		stage.addActor(target);
		if (snowBall != null)
			snowBall.setTarget(target);
	}

	public void addWall(float x, float y, int size) {
		stage.addActor(createWall1(x, y, size));
	}

	public void addBomb(float x, float y) {
		bombsCount++;
		stage.addActor(new Bomb("Bomb" + bombsCount, sprites.getGremlin(),
				factory.createStaticRestitutionBox(x, y, 5, 5), destroyList));
	}

	public void finishGame() {
		isDone = true;
	}

}
