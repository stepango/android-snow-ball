package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.Texture.TextureWrap;
import com.badlogic.gdx.graphics.BitmapFont;
import com.badlogic.gdx.graphics.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

/**
 * The game over screen displays the final score and a game over text and waits for the user to touch the screen in which case it
 * will signal that it is done to the orchestrating GdxInvaders class.
 * 
 * @author mzechner
 * 
 */
public class GameOver implements Screen {
        /** the SpriteBatch used to draw the background, logo and text **/
        private final SpriteBatch spriteBatch;
        /** the background texture **/
        private final Texture background;
        /** the logo texture **/
        private final Texture logo;
        /** the font **/
        private final BitmapFont font;
        /** is done flag **/
        private boolean isDone = false;
        /** view & transform matrix **/
        private final Matrix4 viewMatrix = new Matrix4();
        private final Matrix4 transformMatrix = new Matrix4();

        public GameOver (Application app) {
                spriteBatch = new SpriteBatch();
                background = app.getGraphics().newTexture(app.getFiles().getFileHandle("data/games.png", FileType.Internal),
                        TextureFilter.Linear, TextureFilter.Linear, TextureWrap.ClampToEdge, TextureWrap.ClampToEdge);

                logo = app.getGraphics().newTexture(app.getFiles().getFileHandle("data/title.png", FileType.Internal),
                        TextureFilter.Linear, TextureFilter.Linear, TextureWrap.ClampToEdge, TextureWrap.ClampToEdge);

                font = new BitmapFont(Gdx.files.internal("data/font16.fnt"), Gdx.files.internal("data/font16.png"), false);
        }

        @Override public void dispose () {
                spriteBatch.dispose();
                background.dispose();
                logo.dispose();
                font.dispose();
        }

        @Override public boolean isDone () {
                return isDone;
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
                spriteBatch.draw(logo, 0, 320-128, 480, 128, 0, 256, 512, 256, Color.WHITE, false, false);
                String text = "It is the end my friend.\nTouch to continue!";
                TextBounds bounds = font.getMultiLineBounds(text);
                spriteBatch.setBlendFunction(GL10.GL_ONE, GL10.GL_ONE_MINUS_SRC_ALPHA);
                font.drawMultiLine(spriteBatch, text, 0, 160 + bounds.height / 2, 480, HAlignment.CENTER);              
                spriteBatch.end();
        }

        @Override public void update (Application app) {
                isDone = app.getInput().isTouched();
        }

}
