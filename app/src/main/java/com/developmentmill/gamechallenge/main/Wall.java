package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.graphics.Sprite;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

import android.graphics.Point;

/**
 * Created by IntelliJ IDEA. User: minzdrav Date: 05.01.11 Time: 12:07 To change
 * this template use File | Settings | File Templates.
 */
public class Wall extends Actor {

	private Point coordinate;
	private Body wallBody;
	private Sprite wallSprite;
	private float size;

	private final float pixelsInMeter = Level.PIXELS_IN_METER;

	public Wall(String name, Sprite sprite, Body body, float size) {
		super(name);
		this.size = size;
		wallBody = body;
		wallSprite = sprite;
	}

	@Override
	public Actor hit(float arg0, float arg1) {
		return null;
	}

	@Override
	protected void render(SpriteBatch spriteBatch) {
		x = (wallBody.getPosition().x - size / 2) * pixelsInMeter;
		y = (wallBody.getPosition().y - size / 2) * pixelsInMeter;
		wallSprite.setPosition(x, y);
		wallSprite.setRotation(wallBody.getAngle());
		wallSprite.draw(spriteBatch);
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