package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.graphics.BitmapFont;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Score extends Actor {

	private BitmapFont font;
	public float score;

	public Score() {
		super("score");
//		Sprite sprite = new Sprite(Gdx.graphics.newTexture(Gdx.files
//				.getFileHandle("fonts/snowfont.png", FileType.Internal),
//				TextureFilter.MipMap, TextureFilter.Linear,
//				TextureWrap.ClampToEdge, TextureWrap.ClampToEdge));
//		font = new BitmapFont(Gdx.files.getFileHandle("fonts/snowfont.fnt",
//				FileType.Internal), sprite, false);
		font = Fonts.font;
	}

	@Override
	public Actor hit(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void render(SpriteBatch arg0) {
		font.draw(arg0, "Score: " + Math.round(score), 240, 320);

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
