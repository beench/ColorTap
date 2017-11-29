package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GameScreen extends ScreenAdapter {
	private ColorTap colortapGame;
    private Texture pinkImg;
    private Texture bgImg;
    private Texture blueImg;
    private Texture greenImg;
    private int ypink;

	public GameScreen(ColorTap colortapGame) {
        this.colortapGame = colortapGame;
        pinkImg = new Texture("pink.jpg");
        blueImg = new Texture("blue.jpg");
        greenImg = new Texture("green.jpg");
        bgImg = new Texture("bg.jpg");
        ypink = 850;
    }
	
	@Override
    public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        System.out.println("Hello " + delta);
        SpriteBatch batch = colortapGame.batch;
        update(delta);
        batch.begin();
        batch.draw(pinkImg, 5, ypink);
        batch.end();
	}
	
	private void update(float delta) {
        ypink -= 5;    
    }
}
