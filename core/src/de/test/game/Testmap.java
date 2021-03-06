package de.test.game;

import java.io.File;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;


public class Testmap extends Game {
	
	static String horst;
	static String horsty;
	
	File saveFile;
	static Preferences prefs;
	
	Battlescreen battlescreen;
	Gamescreen gamescreen;
	StartMenu startMenu;
	Gameoverscreen gameoverscreen;
	InventoryScreen inventoryscreen;
	Statusscreen statusscreen;
	musicManager music;
	LoadGameScreen loadGameScreen;
	
	public static enum ScreenType{
		StartMenu,
		Gamescreen,
		Battlescreen,
		Inventory,
		LoadScreen,
		Statusscreen,
		Gameoverscreen,
		LoadGameScreen
	}
	
	public Screen getScreenType(ScreenType screenType){
		switch(screenType){
			case StartMenu:
				return startMenu;
			case Gamescreen:
				return gamescreen;
			case Battlescreen:
				return battlescreen;
			case Inventory:
				return inventoryscreen;
			case Statusscreen:
				return statusscreen;
			case Gameoverscreen:
				return gameoverscreen;
			case LoadGameScreen:
				return loadGameScreen;
			default:
				return startMenu;
		}

	}
	
	@Override
	public void create() {
		music = new musicManager();
		startMenu = new StartMenu(this);
		gamescreen = new Gamescreen(this);
		inventoryscreen = new InventoryScreen(this);
		battlescreen = new Battlescreen(this);
		statusscreen = new Statusscreen(this);
		gameoverscreen = new Gameoverscreen(this);
		loadGameScreen = new LoadGameScreen(this);

		setScreen(startMenu);
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render() {
		music.update();
		super.render();
	}
	
	public Screen getGameScreen(){
		return gamescreen;
	}
	public static void setHorst(String string){
		horst = string;
	}
	public String getHorst(){
		return horst;
	}
	
	public static void setHorsty(String string)
	{
		horsty = string;
	}
	
	public String getHorsty()
	{
		return horsty;
	}
	
	public void setSaveFile(File pSaveFile)
	{
		saveFile = pSaveFile;
		setPrefs();
	}
	
	public void setPrefs()
	{
		prefs = Gdx.app.getPreferences(saveFile.getName());
	}
}