package de.test.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class Testmap extends Game {
	
	Game game;
	Screen startMenu;
	
	@Override
	public void create() {
		
		System.out.println("Game starting!");
		
		setScreen(new Gamescreen(game));
		//setScreen(startMenu);

	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {
		super.render();
	}	
}