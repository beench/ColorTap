package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends ScreenAdapter {
	private ColorTap colortapGame;
    private Texture pinkImg;
    private Texture bgImg;
    private Texture blueImg;
    private Texture greenImg;
    private int score;

	public GameScreen(ColorTap colortapGame) {
        this.colortapGame = colortapGame;
        pinkImg = new Texture("pink.jpg");
        blueImg = new Texture("blue.jpg");
        greenImg = new Texture("green.jpg");
        bgImg = new Texture("bg.jpg");
    }
	
	@Override
    public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = colortapGame.batch;
        update(delta);
        batch.begin();
        batch.draw(bgImg, 0, 0);
        Vector2 pospink = colortapGame.getPositionPink();
        batch.draw(pinkImg, pospink.x, pospink.y);
        Vector2 posblue = colortapGame.getPositionBlue();
        batch.draw(blueImg, posblue.x, posblue.y);
        Vector2 posgreen = colortapGame.getPositionGreen();
        batch.draw(greenImg, posgreen.x, posgreen.y);
        batch.end();
	}
	
	private void update(float delta) {
		colortapGame.movePink();
		colortapGame.moveBlue();
		colortapGame.moveGreen();
        if(colortapGame.getPositionPink().y <= 90 && Gdx.input.isKeyPressed(Keys.LEFT)) {
        	score += 2;
        }
        if(colortapGame.getPositionBlue().y <= 90 && Gdx.input.isKeyPressed(Keys.DOWN)) {
        	score += 2;
        }
        if(colortapGame.getPositionGreen().y <= 90 && Gdx.input.isKeyPressed(Keys.RIGHT)) {
        	score += 2;
        }
    }
}
