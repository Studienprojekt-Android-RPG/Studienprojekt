package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

public class StartMenu extends Window {
	TextButton newGame;
	TextButton loadGame;
	TextButton options;
	TextButton exit;	
	Stage stage;
	public StartMenu(Skin skin) {
		super("Menu", skin);
		
		newGame = new TextButton("New Game", skin, "Button");
		loadGame = new TextButton("Load Game", skin, "Button");
		options = new TextButton("Options", skin, "Button");
		exit = new TextButton("Exit", skin, "Button");
		
		this.pad(this.getPadTop() +40, 10, 10, 10);
		this.add(newGame).width(200).padBottom(10).padTop(20).align(Align.center);
		this.row();
		
		this.add(loadGame).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(options).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(exit).width(200).padBottom(10).align(Align.center);
		this.pack();
		
		 newGame.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		            System.out.println("Inventar geöffnet");
		        }
		    });
		 
		 loadGame.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		            System.out.println("Du bist schwach!");
		        }
		    });
		 
		 options.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		            System.out.println("Speichern geht nicht!");
		        }
		    });
		 
		 exit.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		            Gdx.app.exit();
		        }
		    });
	}
	
}
