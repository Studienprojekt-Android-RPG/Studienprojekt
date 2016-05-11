package de.test.game;

public enum Item {

	MESSER("knife"), SCHWERT3("schwert3"), SCHUHE("schuhe"), BRUSTPANZER("armor"), DONUT("donut"), SCHWERT4("schwert4"), 
	WASSERFLASCHE("wasserflasche"), MANATRANK("manapotion"), ERSTEHILFESET("erstehilfeset"), PIZZA("PIZZA"), 
	HEILTRANK("healthpot"), FLAMMENSCHWERT("schwert5"), LEDERARMBAND("lederarmband"), PAPIER("papier"), REICHTUMSELIXIER("reichtumselixier"), 
	LANGSCHWERT("schwert1"), RUNENARMBAND("runenarmband"), KURZSCHWERT("schwert2"), LEBERKASSEMMEL("leberkassemmel");
	
	private String textureRegion;

	private Item(String textureRegion) {
		this.textureRegion = textureRegion;
	}
	
	public String getTextureRegion() {
		return textureRegion;
	}
}