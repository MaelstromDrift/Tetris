package com.mark.games.tetris;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class World {
	
	static Grid grid;
	ArrayList<Piece> pieces;
	int currentPiece;
	float tickTime = 1.0f; //update rate in seconds
	float tempTick;
	long nano = System.nanoTime();
	static Random ran;
	
	int state = 0;
	
	final static int PLAYING = 0;
	final static int PAUSED = 1;
	final static int GAMEOVER = 2;
	
	public World() {
		ran  = new Random();
		pieces = new ArrayList<Piece>();
		grid = new Grid(new Vector2(10, 15));
		pieces.add(new Piece(new Vector2(4, 13), ran.nextInt(7)));
		currentPiece = 0;
	}
	
	public void updatePieces() {
		if(state == PLAYING) {
			if(((float)(System.nanoTime() - nano) / 1000000000) >= tickTime) {
				nano = System.nanoTime();
				
				for(int i = 0; i < pieces.size(); i++) {
					pieces.get(i).update();
				}
			}
		}
	}
	
	public boolean checkFilled(int y) {
		for(int i = 0; i < 10; i++) {
			if(grid.isFilled(i, y)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public void newPiece() {
		pieces.add(new Piece(new Vector2(4,14), ran.nextInt(7)));
		currentPiece = pieces.size()-1;	
	}
	
	public void movePiece(int direction) {
		switch (direction) {
		case Keys.LEFT:
			pieces.get(currentPiece).moveLeft();
			break;
		case Keys.RIGHT:
			pieces.get(currentPiece).moveRight();
			break;
		}
	}
	
	public void checkFilled() {
		for(int y = 0; y < 14; y++) {
			if(grid.rowFilled(y)) {
				clearLine(y);
				y--;
			}
		}
	}
	
	public void moveDown(int y) {
		for(int i = 0; i < pieces.size(); i++) {
			for(int j = pieces.get(i).blocks.get(pieces.get(i).rotState).size() - 1; j >= 0; j--) {
				if(pieces.get(i).blocks.get(pieces.get(i).rotState).get(j).position.y > y) {
					grid.setEmpty((int)pieces.get(i).blocks.get(pieces.get(i).rotState).get(j).position.x,(int) pieces.get(i).blocks.get(pieces.get(i).rotState).get(j).position.y);
					pieces.get(i).blocks.get(pieces.get(i).rotState).get(j).position.y--;
					grid.setFilled((int)pieces.get(i).blocks.get(pieces.get(i).rotState).get(j).position.x,(int) pieces.get(i).blocks.get(pieces.get(i).rotState).get(j).position.y);
				}
			}
		}
	}
	
	public void clearLine(int y) {
		for(int i = 0; i < pieces.size(); i++) {
			for(int j = pieces.get(i).blocks.get(pieces.get(i).rotState).size() - 1; j >= 0; j--) {
				if(pieces.get(i).blocks.get(pieces.get(i).rotState).get(j).position.y == y && pieces.get(i).state == Piece.PIECE_STOPPED) {
					grid.setEmpty((int)pieces.get(i).blocks.get(pieces.get(i).rotState).get(j).position.x,(int)pieces.get(i).blocks.get(pieces.get(i).rotState).get(j).position.y);
					pieces.get(i).blocks.get(pieces.get(i).rotState).remove(j);
				}
			}
		}
		moveDown(y);
	}
}