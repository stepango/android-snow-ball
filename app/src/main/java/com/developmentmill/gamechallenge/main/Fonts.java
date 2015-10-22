package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.graphics.BitmapFont;
import com.badlogic.gdx.graphics.Sprite;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class Fonts {

	public static BitmapFont font;

	public static void init() {
		Sprite sprite = new Sprite(Gdx.graphics.newTexture(Gdx.files
				.getFileHandle("fonts/snowfont.png", FileType.Internal),
				TextureFilter.MipMap, TextureFilter.Linear,
				TextureWrap.ClampToEdge, TextureWrap.ClampToEdge));
		font = new BitmapFont(Gdx.files.getFileHandle("fonts/snowfont.fnt",
				FileType.Internal), sprite, false);
	}
	
	public static void dispose() {
		font.dispose();
		font = null;
	}
}
