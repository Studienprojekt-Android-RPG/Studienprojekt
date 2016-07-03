package de.test.game;

public enum Item {

	MESSER("knife", false, 0, 0 , 0), 
	LANGSCHWERT("schwert1", false, 0, 0, 0),
	KURZSCHWERT("schwert2", false, 0, 0, 0), 
	SCHWERT3("schwert3", false, 0, 0, 0), 
	SCHWERT4("schwert4", false, 0, 0, 0), 
	FLAMMENSCHWERT("schwert5", false, 0, 0, 0),
	BRUSTPANZER("armor", false, 1, 0, 0), 
	LEDERARMBAND("lederarmband", false, 2, 0, 0),
	RUNENARMBAND("runenarmband", false, 2, 0, 0),
	SCHUHE("schuhe", false, 3, 0, 0), 
	
	HEILTRANK("healthpot", true, 5, 1000, 0), 
	MANATRANK("manapotion", true, 5, 0, 500), 
	REICHTUMSELIXIER("reichtumselixier", true, 5, 0, 0), 
	WASSERFLASCHE("wasserflasche", true, 5, 0, 40),
	DONUT("donut", true, 6, 40, 0), 
	KRAUT("kraut", true, 6, 0, 0), 
	LEBERKASSEMMEL("leberkassemmel", true, 6, 50, 30),
	PIZZA("pizza", true, 6, 100, 50), 
	ERSTEHILFESET("erstehilfeset", true, 7, 200, 0);
	
	private String textureRegion;
	private boolean consumable;
	private boolean equipable;
	private int sort;
	private int atk;
	private int def;
	private int HP;
	private int speed;
	private int exp;
	private int SP;

	private Item(String textureRegion, boolean pConsumable, int cSort, int cHP, int cSP){
		this.textureRegion = textureRegion;
		this.consumable = pConsumable;
		this.sort = cSort;
		this.HP = cHP;
		this.SP = cSP;
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
}