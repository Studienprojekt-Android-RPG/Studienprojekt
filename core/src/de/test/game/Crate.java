package de.test.game;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;


public class Crate {
	Testmap game;
	MapLayer layer;
	MapLayer layerhide;
	Player player = Gamescreen.player;
	Rectangle crate;
	boolean nope = true;
	
	public void abfragecrate(){
	layerhide = Gamescreen.tiledMap.getLayers().get("crate");	
		if(nope){
		
		layer = Gamescreen.tiledMap.getLayers().get("Crate");
		RectangleMapObject eventCrateRect = (RectangleMapObject) layer.getObjects().get("testcrate");
		crate = eventCrateRect.getRectangle();

		if(Intersector.overlaps(crate, player.getBounds())){
			if(Gamescreen.act.isPressed()){
				ArrayList<Item> crateItems = new ArrayList<>();

				for(int i = 0; i < (int) (Math.random()*5); i++) {
					crateItems.add(Item.getRandom());
				}
				
				Iterator<Item> iterator = crateItems.iterator();
				
				while(iterator.hasNext()) {
					InventoryActor.inv.store(iterator.next(), 1);
					Gamescreen.player.saveInventory();
				}
				
				nope = false;
				layerhide.setVisible(false);
			}
		
		
		}}
		
	}
}