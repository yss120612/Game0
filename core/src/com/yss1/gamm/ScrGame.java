package com.yss1.gamm;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by a0804 on 11.10.2016.
 */

public class ScrGame implements Screen {

    Yss1Game game;
    private Stage stage;

    public ScrGame(Game gam)
    {
      game=(Yss1Game)gam;
    }

    @Override

    public void show() {
stage = new Stage();
        Music music = Gdx.audio.newMusic(Gdx.files.getFileHandle("sounds/dzinn.ogg", Files.FileType.Internal));
        music.setVolume(0.5f);
        music.play();
        music.setLooping(false);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        game.batch1.begin();
//        game.batch1.draw(game.img1, 0, 0);
//        game.batch1.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
