package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ColorTap extends Game {
	public SpriteBatch batch;
	Texture img;
	private int ypink;
	private int yblue;
	private int ygreen;
	private Vector2 positionPink;
	private Vector2 positionBlue;
	private Vector2 positionGreen;
	
	public ColorTap() {
		positionPink = new Vector2(6,850);
		positionBlue = new Vector2(226,850);
		positionGreen = new Vector2(445,850);
	}
	
	public Vector2 getPositionPink() {
		return positionPink;
	}
	
	public Vector2 getPositionBlue() {
		return positionBlue;
	}
	
	public Vector2 getPositionGreen() {
		return positionGreen;
	}
	
	public void movePink() {
		positionPink.y -= 4;
	}
	public void moveBlue() {
		positionBlue.y -= 4;
	}
	public void moveGreen() {
		positionGreen.y -= 4;
	}
 
    @Override
    public void create () {
        batch = new SpriteBatch();
        setScreen(new GameScreen(this));
    }
 
    @Override
    public void render () {
        super.render();
    }
 
    @Override
    public void dispose () {
        batch.dispose();
    }
}