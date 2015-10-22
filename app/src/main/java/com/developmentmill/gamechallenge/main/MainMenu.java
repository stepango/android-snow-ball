package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureRegion;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.BitmapFont;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;

/**
 * The main menu screen showing a background, the logo of the game and a label
 * telling the user to touch the screen to start the game. Waits for the touch
 * and returns isDone() == true when it's done so that the ochestrating
 * GdxInvaders class can switch to the next screen.
 * 
 * @author mzechner
 * 
 */
public class MainMenu implements InputProcessor, Screen {
	/** the SpriteBatch used to draw the background, logo and text **/
	private final SpriteBatch spriteBatch;
	/** the background texture **/
	private final Texture background;
	/** the logo texture **/
	//private final Texture logo;
	/** the font **/
	private final BitmapFont font;
	/** is done flag **/
	private boolean isDone = false;
	/** view & transform matrix **/
	private final Matrix4 viewMatrix = new Matrix4();
	private final Matrix4 transformMatrix = new Matrix4();

	private Stage stage;

	public MainMenu(Application app) {
		spriteBatch = new SpriteBatch();
		background = app.getGraphics().newTexture(app.getFiles().getFileHandle("data/menu.png", FileType.Internal),
                TextureFilter.Linear, TextureFilter.Linear, TextureWrap.ClampToEdge, TextureWrap.ClampToEdge);
		/*logo = app.getGraphics().newTexture(
				app.getFiles().getFileHandle("data/title.png",
						FileType.Internal), TextureFilter.Linear,
				TextureFilter.Linear, TextureWrap.ClampToEdge,
				TextureWrap.ClampToEdge);*/

		font = new BitmapFont(Gdx.files.internal("data/font16.fnt"),
				Gdx.files.internal("data/font16.png"), false);

		stage = new Stage(480, 320, true);
		
		TextureRegion buttonPlayRegion = new TextureRegion(background, 
				314, 376, 157, 56);
		TextureRegion buttonDownPlayRegion = new TextureRegion(background, 
				314, 320, 157, 56);
		Button buttonPlay = new Button("Play", buttonPlayRegion, buttonDownPlayRegion);
		buttonPlay.touchable = true;
		buttonPlay.clickListener = new ClickListener() {
			@Override
			public void clicked(Button button) {
				isDone = true;
			}
		};
		buttonPlay.x = 163;
		buttonPlay.y = 140;
		stage.addActor(buttonPlay);
		
		TextureRegion buttonShareRegion = new TextureRegion(background, 
				0, 376, 157, 56);
		TextureRegion buttonDownShareRegion = new TextureRegion(background, 
				0, 320, 157, 56);
		Button buttonShare = new Button("Share", buttonShareRegion, buttonDownShareRegion);
		buttonShare.touchable = true;
		buttonShare.clickListener = new ClickListener() {
			@Override
			public void clicked(Button button) {
				//isDone = true;
			}
		};
		buttonShare.x = 163;
		buttonShare.y = 80;
		stage.addActor(buttonShare);
		
		TextureRegion buttonAboutRegion = new TextureRegion(background, 
				157, 376, 157, 56);
		TextureRegion buttonDownAboutRegion = new TextureRegion(background, 
				157, 320, 157, 56);
		Button buttonAbout = new Button("About", buttonAboutRegion, buttonDownAboutRegion);
		buttonAbout.touchable = true;
		buttonAbout.clickListener = new ClickListener() {
			@Override
			public void clicked(Button button) {
				//isDone = true;
			}
		};
		buttonAbout.x = 163;
		buttonAbout.y = 20;
		stage.addActor(buttonAbout);
		
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render(Application app) {
		app.getGraphics().getGL10().glClear(GL10.GL_COLOR_BUFFER_BIT);

		viewMatrix.setToOrtho2D(0, 0, 480, 320);
		spriteBatch.setProjectionMatrix(viewMatrix);
		spriteBatch.setTransformMatrix(transformMatrix);
		spriteBatch.begin();
		spriteBatch.disableBlending();
		// spriteBatch.setColor(Color.WHITE);
		spriteBatch.draw(background, 0, 0, 480, 320, 0, 0, 480, 320,
				Color.WHITE, false, false);
		spriteBatch.enableBlending();
		// spriteBatch.draw(logo, 0, 320-128, 480, 128, 0, 0, 512, 256, false,
		// false);
		/*spriteBatch.draw(logo, 0, 320 - 128, 480, 128, 0, 0, 512, 256,
				Color.WHITE, false, false);*/
		spriteBatch.setBlendFunction(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		stage.render();
		spriteBatch.end();
	}

	@Override
	public void update(Application app) {
		//isDone = app.getInput().isTouched();
	}

	@Override
	public boolean isDone() {
		return isDone;
	}

	@Override
	public void dispose() {
		spriteBatch.dispose();
		background.dispose();
		//logo.dispose();
		font.dispose();
	}

	@Override
	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer) {
		stage.touchDown(x, y, pointer);
		return false;
	}

	@Override
	public boolean touchDragged(int arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer) {
		stage.touchUp(x, y, pointer);
		return false;
	}
}