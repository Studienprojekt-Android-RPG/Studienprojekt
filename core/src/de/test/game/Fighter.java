package de.test.game;

public abstract class Fighter {
	int ATK;
	int DEF;
	int curHP;
	int maxHP;
	int level;
	int speed;
	String name;
	boolean guard;
	
	public Fighter(int atk, int def, int hp, int lvl, int sp, String name) {
		
		this.ATK = atk;
		this.DEF = def;
		this.curHP = hp;
		this.maxHP = hp;
		this.level = lvl;
		this.speed = sp;
		this.name = name;
		this.guard = false;
		
	}
	
	public static int getAttack(Fighter fighter){
		
		return fighter.ATK;
		
	}
	
	public static int getDefense(Fighter fighter){
		
		return fighter.DEF;
		
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
	
	public String getName(){
		
		return name;
		
	}
	
	public static int turnSpeed(Fighter fighter){
		
		return getLevel(fighter) + getSpeed(fighter);
		
	}
	
	public static double physicalDamage(Fighter attacker, Fighter defender){
		
		double attackDamage = getAttack(attacker)*Fighter.getLevel(attacker)*2 - 
				getDefense(defender)*Fighter.getLevel(defender)/1.5;
		
		if(defender.guard){
			attackDamage /= 2;
			defender.guard = false;
		}
		
		if(attackDamage >= 9999){
			attackDamage = 9999;
		}
		
		return attackDamage;
		
	}
	
	public static double techDamage(Fighter attacker, Fighter defender){
		
		double techDamage = getAttack(attacker)*Fighter.getLevel(attacker)*2 - 
				getDefense(defender)*Fighter.getLevel(defender)/1.5;
		
		if(techDamage >= 9999){
			techDamage = 9999;
		}
		
		return techDamage;
		
	}
	
	public static void attack(Fighter attacker, Fighter defender){
		double damage = Math.round(physicalDamage(attacker, defender));
		defender.curHP -= damage;
		System.out.println(attacker.getName() + " fügt " + defender.getName() + " " + damage + " Schadenspunkte zu!");
		
	}
	
	public static void techAttack(Fighter attacker, Fighter defender){
		double damage = Math.round(techDamage(attacker, defender));
		defender.curHP -= damage;
		System.out.println(attacker.getName() + " fügt " + defender.getName() + " " + damage + " Schadenspunkte zu!");
		
	}
	
	public static void guard(Fighter defender){
		defender.guard = true;
		System.out.println(defender.getName() + " verteidigt sich!");
	}
	
}


