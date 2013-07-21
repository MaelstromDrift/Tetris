package com.mark.games.tetris;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Tetris implements ApplicationListener {
	private SpriteBatch batch;
	protected TextureAtlas atlas;

	MyInputProcessor processor = new MyInputProcessor();

	static World world;
	
	static boolean lRready = true;
	
	static float nano = (float) System.nanoTime();
	
	@Override
	public void create() {
		world = new World();
		atlas = new TextureAtlas(Gdx.files.internal(("data/tetris.atlas")));
		Gdx.input.setInputProcessor(processor);
		
		batch = new SpriteBatch();
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		if(world.state == World.PLAYING) {
			world.updatePieces();
			
			if((((float)System.nanoTime() - nano) / 1000000000) >= .35){
				nano = (float) System.nanoTime();
				lRready = true;
			}
			
			if(Gdx.input.isKeyPressed(Keys.DOWN)) {
				world.tickTime = .1f;
			}
			
			if(lRready) {
				if(Gdx.input.isKeyPressed(Keys.LEFT)) {
					Tetris.world.movePiece(Keys.LEFT);
					lRready = false;
					//System.out.println("cleared");
				}
				if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
					Tetris.world.movePiece(Keys.RIGHT);
					lRready = false;
					//System.out.println("cleared");
				}
			}
		}
		
		batch.begin();
			for(int i = 0; i < world.pieces.size(); i++) {
				for(int j = 0; j < world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).size() ; j++) {
					switch(world.pieces.get(i).type) {
					case Piece.OPIECE:
						batch.draw(atlas.findRegion("opiece"), world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.x * 35, world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.y * 35);
						break;
					case Piece.IPIECE:
						batch.draw(atlas.findRegion("ipiece"), world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.x * 35, world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.y * 35);
						break;
					case Piece.JPIECE:
						batch.draw(atlas.findRegion("jpiece"), world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.x * 35, world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.y * 35);
						break;
					case Piece.SPIECE:
						batch.draw(atlas.findRegion("spiece"), world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.x * 35, world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.y * 35);
						break;
					case Piece.ZPIECE:
						batch.draw(atlas.findRegion("zpiece"), world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.x * 35, world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.y * 35);
						break;
					case Piece.LPIECE:
						batch.draw(atlas.findRegion("lpiece"), world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.x * 35, world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.y * 35);
						break;
					case Piece.TPIECE:
						batch.draw(atlas.findRegion("tpiece"), world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.x * 35, world.pieces.get(i).blocks.get(world.pieces.get(i).rotState).get(j).position.y * 35);
						break;
					}
				}
			}
			batch.end();	
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
