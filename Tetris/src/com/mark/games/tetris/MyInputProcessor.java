package com.mark.games.tetris;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class MyInputProcessor implements InputProcessor {
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.P){ 
			if(Tetris.world.state == World.PLAYING) {
				Tetris.world.state = 1;
			} else {
				Tetris.world.state = 0;
			}
		}
		if(keycode == Keys.DOWN){
			Tetris.world.tempTick = Tetris.world.tickTime;
		}
		if(keycode == Keys.UP) {
			Tetris.world.pieces.get(Tetris.world.currentPiece).rotate();
		}
		if(keycode == Keys.C) {
			Tetris.world.clearLine(0);
			Tetris.world.clearLine(1);
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.DOWN){
			Tetris.world.tickTime = Tetris.world.tempTick;
		}
		if(keycode == Keys.LEFT){ 
			Tetris.lRready = true;
		}
		if(keycode == Keys.RIGHT){ 
			Tetris.lRready = true;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}