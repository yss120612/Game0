package com.yss1.gamm;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by a0804 on 11.10.2016.
 */

public class ScrMenu implements Screen {
    private Yss1Game game;
    private TextButton bG;
    private Skin bSkin;
    public ScrMenu(Game game)
    {
        this.game=(Yss1Game)game;
        bSkin=new Skin();
        bG=new TextButton("Huuu",bSkin);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch1.begin();
        game.batch1.draw(game.img1, 0, 0);
        game.batch1.end();
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
