package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Tile {
	private final Vector2 position;
	
	public Tile(float x, float y) {
		this.position = new Vector2(x, y);
	}
	
	public Vector2 getPosition() {
		return this.position;
	}
	
	public void setPosition(float x, float y) {
		this.position.set(x, y);
	}
}
