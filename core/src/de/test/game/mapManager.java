package de.test.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class mapManager {
	static String map = "data/demondus1.tmx";
	String mapchange;
	MapLayer layer;
	MapProperties prop;
	float playerx;
	float playery;
	int mapWidth;
	int mapHeight;
	
	Player player = Gamescreen.player;
	
	Music Demtheme = Gdx.audio.newMusic(Gdx.files.internal("The Tea Garden.mp3"));
	Music Foresttheme = Gdx.audio.newMusic(Gdx.files.internal("The Lonely Amazon.mp3"));
	Music Schooltheme = Gdx.audio.newMusic(Gdx.files.internal("In-Game.mp3"));
	Music Hometheme = Gdx.audio.newMusic(Gdx.files.internal("Home.mp3"));
	
	ArrayList<Rectangle> bounds = new ArrayList<Rectangle>();
	
	Vector2 spawn1 = new Vector2(playerx, playery);
	Vector2 spawn2 = new Vector2(playerx, playery);
	Vector2 spawn3 = new Vector2(playerx, playery);
	Vector2 spawn4 = new Vector2(playerx, playery);
	Vector2 spawn5 = new Vector2(playerx, playery);
	Vector2 spawn6 = new Vector2(playerx, playery);
	Vector2 spawn7 = new Vector2(playerx, playery);
	Vector2 spawn8 = new Vector2(playerx, playery);
	Vector2 spawn9 = new Vector2(playerx, playery);
	Vector2 spawn10 = new Vector2(playerx, playery);
	Vector2 spawn11= new Vector2(playerx, playery);
	Vector2 spawn12= new Vector2(playerx, playery);
	Vector2 spawn13= new Vector2(playerx, playery);
	Vector2 spawn14= new Vector2(playerx, playery);
	
	Rectangle exit1;
	Rectangle exit2;
	Rectangle exit3;
	Rectangle exit4;
	Rectangle exit5;
	Rectangle exit6;
	Rectangle exit7;
	Rectangle exit8;
	Rectangle exit9;
	Rectangle exit10;
	Rectangle exit11;
	Rectangle exit12;
	Rectangle exit13;
	Rectangle exit14;
	

	public mapManager(){
		
	}
	
	public void update(){
		for (int i = 0; i < bounds.size(); i++){
			if(bounds.get(i).overlaps(player.getBounds())){
				player.reAdjust();
			}
		}
		
		switch(map){  
		case "data/demondus1.tmx":	Demtheme.play();
									if(Intersector.overlaps(exit1, player.getBounds())){
										mapchange = "data/demondus2.tmx";
										changeMap(mapchange, map, spawn1);
									}
									if(Intersector.overlaps(exit2, player.getBounds())){
										mapchange = "data/room.tmx";
										changeMap(mapchange, map, spawn3);
									}
									if(Intersector.overlaps(exit3, player.getBounds())){
										mapchange = "data/room.tmx";
										changeMap(mapchange, map, spawn6);
									}
		break;
		
		case "data/demondus2.tmx":	Demtheme.play();
									if(Intersector.overlaps(exit1, player.getBounds())){
										mapchange = "data/demondus1.tmx";
										changeMap(mapchange, map, spawn2);
									}
									if(Intersector.overlaps(exit3, player.getBounds())){
										mapchange = "data/demondus3.tmx";
										changeMap(mapchange, map, spawn1);
									}
									if(Intersector.overlaps(exit2, player.getBounds())){
										mapchange = "data/room.tmx";
										changeMap(mapchange, map, spawn1);
									}
		break;
		
		case "data/demondus3.tmx": 	Demtheme.play();
									if(Intersector.overlaps(exit1, player.getBounds())){
										mapchange = "data/demondus2.tmx";
										changeMap(mapchange, map, spawn3);
									}							
									if(Intersector.overlaps(exit2, player.getBounds())){
										mapchange = "data/demondus4.tmx";
										changeMap(mapchange, map, spawn1);
									}
									if(Intersector.overlaps(exit3, player.getBounds())){
										mapchange = "data/demondus7.tmx";
										changeMap(mapchange, map, spawn1);
									}	
									if(Intersector.overlaps(exit4, player.getBounds())){
										mapchange ="data/room.tmx";
										changeMap(mapchange, map, spawn7);
									}
		break;
		
		case "data/demondus4.tmx":	Demtheme.play();
									if(Intersector.overlaps(exit1, player.getBounds())){
										mapchange = "data/demondus3.tmx";
										changeMap(mapchange, map, spawn2);
									}
									if(Intersector.overlaps(exit2, player.getBounds())){
										mapchange = "data/room.tmx";
										changeMap(mapchange, map, spawn2);
									}
									if(Intersector.overlaps(exit3, player.getBounds())){
										mapchange = "data/demondus5.tmx";
										changeMap(mapchange, map, spawn1);
									}
		break;
		
		case "data/demondus5.tmx": Demtheme.play();
									if(Intersector.overlaps(exit1, player.getBounds())){
										mapchange = "data/demondus4.tmx";
										changeMap(mapchange, map, spawn3);
									}
		break;
		
		case "data/wehhh.tmx":		Demtheme.play();
									if(Intersector.overlaps(exit1, player.getBounds())){
										mapchange = "data/room.tmx";
										changeMap(mapchange, map, spawn7);
									}
		break;	
									
		case "data/room.tmx":		Demtheme.play();
									if(Intersector.overlaps(exit1, player.getBounds())){
										mapchange = "data/demondus2.tmx";
										changeMap(mapchange, map, spawn2);
									}
									if(Intersector.overlaps(exit2, player.getBounds())){
										mapchange = "data/demondus4.tmx";
										changeMap(mapchange, map, spawn2);
									}
									if(Intersector.overlaps(exit3, player.getBounds())){
										mapchange = "data/demondus1.tmx";
										changeMap(mapchange, map, spawn3);
									}
									if(Intersector.overlaps(exit4, player.getBounds())){
										mapchange = "data/room.tmx";
										player.setPosition(spawn4);
										changeMap(mapchange, map, spawn4);
									}
									if(Intersector.overlaps(exit5, player.getBounds())){
										mapchange = "data/room.tmx";
										changeMap(mapchange, map, spawn5);
									}
									if(Intersector.overlaps(exit6, player.getBounds())){
										mapchange = "data/demondus1.tmx";
										changeMap(mapchange, map, spawn4);
									}
									if(Intersector.overlaps(exit7, player.getBounds())){
										mapchange = "data/demondus3.tmx";
										changeMap(mapchange, map, spawn4);
									}
									if(Intersector.overlaps(exit8, player.getBounds())){
										mapchange = "data/wehhh.tmx";
										changeMap(mapchange, map, spawn1);
									}
									if(Intersector.overlaps(exit9, player.getBounds())){
										mapchange = "data/demondusdorf.tmx";
										changeMap(mapchange, map, spawn3);
									}
									if(Intersector.overlaps(exit10, player.getBounds())){
										mapchange = "data/demondusdorf.tmx";
										changeMap(mapchange, map, spawn4);
									}
									if(Intersector.overlaps(exit11, player.getBounds())){
										mapchange = "data/demondusdorf.tmx";
										changeMap(mapchange, map, spawn2);
									}
		break;
		
		case "data/demondus7.tmx":	if(Intersector.overlaps(exit1, player.getBounds())){
										mapchange = "data/demondus3.tmx";
										changeMap(mapchange, map, spawn3);
									}
									if(Intersector.overlaps(exit2, player.getBounds())){
										mapchange = "data/demondusdorf.tmx";
										changeMap(mapchange, map, spawn1);
									}					
		break;
		
		case "data/demondusdorf.tmx":	if(Intersector.overlaps(exit1, player.getBounds())){
											mapchange = "data/demondus7.tmx";
											changeMap(mapchange, map, spawn2);
										}
										if(Intersector.overlaps(exit2, player.getBounds())){
											mapchange = "data/room.tmx";
											changeMap(mapchange, map, spawn10);
										}
										if(Intersector.overlaps(exit3, player.getBounds())){
											mapchange = "data/room.tmx";
											changeMap(mapchange, map, spawn8);
										}
										if(Intersector.overlaps(exit4, player.getBounds())){
											mapchange = "data/room.tmx";
											changeMap(mapchange, map, spawn9);
										}
										if(Intersector.overlaps(exit5, player.getBounds())){
											mapchange = "data/kathedrale.tmx";
											changeMap(mapchange, map, spawn1);
										}
		break;
		
		case "data/kathedrale.tmx":		Demtheme.play();
									if(Intersector.overlaps(exit1, player.getBounds())){
										mapchange = "data/demondusdorf.tmx";
										changeMap(mapchange, map, spawn5);
									}
									if(Intersector.overlaps(exit2, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn2);
									}
									if(Intersector.overlaps(exit3, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn3);
									}
									if(Intersector.overlaps(exit4, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn4);
									}
									if(Intersector.overlaps(exit5, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn5);
									}
									if(Intersector.overlaps(exit6, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn6);
									}
									if(Intersector.overlaps(exit7, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn7);
									}
									if(Intersector.overlaps(exit8, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn8);
									}
									if(Intersector.overlaps(exit9, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn9);
									}
									if(Intersector.overlaps(exit10, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn10);
									}
									if(Intersector.overlaps(exit11, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn11);
									}
									if(Intersector.overlaps(exit12, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn12);
									}
									if(Intersector.overlaps(exit13, player.getBounds())){
										mapchange = "data/kathedrale.tmx";
										changeMap(mapchange, map, spawn13);
									}
		break;
	}
	}
	
	@SuppressWarnings("static-access")
	public void changeMap(String map, String mapchange, Vector2 spawn) {
		this.map = map;
	        Gamescreen.tiledMap = new TmxMapLoader().load(map); //load the new map
	        Gamescreen.renderer.getMap().dispose(); //dispose the old map
	        Gamescreen.renderer.setMap(Gamescreen.tiledMap); //set the map in your renderer
		    setCollision();
			getSpawnpoints();
			this.mapchange = mapchange;
			playerx = spawn.x;
			playery = spawn.y;
		    Gamescreen.player.position.x = playerx;
		    Gamescreen.player.position.y = playery;
		    getExitpoints();		
	}
	
	@SuppressWarnings("unused")
	public void setCollision(){
		bounds.clear();
		prop = Gamescreen.tiledMap.getProperties();
	    mapWidth = prop.get("width", Integer.class);
	    mapHeight = prop.get("height", Integer.class);
	      for (int i = 0; i < mapWidth; i++){
	    	  for (int j = 0; j < mapHeight; j++){
	    		  TiledMapTileLayer cur = (TiledMapTileLayer) Gamescreen.tiledMap.getLayers().get("Collision");
	    		  Cell cell = new Cell();
	    		  
	    		  if(cur.getCell(i, j) != null){
	    			  cell = cur.getCell(i, j);
	    			  bounds.add(new Rectangle(i * 32, j * 32, 32, 32));
	    		  }
	    	  }
	      }
	}
	
	public void getSpawnpoints(){
		int playerx;
		int playery;
		layer = Gamescreen.tiledMap.getLayers().get("Spawnpoints");
		
		
		switch(map){
			case "data/demondus1.tmx":	RectangleMapObject rect1 = (RectangleMapObject) layer.getObjects().get("spawnpoint1");
										playerx = (int) rect1.getRectangle().x;
										playery = (int) rect1.getRectangle().y;
										spawn1.x = playerx;
										spawn1.y = playery;
										
										RectangleMapObject rect2 = (RectangleMapObject) layer.getObjects().get("spde2");
										playerx = (int) rect2.getRectangle().x;
										playery = (int) rect2.getRectangle().y;
										spawn2.x = playerx;
										spawn2.y = playery;
										
										RectangleMapObject rect3 = (RectangleMapObject) layer.getObjects().get("spzede1");
										playerx = (int) rect3.getRectangle().x;
										playery = (int) rect3.getRectangle().y;
										spawn3.x = playerx;
										spawn3.y = playery;
										
										RectangleMapObject rect4 = (RectangleMapObject) layer.getObjects().get("sprode1");
										playerx = (int) rect4.getRectangle().x;
										playery = (int) rect4.getRectangle().y;
										spawn4.x = playerx;
										spawn4.y = playery;
										
			break;
			
			case "data/demondus2.tmx":	RectangleMapObject rect5 = (RectangleMapObject) layer.getObjects().get("spawnpoint1");
										playerx = (int) rect5.getRectangle().x;
										playery = (int) rect5.getRectangle().y;
										spawn1.x = playerx;
										spawn1.y = playery;
										
										RectangleMapObject rect6 = (RectangleMapObject) layer.getObjects().get("sprode2");
										playerx = (int) rect6.getRectangle().x;
										playery = (int) rect6.getRectangle().y;
										spawn2.x = playerx;
										spawn2.y = playery;
										
										RectangleMapObject rect7 = (RectangleMapObject) layer.getObjects().get("spde3");
										playerx = (int) rect7.getRectangle().x;
										playery = (int) rect7.getRectangle().y;
										spawn3.x = playerx;
										spawn3.y = playery;
										
			break;
			
			case "data/room.tmx":		RectangleMapObject rect8 = (RectangleMapObject) layer.getObjects().get("sprode2");
										playerx = (int) rect8.getRectangle().x;
										playery = (int) rect8.getRectangle().y;
										spawn1.x = playerx;
										spawn1.y = playery;
										
										RectangleMapObject rect9 = (RectangleMapObject) layer.getObjects().get("sprode4");
										playerx = (int) rect9.getRectangle().x;
										playery = (int) rect9.getRectangle().y;
										spawn2.x = playerx;
										spawn2.y = playery;
										
										RectangleMapObject rect10 = (RectangleMapObject) layer.getObjects().get("spzede1");
										playerx = (int) rect10.getRectangle().x;
										playery = (int) rect10.getRectangle().y;
										spawn3.x = playerx;
										spawn3.y = playery;
										
										RectangleMapObject rect11 = (RectangleMapObject) layer.getObjects().get("sptrup");
										playerx = (int) rect11.getRectangle().x;
										playery = (int) rect11.getRectangle().y;
										spawn4.x = playerx;
										spawn4.y = playery;
										
										RectangleMapObject rect12 = (RectangleMapObject) layer.getObjects().get("sptrdo");
										playerx = (int) rect12.getRectangle().x;
										playery = (int) rect12.getRectangle().y;
										spawn5.x = playerx;
										spawn5.y = playery;
										
										RectangleMapObject rect13 = (RectangleMapObject) layer.getObjects().get("sprode1");
										playerx = (int) rect13.getRectangle().x;
										playery = (int) rect13.getRectangle().y;
										spawn6.x = playerx;
										spawn6.y = playery;
										
										RectangleMapObject rect14 = (RectangleMapObject) layer.getObjects().get("sprode3");
										playerx = (int) rect14.getRectangle().x;
										playery = (int) rect14.getRectangle().y;
										spawn7.x = playerx;
										spawn7.y = playery;
										
										RectangleMapObject rect15 = (RectangleMapObject) layer.getObjects().get("sprodd1");
										playerx = (int) rect15.getRectangle().x;
										playery = (int) rect15.getRectangle().y;
										spawn8.x = playerx;
										spawn8.y = playery;
										
										RectangleMapObject rect16 = (RectangleMapObject) layer.getObjects().get("sprodd2");
										playerx = (int) rect16.getRectangle().x;
										playery = (int) rect16.getRectangle().y;
										spawn9.x = playerx;
										spawn9.y = playery;
										
										RectangleMapObject rect17 = (RectangleMapObject) layer.getObjects().get("sprodd3");
										playerx = (int) rect17.getRectangle().x;
										playery = (int) rect17.getRectangle().y;
										spawn10.x = playerx;
										spawn10.y = playery;
			break;
			
			case "data/demondus3.tmx":	RectangleMapObject rect19 = (RectangleMapObject) layer.getObjects().get("spde2");
										playerx = (int) rect19.getRectangle().x;
										playery = (int) rect19.getRectangle().y;
										spawn1.x = playerx;
										spawn1.y = playery;
										
										RectangleMapObject rect20 = (RectangleMapObject) layer.getObjects().get("spde4");
										playerx = (int) rect20.getRectangle().x;
										playery = (int) rect20.getRectangle().y;
										spawn2.x = playerx;
										spawn2.y = playery;
										
										RectangleMapObject rect21 = (RectangleMapObject) layer.getObjects().get("spde7");
										playerx = (int) rect21.getRectangle().x;
										playery = (int) rect21.getRectangle().y;
										spawn3.x = playerx;
										spawn3.y = playery;	
										
										RectangleMapObject rect22 = (RectangleMapObject) layer.getObjects().get("sprode3");
										playerx = (int) rect22.getRectangle().x;
										playery = (int) rect22.getRectangle().y;
										spawn4.x = playerx;
										spawn4.y = playery;
			break;
			
			case "data/demondus4.tmx":	RectangleMapObject rect23 = (RectangleMapObject) layer.getObjects().get("spde3");
										playerx = (int) rect23.getRectangle().x;
										playery = (int) rect23.getRectangle().y;
										spawn1.x = playerx;
										spawn1.y = playery;
										
										RectangleMapObject rect24 = (RectangleMapObject) layer.getObjects().get("sprode4");
										playerx = (int) rect24.getRectangle().x;
										playery = (int) rect24.getRectangle().y;
										spawn2.x = playerx;
										spawn2.y = playery;
										
										RectangleMapObject rect25 = (RectangleMapObject) layer.getObjects().get("spcade4");
										playerx = (int) rect25.getRectangle().x;
										playery = (int) rect25.getRectangle().y;
										spawn3.x = playerx;
										spawn3.y = playery;
			break;
			
			case "data/demondus5.tmx":	RectangleMapObject rect26 = (RectangleMapObject) layer.getObjects().get("spcade4");
										playerx = (int) rect26.getRectangle().x;
										playery = (int) rect26.getRectangle().y;
										spawn1.x = playerx;
										spawn1.y = playery;
			break;
			
			case "data/wehhh.tmx":		RectangleMapObject rect27 = (RectangleMapObject) layer.getObjects().get("spsede3");
										playerx = (int) rect27.getRectangle().x;
										playery = (int) rect27.getRectangle().y;
										spawn1.x = playerx;
										spawn1.y = playery;
			break;
			
			case "data/demondus7.tmx":	RectangleMapObject rect28 = (RectangleMapObject) layer.getObjects().get("spde3");
										playerx = (int) rect28.getRectangle().x;
										playery = (int) rect28.getRectangle().y;
										spawn1.x = playerx;
										spawn1.y = playery;
										
										RectangleMapObject rect29 = (RectangleMapObject) layer.getObjects().get("spdd");
										playerx = (int) rect29.getRectangle().x;
										playery = (int) rect29.getRectangle().y;
										spawn2.x = playerx;
										spawn2.y = playery;
			break;
			
			case "data/demondusdorf.tmx":	RectangleMapObject rect30 = (RectangleMapObject) layer.getObjects().get("spde7");
											playerx = (int) rect30.getRectangle().x;
											playery = (int) rect30.getRectangle().y;
											spawn1.x = playerx;
											spawn1.y = playery;
											
											RectangleMapObject rect31 = (RectangleMapObject) layer.getObjects().get("sprodd3");
											playerx = (int) rect31.getRectangle().x;
											playery = (int) rect31.getRectangle().y;
											spawn2.x = playerx;
											spawn2.y = playery;
											
											RectangleMapObject rect32 = (RectangleMapObject) layer.getObjects().get("sprodd1");
											playerx = (int) rect32.getRectangle().x;
											playery = (int) rect32.getRectangle().y;
											spawn3.x = playerx;
											spawn3.y = playery;			
											
											RectangleMapObject rect33 = (RectangleMapObject) layer.getObjects().get("sprodd2");
											playerx = (int) rect33.getRectangle().x;
											playery = (int) rect33.getRectangle().y;
											spawn4.x = playerx;
											spawn4.y = playery;			
											
											RectangleMapObject rect34 = (RectangleMapObject) layer.getObjects().get("spka");
											playerx = (int) rect34.getRectangle().x;
											playery = (int) rect34.getRectangle().y;
											spawn5.x = playerx;
											spawn5.y = playery;
			break;
			
			case "data/kathedrale.tmx":	RectangleMapObject rect35 = (RectangleMapObject) layer.getObjects().get("spdd");
											playerx = (int) rect35.getRectangle().x;
											playery = (int) rect35.getRectangle().y;
											spawn1.x = playerx;
											spawn1.y = playery;
											
											RectangleMapObject rect36 = (RectangleMapObject) layer.getObjects().get("spka1");
											playerx = (int) rect36.getRectangle().x;
											playery = (int) rect36.getRectangle().y;
											spawn2.x = playerx;
											spawn2.y = playery;
											
											RectangleMapObject rect37 = (RectangleMapObject) layer.getObjects().get("spka2");
											playerx = (int) rect37.getRectangle().x;
											playery = (int) rect37.getRectangle().y;
											spawn3.x = playerx;
											spawn3.y = playery;			
											
											RectangleMapObject rect41 = (RectangleMapObject) layer.getObjects().get("spka3");
											playerx = (int) rect41.getRectangle().x;
											playery = (int) rect41.getRectangle().y;
											spawn4.x = playerx;
											spawn4.y = playery;
											
											RectangleMapObject rect40 = (RectangleMapObject) layer.getObjects().get("spka4");
											playerx = (int) rect40.getRectangle().x;
											playery = (int) rect40.getRectangle().y;
											spawn5.x = playerx;
											spawn5.y = playery;																						
											
											RectangleMapObject rect42 = (RectangleMapObject) layer.getObjects().get("spka5");
											playerx = (int) rect42.getRectangle().x;
											playery = (int) rect42.getRectangle().y;
											spawn6.x = playerx;
											spawn6.y = playery;
											
											RectangleMapObject rect43 = (RectangleMapObject) layer.getObjects().get("spka6");
											playerx = (int) rect43.getRectangle().x;
											playery = (int) rect43.getRectangle().y;
											spawn7.x = playerx;
											spawn7.y = playery;
											
											RectangleMapObject rect46 = (RectangleMapObject) layer.getObjects().get("spka7");
											playerx = (int) rect46.getRectangle().x;
											playery = (int) rect46.getRectangle().y;
											spawn8.x = playerx;
											spawn8.y = playery;
											
											RectangleMapObject rect47 = (RectangleMapObject) layer.getObjects().get("spka8");
											playerx = (int) rect47.getRectangle().x;
											playery = (int) rect47.getRectangle().y;
											spawn9.x = playerx;
											spawn9.y = playery;
											
											RectangleMapObject rect38 = (RectangleMapObject) layer.getObjects().get("spkd1");
											playerx = (int) rect38.getRectangle().x;
											playery = (int) rect38.getRectangle().y;
											spawn10.x = playerx;
											spawn10.y = playery;			
											
											RectangleMapObject rect39 = (RectangleMapObject) layer.getObjects().get("spkd2");
											playerx = (int) rect39.getRectangle().x;
											playery = (int) rect39.getRectangle().y;
											spawn11.x = playerx;
											spawn11.y = playery;											
																					
											RectangleMapObject rect44 = (RectangleMapObject) layer.getObjects().get("spku1");
											playerx = (int) rect44.getRectangle().x;
											playery = (int) rect44.getRectangle().y;
											spawn12.x = playerx;
											spawn12.y = playery;
											
											RectangleMapObject rect45 = (RectangleMapObject) layer.getObjects().get("spku2");
											playerx = (int) rect45.getRectangle().x;
											playery = (int) rect45.getRectangle().y;
											spawn13.x = playerx;
											spawn13.y = playery;								
											
			break;
//			case "data/cafeteria.tmx": RectangleMapObject rect9 = (RectangleMapObject) layer.getObjects().get("spawnpoint1");
//										playerx = (int) rect9.getRectangle().x;
//										playery = (int) rect9.getRectangle().y;
//										spawn1.x = playerx;
//										spawn1.y = playery;
//			break;
		}
	}
	
	public void getExitpoints(){
		MapLayer Exitlayer = Gamescreen.tiledMap.getLayers().get("Exitpoints");
		
		switch(map){
			case "data/demondus1.tmx":	RectangleMapObject exitrect1 = (RectangleMapObject) Exitlayer.getObjects().get("exde2");
										exit1 = exitrect1.getRectangle();
										
										RectangleMapObject exitrect2 = (RectangleMapObject) Exitlayer.getObjects().get("exzede1");
										exit2 = exitrect2.getRectangle();
										
										RectangleMapObject exitrect3 = (RectangleMapObject) Exitlayer.getObjects().get("exrode1");
										exit3 = exitrect3.getRectangle();
			break;
			
			case "data/demondus2.tmx":	RectangleMapObject exitrect4 = (RectangleMapObject) Exitlayer.getObjects().get("exitpoint1");
										exit1 = exitrect4.getRectangle();
										
										RectangleMapObject exitrect5 = (RectangleMapObject) Exitlayer.getObjects().get("exrode2");
										exit2 = exitrect5.getRectangle();
										
										RectangleMapObject exitrect6 = (RectangleMapObject) Exitlayer.getObjects().get("exde3");
										exit3 = exitrect6.getRectangle();
			break;
			
			case "data/room.tmx":		RectangleMapObject exitrect7 = (RectangleMapObject) Exitlayer.getObjects().get("exrode2");
										exit1 = exitrect7.getRectangle();
										
										RectangleMapObject exitrect8 = (RectangleMapObject) Exitlayer.getObjects().get("exrode4");
										exit2 = exitrect8.getRectangle();
										
										RectangleMapObject exitrect9 = (RectangleMapObject) Exitlayer.getObjects().get("exzede1");
										exit3 = exitrect9.getRectangle();
										
										RectangleMapObject exitrect10 = (RectangleMapObject) Exitlayer.getObjects().get("extrup");
										exit4 = exitrect10.getRectangle();
										
										RectangleMapObject exitrect11 = (RectangleMapObject) Exitlayer.getObjects().get("extrdo");
										exit5 = exitrect11.getRectangle();
										
										RectangleMapObject exitrect12 = (RectangleMapObject) Exitlayer.getObjects().get("exrode1");
										exit6 = exitrect12.getRectangle();
										
										RectangleMapObject exitrect13 = (RectangleMapObject) Exitlayer.getObjects().get("exrode3");
										exit7 = exitrect13.getRectangle();
										
										RectangleMapObject exitrect14 = (RectangleMapObject) Exitlayer.getObjects().get("exsede3");
										exit8 = exitrect14.getRectangle();
										
										RectangleMapObject exitrect15 = (RectangleMapObject) Exitlayer.getObjects().get("exrodd1");
										exit9 = exitrect15.getRectangle();
										
										RectangleMapObject exitrect16 = (RectangleMapObject) Exitlayer.getObjects().get("exrodd2");
										exit10 = exitrect16.getRectangle();
										
										RectangleMapObject exitrect17 = (RectangleMapObject) Exitlayer.getObjects().get("exrodd3");
										exit11 = exitrect17.getRectangle();
			break;
			
			case "data/demondus3.tmx":	RectangleMapObject exitrect18 = (RectangleMapObject) Exitlayer.getObjects().get("exde2");
										exit1 = exitrect18.getRectangle();
										
										RectangleMapObject exitrect19 = (RectangleMapObject) Exitlayer.getObjects().get("exde4");
										exit2 = exitrect19.getRectangle();
										
										RectangleMapObject exitrect20 = (RectangleMapObject) Exitlayer.getObjects().get("exde7");
										exit3 = exitrect20.getRectangle();
										
										RectangleMapObject exitrect21 = (RectangleMapObject) Exitlayer.getObjects().get("exrode3");
										exit4 = exitrect21.getRectangle();
			break;
			
			case "data/demondus4.tmx":	RectangleMapObject exitrect22 = (RectangleMapObject) Exitlayer.getObjects().get("exde3");
										exit1 = exitrect22.getRectangle();
										
										RectangleMapObject exitrect23 = (RectangleMapObject) Exitlayer.getObjects().get("exrode4");
										exit2 = exitrect23.getRectangle();
										
										RectangleMapObject exitrect24 = (RectangleMapObject) Exitlayer.getObjects().get("excade4");
										exit3 = exitrect24.getRectangle();
			break;
			
			case "data/demondus5.tmx":	RectangleMapObject exitrect25 = (RectangleMapObject) Exitlayer.getObjects().get("excade4");
										exit1 = exitrect25.getRectangle();
			break;
			
			case "data/wehhh.tmx":		RectangleMapObject exitrect26 = (RectangleMapObject) Exitlayer.getObjects().get("exsede3");
										exit1 = exitrect26.getRectangle();
			break;
			
			case "data/demondus7.tmx":	RectangleMapObject exitrect27 = (RectangleMapObject) Exitlayer.getObjects().get("exde3");
										exit1 = exitrect27.getRectangle();
										
										RectangleMapObject exitrect28 = (RectangleMapObject) Exitlayer.getObjects().get("exdd");
										exit2 = exitrect28.getRectangle();
			break;
			
			case "data/demondusdorf.tmx":	RectangleMapObject exitrect29 = (RectangleMapObject) Exitlayer.getObjects().get("exde7");
											exit1 = exitrect29.getRectangle();
											
											RectangleMapObject exitrect30 = (RectangleMapObject) Exitlayer.getObjects().get("exrodd3");
											exit2 = exitrect30.getRectangle();
											
											RectangleMapObject exitrect31 = (RectangleMapObject) Exitlayer.getObjects().get("exrodd1");
											exit3 = exitrect31.getRectangle();
											
											RectangleMapObject exitrect32 = (RectangleMapObject) Exitlayer.getObjects().get("exrodd2");
											exit4 = exitrect32.getRectangle();
											
											RectangleMapObject exitrect33 = (RectangleMapObject) Exitlayer.getObjects().get("exka");
											exit5 = exitrect33.getRectangle();
			break;
			
			case "data/kathedrale.tmx":	RectangleMapObject exitrect34 = (RectangleMapObject) Exitlayer.getObjects().get("exdd");
										exit1 = exitrect34.getRectangle();
										
										RectangleMapObject exitrect35 = (RectangleMapObject) Exitlayer.getObjects().get("exka1");
										exit2 = exitrect35.getRectangle();
										
										RectangleMapObject exitrect36 = (RectangleMapObject) Exitlayer.getObjects().get("exka2");
										exit3 = exitrect36.getRectangle();
										
										RectangleMapObject exitrect37 = (RectangleMapObject) Exitlayer.getObjects().get("exka3");
										exit4 = exitrect37.getRectangle();
										
										RectangleMapObject exitrect38 = (RectangleMapObject) Exitlayer.getObjects().get("exka4");
										exit5 = exitrect38.getRectangle();
										
										RectangleMapObject exitrect39 = (RectangleMapObject) Exitlayer.getObjects().get("exka5");
										exit6 = exitrect39.getRectangle();
										
										RectangleMapObject exitrect40 = (RectangleMapObject) Exitlayer.getObjects().get("exka6");
										exit7 = exitrect40.getRectangle();
										
										RectangleMapObject exitrect41 = (RectangleMapObject) Exitlayer.getObjects().get("exka7");
										exit8 = exitrect41.getRectangle();
										
										RectangleMapObject exitrect42 = (RectangleMapObject) Exitlayer.getObjects().get("exka8");
										exit9 = exitrect42.getRectangle();
										
										RectangleMapObject exitrect43 = (RectangleMapObject) Exitlayer.getObjects().get("exkd1");
										exit10 = exitrect43.getRectangle();
										
										RectangleMapObject exitrect44 = (RectangleMapObject) Exitlayer.getObjects().get("exkd2");
										exit11 = exitrect44.getRectangle();
										
										RectangleMapObject exitrect45 = (RectangleMapObject) Exitlayer.getObjects().get("exku1");
										exit12 = exitrect45.getRectangle();
										
										RectangleMapObject exitrect46 = (RectangleMapObject) Exitlayer.getObjects().get("exku2");
										exit13 = exitrect46.getRectangle();
			break;
		}
	}
}