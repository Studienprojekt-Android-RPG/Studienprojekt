package de.test.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;

public class Battlemenu extends Window {
	TextButton atk;
	TextButton def;
	TextButton skill;
	TextButton item;
	TextButton run;
	
	public Battlemenu(String title, Skin skin) {
		super("Aktionen", skin);
		
		atk = new TextButton("Angriff", skin);
		def = new TextButton("Verteidigen", skin);
		skill = new TextButton("Spezial", skin);
		item = new TextButton("Item", skin);
		run = new TextButton("Fliehen", skin);
		
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
	}

}
