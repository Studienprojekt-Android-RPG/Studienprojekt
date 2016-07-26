package de.test.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

//atk, satk, def, sdef, hp, lvl, spe, exp, sp, money

public class Goblin extends Monster {

	public Goblin() {
		super(10, 5, 5, 5, 50, 2, 6, 100, 15, 150, "MESSER", "HEILTRANK", elements.ice, null);
		texture = new TextureRegion(enemies.findRegion("Goblin"));
		name = "Goblin";
		
		if (this.level >= Battlescreen.player.level * 2 || this.level*5 <= Battlescreen.player.level){
			this.level = Battlescreen.player.level;
		    this.maxHP = this.maxHP*this.level;
		    this.curHP = this.maxHP;
		    this.ATK = (int) Math.round (Battlescreen.player.ATK/3);
		    this.sATK = (int) Math.round (Battlescreen.player.sATK/3);
		    this.DEF = (int) Math.round(Battlescreen.player.DEF/2);
		    this.sDEF = (int) Math.round(Battlescreen.player.sDEF/2.5);
		    this.speed = (int) Battlescreen.player.speed;
		}
	}
	

	
public void moveAI(){
		
		turn += 1;
		
		if(turn % 5 == 0)
		{
			reizen(this, Battlescreen.player);
			
		}
		
		else{
		coin = (int) (Math.random()*3);
		switch(coin){
		case 0: 
			attack(this, Battlescreen.player);
			Battlescreen.animatk = true;
			break;
		case 1:
			dreckwurf(this, Battlescreen.player);
			break;
		case 2:
			beissen(this, Battlescreen.player);
			break;
	
		}
		}
	}


public void counterAI(){
	
	coin = (int) (Math.random()*4);
	if(coin == 0){
	avengers(this, Battlescreen.player);
	}
	
}
}


