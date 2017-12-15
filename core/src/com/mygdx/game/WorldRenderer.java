package com.mygdx.game;

import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	
	private ColorTapGame colortapgame;
	private World world;
	private SpriteBatch batch;
	private Texture pinkImg;
    private Texture bgImg;
    private Texture blueImg;
    private Texture greenImg;
    private BitmapFont font;
    private Texture gameOverImg;
    private BitmapFont gameOverScore;
    
	public WorldRenderer(ColorTapGame colortapgame, World world) {
        this.colortapgame = colortapgame;
 
        this.world = world;
        world = new World();
        
        pinkImg = new Texture("pink.jpg");
        blueImg = new Texture("blue.jpg");
        greenImg = new Texture("green.jpg");
        bgImg = new Texture("bg.jpg");
        gameOverImg = new Texture("GameOver.png");
        font = new BitmapFont();
        font.getData().setScale(2);
        gameOverScore = new BitmapFont();
        gameOverScore.getData().setScale(2);
        gameOverScore.setColor(Color.BLACK);
    }
	
	public void render(float delta) {
		SpriteBatch batch = colortapgame.batch;
        batch.begin();
        batch.draw(bgImg, 0, 0);
        
        if (world.statusGame == 1) {

        	List<Tile> list = world.getPinkTileList();
        	for (int i = 0; i < list.size(); i++) {
        		Tile tile = list.get(i);
        		batch.draw(pinkImg, tile.getPosition().x, tile.getPosition().y);
        	}
        
        	list = world.getBlueTileList();
        	for (int i = 0; i < list.size(); i++) {
        		Tile tile = list.get(i);
        		batch.draw(blueImg, tile.getPosition().x, tile.getPosition().y);
        	}
        
        	list = world.getGreenTileList();
        	for (int i = 0; i < list.size(); i++) {
        		Tile tile = list.get(i);
        		batch.draw(greenImg, tile.getPosition().x, tile.getPosition().y);
        	}
        }
        else {
        	batch.draw(gameOverImg, 0, 255, 660, 420);
        	gameOverScore.draw(batch, "SCORE: " + world.getScore(), 260, 300);
        }
        
        font.draw(batch, "" + world.getScore(), 600, 830);
        batch.end();
	}
}
