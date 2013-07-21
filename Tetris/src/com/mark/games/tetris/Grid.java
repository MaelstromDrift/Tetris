package com.mark.games.tetris;

import com.badlogic.gdx.math.Vector2;

public class Grid {
	Vector2 size;
	int blockSize;
	boolean filled[][];
	
	public Grid(Vector2 size, int blockSize) {
		this.size = size;
		filled = new boolean[10][15];
	}
	
	public boolean isFilled(int x, int y) {
		return filled[x][y];
	}
	
	public void setFilled(int x, int y) {
		filled[x][y] = true;
	}
	public boolean rowFilled(int y) {
		int check = 0;
		for(int i = 0; i < 10; i++) {
			if(filled[i][y]) {
				check++;
			}
		}
		if(check == 10) {
			return true;
		} else {
			return false;
		}
	}
	public void setEmpty(int x, int y) {
		filled[x][y] = false;
	}
	
	public float getRealX(float x) {
		return x * blockSize;
	}
	
	public float getRealY(float y) {
		return y * blockSize;
	}
	public Vector2 getGridPos(float x, float y) {
		return new Vector2(x/blockSize, y/blockSize);
	}
}