package com.mark.games.tetris;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class Piece {
	ArrayList<ArrayList<Block>> blocks = new ArrayList<ArrayList<Block>>();;
	Vector2 position;
	int type;
	int state;
	
	int rotState = 0;
	int linesCleared = 0;
	
	final static int UP = 0;
	final static int RIGHT = 1;
	final static int DOWN = 2;
	final static int LEFT = 3;
	
	final static int PIECE_MOVING = 0;
	final static int PIECE_STOPPED = 1;
	
	final static int OPIECE = 0;
	final static int LPIECE = 1;
	final static int JPIECE = 2;
	final static int TPIECE = 3;
	final static int SPIECE = 4;
	final static int ZPIECE = 5;
	final static int IPIECE = 6;
	World world;
	public Piece(Vector2 position, int type) {
		
		world = Tetris.world;
		blocks.add(new ArrayList<Block>());
		blocks.add(new ArrayList<Block>());
		blocks.add(new ArrayList<Block>());
		blocks.add(new ArrayList<Block>());
		
		this.position = position;
		this.type = type;
		
		switch(type) {
		case OPIECE:
			//up
			blocks.get(0).add(new Block(new Vector2(position.x - 1,position.y), 35));
			blocks.get(0).add(new Block(new Vector2(position.x,position.y), 35));
			blocks.get(0).add(new Block(new Vector2(position.x - 1,position.y - 1), 35));
			blocks.get(0).add(new Block(new Vector2(position.x,position.y - 1), 35));
			
			//right
			blocks.get(1).add(new Block(new Vector2(position.x - 1,position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x,position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x - 1,position.y - 1), 35));
			blocks.get(1).add(new Block(new Vector2(position.x,position.y - 1), 35));
			
			//down
			blocks.get(2).add(new Block(new Vector2(position.x - 1,position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x,position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x - 1,position.y - 1), 35));
			blocks.get(2).add(new Block(new Vector2(position.x,position.y - 1), 35));
			
			//left
			blocks.get(3).add(new Block(new Vector2(position.x - 1,position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x,position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x - 1,position.y - 1), 35));
			blocks.get(3).add(new Block(new Vector2(position.x,position.y - 1), 35));
			break;
		case IPIECE:
			//up
			blocks.get(0).add(new Block(new Vector2(position.x,position.y), 35));
			blocks.get(0).add(new Block(new Vector2(position.x,position.y - 1), 35));
			blocks.get(0).add(new Block(new Vector2(position.x,position.y - 2), 35));
			blocks.get(0).add(new Block(new Vector2(position.x,position.y - 3), 35));
			
			//right
			blocks.get(1).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x + 2, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x + 1, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x, position.y), 35));
			
			//down
			blocks.get(2).add(new Block(new Vector2(position.x,position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x,position.y - 1), 35));
			blocks.get(2).add(new Block(new Vector2(position.x,position.y - 2), 35));
			blocks.get(2).add(new Block(new Vector2(position.x,position.y - 3), 35));
			
			//left
			blocks.get(3).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x + 2, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x + 1, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x, position.y), 35));
			break;
		case JPIECE:
			//up
			blocks.get(0).add(new Block(new Vector2(position.x - 1, position.y - 2), 35));
			blocks.get(0).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(0).add(new Block(new Vector2(position.x, position.y - 1), 35));
			blocks.get(0).add(new Block(new Vector2(position.x, position.y - 2), 35));
			//right
			blocks.get(1).add(new Block(new Vector2(position.x - 1, position.y + 1), 35));
			blocks.get(1).add(new Block(new Vector2(position.x + 1, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x - 1, position.y), 35));
			
			//down
			blocks.get(2).add(new Block(new Vector2(position.x, position.y + 1), 35));
			blocks.get(2).add(new Block(new Vector2(position.x + 1, position.y + 1), 35));
			blocks.get(2).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x, position.y - 1), 35));
			
			//left
			blocks.get(3).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x + 1, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x + 1, position.y - 1), 35));
			break; 
		case LPIECE:
			//up
			blocks.get(0).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(0).add(new Block(new Vector2(position.x + 1, position.y -2), 35));
			blocks.get(0).add(new Block(new Vector2(position.x, position.y - 1), 35));
			blocks.get(0).add(new Block(new Vector2(position.x , position.y - 2), 35));
			
			//right
			blocks.get(1).add(new Block(new Vector2(position.x -1, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x + 1, position.y + 1), 35));
			blocks.get(1).add(new Block(new Vector2(position.x, position.y ), 35));
			blocks.get(1).add(new Block(new Vector2(position.x  + 1, position.y), 35));
			
			//down
			blocks.get(2).add(new Block(new Vector2(position.x - 1, position.y + 1), 35));
			blocks.get(2).add(new Block(new Vector2(position.x, position.y + 1), 35));
			blocks.get(2).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x , position.y - 1), 35));
			
			//left
			blocks.get(3).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x + 1, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x - 1, position.y - 1), 35));
			break;
		case ZPIECE:
			//up
			blocks.get(0).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(0).add(new Block(new Vector2(position.x + 1, position.y - 1), 35));
			blocks.get(0).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(0).add(new Block(new Vector2(position.x, position.y - 1), 35));
		
			//right
			blocks.get(1).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x, position.y + 1), 35));
			blocks.get(1).add(new Block(new Vector2(position.x - 1, position.y - 1), 35));
			
			//down
			blocks.get(2).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x + 1, position.y - 1), 35));
			blocks.get(2).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x, position.y - 1), 35));
			
			//left
			blocks.get(3).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x, position.y + 1), 35));
			blocks.get(3).add(new Block(new Vector2(position.x - 1, position.y - 1), 35));
			break;
		case SPIECE:
			//up
			blocks.get(0).add(new Block(new Vector2(position.x - 1, position.y - 1), 35));
			blocks.get(0).add(new Block(new Vector2(position.x + 1, position.y), 35));
			blocks.get(0).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(0).add(new Block(new Vector2(position.x, position.y - 1), 35));
			
			//right
			blocks.get(1).add(new Block(new Vector2(position.x - 1, position.y + 1), 35));
			blocks.get(1).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x, position.y - 1), 35));
			
			//down
			blocks.get(2).add(new Block(new Vector2(position.x - 1, position.y - 1), 35));
			blocks.get(2).add(new Block(new Vector2(position.x + 1, position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x, position.y - 1), 35));
			
			//left
			blocks.get(3).add(new Block(new Vector2(position.x - 1, position.y + 1), 35));
			blocks.get(3).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x, position.y - 1), 35));
			break;
		case TPIECE:
			//up
			blocks.get(0).add(new Block(new Vector2(position.x - 1, position.y - 1), 35));
			blocks.get(0).add(new Block(new Vector2(position.x + 1, position.y - 1), 35));
			blocks.get(0).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(0).add(new Block(new Vector2(position.x,position.y - 1), 35));
			//right
			blocks.get(1).add(new Block(new Vector2(position.x, position.y + 1), 35));
			blocks.get(1).add(new Block(new Vector2(position.x + 1, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(1).add(new Block(new Vector2(position.x,position.y - 1), 35));
			
			//down
			blocks.get(2).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x + 1, position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(2).add(new Block(new Vector2(position.x,position.y - 1), 35));
			
			//left
			blocks.get(3).add(new Block(new Vector2(position.x - 1, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x, position.y + 1), 35));
			blocks.get(3).add(new Block(new Vector2(position.x, position.y), 35));
			blocks.get(3).add(new Block(new Vector2(position.x,position.y - 1), 35));
			break;			
		}	
	}
	
	public void update() {
		if(state == PIECE_MOVING) {
			if(blocks.get(rotState).get(3).position.y == 0 || checkCollision()) {
				state = PIECE_STOPPED;
				for(int i = 0; i < blocks.get(rotState).size(); i++) {
					World.grid.setFilled((int)blocks.get(rotState).get(i).position.x, (int)blocks.get(rotState).get(i).position.y);
				}
				stopBlock();

			} else {
				for(int i = 0; i < 4; i++) {
					blocks.get(i).get(0).position.y--;
					blocks.get(i).get(1).position.y--;
					blocks.get(i).get(2).position.y--;
					blocks.get(i).get(3).position.y--;
				}
			}
		}
	}
	public boolean checkCollision() {
		for(int i = 0; i < 4; i++) {
			if(World.grid.isFilled((int)blocks.get(rotState).get(i).position.x, (int)blocks.get(rotState).get(i).position.y - 1)) {
				return true;
			} 
		}
		return false;
	}

	public void rotate() {
		if(state == PIECE_MOVING) {
			if(rotState != 3) {
				rotState++;
			} else {
				rotState = 0;
			}
			for(int i = 0; i < blocks.get(rotState).size(); i++) {
				if (blocks.get(rotState).get(i).position.y < 0) {
					for(int j = 0; j < 4; j++) {
						blocks.get(j).get(0).position.y++;
						blocks.get(j).get(1).position.y++;
						blocks.get(j).get(2).position.y++;
						blocks.get(j).get(3).position.y++;
					}
				}
				if(blocks.get(rotState).get(i).position.x < 0) {
					for(int j = 0; j < 4; j++) {
						blocks.get(j).get(0).position.x++;
						blocks.get(j).get(1).position.x++;
						blocks.get(j).get(2).position.x++;
						blocks.get(j).get(3).position.x++;
					}
				}
				if(blocks.get(rotState).get(1).position.x > 9) {
					for(int j = 0; j < 4; j++) {
						blocks.get(j).get(0).position.x--;
						blocks.get(j).get(1).position.x--;
						blocks.get(j).get(2).position.x--;
						blocks.get(j).get(3).position.x--;
					}
				}
			}
		}
	}
	
	public void stopBlock() {
		Tetris.world.checkFilled();
		Tetris.world.newPiece();
	}

	public boolean checkRCollision() {
		for(int i = 0; i < 4; i++) {
			if((int)blocks.get(rotState).get(i).position.x + 1 < 9 && World.grid.isFilled((int)blocks.get(rotState).get(i).position.x + 1, (int)blocks.get(rotState).get(i).position.y)) {
				return true;
			} 
		}
		return false;
	}
	
	public boolean checkLCollision() {
		for(int i = 0; i < 4; i++) {
			if((int)blocks.get(rotState).get(i).position.x - 1 > 0 && World.grid.isFilled((int)blocks.get(rotState).get(i).position.x - 1, (int)blocks.get(rotState).get(i).position.y)) {
				return true;
			} 
		}
		return false;
	}
	
	public void moveLeft() {
		if(blocks.get(rotState).get(0).position.x > 0) {
			for(int j = 0; j < 4; j++) {
				if(blocks.get(rotState).get(j).position.x - 1 >= 0 && !checkLCollision()) {
					blocks.get(j).get(0).position.x--;
					blocks.get(j).get(1).position.x--;
					blocks.get(j).get(2).position.x--;
					blocks.get(j).get(3).position.x--;
				} else {
					break;
				}
			}
		}
	}
	
	public void moveRight() {
		if(blocks.get(rotState).get(1).position.x < 9) {
			for(int i = 0; i < 4; i++) {
				if(blocks.get(rotState).get(i).position.x + 1 <= 9 && !checkRCollision()) {
					blocks.get(i).get(0).position.x++;
					blocks.get(i).get(1).position.x++;
					blocks.get(i).get(2).position.x++;
					blocks.get(i).get(3).position.x++;
				} else {
					break;
				}
			}
		}
	}
}