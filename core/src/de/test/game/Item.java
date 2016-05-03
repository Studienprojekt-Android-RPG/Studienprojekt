package de.test.game;

public enum Item {

	MESSER("knife"), CRYSTAL_BLUE("bluecrystal"), CRYSTAL_GREEN("greencrystal"), BRUSTPANZER("armor"), 
	CRYSTAL_MAGENTA("magentacrystal"), CRYSTAL_CYAN("cyancrystal"), CRYSTAL_ORANGE("orangecrystal"), MANATRANK("manapotion"), 
	TITANIUM("titanium"), PALLADIUM("palladium"), HEILTRANK("healthpot"), RHODIUM("rhodium"), HULL("hullbase"), 
	CANNON("cannonbase"), REICHTUMSELIXIER("reichtumselixier"), LANGSCHWERT("schwert1"), DROID("droidbase"), 
	KURZSCHWERT("schwert2"), BATTERY("batterybase");

	private String textureRegion;

	private Item(String textureRegion) {
		this.textureRegion = textureRegion;
	}

	public String getTextureRegion() {
		return textureRegion;
	}

}