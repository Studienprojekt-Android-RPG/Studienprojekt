package de.test.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class StartMenu extends Window {
	TextButton newGame;
	TextButton loadGame;
	TextButton options;
	TextButton exit;	
	Stage stage;
	public StartMenu(Skin skin) {
		super("Menu", skin);
	}
	
}
