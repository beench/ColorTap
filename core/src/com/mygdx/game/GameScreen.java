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
	private ColorTapGame colortapgame;
	private World world;
	private WorldRenderer worldRenderer;
    private int score;

	public GameScreen(ColorTapGame colortapgame) {
        world = new World();
        worldRenderer = new WorldRenderer(colortapgame, world);
    }
	
	@Override
    public void render(float delta) {
		update(delta);
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        worldRenderer.render(delta);
	}
	
	private void update(float delta) {
		world.update();
    }
}
