package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.ColorTapGame;
import com.mygdx.game.World;

public class DesktopLauncher {
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 660;
        config.height = 850;
		new LwjglApplication(new ColorTapGame(), config);
	}
}

