package com.mark.games.tetris;

import com.badlogic.gdx.math.Vector2;

public class Block {
	
	int size;
	Vector2 position;
	
	public Block(Vector2 position, int size) {
		this.size = size;
		this.position = position;
	}
}