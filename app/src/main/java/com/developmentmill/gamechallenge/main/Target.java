package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.graphics.Sprite;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Target extends Actor {

	Sprite sprite;

	public Target(Sprite sprite, float x, float y) {
		super("target");
		this.sprite = sprite;
		//this.sprite.setBounds(100, 100, 85, 85);
		this.x = x * Level.PIXELS_IN_METER  - 42.5f;//sprite.getX();
		this.y = y * Level.PIXELS_IN_METER  - 42.5f;//sprite.getY();
		this.sprite.setPosition(this.x, this.y);		
		width = sprite.getWidth();
		height = sprite.getHeight();		
	}

	@Override
	public Actor hit(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void render(SpriteBatch arg0) {
		sprite.draw(arg0);
	}

	@Override
	protected boolean touchDown(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean touchDragged(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean touchUp(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

}
