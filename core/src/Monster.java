package de.test.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Monster extends Fighter {
	
	TextureAtlas enemies = new TextureAtlas("enemies.atlas");
	TextureRegion texture;
	
	public Monster(int atk, int satk, int def, int sdef, int hp, int lvl,
			int spe, int exp, int sp, int money) {
		super(atk, satk, def, sdef, hp, lvl, spe, exp, sp, money);
	}

}
