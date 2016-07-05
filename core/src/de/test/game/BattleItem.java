package de.test.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

public class BattleItem extends Window {
	TextButton heil, pkt, etc, exit;

	public BattleItem(Skin skin) {
		super("Items", skin);

		heil = new TextButton("Heiltrank", skin, "Button");
		pkt = new TextButton("Manatrank", skin, "Button");
		etc = new TextButton("Zeug", skin, "Button");
		exit = new TextButton("Zurück", skin, "Button");
		
		this.pad(this.getPadTop() +40, 10, 10, 10);
		this.add(heil).width(200).padBottom(10).padTop(5).align(Align.center);
		this.row();
		
		this.add(pkt).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(etc).width(200).padBottom(10).align(Align.center);
		this.row();
		
		this.add(exit).width(200).padBottom(10).align(Align.center);
		this.row();
		
		heil.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	Battlescreen.player.curHP = Battlescreen.player.maxHP;
	        	Battlescreen.battlemenu.setVisible(true);
	            Battlescreen.battleitem.setVisible(false);
//	            Battlescreen.battlestate = Battlestate.firstStrike;
	            Battlescreen.battlemenu.hasClicked = true;
	        }
	    });
		
		pkt.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	Battlescreen.battlemenu.setVisible(true);
	            Battlescreen.battleitem.setVisible(false);
	        }
	    });
		
		etc.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	Battlescreen.battlemenu.setVisible(true);
	            Battlescreen.battleitem.setVisible(false);
	        }
	    });

		exit.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	        	Battlescreen.battlemenu.setVisible(true);
	            Battlescreen.battleitem.setVisible(false);
	        }
	    });
		
	}

}
