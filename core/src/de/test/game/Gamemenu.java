package de.test.game;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

public class Gamemenu extends Window {
	TextButton inv;
	TextButton stats;
	TextButton save;
	TextButton resume;
	TextButton exit;
	
	public Gamemenu(Skin skin) {
		super("Menu", skin);
		
		inv = new TextButton("Inventar", skin, "Button");
		stats = new TextButton("Status", skin, "Button");
		save = new TextButton("Speichern", skin, "Button");
		resume = new TextButton("Fortsetzen", skin, "Button");
		exit = new TextButton("Beenden", skin, "Button");
		
		this.pad(this.getPadTop() +40, 10, 10, 10);
		this.add(inv).width(200).padBottom(10).padTop(20).align(Align.center);
		this.row();
		
		this.add(stats).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(save).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(resume).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(exit).width(200).padBottom(10).align(Align.center);
		this.pack();
		
		 inv.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		            System.out.println("Inventar geöffnet");
		        }
		    });
		 
		 stats.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		        	if(Gamescreen.player.speed == 3f){
		        		Gamescreen.player.speed = 10f;
		        	}
		        	else{
		        		Gamescreen.player.speed = 3f;
		        	}
		            System.out.println("Du bist schwach!");
		        }
		    });
		 
		 save.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		        	try {
						Gamescreen.player.savePlayer(Gamescreen.player);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		        	System.out.println("Gespeichert!");
		        }
		    });
		 
		 resume.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		            Gamescreen.gamenu.setVisible(false);
		            Gamescreen.player.allowMov = true;
		        }
		    });
		 
		 exit.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		            Gdx.app.exit();
		        }
		    });
	}
	
}
