package de.test.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

public class Skills extends Window {
	TextButton skill1, skill2, skill3, skill4, skill5, skill6, skill7, skill8, exit;
	ScrollPane scroll;
	Table table = new Table();
	
	public Skills(Skin skin) {
		super("Technick", skin);
		
		skill1 = new TextButton("Schockschlag", skin, "Button");
		skill2 = new TextButton("Vendetta", skin, "Button");
		skill3 = new TextButton("Klingensturz", skin, "Button");
		skill4 = new TextButton("Flammensiegel", skin, "Button");
		skill5 = new TextButton("Windschleier", skin, "Button");
		skill6 = new TextButton("Lichthieb", skin, "Button");
		skill7 = new TextButton("Millenium-Streich", skin, "Button");
		skill8 = new TextButton("Phidaels Ruf", skin, "Button");
		exit = new TextButton("Zurück", skin, "Button");
		
		scroll = new ScrollPane(table);
		
//		table.pad(table.getPadTop() +40, 10, 10, 10);
		table.add(skill1).width(200).padTop(10).padBottom(10).align(Align.center);
		table.row();
		
		table.add(skill2).width(200).padBottom(10).align(Align.center);
		table.row();
		
		table.add(skill3).width(200).padBottom(10).align(Align.center);
		table.row();
		
		table.add(skill4).width(200).padBottom(10).align(Align.center);
		table.row();
		
		table.add(skill5).width(200).padBottom(10).align(Align.center);
		table.row();
		
		table.add(skill6).width(200).padBottom(10).align(Align.center);
		table.row();
		
		table.add(skill7).width(200).padBottom(10).align(Align.center);
		table.row();
		
		table.add(skill8).width(200).padBottom(10).align(Align.center);
		table.row();
		
		table.add(exit).width(200).padBottom(10).align(Align.center);
		table.pack();
		scroll.setScrollingDisabled(true, false);
		
		this.pad(this.getPadTop()+ 40, 10, 0, 10);
		this.add(scroll).width(200).height(300);
	   	this.pack();
		
	   	skill1.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	
	        }
	    });
		
		skill2.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	
	        }
	    });
		
		skill3.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	
	        }
	    });
		
		skill4.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				
	        }
	    });
		
		skill5.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				
	        }
	    });
		
		skill6.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				
	        }
	    });
		
		skill7.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				
	        }
	    });
	    
	    skill8.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				
	        }
	    });
		
		exit.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	Battlescreen.skills.setVisible(false);
	        	Battlescreen.battlemenu.setVisible(true);
	        }
	    });
	}

}
