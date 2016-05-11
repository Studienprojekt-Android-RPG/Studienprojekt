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
	TextButton gen, reichsschweng, potatoe, ohit, twerk,exit;
	ScrollPane scroll;
	Table table = new Table();
	
	public Skills(Skin skin) {
		super("Technick", skin);
		
		gen = new TextButton("Skill1", skin, "Button");
		reichsschweng = new TextButton("Skill2", skin, "Button");
		potatoe = new TextButton("Skill3", skin, "Button");
		ohit = new TextButton("Skill4", skin, "Button");
		twerk = new TextButton("Skill5", skin, "Button");
		exit = new TextButton("Zurück", skin, "Button");
		
		scroll = new ScrollPane(table);
		
//		table.pad(table.getPadTop() +40, 10, 10, 10);
		table.add(gen).width(200).padTop(10).padBottom(10).align(Align.center);
		table.row();
		
		table.add(reichsschweng).width(200).padBottom(10).align(Align.center);
		table.row();
		
		table.add(potatoe).width(200).padBottom(10).align(Align.center);
		table.row();
		
		table.add(ohit).width(200).padBottom(10).align(Align.center);
		table.row();
		
		table.add(twerk).width(200).padBottom(10).align(Align.center);
		table.row();
		
		table.add(exit).width(200).padBottom(10).align(Align.center);
		table.pack();
		scroll.setScrollingDisabled(true, false);
		
		this.pad(this.getPadTop()+ 40, 10, 0, 10);
		this.add(scroll).width(200).height(300);
	   	this.pack();
		
	   	gen.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	
	        }
	    });
		
		reichsschweng.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Dickslap!");
	        }
	    });
		
		potatoe.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	
	        }
	    });
		
		ohit.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				
	        }
	    });
		
		twerk.addListener(new ClickListener() {
			public void clicked(InputEvent e, float x, float y) {
				System.out.println("Leon beginnt zu twerken!");
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
