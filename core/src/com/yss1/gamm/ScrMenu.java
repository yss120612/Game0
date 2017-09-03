package com.yss1.gamm;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by a0804 on 11.10.2016.
 */

public class ScrMenu implements Screen {
    private Yss1Game game;
    private Stage stage;
    private Table table;
    private TextButton bG,bE,bS;
    private Skin bSkin;
    //private TextButton.TextButtonStyle tbs;
    TextureAtlas buttonAtlas;
    public ScrMenu(Game gam)
    {
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        table=new Table();
        //table.setDebug(true);
        table.row().pad(20); // Новая строка + отступы
        table.center();
        table.setFillParent(true);

        game=(Yss1Game)gam;
        bSkin = new Skin();


        buttonAtlas = game.manager.get("images/all.pack", TextureAtlas.class);

        bSkin.addRegions(buttonAtlas);
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = this.game.yss_font;
        textButtonStyle.up = bSkin.getDrawable("button-up");
        textButtonStyle.down = bSkin.getDrawable("button-down");
        //textButtonStyle.checked = bSkin.getDrawable("button-up");
        textButtonStyle.pressedOffsetX= 1;
        textButtonStyle.pressedOffsetY=-1;
        TextField.TextFieldStyle tfs= new TextField.TextFieldStyle();
        tfs.font=((Yss1Game) game).yss_font;
        tfs.fontColor= Color.CORAL;

        Label.LabelStyle labelStyle = new Label.LabelStyle();
        labelStyle.font = ((Yss1Game) game).yss_font;
        table.add(new Label("Height="+ Gdx.graphics.getHeight()+" Width="+Gdx.graphics.getWidth(),labelStyle));
        table.row();
        table.add(new TextField("["+Gdx.graphics.getGLVersion()+"]",tfs));
        table.row();
        table.debug();
        bE = new TextButton("Exit", textButtonStyle);
        bE.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                Gdx.app.exit();
            }
        });
        bG = new TextButton("Play", textButtonStyle);
        bG.addListener(new ClickListener() {
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    //Gdx.app.exit();
                    //game.scrGame=new ScrMenu(game);
                    game.setScreen(game.scrGame);
                    dispose();
                }
        });
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.input.vibrate(20);
//                return true;
//            };
//            @Override
//            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
//                Gdx.app.exit();
//                dispose();
//            }

        //bG.setTouchable(Touchable.enabled);
        table.add(bG);
        table.add(bE);
        stage.addActor(table);
    }

    @Override
    public void show() {
        
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
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
    stage.dispose();
        bSkin.dispose();
        buttonAtlas.dispose();
    }
}
