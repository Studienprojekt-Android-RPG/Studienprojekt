package de.test.game;

public enum Item {

	MESSER("knife", false, 0 ,0), 
	SCHWERT3("schwert3", false, 0, 0), 
	SCHUHE("schuhe", false, 0, 0), 
	BRUSTPANZER("armor", false, 0, 0), 
	DONUT("donut", true, 40, 0), 
	SCHWERT4("schwert4", false, 0, 0), 
	WASSERFLASCHE("wasserflasche", true, 0, 40), 
	MANATRANK("manapotion", true, 0, 500), 
	ERSTEHILFESET("erstehilfeset", true, 200, 0), 
	PIZZA("pizza", true, 100, 50), 
	HEILTRANK("healthpot", true, 1000, 0), 
	FLAMMENSCHWERT("schwert5", false, 0, 0), 
	LEDERARMBAND("lederarmband", false, 0, 0), 
	KRAUT("kraut", true, 0, 0), 
	REICHTUMSELIXIER("reichtumselixier", true, 0, 0), 
	LANGSCHWERT("schwert1", false, 0, 0), 
	RUNENARMBAND("runenarmband", false, 0, 0), 
	KURZSCHWERT("schwert2", false, 0, 0), 
	LEBERKASSEMMEL("leberkassemmel", true, 50, 30);
	
	private String textureRegion;
	private boolean consumable;
	private boolean equipable;
	private int atk;
	private int def;
	private int HP;
	private int speed;
	private int exp;
	private int SP;

	private Item(String textureRegion, boolean pConsumable, int pHP, int pSP){
		this.textureRegion = textureRegion;
		this.consumable = pConsumable;
		this.HP = pHP;
		this.SP = pSP;
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
}