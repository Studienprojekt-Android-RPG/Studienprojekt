package de.test.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

public class Battlemenu extends Window {
	TextButton atk;
	TextButton def;
	TextButton skill;
	TextButton item;
	TextButton run;
	
	Game game;
	
	static Vector2 vec = new Vector2(500, 400);
	
	Gamescreen gamescreen;
	
	public Battlemenu(Skin skin) {
		super("Aktionen", skin);
		
		game = Gamescreen.game;
		
		atk = new TextButton("Angriff", skin, "Button");
		def = new TextButton("Verteidigen", skin, "Button");
		skill = new TextButton("Spezial", skin, "Button");
		item = new TextButton("Item", skin, "Button");
		run = new TextButton("Fliehen", skin, "Button");
		
		this.pad(this.getPadTop() +10, 10, 10, 10);
		this.add(atk).width(200).padBottom(10).padTop(20).align(Align.center);
		this.row();
		
		this.add(def).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(skill).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(item).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(run).width(200).padBottom(10).align(Align.center);
		this.pack();
		
		atk.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Angriff!");
	        }
	    });
		
		def.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Verteidigung!");
	        }
	    });
		
		skill.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Skill!");
	        }
	    });
		
		item.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Item eingesetzt!");
	        }
	    });
		
		run.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	gamescreen = Gamescreen.gamescreen;
	        	Battlescreen.battletheme.stop();
	        	game.setScreen(new Gamescreen(game));
//	        	game.setScreen(gamescreen);
	        	//Gamescreen.player.reAdjust();
	            System.out.println("Du bist geflohen!");
	        }
	    });
	}

}
