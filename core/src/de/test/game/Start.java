package de.test.game;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;

import de.test.game.Testmap.ScreenType;

public class Start
{
	Testmap game;
	
	Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
	
	public static InventoryActor inventoryActor; 
	
	public Player player;

	public Start()
	{
		inventoryActor = new InventoryActor(new Inventory(), skin);
		player = new Player(new Vector2(Gamescreen.gamescreen.playerx, Gamescreen.gamescreen.playery), "leon.png", 55, 55, 10, 10, 200, 20, 10, 600, 10, 500);
	}
	
	public void newGame()
	{
		Gamescreen.tiledMap = new TmxMapLoader().load(Gamescreen.map);
		Gamescreen.gamescreen.layer = Gamescreen.tiledMap.getLayers().get("Spawnpoints");
		Gamescreen.gamescreen.rect = (RectangleMapObject) Gamescreen.gamescreen.layer.getObjects().get("spla1");
	 	player.position.x = (float) Gamescreen.gamescreen.rect.getRectangle().x;
	 	player.position.y = (float) Gamescreen.gamescreen.rect.getRectangle().y;
		System.out.println("Player Does Not Exist, Creating Player and Saving Player");
		game.setScreen(game.getScreenType(ScreenType.Gamescreen));
	}
	
	public void loadGame()
	{
		try {
			player.readPlayer();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Player Exists, Reading File");
		game.setScreen(game.getScreenType(ScreenType.Gamescreen));
		Gamescreen.tiledMap = new TmxMapLoader().load(Gamescreen.map);
	}
	
	public Player getPlayer()
	{
		return this.player;
	}
}
