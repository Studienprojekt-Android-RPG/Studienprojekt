package de.test.game;

import java.io.IOException;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import de.test.game.Testmap.ScreenType;

public class Gamemenu extends Window {
	TextButton inv, stats, save, resume, exit;
	Testmap game = Gamescreen.game;
	
	public Gamemenu(Skin skin) {
		super("Menü", skin);
		
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
		        	try {
						Gamescreen.player.savePlayer(Gamescreen.player);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            System.out.println("Inventar geöffnet");
		            game.setScreen(game.getScreenType(ScreenType.Inventory));
		        }
		    });
		 
		 stats.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		        	try {
						Gamescreen.player.savePlayer(Gamescreen.player);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            game.setScreen(game.getScreenType(ScreenType.Statusscreen));
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
		            if(Gamescreen.player.rspeed == 3f){
		        		Gamescreen.player.rspeed = 10f;
		        		System.out.println("Speeeeeeeeeeeeeeed!!!");
		        	}
		        	else{
		        		Gamescreen.player.rspeed = 3f;
		        		 System.out.println("Slooooooooooooooooow!!!");
		        	}
		        }
		    });
		 
		 exit.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		        	Gamescreen.tiledMap.dispose();
		        	Gamescreen.renderer.getMap().dispose();
		        	game.setScreen(game.getScreenType(ScreenType.StartMenu));
		        }
		    });
	}
	
}
