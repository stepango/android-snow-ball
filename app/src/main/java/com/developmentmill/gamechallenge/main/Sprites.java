package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.graphics.Sprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;

public class Sprites {

	private Texture texture;
	private Sprite ball, wall1, wall2, wall3, background, target, gremlin;

	public void init(){
		if (texture == null)
			initTexture();
	}
	
	public Sprite getBall() {
		if (texture == null)
			initTexture();
		return new Sprite(texture, 1, 321, 40, 40);
	}

	private void initTexture() {
		texture = Gdx.graphics.newTexture(Gdx.files.getFileHandle(
				"data/games.png", FileType.Internal), TextureFilter.MipMap,
				TextureFilter.Linear, TextureWrap.ClampToEdge,
				TextureWrap.ClampToEdge);
	}

	public Sprite getBackGround() {
		if (texture == null)
			initTexture();
		return background = new Sprite(texture, 0, 0, 480, 320);
	}

	public Sprite getWall1() {
		if (texture == null)
			initTexture();
		return wall1 = new Sprite(texture, 130, 322, 10, 10);
	}

	public Sprite getWall2() {
		if (texture == null)
			initTexture();
		return wall2 = new Sprite(texture, 145, 322, 20, 20);
	}

	public Sprite getWall3() {
		if (texture == null)
			initTexture();
		return wall3 = new Sprite(texture, 170, 322, 30, 30);
	}
	
	public Sprite getTarget() {
		if (texture == null)
			initTexture();
		return target = new Sprite(texture, 45, 320, 85, 85);
	}
	
	public Sprite getGremlin() {
		if (texture == null)
			initTexture();
		//return gremlin = new Sprite(texture, 145, 322, 20, 20);
		return gremlin = new Sprite(texture, 200, 322, 50, 50);
	}
	
	public void dispose(){
		texture.dispose();
		texture = null;
		ball = null;
		wall1 = null;
		wall2 = null;
		wall3 = null;
		background = null;
		target = null;
		gremlin = null;
	}

}
