package de.test.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

//atk, satk, def, sdef, hp, lvl, spe, exp, sp, money

public class Saubaer extends Monster {

	public Saubaer() {
		super(10, 7, 50, 50, 1050, 10, 7, 500, 3, 600, "MESSER", "HEILTRANK", elements.none);
		texture = new TextureRegion(enemies.findRegion("Saubaer"));
		name = "Saubär";
	
	
		if (this.level >= Battlescreen.player.level * 2 || this.level*1.5 <= Battlescreen.player.level){
			this.level = Battlescreen.player.level;
		    this.maxHP = (int) Math.round(level * maxHP/4);
		    this.curHP = this.maxHP;
		    this.ATK = (int) Math.round (Battlescreen.player.ATK/1.8);
		    this.sATK = Math.round (Battlescreen.player.sATK/2);
		    this.DEF = (int) Math.round(Battlescreen.player.DEF*1.2);
		    this.sDEF = (int) Math.round(Battlescreen.player.sDEF/2.5);
		    this.speed = (int) Battlescreen.player.speed-20;
		}
		 }
	
	
	
	
public void moveAI(){
		
		turn += 1;
		
		if(turn%5 == 0)
		{
			ausruhen(this);
		}
		if(turn % 7 == 0)
		{
			jagdfieber(this);
			
		}
		
		else{
		coin = (int) (Math.random()*5);
		switch(coin){
		case 0: 
			attack(this, Battlescreen.player);
			Battlescreen.animatk = true;
			break;
		case 1:
			tollwut(this, Battlescreen.player);
			break;
		case 2:
			beissen(this, Battlescreen.player);
			break;
		case 3:
			pranke(this, Battlescreen.player);
			break;
		case 4:
			bruellen(this, Battlescreen.player);
		}
		}
		}
		
		public void counterAI(){
		  coin = (int) (Math.random()*4);
		  if(coin == 0){
			  sprung(this, Battlescreen.player);
		  }
				  
			  
}
}

