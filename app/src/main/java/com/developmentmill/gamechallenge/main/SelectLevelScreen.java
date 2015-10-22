package com.developmentmill.gamechallenge.main;

import android.view.ViewDebug.IntToString;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.BitmapFont;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.TextureRegion;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actors.Button;
import com.badlogic.gdx.scenes.scene2d.actors.Button.ClickListener;

public class SelectLevelScreen implements InputProcessor, Screen {

	/** the SpriteBatch used to draw the background, logo and text **/
    private final SpriteBatch spriteBatch;
    /** the background texture **/
    private final Texture background;
    /** the font **/
    private final BitmapFont font;
    /** is done flag **/
    private boolean isDone = false;
    /** view & transform matrix **/
    private final Matrix4 viewMatrix = new Matrix4();
    private final Matrix4 transformMatrix = new Matrix4();
    
    private Stage stage;
    private int selectedLevel = 0;
       
    public int getSelectedLevel() {
    	return selectedLevel;
    }
    
    public SelectLevelScreen (Application app) {
            spriteBatch = new SpriteBatch();
            background = app.getGraphics().newTexture(app.getFiles().getFileHandle("data/level.png", FileType.Internal),
                    TextureFilter.Linear, TextureFilter.Linear, TextureWrap.ClampToEdge, TextureWrap.ClampToEdge);
           

            font = new BitmapFont(Gdx.files.internal("data/font16.fnt"), Gdx.files.internal("data/font16.png"), false);
                              	
            int upXIndex = 0;
            int downXIndex = 98;
            int upYIndex = 320;
            int downYIndex = 369;
            
            int positionX = 30;
            int positionY = 200;
            
        	stage = new Stage(480, 320, true);
        	for (int i = 1; i < 13; i++) {
        		TextureRegion buttonRegion = new TextureRegion(background, upXIndex, upYIndex, 49, 49);
                TextureRegion buttonDownRegion = new TextureRegion(background, downXIndex, downYIndex, 49, 49);   
                upXIndex+=49;
                downXIndex+=49;
                if (upXIndex > 441) {
                	upXIndex =0;
                	upYIndex += 49;
                }
                if (downXIndex > 441) {
                	downXIndex =0;
                	downYIndex += 49;
                }
                
        		String str = Integer.toString(i);
        		Button buttonLevel = new Button(str, buttonRegion, buttonDownRegion);
        		buttonLevel.touchable = true;
        		buttonLevel.clickListener = new ClickListener() {
                    @Override public void clicked(Button button) {
                    	selectedLevel = Integer.parseInt(button.name);                    	
                    }
        		};        		
        		buttonLevel.x = positionX;//(i<7)?(80 * (i - 1)):(80 * (i - 7));
        		buttonLevel.y = positionY;        		//(i<7)?200:100;
        		positionX += 90;
        		if (positionX > 400) {
        			positionX = 30;
        			positionY -= 90;
        		}
        		
        		stage.addActor(buttonLevel);	
        	}
        	Gdx.input.setInputProcessor(this);
    }

    @Override public void render (Application app) {
            app.getGraphics().getGL10().glClear(GL10.GL_COLOR_BUFFER_BIT);

            viewMatrix.setToOrtho2D(0, 0, 480, 320);
            spriteBatch.setProjectionMatrix(viewMatrix);
            spriteBatch.setTransformMatrix(transformMatrix);
            spriteBatch.begin();
            spriteBatch.disableBlending();
            //spriteBatch.setColor(Color.WHITE);              
            spriteBatch.draw(background, 0, 0, 480, 320, 0, 0, 480, 320, Color.WHITE, false, false);
            spriteBatch.enableBlending();
            spriteBatch.setBlendFunction(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);
            /*String text = "Touch screen to start!";
            int width = font.getBounds(text).width; 
            font.draw(spriteBatch, text, 240 - width / 2, 128);*/
            stage.render();
            spriteBatch.end();
    }

    @Override public void update (Application app) {
            //isDone = app.getInput().isTouched();
    }

    @Override public boolean isDone () {
    	if (selectedLevel > 0) {
    		return true;
    	} else
            return false;
    }

    @Override public void dispose () {
            spriteBatch.dispose();
            background.dispose();
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
