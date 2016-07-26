package de.test.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
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
	            EnemyAtk.enemyATK = false;
	            Battlescreen.animatk = true;
	            System.out.println("Angriff!");
	            if(Battlescreen.selEnemy == 1){
	            	Fighter.attack(Battlescreen.player, Battlescreen.gegner1);
	            	if(Battlescreen.gegner1.curHP > 0){
	            	Battlescreen.gegner1.counterAI();
	            	}
	            }
	            
	            if(Battlescreen.selEnemy == 2){
	            	Fighter.attack(Battlescreen.player, Battlescreen.gegner2);
	            	if(Battlescreen.gegner2.curHP > 0){
	            	Battlescreen.gegner2.counterAI();
	            	}
	            }
	            
	            if(Battlescreen.selEnemy == 3){
	            	Fighter.attack(Battlescreen.player, Battlescreen.gegner3);
	            	if(Battlescreen.gegner3.curHP > 0){
	            	Battlescreen.gegner3.counterAI();
	            	}
	            }
	            
	            
//	            Battlescreen.battlestate = Battlestate.firstStrike;
	            hasClicked = true;
	        }
	    });
		
		def.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Verteidigung!");
	            Fighter.guard(Battlescreen.player);
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
	        	Battlescreen.battlemenu.setVisible(false);
	        	checkForItems();
	        	Battlescreen.battleitem.setVisible(true);
	        }
	    });
		
		run.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Du bist geflohen!");
	            Battlescreen.battlestate = Battlestate.firstStrike;
	            Battlescreen.player.saveBattle();
	            hasClicked = true;
	        	game.setScreen(game.getScreenType(ScreenType.Gamescreen));
	        	Battlescreen.fighterList.clear();
	        }
	    });
	}
	
	private void checkForItems() {
		if(InventoryActor.inv.checkInventory(Item.HEILTRANK) <= 0) {
			Battlescreen.battleitem.heil.setTouchable(Touchable.disabled);
		}
		if(InventoryActor.inv.checkInventory(Item.MANATRANK) <= 0) {
			Battlescreen.battleitem.pkt.setTouchable(Touchable.disabled);
		}
	}
}
