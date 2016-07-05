package de.test.game;

public enum Item {
	//				textureRegion		consumable sort HP		SP		Atk		Def		Speed	Exp
	MESSER			("knife", 				false,	0,	0, 		0,		0, 	 	0,		0,		0), 
	LANGSCHWERT		("schwert1", 			false, 	0, 	0, 		0,		0,		0,		0,		0),
	KURZSCHWERT		("schwert2", 			false, 	0, 	0, 		0,		0,		0,		0,		0), 
	SCHWERT3		("schwert3", 			false, 	0, 	0, 		0,		0,		0,		0,		0), 
	SCHWERT4		("schwert4", 			false, 	0, 	0, 		0,		0,		0,		0,		0), 
	FLAMMENSCHWERT	("schwert5", 			false, 	0, 	0, 		0,		0,		0,		0,		0),
	BRUSTPANZER		("armor", 				false, 	1, 	0, 		0,		0,		0,		0,		0), 
	LEDERARMBAND	("lederarmband", 		false, 	2, 	0, 		0,		0,		0,		0,		0),
	RUNENARMBAND	("runenarmband", 		false, 	2, 	0, 		0,		0,		0,		0,		0),
	SCHUHE			("schuhe", 				false, 	3, 	0, 		0,		0,		0,		0,		0), 
	HEILTRANK		("healthpot", 			true, 	5, 	1000,	0,		0,		0,		0,		0), 
	MANATRANK		("manapotion", 			true, 	5, 	0, 		500,	0,		0,		0,		0), 
	REICHTUMSELIXIER("reichtumselixier", 	true, 	5, 	0, 		0,		0,		0,		0,		0), 
	WASSERFLASCHE	("wasserflasche", 		true, 	5, 	0, 		40,		0,		0,		0,		0),
	DONUT			("donut", 				true, 	6, 	40, 	0,		0,		0,		0,		0), 
	KRAUT			("kraut", 				true, 	6, 	0, 		0,		0,		0,		0,		0), 
	LEBERKASSEMMEL	("leberkassemmel", 		true, 	6, 	50, 	30,		0,		0,		0,		0),
	PIZZA			("pizza", 				true, 	6, 	100, 	50,		0,		0,		0,		0), 
	ERSTEHILFESET	("erstehilfeset", 		true, 	7, 	200, 	0,		0,		0,		0,		0);
	
	private String textureRegion;
	private final boolean consumable;
	private final int sort;
	private final int atk;
	private final int def;
	private final int HP;
	private final int speed;
	private final int exp;
	private final int SP;

	private Item(String textureRegion, boolean pConsumable, int cSort, int cHP, int cSP, int cAtk, int cDef, int cSpeed, int cExp){
		this.textureRegion = textureRegion;
		this.consumable = pConsumable;
		this.sort = cSort;
		this.HP = cHP;
		this.SP = cSP;
		this.atk = cAtk;
		this.def = cDef;
		this.speed = cSpeed;
		this.exp = cExp;
	}
	
	public String getTextureRegion() {
		return textureRegion;
	}
	
	public boolean getConsumable()
	{
		return consumable;
	}
	
	public int getHP()
	{
		return HP;
	}
	
	public int getSP()
	{
		return SP;
	}
	
	public int getSort() {
		return sort;
	}

	public int getAtk() {
		return atk;
	}

	public int getDef() {
		return def;
	}

	public int getSpeed() {
		return speed;
	}

	public int getExp() {
		return exp;
	}
}