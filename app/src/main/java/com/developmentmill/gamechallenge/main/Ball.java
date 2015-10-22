package com.developmentmill.gamechallenge.main;

import android.graphics.Point;
import android.location.Address;
import android.util.Log;

import com.badlogic.gdx.graphics.Sprite;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by IntelliJ IDEA. User: minzdrav Date: 05.01.11 Time: 12:07 To change
 * this template use File | Settings | File Templates.
 */
public class Ball extends Actor {

	private final float radius = 2;
	private Point coordinate;
	private Body ballBody;
	private Sprite ballSprite;
	Vector2 zero = new Vector2(0f, 0f);
	private final float pixelsInMeter = Level.PIXELS_IN_METER;
	private Target target;

	public void applyLinearImpulse(Vector2 impulse) {
		ballBody.applyLinearImpulse(impulse, zero);
	}

	public Ball(String name, Sprite sprite, Body body) {
		super(name);
		ballBody = body;
		ballSprite = sprite;
		width = ballSprite.getWidth();
		height = ballSprite.getHeight();
	}

	@Override
	public Actor hit(float arg0, float arg1) {
		return null;
	}

	@Override
	protected void render(SpriteBatch spriteBatch) {
		x = (ballBody.getPosition().x - radius) * pixelsInMeter;
		y = (ballBody.getPosition().y - radius) * pixelsInMeter;
		ballSprite.setPosition(x, y);
		ballSprite.setRotation(ballBody.getAngle());
		ballSprite.draw(spriteBatch);

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

	public void setTarget(Target target) {
		this.target = target;
	}

	public double distanceToTarget() {
		if (target == null) {
			return -1;
		} else {
			double x = Math.pow(Math.abs(ballBody.getPosition().x * 10
					- (target.x + target.width / 2)), 2);
			double y = Math.pow(Math.abs(ballBody.getPosition().y * 10
					- (target.y + target.height / 2)), 2);
			return Math.sqrt(x + y);
		}
	}
}
