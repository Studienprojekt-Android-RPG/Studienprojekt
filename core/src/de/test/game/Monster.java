package de.test.game;


import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Monster extends Fighter {

	static String attackName;
	
	TextureAtlas enemies = new TextureAtlas("enemies.atlas");
	TextureRegion texture;
	
	public Monster(int atk, int satk, int def, int sdef, int hp, int lvl,
			int spe, int exp, int sp, int money, String common, String rare, elements weak) {
		super(atk, satk, def, sdef, hp, lvl, spe, exp, sp, money, common, rare, weak);
	}
	
	static int success;
	
	//katalog
	
	public void counterAI(){
		
	}
	
	
	public static String getMove(String moveName){
		
		attackName = moveName;
		
		return attackName;
	}
	
	
	public static void einwickeln(Fighter attacker, Fighter defender){
		moveElement = elements.none;
		attackName = "Einwickeln";
		attackDamage = attacker.ATK * attacker.speed / 1.5 - defender.DEF;
		damage(attacker, defender);
	}
	
	public static void bezirzen(Fighter attacker, Fighter defender){
		moveElement = elements.none;
		attackName = "Bezirzen";
		Math.round(defender.speed /= 1.5);
		System.out.println(defender.getName() + "'s Geschwindigkeit verringert sich auf " + Fighter.getSpeed(defender) + "!");
	}
	
	public static void beissen(Fighter attacker, Fighter defender){
		moveElement = elements.none;
		attackName = "Beißen";
		attackDamage = (attacker.ATK * attacker.level * 2.2) - (defender.DEF * defender.level / 1.5);
		statusChange("poison", 1, defender);
		damage(attacker, defender);
		
	}
	
	public static void heulen(){
		attackName= "Heulen";
		int success = (int) Math.random ()*4;
		if(success == 3)
		{
	Battlescreen.player.DEF = (int) Math.round(Battlescreen.player.DEF/1.2);
		}
		
	}
	
	public static void irrlicht(Fighter attacker, Fighter defender){
		moveElement = elements.fire;
		attackName = "Irrlicht";
		attackDamage = (attacker.sATK * attacker.level*3) - (defender.sDEF * defender.level / 1.5);
		damage(attacker, defender);
		}
		
		public static void reizen(Fighter attacker, Fighter defender){
			attackName = "Reizen";
			Math.round(defender.ATK*1.2);
			if (defender.ATK >= 255)
			{
				defender.ATK = 255;
			}
		}
		
		public static void dreckwurf(Fighter attacker, Fighter defender){
			moveElement = elements.earth;
			attackName = "Dreckwurf";
			attackDamage = attacker.sATK * attacker.level * 1.8 - defender.sDEF*defender.level/2;
			damage(attacker, defender);
		}
		
		public static void meditieren(Fighter attacker){
			attackName = "Meditieren";
			attacker.sATK = (int) Math.round(attacker.sATK *1.1);
			attacker.DEF = (int) Math.round(attacker.DEF * 1.2);
			attacker.sDEF = (int) Math.round(attacker.sDEF *1.2);
			
			if (attacker.sATK > 255)
			{
				attacker.sATK = 255;
			}
			if (attacker.DEF > 255)
			{
				attacker.DEF = 255;
			}
			if (attacker.sDEF > 255)
			{
				attacker.sDEF = 255;
			}
		}
		
		public static void hohngesang(Fighter attacker){
			attackName = "Hohngesang";
			attacker.curHP += attacker.curHP/2;
			
			if (attacker.curHP > attacker.maxHP){
				attacker.curHP = attacker.maxHP;
			}
		}
		
		public static void ernte(Fighter attacker, Fighter defender){
			moveElement = elements.nothingness;
			attackName = "Ernte";
			attackDamage = attacker.ATK * attacker.level * 2 - defender.DEF*defender.level/1.5;
		    damage(attacker, defender);
		    attacker.curHP += (int) Math.round(attacker.attackDamage);
			
		}
		public static void bruellen(Fighter attacker, Fighter defender){
			attackName = "Brüllen";
			success = (int) Math.random ()*4;
			if(success == 3)
			{
				defender.DEF = (int) Math.round(defender.DEF*0.9);
			}
			boosterMove(attacker);
		}
		
		public static void pranke(Fighter attacker, Fighter defender){
			moveElement = elements.none;
			attackName = "Prankenschwung";
			attackDamage = attacker.ATK * attacker.level * 2.3 - defender.DEF*defender.level/1.5;
			damage(attacker, defender);
		}
		
		public static void tollwut(Fighter attacker, Fighter defender){
			moveElement = elements.none;
			attackName = "Tollwut-Wirbel";
			attackDamage = attacker.ATK * attacker.level * 2.3 - defender.DEF*defender.level/1.5;
			damage(attacker, defender);
		}

		public static void sprung(Fighter attacker, Fighter defender){
			moveElement = elements.none;
			attackName = "Sprungattacke";
			attackDamage = attacker.ATK * attacker.level * 2.2 - defender.DEF*defender.level/1.7;
			damage(attacker, defender);
		}
	
		public static void jagdfieber(Fighter attacker){
			attackName = "Jagdfieber";
			attacker.ATK = (int) Math.round(attacker.ATK*1.25);
			attacker.speed = (int) Math.round(attacker.speed*1.25);
			boosterMove(attacker);
		}
		
	   public static void ausruhen(Fighter attacker){
		   attackName = "Ausruhen";
		   attacker.curHP += (int) Math.round(attacker.maxHP*0.25);
		   if(attacker.curHP > attacker.maxHP){
			   attacker.curHP = attacker.maxHP;
		   }
	   }
	   
	   public static void fokus(Fighter attacker){
		   attackName = "Fokussieren";
		   attacker.sATK = (int) Math.round(attacker.sATK*1.1);
		   if(attacker.sATK > 100){
			   attacker.sATK = 100;
		   }
		   boosterMove(attacker);
	   }
	   
	   public static void schlachtruf(Fighter attacker, Fighter defender){
		   attackName = "Schlachtruf";
		   attacker.ATK = (int) Math.round(attacker.ATK*1.1);
		   if(attacker.ATK > 100){
			   attacker.ATK = 100;
		   }
		   boosterMove(attacker);
	   }
	   
	   public static void eisspeer(Fighter attacker, Fighter defender)
	   {
		   moveElement = elements.ice;
		   attackName = "Eisspeer";
			if(attacker.speed*1.5 <= defender.speed)
			{
			    success = (int) Math.random ()*2;
				if(success == 1)
				{
					System.out.println("Verfehlt!");
				}
				
				else
				{
					 attackDamage = attacker.ATK*attacker.level*1.6-defender.DEF*defender.level/2.3;
					   defender.speed = (int) Math.round(attacker.ATK/1.2);
					   if (defender.speed < 0)
					   {
							defender.speed = 0;
				       }
				}
			}
			
			
			else
			{
		   attackDamage = attacker.ATK*attacker.level*1.6-defender.speed*defender.level/2.3;
		   defender.speed = (int) Math.round(attacker.ATK/1.3);
		   if (defender.speed < 0)
		   {
				defender.speed = 0;
		   }
		   damage(attacker, defender);
			}
	   }
	   
	   public static void lichtblitz(Fighter attacker, Fighter defender){
		   moveElement = elements.sacred;
		   attackName = "Lichtblitz";
		   attackDamage = attacker.ATK*attacker.level*2-defender.DEF*defender.level/1.7;
		   damage(attacker, defender);
	   }
	   
	   public static void extermination(Fighter attacker, Fighter defender){
		   moveElement = elements.nothingness;
		   attackName = "Extermination";
		   attackDamage = attacker.sATK*attacker.level*2-defender.sDEF*defender.level;
		   damage(attacker, defender);
	   }
	   
	   
	   public static void blutrausch(Fighter attacker, Fighter defender){
		   moveElement = elements.none;
		   attackName = "Blutrausch";
		   attackDamage = attacker.ATK*defender.level*2.2-defender.ATK*defender.level/1.5;
		   attacker.ATK = (int) Math.round(attacker.speed*1.1);
		   if(attacker.speed > 100){
			   attacker.speed = 100;
		   }
		   damage(attacker, defender);
		   
	   }
	   
	   public static void kombo(Fighter attacker, Fighter defender){
		   moveElement = elements.none;
		   attackName = "Kombo";
		   attackDamage = attacker.ATK*attacker.level*2.5-defender.DEF*defender.level/1.8;
		   damage(attacker, defender);
	   }
	   

	   public static void avengers(Fighter attacker, Fighter defender){
		   moveElement = elements.none;
		   attackName = "Konter";
		   attackDamage = (getDamageStorage(defender)/4);
		   damage(attacker, defender);
	   }
	   
	   
	public static void damage(Fighter attacker, Fighter defender){
		attackDamage = attackDamage*attacker.weak(defender);
		if (defender.guard){
			attackDamage /= 2;
			defender.guard = false;
		}
		attackDamage = maxDamage();
		defender.curHP -= attackDamage;
		System.out.println(attackName + "!\n" + attacker.getName() + " fügt " + defender.getName() + " " +  attackDamage + " Schadenspunkte zu!");
		
	}
	
	public static void boosterMove(Fighter attacker){
		System.out.println(attackName + "!\n" + attacker.getName() + " verändert die Werte!");
	}

}
