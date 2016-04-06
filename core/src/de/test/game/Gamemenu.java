package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
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
	Stage stage;
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
		            System.out.println("Du bist schwach!");
		        }
		    });
		 
		 save.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		            System.out.println("Speichern geht nicht!");
		        }
		    });
		 
		 resume.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		            Gamescreen.gamenu.setVisible(false);;
		        }
		    });
		 
		 exit.addListener(new ClickListener() {
		        public void clicked(InputEvent e, float x, float y) {
		            Gdx.app.exit();
		        }
		    });
	}
	
}
