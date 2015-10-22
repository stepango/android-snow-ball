package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class Box2dObjectsFactory {

	World world;

	public Box2dObjectsFactory(World world) {
		this.world = world;
	}

	public void createRightWall() {
		createWall(new Vector2(48f, 0f), new Vector2(48f, 32f));
	}

	public void createLeftWall() {
		createWall(new Vector2(0f, 0f), new Vector2(0f, 32f));
	}

	public void createUpWall() {
		createWall(new Vector2(0f, 32f), new Vector2(48f, 32f));
	}

	public void createDownWall() {
		createWall(new Vector2(0f, 0f), new Vector2(48f, 0f));
	}

	private void createWall(Vector2 start, Vector2 finish) {
		PolygonShape shape = new PolygonShape();
		shape.setAsEdge(start, finish);

		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.friction = 0.3f;
		fd.restitution = 0.6f;

		BodyDef bd = new BodyDef();
		Body ground = world.createBody(bd);
		ground.createFixture(fd);
		shape.dispose();
	}

	public Body createCircle(float x, float y, float radius, float mass) {
		CircleShape shape = new CircleShape();
		shape.setRadius(radius);

		BodyDef def = new BodyDef();
		def.position.y = y;
		def.position.x = x;
		def.angle = (float) Math.toRadians(90);
		def.type = BodyType.DynamicBody;
		def.angularDamping = 0.7f;
		def.inertiaScale = 0.5f;

		Body ball = world.createBody(def);
		MassData massData = new MassData();
		massData.mass = mass;
		ball.setMassData(massData);
		ball.createFixture(shape, 1);

		shape.dispose();
		return ball;
	}

	public Body createStaticBox(float x, float y, float width, float height) {
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width / 2, height / 2);

		BodyDef def = new BodyDef();
		def.position.y = y;
		def.position.x = x;
		def.angle = (float) Math.toRadians(90);
		def.type = BodyType.StaticBody;

		Body box = world.createBody(def);
		box.createFixture(shape, 1);

		shape.dispose();
		return box;
	}
	
	public Body createStaticRestitutionBox(float x, float y, float width, float height) {
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width / 2, height / 2);

		BodyDef def = new BodyDef();
		def.position.y = y;
		def.position.x = x;
		def.angle = (float) Math.toRadians(90);
		def.type = BodyType.StaticBody;
		FixtureDef fd = new FixtureDef();
		fd.shape = shape;
		fd.friction = 0.3f;
		fd.restitution = 0.6f;

		Body box = world.createBody(def);
		box.createFixture(fd);

		shape.dispose();
		return box;
	}

}
