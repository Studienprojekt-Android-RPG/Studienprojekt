package de.test.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

//atk, satk, def, sdef, hp, lvl, spe, exp, sp, money

public class Saubaer extends Monster {

	public Saubaer() {
//		super(35, 30, 28, 23, 50, 10, 20, 200, 0, 500);
		super(10, 7, 50, 50, 1050, 10, 7, 500, 3, 600);
		texture = new TextureRegion(enemies.findRegion("Saubaer"));
		name = "Saubär";
	}

}

