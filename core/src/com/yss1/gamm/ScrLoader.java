package com.yss1.gamm;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by ys on 05.02.2017.
 */

public class ScrLoader implements Screen {
    private Yss1Game game;
    private Table table;
    private Label.LabelStyle labelStyle;
    private Stage stage;
    private Label label;

    public ScrLoader(Game gam)
    {
        game=(Yss1Game)gam;
        game.manager.load("images/all.pack", TextureAtlas.class);

        stage = new Stage(new ScreenViewport());

        //stage.addActor(game.background);

        //game.getHandler().showAds(false);

        labelStyle = new Label.LabelStyle();
        labelStyle.font = game.yss_font;
        table = new Table();
        table.setFillParent(true);
        label = new Label(  "Loading..." , labelStyle);

        table.add(label);
        stage.addActor(table);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();

        if (game.manager.update()) {
            game.scrMenu=new ScrMenu(game);
            game.setScreen(game.scrMenu);
            dispose();
        }
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
        stage.dispose();
    }
}
