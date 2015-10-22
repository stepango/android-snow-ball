package com.developmentmill.gamechallenge.main;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.audio.Music;
import com.developmentmill.gamechallenge.R;

public class GameListener implements ApplicationListener {
    /** flag indicating whether we were initialized already **/
    private boolean isInitialized = false;

    /** the current screen **/
    private Screen screen;

    @Override public void dispose () {

    }

    @Override public void render () {
            Application app = Gdx.app;

            // update the screen
            screen.update(app);

            // render the screen
            screen.render(app);

            // when the screen is done we change to the
            // next screen
            if (screen.isDone()) {
                // dispose the current screen
                screen.dispose();

                // if this screen is a main menu screen we switch to
                // the game loop
                if (screen instanceof MainMenu)
                        screen = new SelectLevelScreen(app);
                else
                if (screen instanceof SelectLevelScreen)
                        screen = new Level(app, R.xml.level1/*);//*/ + ((SelectLevelScreen)screen).getSelectedLevel() - 1);
                else
                // if this screen is a game loop screen we switch to the
                // game over screen
                if (screen instanceof Level)
                        screen = new GameOver(app);
                else
                // if this screen is a game over screen we switch to the
                // main menu screen
                if (screen instanceof GameOver) screen = new MainMenu(app);
        }
    }

    @Override public void resize (int width, int height) {

    }

    @Override public void create () {
            if (!isInitialized) {
                    screen = new MainMenu(Gdx.app);
                    Music music = Gdx.audio.newMusic(Gdx.files.getFileHandle("data/music5.ogg", FileType.Internal));
                    music.setLooping(true);
                    music.play();
                    isInitialized = true;
            }
    }

    @Override
    public void pause() {
            // TODO Auto-generated method stub
            
    }

    @Override
    public void resume() {
            // TODO Auto-generated method stub
            
    }
}