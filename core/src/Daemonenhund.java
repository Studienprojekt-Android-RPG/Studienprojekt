package de.test.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

//atk, satk, def, sdef, hp, lvl, spe, exp, sp, money

public class Daemonenhund extends Monster {

	public Daemonenhund() {
		super(7, 7, 50, 50, 50, 15, 7, 500, 3, 600);
		texture = new TextureRegion(enemies.findRegion("Daemonenhund"));
		name = "Dämonenhund";
	}

}
