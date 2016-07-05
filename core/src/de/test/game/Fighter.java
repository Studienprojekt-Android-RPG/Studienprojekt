package de.test.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import de.test.game.Battlescreen.Battlestate;

public abstract class Fighter {
	Testmap game = Battlescreen.battle;
	int ATK;
	int sATK;
	int DEF;
	int sDEF;
	int curHP;
	int maxHP;
	int level;
	int speed;
	int EXP;
    int turn;
	int coin;//
	int curSP;
	int maxSP;
	int money;
	Item item;
	String common;
	String rare;
	String name;
	boolean guard;
	static double attackDamage;
	ArrayList<Item> rewardList = new ArrayList<>();
	int wallet;
	double damageStorage;
	enum ailment {healthy, poison, infection, frost, burn, bleed};
	ailment condition;
	enum elements {none, fire, water, ice, elec, earth, wind, corrupt, sacred, nothingness};
	elements weakness;
	elements armor;
	static elements moveElement;
	int modifier = 1;
	
	public Fighter(int atk, int satk, int def, int sdef, int hp, int lvl, int spe, int exp, int sp, int money, String cItem, String rItem, elements weak) {
		
		this.ATK = atk;
		this.sATK = satk;
		this.DEF = def;
		this.sDEF = sdef;
		this.curHP = hp;
		this.maxHP = hp;
		this.level = lvl;
		this.speed = spe;
		this.EXP = exp;
		this.curSP = sp;
		this.maxSP = sp;
		this.money = money;
		this.guard = false;
		this.turn = 0;
		this.common = cItem;
		this.rare = rItem;
		this.condition = ailment.healthy;
		this.weakness = weak;
		this.armor = null;
		
	}
	
	
	// modifikator für schwäche und resistenz
	public int weak(Fighter defender){
		
		if(this.moveElement == defender.weakness){
		
		return modifier = 2;
		}
		if(this.moveElement == defender.armor)
		{
			return modifier /= 2;
		}
		else{
			return modifier;
		}
	}

// funktionen zur itemgewinnung
	public void itemReward(Fighter dropper){
		
		int chance = (int) (Math.random()*99);
		System.out.println(chance);
		if(chance <= 75){
		}
		if(chance > 75 && chance < 90){
				this.rewardList.add (dropper.item.valueOf(dropper.common));
			}
		
		if(chance >= 90){
			this.rewardList.add (dropper.item.valueOf(dropper.rare));
		}
	}
	
	
	public void heapHeapHooray(){
		
		Iterator<Item> iterator = this.rewardList.iterator();
		System.out.println(rewardList);
		while(iterator.hasNext()){
				InventoryScreen.inventoryActor.inv.store(iterator.next(), 1);
		}
		
	}
	
	//funktionen zum kohlemachen
	public void moneyBucket(Fighter deadEnemy){
		wallet+= deadEnemy.money;
	}
	
	public void wallet(){
		this.money += this.wallet;
		System.out.println(this.money);
		
	}


	//funktionsdeklaration für fähigkeiten
	public void moveAI()
	{
		
	}
	
	public void counterAI(){
		
	}
	
//getter 
	public static int getAttack(Fighter fighter){
		
		return fighter.ATK;
		
	}
	
	public static int getSpAttack(Fighter fighter){
		
		return fighter.sATK;
		
	}
	
	public static int getDefense(Fighter fighter){
		
		return fighter.DEF;
		
	}
	
	public static int getSpDefense(Fighter fighter){
		
		return fighter.sDEF;
		
	}
	
	public int getCurrentHP(){
		
		return this.curHP;
		
	}
	
	public int getMaxHP(){
		
		return this.maxHP;
		
	}
	
	public static int getLevel(Fighter fighter){
		
		return fighter.level;
		
	}
	
	public static int getSpeed(Fighter fighter){
		
		return fighter.speed;
		
	}
	
	public static int getExp(Fighter fighter){
		
		return fighter.EXP;
		
	}
	
	public static int getCurSP(Fighter fighter){
		
		return fighter.curSP;
		
	}
	
	public static int getMaxSP(Fighter fighter){
		
		return fighter.maxSP;
		
	}
	
	public static int getMoney(Fighter fighter){
		
		return fighter.money;
		
	}
	
	public String getName(){
		
		return name;
		
	}
	
	//regulärer schaden
	public static double physicalDamage(Fighter attacker, Fighter defender){
		
		attackDamage = getAttack(attacker)*Fighter.getLevel(attacker)*2 - 
				getDefense(defender)*Fighter.getLevel(defender)/1.5;
		
		
		if(defender.guard){
			attackDamage /= 2;
			defender.guard = false;
		}
		
		attackDamage = maxDamage();
		
				
		return attackDamage;
		
	}
	
	//scahdenslimit, et cetera
	public static double maxDamage(){
		
		
		
		Random gen = new Random();
		int battleGen = gen.nextInt(10);
		
		if(battleGen == 0){
			attackDamage = attackDamage  * 2;
		}
		
		attackDamage = Math.round(attackDamage);
		
		if(attackDamage <= 0){
			attackDamage = 1;
		}
		
		if(attackDamage >= 9999){
			attackDamage = 9999;
			return attackDamage;
		}
		
		else{
			return attackDamage;
		}
		
			
		
	}
	
	//physischer angriff
	public static void attack(Fighter attacker, Fighter defender){
		moveElement = elements.none;
		double damage = physicalDamage(attacker, defender);
		damage = damage*attacker.weak(defender);
		defender.curHP -= damage;
		attacker.damageStorage = damage;
		System.out.println(attacker.getName() + " fügt " + defender.getName() + " " + damage + " Schadenspunkte zu!");
		
	}
	
	
//abwehrfunktion
	public static void guard(Fighter defender){
		defender.guard = true;
		System.out.println(defender.getName() + " verteidigt sich!");
	}


	//damage-storage getter für funktionen wie vendetta-konter die mit dem letzten schaden arbeiten
	public static double getDamageStorage(Fighter fighter) {
		return fighter.damageStorage;
	}
	
	
	//funktionen für statusveränderungen
	public static void statusChange(String statusAilment, int chance, Fighter defender){
		
		int hitOrMiss = (int) Math.random()*chance;
		
		if(hitOrMiss == 0)
		{
		switch(statusAilment){
		
		
		case "poison":
			defender.condition = ailment.poison;
			break;
		case "infection":
			defender.condition = ailment.infection;
			break;
		case "frost":
			defender.condition  = ailment.frost;
			break;
		case "burn":
			defender.condition = ailment.burn;
			break;
		case "bleed":
			defender.condition = ailment.bleed;
			break;
		}
			
		}
	}
	
	public void howAreYou()
	{
		if (this.condition == ailment.poison)
		{
			if(this.curHP >= 11){
			this.curHP -= 10;
			}
			if(this.sDEF > 0){
				this.sDEF -= 1;
			}
		}
		
		if (this.condition == ailment.infection)
		{
			if(this.ATK > 0){
				this.ATK -= 1;
			}
			if(this.sDEF > 0){
				this.sDEF -= 1;
		}
		}
		
		if(this.condition == ailment.frost)
		{
			if(this.DEF > 0){
				this.DEF -= 1;
			}
			if(this.speed > 0){
				this.speed -= 1;
			}
		}
		
		if(this.condition == ailment.burn)
		{
			if(this.curHP >= 11){
				this.curHP -= 10;
			}
			if(this.DEF > 0){
				this.DEF -= 1;
		}
		
	}
	
	     if(this.condition == ailment.bleed)
	     {
		   if(this.DEF > 0){
			this.DEF -= 1;
		    }
		   if(this.sDEF > 0){
			this.sDEF -= 1;
	        }
	
        }
	}
}
	




