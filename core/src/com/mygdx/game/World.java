
package com.mygdx.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class World extends Game {

	private final int FIRST_SPEED = 4;
	private final int SECOND_SPEED = 5;
	private final int THIRD_SPEED = 7;
	private final int FORTH_SPEED = 9;
	
	private int score;
	private int tileSpeed;
	
	int pinkPrevPosition = 850;
	int bluePrevPosition = 850;
	int greenPrevPosition = 850;
	
	private final List<Tile> pinkTileList;
	private final List<Tile> blueTileList;
	private final List<Tile> greenTileList;
	
	public int statusGame;
	
	private final Random random;
	
	public World() {

		score = 0;
		tileSpeed = FIRST_SPEED;
		statusGame = 1;
		
		pinkTileList = new LinkedList<Tile>();
		blueTileList = new LinkedList<Tile>();
		greenTileList = new LinkedList<Tile>();
		
		random = new Random();
		
		for (int i = 0; i < 6; i++) {
			generatePinkTile();
			generateBlueTile();
			generateGreenTile();
		}
	}
	
	public void generatePinkTile() {
		int nextPosition = pinkPrevPosition + (random.nextInt(4) + 2) * 88;
		pinkTileList.add(new Tile(6, nextPosition));
		pinkPrevPosition = nextPosition;
	}
	
	public void generateBlueTile() {
		int nextPosition = bluePrevPosition + (random.nextInt(4) + 2) * 88;
		blueTileList.add(new Tile(226, nextPosition));
		bluePrevPosition = nextPosition;
	}
	
	public void generateGreenTile() {
		int nextPosition = greenPrevPosition + (random.nextInt(4) + 2) * 88;
		greenTileList.add(new Tile(446, nextPosition));
		greenPrevPosition = nextPosition;
	}
	
	public List<Tile> getPinkTileList() {
		return pinkTileList;
	}
	
	public List<Tile> getBlueTileList() {
		return blueTileList;
	}
	
	public List<Tile> getGreenTileList() {
		return greenTileList;
	}
	
	public int getScore() {
		return score;
	}
	
	public void movePink() {
		pinkPrevPosition -= tileSpeed;
		for (int i = 0; i < pinkTileList.size(); i++) {
			Tile tile = pinkTileList.get(i);
			tile.setPosition(tile.getPosition().x, tile.getPosition().y - tileSpeed);
			if (tile.getPosition().y < -50) {
				statusGame = 0;
			}
		}
	}
	public void moveBlue() {
		bluePrevPosition -= tileSpeed;
		for (int i = 0; i < blueTileList.size(); i++) {
			Tile tile = blueTileList.get(i);
			tile.setPosition(tile.getPosition().x, tile.getPosition().y - tileSpeed);
			if (tile.getPosition().y < -50) {
				statusGame = 0;
			}
		}
	}
	public void moveGreen() {
		greenPrevPosition -= tileSpeed;
		for (int i = 0; i < greenTileList.size(); i++) {
			Tile tile = greenTileList.get(i);
			tile.setPosition(tile.getPosition().x, tile.getPosition().y - tileSpeed);
			if (tile.getPosition().y < -50) {
				statusGame = 0;
			}
		}
	}
	
	public void update() {
		movePink();
		moveBlue();
		moveGreen();
		
		if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			Tile tile = pinkTileList.get(0);
			if (tile.getPosition().y <= 50) {
				pinkTileList.remove(tile);
				score += 5;
				generatePinkTile();
			}
			else if (tile.getPosition().y <= 100) {
				pinkTileList.remove(tile);
				score += 2;
				generatePinkTile();
			}
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.DOWN)) {
			Tile tile = blueTileList.get(0);
			if (tile.getPosition().y <= 50) {
				blueTileList.remove(tile);
				score += 5;
				generateBlueTile();
			}
			else if (tile.getPosition().y <= 100) {
				blueTileList.remove(tile);
				score += 2;
				generateBlueTile();
			}
		}
		
		if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			Tile tile = greenTileList.get(0);
			if (tile.getPosition().y <= 50) {
				greenTileList.remove(tile);
				score += 5;
				generateGreenTile();
			}
			if (tile.getPosition().y <= 100) {
				greenTileList.remove(tile);
				score += 2;
				generateGreenTile();
			}
		}
		
		if(score > 100 && score < 300) {
			tileSpeed = SECOND_SPEED;
		}
		if(score > 300 && score < 450) {
			tileSpeed = THIRD_SPEED;
		}
		if(score > 450) {
			tileSpeed = FORTH_SPEED;
		}
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}
 

}