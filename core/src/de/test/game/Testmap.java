package de.test.game;

import com.badlogic.gdx.Game;


public class Testmap extends Game {
	static Game game;
	static Testmap gameT;
	
	Gamescreen gamescreen;
	StartMenu startMenu;
	
	@Override
	public void create() {
		startMenu = new StartMenu(this);
		gamescreen = new Gamescreen(this);

		gameT = new Testmap();

		setScreen(startMenu);

	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {
		super.render();
	}	
}