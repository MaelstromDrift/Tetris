package com.mark.games.tetris;

import com.badlogic.gdx.math.Vector2;

public class Grid {
	Vector2 size;
	boolean filled[][];
	
	public Grid(Vector2 size) {
		this.size = size;
		filled = new boolean[10][15];
	}
	
	public boolean isFilled(int x, int y) {
		return filled[x][y];
	}
	
	public void setFilled(int x, int y) {
		filled[x][y] = true;
	}
	
	public void setEmpty(int x, int y) {
		filled[x][y] = false;
	}
	
	public boolean rowFilled(int y) {
		for(int i = 0; i < 10; i++) {
			if(!filled[i][y]) {
				return false;
			}
		}
		return true;
	}
}