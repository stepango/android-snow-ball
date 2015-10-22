package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.graphics.BitmapFont;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Timer extends Actor {

	private BitmapFont font;
	private long currentTime;
	private Level level;

	public Timer(Level level, long seconds) {
		super("timer");
		this.level = level;
//		Sprite sprite = new Sprite(Gdx.graphics.newTexture(Gdx.files
//				.getFileHandle("fonts/snowfont.png", FileType.Internal),
//				TextureFilter.MipMap, TextureFilter.Linear,
//				TextureWrap.ClampToEdge, TextureWrap.ClampToEdge));
//		font = new BitmapFont(Gdx.files.getFileHandle("fonts/snowfont.fnt",
//				FileType.Internal), sprite, false);
		font = Fonts.font;
		// startTime = System.currentTimeMillis();
		currentTime = System.currentTimeMillis() + seconds * 1000;
	}

	@Override
	public Actor hit(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void render(SpriteBatch arg0) {

		long seconds = (currentTime - System.currentTimeMillis()) / 1000;
		if (seconds <= 0)
			level.finishGame();
		else
			font.draw(arg0, "Time: " + Math.round(seconds), 20, 320);
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
