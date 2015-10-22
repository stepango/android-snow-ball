package com.developmentmill.gamechallenge;


public class DebugRendererTest {

//	Box2dObjectsFactory factory;
//	
//	Body snowBall;
//	
//	SpriteBatch spriteBatch;
//
//	Sprite backGround, ball;
//
//	Texture texture;
//
//	@Override
//	protected void createWorld(World world) {
//		factory = new Box2dObjectsFactory(world);
//		
//		{
//			factory.createDownWall();
//			factory.createUpWall();
//			factory.createLeftWall();
//			factory.createRightWall();
//		}
//
//		{
//			snowBall = factory.createCircle(0, 10, 2f, 0.5f);
//			factory.createStaticBox(10, 10, 1, 1);
//		}
//
//	}
//
//	@Override
//	protected void applyForce(float delta, Vector2 force) {
//		snowBall.applyLinearImpulse(force, worldVector);
//	}
//
//	@Override
//	public void render() {
//		float x, y;
//		Input input = Gdx.input;
//		x = input.getAccelerometerX();
//		y = input.getAccelerometerY();
//		applyForce(0, new Vector2(y, -x));
//		
//		// update the world with a fixed time step
//		world.step(Gdx.app.getGraphics().getDeltaTime(), 8, 3);
//
//		// clear the screen and setup the projection matrix
//		GL10 gl = Gdx.app.getGraphics().getGL10();
//		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
//		camera.setMatrices();
//
////		spriteBatch.begin();
////		backGround.draw(spriteBatch);
////		ball.setPosition(snowBall.getPosition().x * 10 + 220, snowBall.getPosition().y * 10 - 20);
////		ball.setRotation(snowBall.getAngle());
////		ball.draw(spriteBatch);
////		spriteBatch.end();
//		// backGround.draw(renderer.batch);
//		// render the world using the debug renderer
//		 renderer.render(world);
//		
//	}
//	
//	@Override
//	public void create() {
//		super.create();
//		spriteBatch = new SpriteBatch();
//		texture = Gdx.graphics.newTexture(Gdx.files.getFileHandle(
//				"data/games.png", FileType.Internal), TextureFilter.MipMap,
//				TextureFilter.Linear, TextureWrap.ClampToEdge,
//				TextureWrap.ClampToEdge);
//		backGround = new Sprite(texture, 0, 0, 480, 320);
//		ball = new Sprite(texture, 0, 320, 40, 40);
//	}

}
