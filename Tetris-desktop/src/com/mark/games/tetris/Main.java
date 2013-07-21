package com.mark.games.tetris;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Tetris";
		cfg.useGL20 = false;
		cfg.width = 350;
		cfg.height = 490;
		//testing
		
		new LwjglApplication(new Tetris(), cfg);
	}
}
