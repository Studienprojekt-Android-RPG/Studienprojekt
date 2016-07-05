package de.test.game;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

public class EventManager {
	MapLayer layer;
	Player player = Gamescreen.player;
	enum eventState{Demo, eventEnd};
	static eventState eventstate = eventState.Demo;
	Events demo = new Events();
	String map = mapManager.map;
	
	Rectangle eventDemo;
	
	public EventManager(){
	
	}
	
	public void abfrage(){
		if(mapManager.map.equals("maps/altbau.tmx")){
			layer = Gamescreen.tiledMap.getLayers().get("Event");
			
			RectangleMapObject eventDemoRect = (RectangleMapObject) layer.getObjects().get("DemoEvent");
			eventDemo = eventDemoRect.getRectangle();
		
			switch(eventstate){
				case Demo:
					if(Intersector.overlaps(eventDemo, player.getBounds())){
						demo.demoEvent();
//						eventstate = eventState.eventEnd;
					}
				break;
				
				case eventEnd:
						Events.ani = null;
//						Gamescreen.eventmanager.demo.demoStrings.setVisible(false);
						Gamescreen.player.allowMov = true;
				break;
			}
		}
		
	}
}
