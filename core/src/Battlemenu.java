package de.test.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import de.test.game.Battlescreen.Battlestate;
import de.test.game.Testmap.ScreenType;

public class Battlemenu extends Window {
	TextButton atk;
	TextButton def;
	TextButton tech;
	TextButton item;
	TextButton run;
	static boolean hasClicked = false;
	
	Testmap game = Battlescreen.battle;
	
	static Vector2 vec = new Vector2(750, 300);
	
	Gamescreen gamescreen;
	
	public Battlemenu(Skin skin) {
		super("Aktionen", skin);
		
		
		atk = new TextButton("Angriff", skin, "Button");
		def = new TextButton("Verteidigen", skin, "Button");
		tech = new TextButton("Technik", skin, "Button");
		item = new TextButton("Item", skin, "Button");
		run = new TextButton("Fliehen", skin, "Button");
		
		this.pad(this.getPadTop() +40, 10, 10, 10);
		this.add(atk).width(200).padBottom(10).padTop(5).align(Align.center);
		this.row();
		
		this.add(def).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(tech).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(item).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(run).width(200).padBottom(5).align(Align.center);
		this.pack();
		this.
		
		atk.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	Battlescreen.anim = true;
	            System.out.println("Angriff!");
	            Fighter.attack(Gamescreen.player, Battlescreen.gegner);
	            Battlescreen.battlestate = Battlestate.firstStrike;
	            hasClicked = true;
	        }
	    });
		
		def.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Verteidigung!");
	            Fighter.guard(Gamescreen.player);
	            Battlescreen.battlestate = Battlestate.firstStrike;
	            hasClicked = true;
	        }
	    });
		
		tech.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	Battlescreen.battlemenu.setVisible(false);
	        	Battlescreen.skills.setVisible(true);
	            System.out.println("Technik eingesetzt!");
//	            Fighter.techAttack(Gamescreen.player, Battlescreen.gener);
//	            Battlescreen.battlestate = Battlestate.firstStrike;
//	            hasClicked = true;
	        }
	    });
		
		item.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Item eingesetzt!");
	            Battlescreen.battlestate = Battlestate.firstStrike;
	            hasClicked = true;
	        }
	    });
		
		run.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Du bist geflohen!");
	            Battlescreen.battlestate = Battlestate.firstStrike;
	            Battlescreen.player.saveBattle();
	            hasClicked = true;
	        	game.setScreen(game.getScreenType(ScreenType.Gamescreen));
	        }
	    });
	}

}
