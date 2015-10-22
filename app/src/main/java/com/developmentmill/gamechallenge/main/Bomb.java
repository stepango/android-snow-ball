package com.developmentmill.gamechallenge.main;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.LinkedList;

import com.badlogic.gdx.graphics.Sprite;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by IntelliJ IDEA. User: minzdrav Date: 05.01.11 Time: 12:07 To change
 * this template use File | Settings | File Templates.
 */
public class Bomb extends Actor {

	float speed;
	float globalSpeedModifer;
	float localSpeedModifer;
	float currentSpeed;
	LinkedList<Bomb> destroyList;

	private void calculateSpeed() {
		currentSpeed = speed * localSpeedModifer * globalSpeedModifer;
	}

	private Point coordinate;
	Body gremlinBody;
	private Sprite gremlinSprite;

	public Bomb(String name, Sprite sprite, Body body, LinkedList<Bomb> list) {
		super(name);
		gremlinBody = body;
		gremlinBody.setUserData("gremlin");
		gremlinSprite = sprite;
		destroyList = list;
	}

	@Override
	public Actor hit(float arg0, float arg1) {
		return null;
	}

	@Override
	protected void render(SpriteBatch spriteBatch) {
		if (((String) gremlinBody.getUserData()).equals("Dead")) {
			destroyList.add(this);
		} else {
			gremlinSprite.setPosition(gremlinBody.getPosition().x * Level.PIXELS_IN_METER - 25,
					gremlinBody.getPosition().y * Level.PIXELS_IN_METER - 25);
			gremlinSprite.setRotation(gremlinBody.getAngle());
			gremlinSprite.draw(spriteBatch);
		}
	}

	@Override
	protected boolean touchDown(float arg0, float arg1, int arg2) {
		return false;
	}

	@Override
	protected boolean touchDragged(float arg0, float arg1, int arg2) {
		return false;
	}

	@Override
	protected boolean touchUp(float arg0, float arg1, int arg2) {
		return false;
	}
}