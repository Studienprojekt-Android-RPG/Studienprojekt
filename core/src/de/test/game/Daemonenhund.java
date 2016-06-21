package de.test.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

//atk, satk, def, sdef, hp, lvl, spe, exp, sp, money

public class Daemonenhund extends Monster {

	public Daemonenhund() {
		super(7, 7, 50, 50, 1050, 10, 7, 500, 3, 600);
		texture = new TextureRegion(enemies.findRegion("Daemonenhund"));
		name = "Dämonenhund";
		
	if (this.level >= Battlescreen.player.level * 2 || this.level*2 <= Battlescreen.player.level){
		this.level = Battlescreen.player.level;
	    this.maxHP = (int) Math.round(maxHP * (level/5));
	    this.curHP = this.maxHP;
	    this.ATK = (int) Math.round (Battlescreen.player.ATK/2.5);
	    this.sATK = (int) Math.round (Battlescreen.player.sATK/1.5);
	    this.DEF = (int) Math.round(Battlescreen.player.DEF*1.2);
	    this.sDEF = (int) Math.round(Battlescreen.player.sDEF/1.5);
	    this.speed = (int) Battlescreen.player.speed-5;
	}
	 }




public void moveAI(){
	
	turn += 1;
	
	if(turn % 7 == 0)
	{
		jagdfieber(this);
		
	}
	
	else{
	coin = (int) (Math.random()*5);
	switch(coin){
	case 0: 
		attack(this, Battlescreen.player);
		break;
	case 1:
		bruellen(this, Battlescreen.player);
		break;
	case 2:
		beissen(this, Battlescreen.player);
		break;
	case 3:
		pranke(this, Battlescreen.player);
		break;
	case 4:
		sprung(this,Battlescreen.player);
	}
	}

	
		
	}

public void counterAI(){
	    int coin = (int) (Math.random()*4);
	    if (coin == 0){
	    	bruellen(this, Battlescreen.player);
	    }
}

}
