package de.test.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

//atk, satk, def, sdef, hp, lvl, spe, exp, sp, money

public class Goblin extends Monster {

	public Goblin() {
		super(10, 5, 5, 5, 50, 2, 6, 100, 0, 150);
		texture = new TextureRegion(enemies.findRegion("Goblin"));
		name = "Goblin";
	}

}
