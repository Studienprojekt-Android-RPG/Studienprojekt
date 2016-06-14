package de.test.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;


public class Testmap extends Game {
	static String horst;
	Battlescreen battlescreen;
	Gamescreen gamescreen;
	StartMenu startMenu;
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
}