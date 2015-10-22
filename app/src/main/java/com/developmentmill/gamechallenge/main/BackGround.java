package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.graphics.Sprite;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BackGround extends Actor{

	Sprite sprite;
	
	public BackGround(Sprite sprite) {
		super("background");
		this.sprite = sprite;
	}

	@Override
	public Actor hit(float arg0, float arg1) {
		return null;
	}

	@Override
	protected void render(SpriteBatch arg0) {
		sprite.draw(arg0);
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
