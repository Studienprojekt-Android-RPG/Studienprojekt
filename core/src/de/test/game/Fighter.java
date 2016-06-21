package de.test.game;

import java.util.Random;

public abstract class Fighter {
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
	//Item item;
	String name;
	boolean guard;
	static double attackDamage;
	double damageStorage;
	
	public Fighter(int atk, int satk, int def, int sdef, int hp, int lvl, int spe, int exp, int sp, int money) {
		
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
		
	}

	
	public void moveAI()
	{
		
	}
	
	public void counterAI(){
		
	}
	

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
	
	public static int turnSpeed(Fighter fighter){
		
		return getLevel(fighter) + getSpeed(fighter);
		
	}
	
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
	
	public static double techDamage(Fighter attacker, Fighter defender){
		
		attackDamage = getAttack(attacker)*Fighter.getLevel(attacker)*2 - 
				getDefense(defender)*Fighter.getLevel(defender)/1.5;
		
		attackDamage = maxDamage();
		
		return attackDamage;
		
	}
	
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
	
	public static void attack(Fighter attacker, Fighter defender){
		double damage = physicalDamage(attacker, defender);
		defender.curHP -= damage;
		attacker.damageStorage = damage;
		System.out.println(attacker.getName() + " fügt " + defender.getName() + " " + damage + " Schadenspunkte zu!");
		
	}
	
	


	public static void guard(Fighter defender){
		defender.guard = true;
		System.out.println(defender.getName() + " verteidigt sich!");
	}


	public static double getDamageStorage(Fighter fighter) {
		return fighter.damageStorage;
	}





}


