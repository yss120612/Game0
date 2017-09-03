package com.yss1.gamm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Yss1Game extends Game {
	SpriteBatch batch1;
	Texture img1;
	Screen scrMenu,scrGame,scrLoad;
	BitmapFont yss_font;
	public AssetManager manager;
	private static final String FONT_CHARACTERS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯabcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
	@Override
	public void create () {
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Roboto-Regular.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter param = new FreeTypeFontGenerator.FreeTypeFontParameter();
		param.size = Gdx.graphics.getHeight() / 18; // Размер шрифта. Я сделал его исходя из размеров экрана. Правда коряво, но вы сами можете поиграться, как вам угодно.
		param.characters = FONT_CHARACTERS; // Наши символы
		yss_font = generator.generateFont(param); // Генерируем шрифт
		yss_font.setColor(Color.WHITE); // Цвет белый
		generator.dispose(); // Уничтожаем наш генератор за ненадобностью.
		manager=new AssetManager();
		scrLoad=new ScrLoader(this);
		scrGame=new ScrGame(this);
		setScreen(scrLoad);
		batch1 = new SpriteBatch();
		img1 = new Texture("badlogic.jpg");
	}


	
	@Override
	public void dispose () {
		super.dispose();
		manager.dispose();
		batch1.dispose();
		img1.dispose();
	}
}
