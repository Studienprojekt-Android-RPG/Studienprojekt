package de.test.game;

import com.badlogic.gdx.Game;


public class Testmap extends Game {
	static Game game;
	static Testmap gameT;
	
	Gamescreen gamescreen;
//	Battlescreen battlescreen;
	
	@Override
	public void create() {
		gamescreen = new Gamescreen(this);
//		battlescreen = new Battlescreen(this);
		gameT = new Testmap();
		
		//setScreen(new Gamescreen(game));
		setScreen(gamescreen);
		//setScreen(new Battlescreen(game));

	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {
		super.render();
	}	
}