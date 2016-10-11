package com.yss1.gamm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Yss1Game extends Game {
	SpriteBatch batch;
	Texture img1;
	Screen scrMenu,scrGame;
	@Override
	public void create () {
		scrMenu=new ScrMenu(this);
		batch = new SpriteBatch();
		img1 = new Texture("badlogic.jpg");
		setScreen(scrMenu);
	}


	
	@Override
	public void dispose () {
		batch.dispose();
		img1.dispose();
	}
}
