package com.mark.games.tetris;

import com.badlogic.gdx.math.Vector2;

public class Block {
	
	int size;
	String color;
	Vector2 position;
	
	public Block(Vector2 position, int size, String color) {
		this.size = size;
		this.color = color;
		this.position = position;
	}
}