package de.test.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Monster extends Fighter {
	
	static String attackName;
	
	TextureAtlas enemies = new TextureAtlas("enemies.atlas");
	TextureRegion texture;
	
	public Monster(int atk, int satk, int def, int sdef, int hp, int lvl,
			int spe, int exp, int sp, int money) {
		super(atk, satk, def, sdef, hp, lvl, spe, exp, sp, money);
	}
	
	//katalog
	
	public static void einwickeln(Fighter attacker, Fighter defender){
		attackName = "Einwickeln";
		attackDamage = attacker.ATK * attacker.speed / 1.5 - defender.DEF;
		damage(attacker, defender);
	}
	
	public static void bezirzen(Fighter attacker, Fighter defender){
		attackName = "Bezirzen";
		Math.round(defender.speed /= 1.5);
		System.out.println(defender.getName() + "'s Geschwindigkeit verringert sich auf " + Fighter.getSpeed(defender) + "!");
	}
	
	public static void beissen(Fighter attacker, Fighter defender){
		attackName = "Beißen";
		attackDamage = (attacker.ATK * attacker.level * 2.2) - (defender.DEF * defender.level / 1.5);
		damage(attacker, defender);
	}
	
	public static void heulen(Fighter attacker, Fighter defender){
		
	}
	
	public static void irrlicht(Fighter attacker, Fighter defender){
		attackName = "Irrlicht";
		attackDamage = (attacker.sATK * attacker.level*3) - (defender.sDEF * defender.level / 1.5);
		damage(attacker, defender);
	}
	
	public static void damage(Fighter attacker, Fighter defender){
		
		if (defender.guard){
			attackDamage /= 2;
			defender.guard = false;
		}
		
		attackDamage = maxDamage();
		defender.curHP -= attackDamage;
		System.out.println(attacker.getName() + " fügt durch " + attackName + defender.getName() + " " + attackDamage + " Schadenspunkte zu!");
		
	}
}
