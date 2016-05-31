package de.test.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import de.test.game.Battlescreen.Battlestate;
import de.test.game.Testmap.ScreenType;

public class mapManager {
	static String map = "maps/maze.tmx";
	String mapchange;
	MapLayer layer;
	MapProperties prop;
	float playerx;
	float playery;
	int mapWidth;
	int mapHeight;
	Testmap game = Gamescreen.game;
	Player player = Gamescreen.player;

	ArrayList<Rectangle> bounds = new ArrayList<Rectangle>();
	ArrayList<Rectangle> battleBounds = new ArrayList<Rectangle>();

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
	Vector2 spawn11 = new Vector2(playerx, playery);
	Vector2 spawn12 = new Vector2(playerx, playery);
	Vector2 spawn13 = new Vector2(playerx, playery);
	Vector2 spawn14 = new Vector2(playerx, playery);
	Vector2 spawn15 = new Vector2(playerx, playery);
	Vector2 spawn16 = new Vector2(playerx, playery);
	Vector2 spawn17 = new Vector2(playerx, playery);
	Vector2 spawn18 = new Vector2(playerx, playery);
	Vector2 spawn19 = new Vector2(playerx, playery);
	Vector2 spawn20 = new Vector2(playerx, playery);
	Vector2 spawn21 = new Vector2(playerx, playery);
	Vector2 spawn22 = new Vector2(playerx, playery);
	Vector2 spawn23 = new Vector2(playerx, playery);
	Vector2 spawn24 = new Vector2(playerx, playery);
	Vector2 spawn25 = new Vector2(playerx, playery);

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
	Rectangle exit15;
	Rectangle exit16;
	Rectangle exit17;
	Rectangle exit18;
	Rectangle exit19;
	Rectangle exit20;
	Rectangle exit21;
	Rectangle exit22;
	Rectangle exit23;
	Rectangle exit24;
	Rectangle exit25;

	static int safety = 0;

	static Battlescreen battlescreen;
	static LoadScreen loadscreen;

	public mapManager() {

	}

	public void update() {
		for (int i = 0; i < bounds.size(); i++) {
			if (bounds.get(i).overlaps(player.getBounds())) {
				player.reAdjust();
			}
		}

		switch (map) {
		case "maps/demondus1.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/demondus2.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/room.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/room.tmx";
				changeMap(mapchange, map, spawn6);
			}
			break;

		case "maps/demondus2.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/demondus1.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/demondus3.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/room.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;

		case "maps/demondus3.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/demondus2.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/demondus4.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/demondus7.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/room.tmx";
				changeMap(mapchange, map, spawn7);
			}
			break;

		case "maps/demondus4.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/demondus3.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/room.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/demondus5.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;

		case "maps/demondus5.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/demondus4.tmx";
				changeMap(mapchange, map, spawn3);
			}
			break;

		case "maps/wehhh.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/room.tmx";
				changeMap(mapchange, map, spawn7);
			}
			break;

		case "maps/room.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/demondus2.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/demondus4.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/demondus1.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/room.tmx";
				player.setPosition(spawn4);
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit5, player.getBounds())) {
				mapchange = "maps/room.tmx";
				changeMap(mapchange, map, spawn5);
			}
			if (Intersector.overlaps(exit6, player.getBounds())) {
				mapchange = "maps/demondus1.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit7, player.getBounds())) {
				mapchange = "maps/demondus3.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit8, player.getBounds())) {
				mapchange = "maps/wehhh.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit9, player.getBounds())) {
				mapchange = "maps/demondusdorf.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit10, player.getBounds())) {
				mapchange = "maps/demondusdorf.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit11, player.getBounds())) {
				mapchange = "maps/demondusdorf.tmx";
				changeMap(mapchange, map, spawn2);
			}
			break;

		case "maps/demondus7.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/demondus3.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/demondusdorf.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;

		case "maps/demondusdorf.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/demondus7.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/room.tmx";
				changeMap(mapchange, map, spawn10);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/room.tmx";
				changeMap(mapchange, map, spawn8);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/room.tmx";
				changeMap(mapchange, map, spawn9);
			}
			if (Intersector.overlaps(exit5, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;

		case "maps/kathedrale.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/demondusdorf.tmx";
				changeMap(mapchange, map, spawn5);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit5, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn5);
			}
			if (Intersector.overlaps(exit6, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn6);
			}
			if (Intersector.overlaps(exit7, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn7);
			}
			if (Intersector.overlaps(exit8, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn8);
			}
			if (Intersector.overlaps(exit9, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn9);
			}
			if (Intersector.overlaps(exit10, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn10);
			}
			if (Intersector.overlaps(exit11, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn11);
			}
			if (Intersector.overlaps(exit12, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn12);
			}
			if (Intersector.overlaps(exit13, player.getBounds())) {
				mapchange = "maps/kathedrale.tmx";
				changeMap(mapchange, map, spawn13);
			}
			break;

		case "maps/Dach_Tag.tmx":

			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn3);
			}
			break;

		case "maps/Dach_Nacht.tmx":

			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn3);
			}
			break;

		case "maps/Hauptweg_Tag.tmx":	

			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/leonswohnung.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/WegZumSee_Tag.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/Lichtung_Tag.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;

		case "maps/Hauptweg_Nacht.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/leonswohnung.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/WegZumSee_Nacht.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/Lichtung_Nacht.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;

		case "maps/Lichtung_Tag.tmx":
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/Hauptweg_Tag.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/leonswohnung.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;

		case "maps/Lichtung_Nacht.tmx":
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/Hauptweg_Nacht.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/leonswohnung.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;

		case "maps/See_Tag.tmx":
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/WegZumSee_Tag.tmx";
				changeMap(mapchange, map, spawn2);
			}
			break;

		case "maps/See_Nacht.tmx":
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/WegZumSee_Nacht.tmx";
				changeMap(mapchange, map, spawn2);
			}
			break;

		case "maps/WegZumSee_Tag.tmx":
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/Hauptweg_Tag.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/See_Tag.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;

		case "maps/WegZumSee_Nacht.tmx":
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/Hauptweg_Nacht.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/See_Nacht.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;
		case "maps/Sozialzweig.tmx":
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/Dach_Tag.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn10);
			}
			if (Intersector.overlaps(exit5, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn11);
			}
			if (Intersector.overlaps(exit6, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn5);
			}
			if (Intersector.overlaps(exit7, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn12);
			}
			if (Intersector.overlaps(exit8, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn13);
			}
			if (Intersector.overlaps(exit9, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn8);
			}
			if (Intersector.overlaps(exit10, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit11, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn7);
			}
			if (Intersector.overlaps(exit12, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn6);
			}
			if (Intersector.overlaps(exit13, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn9);
			}
			break;

		case "maps/cafeteria.tmx":
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/cafeteria.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/cafeteria.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/cafeteria.tmx";
				changeMap(mapchange, map, spawn5);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/cafeteria.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit5, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit6, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit7, player.getBounds())) {
				mapchange = "maps/cafeteria.tmx";
				changeMap(mapchange, map, spawn7);
			}
			break;

		case "maps/altbau.tmx":
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn25);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit5, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn5);
			}
			if (Intersector.overlaps(exit6, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn6);
			}
			if (Intersector.overlaps(exit7, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn7);
			}
			if (Intersector.overlaps(exit8, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn8);
			}
			if (Intersector.overlaps(exit9, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn9);
			}
			if (Intersector.overlaps(exit10, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn10);
			}
			if (Intersector.overlaps(exit11, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn11);
			}
			if (Intersector.overlaps(exit12, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn12);
			}
			if (Intersector.overlaps(exit13, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn13);
			}
			break;

		case "maps/IF2.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/Hauptweg_Tag.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/Sozialzweig.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/cafeteria.tmx";
				changeMap(mapchange, map, spawn6);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/cafeteria.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit5, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn5);
			}
			if (Intersector.overlaps(exit6, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn6);
			}
			if (Intersector.overlaps(exit7, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn7);
			}
			if (Intersector.overlaps(exit8, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn8);
			}
			if (Intersector.overlaps(exit9, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn9);
			}
			if (Intersector.overlaps(exit10, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn10);
			}
			if (Intersector.overlaps(exit11, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn11);
			}
			if (Intersector.overlaps(exit12, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn12);
			}
			if (Intersector.overlaps(exit13, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn13);
			}
			if (Intersector.overlaps(exit14, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn14);
			}
			if (Intersector.overlaps(exit15, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn15);
			}
			if (Intersector.overlaps(exit16, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn16);
			}
			if (Intersector.overlaps(exit17, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn17);
			}
			if (Intersector.overlaps(exit18, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn18);
			}
			if (Intersector.overlaps(exit19, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn19);
			}
			if (Intersector.overlaps(exit20, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn20);
			}
			if (Intersector.overlaps(exit21, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn21);
			}
			if (Intersector.overlaps(exit22, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn22);
			}
			if (Intersector.overlaps(exit23, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn23);
			}
			if (Intersector.overlaps(exit24, player.getBounds())) {
				mapchange = "maps/IF2.tmx";
				changeMap(mapchange, map, spawn24);
			}
			if (Intersector.overlaps(exit25, player.getBounds())) {
				mapchange = "maps/altbau.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;

		case "maps/ho.tmx":
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn5);
			}
			if (Intersector.overlaps(exit5, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn6);
			}
			if (Intersector.overlaps(exit6, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn7);
			}
			if (Intersector.overlaps(exit7, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn8);
			}
			if (Intersector.overlaps(exit8, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn9);
			}
			if (Intersector.overlaps(exit9, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn10);
			}
			if (Intersector.overlaps(exit10, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn11);
			}
			if (Intersector.overlaps(exit11, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn12);
			}
			if (Intersector.overlaps(exit12, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn13);
			}
			if (Intersector.overlaps(exit13, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn14);
			}
			if (Intersector.overlaps(exit14, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn15);
			}
			if (Intersector.overlaps(exit15, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn16);
			}
			if (Intersector.overlaps(exit16, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn17);
			}
			if (Intersector.overlaps(exit17, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn18);
			}
			if (Intersector.overlaps(exit18, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn19);
			}
			if (Intersector.overlaps(exit19, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn20);
			}
			if (Intersector.overlaps(exit20, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn21);
			}
			if (Intersector.overlaps(exit21, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn22);
			}
			if (Intersector.overlaps(exit22, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn23);
			}
			if (Intersector.overlaps(exit23, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn24);
			}
			if (Intersector.overlaps(exit24, player.getBounds())) {
				mapchange = "maps/ho.tmx";
				changeMap(mapchange, map, spawn25);
			}
			break;

		case "maps/maze.tmx":
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn4);
			}
			if (Intersector.overlaps(exit4, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn5);
			}
			if (Intersector.overlaps(exit5, player.getBounds())) {
				mapchange = "maps/leonswohnung.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit6, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit7, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit8, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit9, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit10, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit11, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit12, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit13, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit14, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit15, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit16, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit17, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit18, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit19, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			if (Intersector.overlaps(exit20, player.getBounds())) {
				mapchange = "maps/maze.tmx";
				changeMap(mapchange, map, spawn1);
			}
			break;

		case "maps/leonswohnung.tmx":
			
			if (Intersector.overlaps(exit1, player.getBounds())) {
				mapchange = "maps/Hauptweg_Tag.tmx";
				changeMap(mapchange, map, spawn3);
			}
			if (Intersector.overlaps(exit2, player.getBounds())) {
				mapchange = "maps/leonswohnung.tmx";
				changeMap(mapchange, map, spawn2);
			}
			if (Intersector.overlaps(exit3, player.getBounds())) {
				mapchange = "maps/leonswohnung.tmx";
				changeMap(mapchange, map, spawn3);
			}
			break;
		}
		
		for (int j = 0; j < battleBounds.size(); j++) {
			if (battleBounds.get(j).overlaps(player.getBounds()) && Gamescreen.player.isMoving == true) {
				Gamescreen.warn.setVisible(true);
				Random gen = new Random();
				int battleGen = gen.nextInt(7500);
				safety++;
				System.out.println("Safe: " + safety);
				System.out.println("Random: " + battleGen);
				if (battleGen < 8 || safety == 1500) {
					try {
						player.savePlayer(player);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					player.setPosition(Battlemenu.vec);
					player.movement = "left";
					
					Battlescreen.player = player;
					Battlescreen.battlestate = Battlestate.firstStrike;
					Battlemenu.hasClicked = false;
					safety = 0;
					game.setScreen(game.getScreenType(ScreenType.LoadScreen));
				}
			}
		}
	}

	@SuppressWarnings("static-access")
	public void changeMap(String map, String mapchange, Vector2 spawn) {
		this.map = map;
		Gamescreen.tiledMap = new TmxMapLoader().load(map); // load the new map
		Gamescreen.renderer.getMap().dispose(); // dispose the old map
		Gamescreen.renderer.setMap(Gamescreen.tiledMap); // set the map in your
															// renderer
		setCollision();
		setBattle();
		getSpawnpoints();
		this.mapchange = mapchange;
		playerx = spawn.x;
		playery = spawn.y;
		Gamescreen.player.position.x = playerx;
		Gamescreen.player.position.y = playery;
		getExitpoints();
	}

	@SuppressWarnings("unused")
	public void setCollision() {
		bounds.clear();
		prop = Gamescreen.tiledMap.getProperties();
		mapWidth = prop.get("width", Integer.class);
		mapHeight = prop.get("height", Integer.class);
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				TiledMapTileLayer cur = (TiledMapTileLayer) Gamescreen.tiledMap
						.getLayers().get("Collision");
				Cell cell = new Cell();

				if (cur.getCell(i, j) != null) {
					cell = cur.getCell(i, j);
					bounds.add(new Rectangle(i * 32, j * 32, 32, 32));
				}
			}
		}
	}

	@SuppressWarnings("unused")
	public void setBattle() {
		battleBounds.clear();
		prop = Gamescreen.tiledMap.getProperties();
		mapWidth = prop.get("width", Integer.class);
		mapHeight = prop.get("height", Integer.class);
		for (int i = 0; i < mapWidth; i++) {
			for (int j = 0; j < mapHeight; j++) {
				TiledMapTileLayer bat = (TiledMapTileLayer) Gamescreen.tiledMap
						.getLayers().get("Battle");
				Cell cellB = new Cell();

				if (bat.getCell(i, j) != null) {
					cellB = bat.getCell(i, j);
					battleBounds.add(new Rectangle(i * 32, j * 32, 32, 32));
				}
			}
		}
	}

	public void getSpawnpoints() {
		int playerx;
		int playery;
		layer = Gamescreen.tiledMap.getLayers().get("Spawnpoints");

		switch (map) {
		case "maps/demondus1.tmx":
			RectangleMapObject rect1 = (RectangleMapObject) layer.getObjects()
					.get("spawnpoint1");
			playerx = (int) rect1.getRectangle().x;
			playery = (int) rect1.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect2 = (RectangleMapObject) layer.getObjects()
					.get("spde2");
			playerx = (int) rect2.getRectangle().x;
			playery = (int) rect2.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect3 = (RectangleMapObject) layer.getObjects()
					.get("spzede1");
			playerx = (int) rect3.getRectangle().x;
			playery = (int) rect3.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect4 = (RectangleMapObject) layer.getObjects()
					.get("sprode1");
			playerx = (int) rect4.getRectangle().x;
			playery = (int) rect4.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;

			break;

		case "maps/demondus2.tmx":
			RectangleMapObject rect5 = (RectangleMapObject) layer.getObjects()
					.get("spawnpoint1");
			playerx = (int) rect5.getRectangle().x;
			playery = (int) rect5.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect6 = (RectangleMapObject) layer.getObjects()
					.get("sprode2");
			playerx = (int) rect6.getRectangle().x;
			playery = (int) rect6.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect7 = (RectangleMapObject) layer.getObjects()
					.get("spde3");
			playerx = (int) rect7.getRectangle().x;
			playery = (int) rect7.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			break;

		case "maps/room.tmx":
			RectangleMapObject rect8 = (RectangleMapObject) layer.getObjects()
					.get("sprode2");
			playerx = (int) rect8.getRectangle().x;
			playery = (int) rect8.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect9 = (RectangleMapObject) layer.getObjects()
					.get("sprode4");
			playerx = (int) rect9.getRectangle().x;
			playery = (int) rect9.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect10 = (RectangleMapObject) layer.getObjects()
					.get("spzede1");
			playerx = (int) rect10.getRectangle().x;
			playery = (int) rect10.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect11 = (RectangleMapObject) layer.getObjects()
					.get("sptrup");
			playerx = (int) rect11.getRectangle().x;
			playery = (int) rect11.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;

			RectangleMapObject rect12 = (RectangleMapObject) layer.getObjects()
					.get("sptrdo");
			playerx = (int) rect12.getRectangle().x;
			playery = (int) rect12.getRectangle().y;
			spawn5.x = playerx;
			spawn5.y = playery;

			RectangleMapObject rect13 = (RectangleMapObject) layer.getObjects()
					.get("sprode1");
			playerx = (int) rect13.getRectangle().x;
			playery = (int) rect13.getRectangle().y;
			spawn6.x = playerx;
			spawn6.y = playery;

			RectangleMapObject rect14 = (RectangleMapObject) layer.getObjects()
					.get("sprode3");
			playerx = (int) rect14.getRectangle().x;
			playery = (int) rect14.getRectangle().y;
			spawn7.x = playerx;
			spawn7.y = playery;

			RectangleMapObject rect15 = (RectangleMapObject) layer.getObjects()
					.get("sprodd1");
			playerx = (int) rect15.getRectangle().x;
			playery = (int) rect15.getRectangle().y;
			spawn8.x = playerx;
			spawn8.y = playery;

			RectangleMapObject rect16 = (RectangleMapObject) layer.getObjects()
					.get("sprodd2");
			playerx = (int) rect16.getRectangle().x;
			playery = (int) rect16.getRectangle().y;
			spawn9.x = playerx;
			spawn9.y = playery;

			RectangleMapObject rect17 = (RectangleMapObject) layer.getObjects()
					.get("sprodd3");
			playerx = (int) rect17.getRectangle().x;
			playery = (int) rect17.getRectangle().y;
			spawn10.x = playerx;
			spawn10.y = playery;
			break;

		case "maps/demondus3.tmx":
			RectangleMapObject rect19 = (RectangleMapObject) layer.getObjects()
					.get("spde2");
			playerx = (int) rect19.getRectangle().x;
			playery = (int) rect19.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect20 = (RectangleMapObject) layer.getObjects()
					.get("spde4");
			playerx = (int) rect20.getRectangle().x;
			playery = (int) rect20.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect21 = (RectangleMapObject) layer.getObjects()
					.get("spde7");
			playerx = (int) rect21.getRectangle().x;
			playery = (int) rect21.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect22 = (RectangleMapObject) layer.getObjects()
					.get("sprode3");
			playerx = (int) rect22.getRectangle().x;
			playery = (int) rect22.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;
			break;

		case "maps/demondus4.tmx":
			RectangleMapObject rect23 = (RectangleMapObject) layer.getObjects()
					.get("spde3");
			playerx = (int) rect23.getRectangle().x;
			playery = (int) rect23.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect24 = (RectangleMapObject) layer.getObjects()
					.get("sprode4");
			playerx = (int) rect24.getRectangle().x;
			playery = (int) rect24.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect25 = (RectangleMapObject) layer.getObjects()
					.get("spcade4");
			playerx = (int) rect25.getRectangle().x;
			playery = (int) rect25.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;
			break;

		case "maps/demondus5.tmx":
			RectangleMapObject rect26 = (RectangleMapObject) layer.getObjects()
					.get("spcade4");
			playerx = (int) rect26.getRectangle().x;
			playery = (int) rect26.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;
			break;

		case "maps/wehhh.tmx":
			RectangleMapObject rect27 = (RectangleMapObject) layer.getObjects()
					.get("spsede3");
			playerx = (int) rect27.getRectangle().x;
			playery = (int) rect27.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;
			break;

		case "maps/demondus7.tmx":
			RectangleMapObject rect28 = (RectangleMapObject) layer.getObjects()
					.get("spde3");
			playerx = (int) rect28.getRectangle().x;
			playery = (int) rect28.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect29 = (RectangleMapObject) layer.getObjects()
					.get("spdd");
			playerx = (int) rect29.getRectangle().x;
			playery = (int) rect29.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;
			break;

		case "maps/demondusdorf.tmx":
			RectangleMapObject rect30 = (RectangleMapObject) layer.getObjects()
					.get("spde7");
			playerx = (int) rect30.getRectangle().x;
			playery = (int) rect30.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect31 = (RectangleMapObject) layer.getObjects()
					.get("sprodd3");
			playerx = (int) rect31.getRectangle().x;
			playery = (int) rect31.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect32 = (RectangleMapObject) layer.getObjects()
					.get("sprodd1");
			playerx = (int) rect32.getRectangle().x;
			playery = (int) rect32.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect33 = (RectangleMapObject) layer.getObjects()
					.get("sprodd2");
			playerx = (int) rect33.getRectangle().x;
			playery = (int) rect33.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;

			RectangleMapObject rect34 = (RectangleMapObject) layer.getObjects()
					.get("spka");
			playerx = (int) rect34.getRectangle().x;
			playery = (int) rect34.getRectangle().y;
			spawn5.x = playerx;
			spawn5.y = playery;
			break;

		case "maps/kathedrale.tmx":
			RectangleMapObject rect35 = (RectangleMapObject) layer.getObjects()
					.get("spdd");
			playerx = (int) rect35.getRectangle().x;
			playery = (int) rect35.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect36 = (RectangleMapObject) layer.getObjects()
					.get("spka1");
			playerx = (int) rect36.getRectangle().x;
			playery = (int) rect36.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect37 = (RectangleMapObject) layer.getObjects()
					.get("spka2");
			playerx = (int) rect37.getRectangle().x;
			playery = (int) rect37.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect41 = (RectangleMapObject) layer.getObjects()
					.get("spka3");
			playerx = (int) rect41.getRectangle().x;
			playery = (int) rect41.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;

			RectangleMapObject rect40 = (RectangleMapObject) layer.getObjects()
					.get("spka4");
			playerx = (int) rect40.getRectangle().x;
			playery = (int) rect40.getRectangle().y;
			spawn5.x = playerx;
			spawn5.y = playery;

			RectangleMapObject rect42 = (RectangleMapObject) layer.getObjects()
					.get("spka5");
			playerx = (int) rect42.getRectangle().x;
			playery = (int) rect42.getRectangle().y;
			spawn6.x = playerx;
			spawn6.y = playery;

			RectangleMapObject rect43 = (RectangleMapObject) layer.getObjects()
					.get("spka6");
			playerx = (int) rect43.getRectangle().x;
			playery = (int) rect43.getRectangle().y;
			spawn7.x = playerx;
			spawn7.y = playery;

			RectangleMapObject rect46 = (RectangleMapObject) layer.getObjects()
					.get("spka7");
			playerx = (int) rect46.getRectangle().x;
			playery = (int) rect46.getRectangle().y;
			spawn8.x = playerx;
			spawn8.y = playery;

			RectangleMapObject rect47 = (RectangleMapObject) layer.getObjects()
					.get("spka8");
			playerx = (int) rect47.getRectangle().x;
			playery = (int) rect47.getRectangle().y;
			spawn9.x = playerx;
			spawn9.y = playery;

			RectangleMapObject rect38 = (RectangleMapObject) layer.getObjects()
					.get("spkd1");
			playerx = (int) rect38.getRectangle().x;
			playery = (int) rect38.getRectangle().y;
			spawn10.x = playerx;
			spawn10.y = playery;

			RectangleMapObject rect39 = (RectangleMapObject) layer.getObjects()
					.get("spkd2");
			playerx = (int) rect39.getRectangle().x;
			playery = (int) rect39.getRectangle().y;
			spawn11.x = playerx;
			spawn11.y = playery;

			RectangleMapObject rect44 = (RectangleMapObject) layer.getObjects()
					.get("spku1");
			playerx = (int) rect44.getRectangle().x;
			playery = (int) rect44.getRectangle().y;
			spawn12.x = playerx;
			spawn12.y = playery;

			RectangleMapObject rect45 = (RectangleMapObject) layer.getObjects()
					.get("spku2");
			playerx = (int) rect45.getRectangle().x;
			playery = (int) rect45.getRectangle().y;
			spawn13.x = playerx;
			spawn13.y = playery;

			break;

		case "maps/Dach_Tag.tmx":
			RectangleMapObject rect48 = (RectangleMapObject) layer.getObjects()
					.get("spdach");
			playerx = (int) rect48.getRectangle().x;
			playery = (int) rect48.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;
			break;

		case "maps/Dach_Nacht.tmx":
			RectangleMapObject rect49 = (RectangleMapObject) layer.getObjects()
					.get("spdach");
			playerx = (int) rect49.getRectangle().x;
			playery = (int) rect49.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;
			break;

		case "maps/Hauptweg_Tag.tmx":
			RectangleMapObject rect50 = (RectangleMapObject) layer.getObjects()
					.get("spwese");
			playerx = (int) rect50.getRectangle().x;
			playery = (int) rect50.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect51 = (RectangleMapObject) layer.getObjects()
					.get("sphof");
			playerx = (int) rect51.getRectangle().x;
			playery = (int) rect51.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect52 = (RectangleMapObject) layer.getObjects()
					.get("spwo");
			playerx = (int) rect52.getRectangle().x;
			playery = (int) rect52.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect53 = (RectangleMapObject) layer.getObjects()
					.get("splich");
			playerx = (int) rect53.getRectangle().x;
			playery = (int) rect53.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;
			break;

		case "maps/Hauptweg_Nacht.tmx":
			RectangleMapObject rect54 = (RectangleMapObject) layer.getObjects()
					.get("spwese");
			playerx = (int) rect54.getRectangle().x;
			playery = (int) rect54.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect55 = (RectangleMapObject) layer.getObjects()
					.get("sphof");
			playerx = (int) rect55.getRectangle().x;
			playery = (int) rect55.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect56 = (RectangleMapObject) layer.getObjects()
					.get("spwo");
			playerx = (int) rect56.getRectangle().x;
			playery = (int) rect56.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect57 = (RectangleMapObject) layer.getObjects()
					.get("splich");
			playerx = (int) rect57.getRectangle().x;
			playery = (int) rect57.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;
			break;

		case "maps/Lichtung_Tag.tmx":
			RectangleMapObject rect58 = (RectangleMapObject) layer.getObjects()
					.get("sphawe");
			playerx = (int) rect58.getRectangle().x;
			playery = (int) rect58.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect59 = (RectangleMapObject) layer.getObjects()
					.get("spwo");
			playerx = (int) rect59.getRectangle().x;
			playery = (int) rect59.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;
			break;

		case "maps/Lichtung_Nacht.tmx":
			RectangleMapObject rect60 = (RectangleMapObject) layer.getObjects()
					.get("sphawe");
			playerx = (int) rect60.getRectangle().x;
			playery = (int) rect60.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect61 = (RectangleMapObject) layer.getObjects()
					.get("spwo");
			playerx = (int) rect61.getRectangle().x;
			playery = (int) rect61.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;
			break;

		case "maps/WegZumSee_Tag.tmx":
			RectangleMapObject rect62 = (RectangleMapObject) layer.getObjects()
					.get("sphawe");
			playerx = (int) rect62.getRectangle().x;
			playery = (int) rect62.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect156 = (RectangleMapObject) layer
					.getObjects().get("spsee");
			playerx = (int) rect156.getRectangle().x;
			playery = (int) rect156.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;
			break;

		case "maps/WegZumSee_Nacht.tmx":
			RectangleMapObject rect63 = (RectangleMapObject) layer.getObjects()
					.get("sphawe");
			playerx = (int) rect63.getRectangle().x;
			playery = (int) rect63.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect157 = (RectangleMapObject) layer
					.getObjects().get("spsee");
			playerx = (int) rect157.getRectangle().x;
			playery = (int) rect157.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;
			break;

		case "maps/See_Tag.tmx":
			RectangleMapObject rect64 = (RectangleMapObject) layer.getObjects()
					.get("spwese");
			playerx = (int) rect64.getRectangle().x;
			playery = (int) rect64.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;
			break;

		case "maps/See_Nacht.tmx":
			RectangleMapObject rect65 = (RectangleMapObject) layer.getObjects()
					.get("spwese");
			playerx = (int) rect65.getRectangle().x;
			playery = (int) rect65.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;
			break;

		case "maps/Sozialzweig.tmx":
			RectangleMapObject rect66 = (RectangleMapObject) layer.getObjects()
					.get("spho1");
			playerx = (int) rect66.getRectangle().x;
			playery = (int) rect66.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect68 = (RectangleMapObject) layer.getObjects()
					.get("spdach");
			playerx = (int) rect68.getRectangle().x;
			playery = (int) rect68.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect69 = (RectangleMapObject) layer.getObjects()
					.get("speg");
			playerx = (int) rect69.getRectangle().x;
			playery = (int) rect69.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;

			RectangleMapObject rect70 = (RectangleMapObject) layer.getObjects()
					.get("sp1s");
			playerx = (int) rect70.getRectangle().x;
			playery = (int) rect70.getRectangle().y;
			spawn5.x = playerx;
			spawn5.y = playery;

			RectangleMapObject rect71 = (RectangleMapObject) layer.getObjects()
					.get("sp12s");
			playerx = (int) rect71.getRectangle().x;
			playery = (int) rect71.getRectangle().y;
			spawn6.x = playerx;
			spawn6.y = playery;

			RectangleMapObject rect72 = (RectangleMapObject) layer.getObjects()
					.get("sp2s");
			playerx = (int) rect72.getRectangle().x;
			playery = (int) rect72.getRectangle().y;
			spawn7.x = playerx;
			spawn7.y = playery;

			RectangleMapObject rect73 = (RectangleMapObject) layer.getObjects()
					.get("spbiog");
			playerx = (int) rect73.getRectangle().x;
			playery = (int) rect73.getRectangle().y;
			spawn8.x = playerx;
			spawn8.y = playery;

			RectangleMapObject rect74 = (RectangleMapObject) layer.getObjects()
					.get("spbiug");
			playerx = (int) rect74.getRectangle().x;
			playery = (int) rect74.getRectangle().y;
			spawn9.x = playerx;
			spawn9.y = playery;

			RectangleMapObject rect75 = (RectangleMapObject) layer.getObjects()
					.get("spbib1");
			playerx = (int) rect75.getRectangle().x;
			playery = (int) rect75.getRectangle().y;
			spawn10.x = playerx;
			spawn10.y = playery;

			RectangleMapObject rect76 = (RectangleMapObject) layer.getObjects()
					.get("spbib2");
			playerx = (int) rect76.getRectangle().x;
			playery = (int) rect76.getRectangle().y;
			spawn11.x = playerx;
			spawn11.y = playery;

			RectangleMapObject rect77 = (RectangleMapObject) layer.getObjects()
					.get("spbi1");
			playerx = (int) rect77.getRectangle().x;
			playery = (int) rect77.getRectangle().y;
			spawn12.x = playerx;
			spawn12.y = playery;

			RectangleMapObject rect78 = (RectangleMapObject) layer.getObjects()
					.get("spbi2");
			playerx = (int) rect78.getRectangle().x;
			playery = (int) rect78.getRectangle().y;
			spawn13.x = playerx;
			spawn13.y = playery;
			break;
		case "maps/cafeteria.tmx":
			RectangleMapObject rect79 = (RectangleMapObject) layer.getObjects()
					.get("spcaif");
			playerx = (int) rect79.getRectangle().x;
			playery = (int) rect79.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect80 = (RectangleMapObject) layer.getObjects()
					.get("spcake");
			playerx = (int) rect80.getRectangle().x;
			playery = (int) rect80.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect81 = (RectangleMapObject) layer.getObjects()
					.get("spkeca");
			playerx = (int) rect81.getRectangle().x;
			playery = (int) rect81.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect82 = (RectangleMapObject) layer.getObjects()
					.get("sproca");
			playerx = (int) rect82.getRectangle().x;
			playery = (int) rect82.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;

			RectangleMapObject rect83 = (RectangleMapObject) layer.getObjects()
					.get("spcaro");
			playerx = (int) rect83.getRectangle().x;
			playery = (int) rect83.getRectangle().y;
			spawn5.x = playerx;
			spawn5.y = playery;

			RectangleMapObject rect84 = (RectangleMapObject) layer.getObjects()
					.get("spca");
			playerx = (int) rect84.getRectangle().x;
			playery = (int) rect84.getRectangle().y;
			spawn6.x = playerx;
			spawn6.y = playery;

			RectangleMapObject rect85 = (RectangleMapObject) layer.getObjects()
					.get("spke");
			playerx = (int) rect85.getRectangle().x;
			playery = (int) rect85.getRectangle().y;
			spawn7.x = playerx;
			spawn7.y = playery;
			break;

		case "maps/altbau.tmx":
			RectangleMapObject rect86 = (RectangleMapObject) layer.getObjects()
					.get("spif2");
			playerx = (int) rect86.getRectangle().x;
			playery = (int) rect86.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect87 = (RectangleMapObject) layer.getObjects()
					.get("spalt1");
			playerx = (int) rect87.getRectangle().x;
			playery = (int) rect87.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect88 = (RectangleMapObject) layer.getObjects()
					.get("spalt2");
			playerx = (int) rect88.getRectangle().x;
			playery = (int) rect88.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect89 = (RectangleMapObject) layer.getObjects()
					.get("spalt3");
			playerx = (int) rect89.getRectangle().x;
			playery = (int) rect89.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;

			RectangleMapObject rect90 = (RectangleMapObject) layer.getObjects()
					.get("spalt4");
			playerx = (int) rect90.getRectangle().x;
			playery = (int) rect90.getRectangle().y;
			spawn5.x = playerx;
			spawn5.y = playery;

			RectangleMapObject rect91 = (RectangleMapObject) layer.getObjects()
					.get("spalt5");
			playerx = (int) rect91.getRectangle().x;
			playery = (int) rect91.getRectangle().y;
			spawn6.x = playerx;
			spawn6.y = playery;

			RectangleMapObject rect92 = (RectangleMapObject) layer.getObjects()
					.get("spalt6");
			playerx = (int) rect92.getRectangle().x;
			playery = (int) rect92.getRectangle().y;
			spawn7.x = playerx;
			spawn7.y = playery;

			RectangleMapObject rect93 = (RectangleMapObject) layer.getObjects()
					.get("spalt7");
			playerx = (int) rect93.getRectangle().x;
			playery = (int) rect93.getRectangle().y;
			spawn8.x = playerx;
			spawn8.y = playery;

			RectangleMapObject rect94 = (RectangleMapObject) layer.getObjects()
					.get("spalt8");
			playerx = (int) rect94.getRectangle().x;
			playery = (int) rect94.getRectangle().y;
			spawn9.x = playerx;
			spawn9.y = playery;

			RectangleMapObject rect95 = (RectangleMapObject) layer.getObjects()
					.get("spalt9");
			playerx = (int) rect95.getRectangle().x;
			playery = (int) rect95.getRectangle().y;
			spawn10.x = playerx;
			spawn10.y = playery;

			RectangleMapObject rect96 = (RectangleMapObject) layer.getObjects()
					.get("spalt0");
			playerx = (int) rect96.getRectangle().x;
			playery = (int) rect96.getRectangle().y;
			spawn11.x = playerx;
			spawn11.y = playery;

			RectangleMapObject rect97 = (RectangleMapObject) layer.getObjects()
					.get("spalt10");
			playerx = (int) rect97.getRectangle().x;
			playery = (int) rect97.getRectangle().y;
			spawn12.x = playerx;
			spawn12.y = playery;

			RectangleMapObject rect98 = (RectangleMapObject) layer.getObjects()
					.get("spalt11");
			playerx = (int) rect98.getRectangle().x;
			playery = (int) rect98.getRectangle().y;
			spawn13.x = playerx;
			spawn13.y = playery;
			break;

		case "maps/IF2.tmx":
			RectangleMapObject rect99 = (RectangleMapObject) layer.getObjects()
					.get("spwa");
			playerx = (int) rect99.getRectangle().x;
			playery = (int) rect99.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect100 = (RectangleMapObject) layer
					.getObjects().get("spsz");
			playerx = (int) rect100.getRectangle().x;
			playery = (int) rect100.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect101 = (RectangleMapObject) layer
					.getObjects().get("spca1");
			playerx = (int) rect101.getRectangle().x;
			playery = (int) rect101.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect102 = (RectangleMapObject) layer
					.getObjects().get("spca2");
			playerx = (int) rect102.getRectangle().x;
			playery = (int) rect102.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;

			RectangleMapObject rect103 = (RectangleMapObject) layer
					.getObjects().get("spif1");
			playerx = (int) rect103.getRectangle().x;
			playery = (int) rect103.getRectangle().y;
			spawn5.x = playerx;
			spawn5.y = playery;

			RectangleMapObject rect104 = (RectangleMapObject) layer
					.getObjects().get("spif2");
			playerx = (int) rect104.getRectangle().x;
			playery = (int) rect104.getRectangle().y;
			spawn6.x = playerx;
			spawn6.y = playery;

			RectangleMapObject rect105 = (RectangleMapObject) layer
					.getObjects().get("spif3");
			playerx = (int) rect105.getRectangle().x;
			playery = (int) rect105.getRectangle().y;
			spawn7.x = playerx;
			spawn7.y = playery;

			RectangleMapObject rect106 = (RectangleMapObject) layer
					.getObjects().get("spif4");
			playerx = (int) rect106.getRectangle().x;
			playery = (int) rect106.getRectangle().y;
			spawn8.x = playerx;
			spawn8.y = playery;

			RectangleMapObject rect107 = (RectangleMapObject) layer
					.getObjects().get("spif5");
			playerx = (int) rect107.getRectangle().x;
			playery = (int) rect107.getRectangle().y;
			spawn9.x = playerx;
			spawn9.y = playery;

			RectangleMapObject rect108 = (RectangleMapObject) layer
					.getObjects().get("spif6");
			playerx = (int) rect108.getRectangle().x;
			playery = (int) rect108.getRectangle().y;
			spawn10.x = playerx;
			spawn10.y = playery;

			RectangleMapObject rect109 = (RectangleMapObject) layer
					.getObjects().get("spif7");
			playerx = (int) rect109.getRectangle().x;
			playery = (int) rect109.getRectangle().y;
			spawn11.x = playerx;
			spawn11.y = playery;

			RectangleMapObject rect110 = (RectangleMapObject) layer
					.getObjects().get("spif8");
			playerx = (int) rect110.getRectangle().x;
			playery = (int) rect110.getRectangle().y;
			spawn12.x = playerx;
			spawn12.y = playery;

			RectangleMapObject rect111 = (RectangleMapObject) layer
					.getObjects().get("spif9");
			playerx = (int) rect111.getRectangle().x;
			playery = (int) rect111.getRectangle().y;
			spawn13.x = playerx;
			spawn13.y = playery;

			RectangleMapObject rect112 = (RectangleMapObject) layer
					.getObjects().get("spif10");
			playerx = (int) rect112.getRectangle().x;
			playery = (int) rect112.getRectangle().y;
			spawn14.x = playerx;
			spawn14.y = playery;

			RectangleMapObject rect113 = (RectangleMapObject) layer
					.getObjects().get("spif11");
			playerx = (int) rect113.getRectangle().x;
			playery = (int) rect113.getRectangle().y;
			spawn15.x = playerx;
			spawn15.y = playery;

			RectangleMapObject rect114 = (RectangleMapObject) layer
					.getObjects().get("spif12");
			playerx = (int) rect114.getRectangle().x;
			playery = (int) rect114.getRectangle().y;
			spawn16.x = playerx;
			spawn16.y = playery;

			RectangleMapObject rect115 = (RectangleMapObject) layer
					.getObjects().get("spif13");
			playerx = (int) rect115.getRectangle().x;
			playery = (int) rect115.getRectangle().y;
			spawn17.x = playerx;
			spawn17.y = playery;

			RectangleMapObject rect116 = (RectangleMapObject) layer
					.getObjects().get("spif14");
			playerx = (int) rect116.getRectangle().x;
			playery = (int) rect116.getRectangle().y;
			spawn18.x = playerx;
			spawn18.y = playery;

			RectangleMapObject rect117 = (RectangleMapObject) layer
					.getObjects().get("spif15");
			playerx = (int) rect117.getRectangle().x;
			playery = (int) rect117.getRectangle().y;
			spawn19.x = playerx;
			spawn19.y = playery;

			RectangleMapObject rect118 = (RectangleMapObject) layer
					.getObjects().get("spif16");
			playerx = (int) rect118.getRectangle().x;
			playery = (int) rect118.getRectangle().y;
			spawn20.x = playerx;
			spawn20.y = playery;

			RectangleMapObject rect119 = (RectangleMapObject) layer
					.getObjects().get("spif17");
			playerx = (int) rect119.getRectangle().x;
			playery = (int) rect119.getRectangle().y;
			spawn21.x = playerx;
			spawn21.y = playery;

			RectangleMapObject rect120 = (RectangleMapObject) layer
					.getObjects().get("spif18");
			playerx = (int) rect120.getRectangle().x;
			playery = (int) rect120.getRectangle().y;
			spawn22.x = playerx;
			spawn22.y = playery;

			RectangleMapObject rect121 = (RectangleMapObject) layer
					.getObjects().get("spif19");
			playerx = (int) rect121.getRectangle().x;
			playery = (int) rect121.getRectangle().y;
			spawn23.x = playerx;
			spawn23.y = playery;

			RectangleMapObject rect122 = (RectangleMapObject) layer
					.getObjects().get("spif20");
			playerx = (int) rect122.getRectangle().x;
			playery = (int) rect122.getRectangle().y;
			spawn24.x = playerx;
			spawn24.y = playery;

			RectangleMapObject rect158 = (RectangleMapObject) layer
					.getObjects().get("spalt");
			playerx = (int) rect158.getRectangle().x;
			playery = (int) rect158.getRectangle().y;
			spawn25.x = playerx;
			spawn25.y = playery;
			break;

		case "maps/ho.tmx":
			RectangleMapObject rect123 = (RectangleMapObject) layer
					.getObjects().get("spho");
			playerx = (int) rect123.getRectangle().x;
			playery = (int) rect123.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect124 = (RectangleMapObject) layer
					.getObjects().get("spho1");
			playerx = (int) rect124.getRectangle().x;
			playery = (int) rect124.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect125 = (RectangleMapObject) layer
					.getObjects().get("spho2");
			playerx = (int) rect125.getRectangle().x;
			playery = (int) rect125.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect126 = (RectangleMapObject) layer
					.getObjects().get("spho3");
			playerx = (int) rect126.getRectangle().x;
			playery = (int) rect126.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;

			RectangleMapObject rect127 = (RectangleMapObject) layer
					.getObjects().get("spho4");
			playerx = (int) rect127.getRectangle().x;
			playery = (int) rect127.getRectangle().y;
			spawn5.x = playerx;
			spawn5.y = playery;

			RectangleMapObject rect128 = (RectangleMapObject) layer
					.getObjects().get("spho5");
			playerx = (int) rect128.getRectangle().x;
			playery = (int) rect128.getRectangle().y;
			spawn6.x = playerx;
			spawn6.y = playery;

			RectangleMapObject rect129 = (RectangleMapObject) layer
					.getObjects().get("spho6");
			playerx = (int) rect129.getRectangle().x;
			playery = (int) rect129.getRectangle().y;
			spawn7.x = playerx;
			spawn7.y = playery;

			RectangleMapObject rect130 = (RectangleMapObject) layer
					.getObjects().get("spho7");
			playerx = (int) rect130.getRectangle().x;
			playery = (int) rect130.getRectangle().y;
			spawn8.x = playerx;
			spawn8.y = playery;

			RectangleMapObject rect131 = (RectangleMapObject) layer
					.getObjects().get("spho8");
			playerx = (int) rect131.getRectangle().x;
			playery = (int) rect131.getRectangle().y;
			spawn9.x = playerx;
			spawn9.y = playery;

			RectangleMapObject rect132 = (RectangleMapObject) layer
					.getObjects().get("spho9");
			playerx = (int) rect132.getRectangle().x;
			playery = (int) rect132.getRectangle().y;
			spawn10.x = playerx;
			spawn10.y = playery;

			RectangleMapObject rect133 = (RectangleMapObject) layer
					.getObjects().get("spho10");
			playerx = (int) rect133.getRectangle().x;
			playery = (int) rect133.getRectangle().y;
			spawn11.x = playerx;
			spawn11.y = playery;

			RectangleMapObject rect134 = (RectangleMapObject) layer
					.getObjects().get("spho11");
			playerx = (int) rect134.getRectangle().x;
			playery = (int) rect134.getRectangle().y;
			spawn12.x = playerx;
			spawn12.y = playery;

			RectangleMapObject rect135 = (RectangleMapObject) layer
					.getObjects().get("spho12");
			playerx = (int) rect135.getRectangle().x;
			playery = (int) rect135.getRectangle().y;
			spawn13.x = playerx;
			spawn13.y = playery;

			RectangleMapObject rect136 = (RectangleMapObject) layer
					.getObjects().get("spho13");
			playerx = (int) rect136.getRectangle().x;
			playery = (int) rect136.getRectangle().y;
			spawn14.x = playerx;
			spawn14.y = playery;

			RectangleMapObject rect137 = (RectangleMapObject) layer
					.getObjects().get("spho14");
			playerx = (int) rect137.getRectangle().x;
			playery = (int) rect137.getRectangle().y;
			spawn15.x = playerx;
			spawn15.y = playery;

			RectangleMapObject rect138 = (RectangleMapObject) layer
					.getObjects().get("spho15");
			playerx = (int) rect138.getRectangle().x;
			playery = (int) rect138.getRectangle().y;
			spawn16.x = playerx;
			spawn16.y = playery;

			RectangleMapObject rect139 = (RectangleMapObject) layer
					.getObjects().get("spho16");
			playerx = (int) rect139.getRectangle().x;
			playery = (int) rect139.getRectangle().y;
			spawn17.x = playerx;
			spawn17.y = playery;

			RectangleMapObject rect140 = (RectangleMapObject) layer
					.getObjects().get("spho17");
			playerx = (int) rect140.getRectangle().x;
			playery = (int) rect140.getRectangle().y;
			spawn18.x = playerx;
			spawn18.y = playery;

			RectangleMapObject rect141 = (RectangleMapObject) layer
					.getObjects().get("spho18");
			playerx = (int) rect141.getRectangle().x;
			playery = (int) rect141.getRectangle().y;
			spawn19.x = playerx;
			spawn19.y = playery;

			RectangleMapObject rect142 = (RectangleMapObject) layer
					.getObjects().get("spho19");
			playerx = (int) rect142.getRectangle().x;
			playery = (int) rect142.getRectangle().y;
			spawn20.x = playerx;
			spawn20.y = playery;

			RectangleMapObject rect143 = (RectangleMapObject) layer
					.getObjects().get("spho20");
			playerx = (int) rect143.getRectangle().x;
			playery = (int) rect143.getRectangle().y;
			spawn21.x = playerx;
			spawn21.y = playery;

			RectangleMapObject rect144 = (RectangleMapObject) layer
					.getObjects().get("spho21");
			playerx = (int) rect144.getRectangle().x;
			playery = (int) rect144.getRectangle().y;
			spawn22.x = playerx;
			spawn22.y = playery;

			RectangleMapObject rect145 = (RectangleMapObject) layer
					.getObjects().get("spho22");
			playerx = (int) rect145.getRectangle().x;
			playery = (int) rect145.getRectangle().y;
			spawn23.x = playerx;
			spawn23.y = playery;

			RectangleMapObject rect146 = (RectangleMapObject) layer
					.getObjects().get("spho23");
			playerx = (int) rect146.getRectangle().x;
			playery = (int) rect146.getRectangle().y;
			spawn24.x = playerx;
			spawn24.y = playery;

			RectangleMapObject rect147 = (RectangleMapObject) layer
					.getObjects().get("spho24");
			playerx = (int) rect147.getRectangle().x;
			playery = (int) rect147.getRectangle().y;
			spawn25.x = playerx;
			spawn25.y = playery;
			break;

		case "maps/maze.tmx":
			RectangleMapObject rect148 = (RectangleMapObject) layer
					.getObjects().get("spla1");
			playerx = (int) rect148.getRectangle().x;
			playery = (int) rect148.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect149 = (RectangleMapObject) layer
					.getObjects().get("spla2");
			playerx = (int) rect149.getRectangle().x;
			playery = (int) rect149.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect150 = (RectangleMapObject) layer
					.getObjects().get("spla3");
			playerx = (int) rect150.getRectangle().x;
			playery = (int) rect150.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;

			RectangleMapObject rect151 = (RectangleMapObject) layer
					.getObjects().get("spla4");
			playerx = (int) rect151.getRectangle().x;
			playery = (int) rect151.getRectangle().y;
			spawn4.x = playerx;
			spawn4.y = playery;

			RectangleMapObject rect152 = (RectangleMapObject) layer
					.getObjects().get("spla5");
			playerx = (int) rect152.getRectangle().x;
			playery = (int) rect152.getRectangle().y;
			spawn5.x = playerx;
			spawn5.y = playery;
			break;

		case "maps/leonswohnung.tmx":
			RectangleMapObject rect153 = (RectangleMapObject) layer
					.getObjects().get("spwa");
			playerx = (int) rect153.getRectangle().x;
			playery = (int) rect153.getRectangle().y;
			spawn1.x = playerx;
			spawn1.y = playery;

			RectangleMapObject rect154 = (RectangleMapObject) layer
					.getObjects().get("spwo1");
			playerx = (int) rect154.getRectangle().x;
			playery = (int) rect154.getRectangle().y;
			spawn2.x = playerx;
			spawn2.y = playery;

			RectangleMapObject rect155 = (RectangleMapObject) layer
					.getObjects().get("spwo2");
			playerx = (int) rect155.getRectangle().x;
			playery = (int) rect155.getRectangle().y;
			spawn3.x = playerx;
			spawn3.y = playery;
			break;
		}
	}

	public void getExitpoints() {
		MapLayer Exitlayer = Gamescreen.tiledMap.getLayers().get("Exitpoints");

		switch (map) {
		case "maps/demondus1.tmx":
			RectangleMapObject exitrect1 = (RectangleMapObject) Exitlayer
					.getObjects().get("exde2");
			exit1 = exitrect1.getRectangle();

			RectangleMapObject exitrect2 = (RectangleMapObject) Exitlayer
					.getObjects().get("exzede1");
			exit2 = exitrect2.getRectangle();

			RectangleMapObject exitrect3 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrode1");
			exit3 = exitrect3.getRectangle();
			break;

		case "maps/demondus2.tmx":
			RectangleMapObject exitrect4 = (RectangleMapObject) Exitlayer
					.getObjects().get("exitpoint1");
			exit1 = exitrect4.getRectangle();

			RectangleMapObject exitrect5 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrode2");
			exit2 = exitrect5.getRectangle();

			RectangleMapObject exitrect6 = (RectangleMapObject) Exitlayer
					.getObjects().get("exde3");
			exit3 = exitrect6.getRectangle();
			break;

		case "maps/room.tmx":
			RectangleMapObject exitrect7 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrode2");
			exit1 = exitrect7.getRectangle();

			RectangleMapObject exitrect8 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrode4");
			exit2 = exitrect8.getRectangle();

			RectangleMapObject exitrect9 = (RectangleMapObject) Exitlayer
					.getObjects().get("exzede1");
			exit3 = exitrect9.getRectangle();

			RectangleMapObject exitrect10 = (RectangleMapObject) Exitlayer
					.getObjects().get("extrup");
			exit4 = exitrect10.getRectangle();

			RectangleMapObject exitrect11 = (RectangleMapObject) Exitlayer
					.getObjects().get("extrdo");
			exit5 = exitrect11.getRectangle();

			RectangleMapObject exitrect12 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrode1");
			exit6 = exitrect12.getRectangle();

			RectangleMapObject exitrect13 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrode3");
			exit7 = exitrect13.getRectangle();

			RectangleMapObject exitrect14 = (RectangleMapObject) Exitlayer
					.getObjects().get("exsede3");
			exit8 = exitrect14.getRectangle();

			RectangleMapObject exitrect15 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrodd1");
			exit9 = exitrect15.getRectangle();

			RectangleMapObject exitrect16 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrodd2");
			exit10 = exitrect16.getRectangle();

			RectangleMapObject exitrect17 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrodd3");
			exit11 = exitrect17.getRectangle();
			break;

		case "maps/demondus3.tmx":
			RectangleMapObject exitrect18 = (RectangleMapObject) Exitlayer
					.getObjects().get("exde2");
			exit1 = exitrect18.getRectangle();

			RectangleMapObject exitrect19 = (RectangleMapObject) Exitlayer
					.getObjects().get("exde4");
			exit2 = exitrect19.getRectangle();

			RectangleMapObject exitrect20 = (RectangleMapObject) Exitlayer
					.getObjects().get("exde7");
			exit3 = exitrect20.getRectangle();

			RectangleMapObject exitrect21 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrode3");
			exit4 = exitrect21.getRectangle();
			break;

		case "maps/demondus4.tmx":
			RectangleMapObject exitrect22 = (RectangleMapObject) Exitlayer
					.getObjects().get("exde3");
			exit1 = exitrect22.getRectangle();

			RectangleMapObject exitrect23 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrode4");
			exit2 = exitrect23.getRectangle();

			RectangleMapObject exitrect24 = (RectangleMapObject) Exitlayer
					.getObjects().get("excade4");
			exit3 = exitrect24.getRectangle();
			break;

		case "maps/demondus5.tmx":
			RectangleMapObject exitrect25 = (RectangleMapObject) Exitlayer
					.getObjects().get("excade4");
			exit1 = exitrect25.getRectangle();
			break;

		case "maps/wehhh.tmx":
			RectangleMapObject exitrect26 = (RectangleMapObject) Exitlayer
					.getObjects().get("exsede3");
			exit1 = exitrect26.getRectangle();
			break;

		case "maps/demondus7.tmx":
			RectangleMapObject exitrect27 = (RectangleMapObject) Exitlayer
					.getObjects().get("exde3");
			exit1 = exitrect27.getRectangle();

			RectangleMapObject exitrect28 = (RectangleMapObject) Exitlayer
					.getObjects().get("exdd");
			exit2 = exitrect28.getRectangle();
			break;

		case "maps/demondusdorf.tmx":
			RectangleMapObject exitrect29 = (RectangleMapObject) Exitlayer
					.getObjects().get("exde7");
			exit1 = exitrect29.getRectangle();

			RectangleMapObject exitrect30 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrodd3");
			exit2 = exitrect30.getRectangle();

			RectangleMapObject exitrect31 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrodd1");
			exit3 = exitrect31.getRectangle();

			RectangleMapObject exitrect32 = (RectangleMapObject) Exitlayer
					.getObjects().get("exrodd2");
			exit4 = exitrect32.getRectangle();

			RectangleMapObject exitrect33 = (RectangleMapObject) Exitlayer
					.getObjects().get("exka");
			exit5 = exitrect33.getRectangle();
			break;

		case "maps/kathedrale.tmx":
			RectangleMapObject exitrect34 = (RectangleMapObject) Exitlayer
					.getObjects().get("exdd");
			exit1 = exitrect34.getRectangle();

			RectangleMapObject exitrect35 = (RectangleMapObject) Exitlayer
					.getObjects().get("exka1");
			exit2 = exitrect35.getRectangle();

			RectangleMapObject exitrect36 = (RectangleMapObject) Exitlayer
					.getObjects().get("exka2");
			exit3 = exitrect36.getRectangle();

			RectangleMapObject exitrect37 = (RectangleMapObject) Exitlayer
					.getObjects().get("exka3");
			exit4 = exitrect37.getRectangle();

			RectangleMapObject exitrect38 = (RectangleMapObject) Exitlayer
					.getObjects().get("exka4");
			exit5 = exitrect38.getRectangle();

			RectangleMapObject exitrect39 = (RectangleMapObject) Exitlayer
					.getObjects().get("exka5");
			exit6 = exitrect39.getRectangle();

			RectangleMapObject exitrect40 = (RectangleMapObject) Exitlayer
					.getObjects().get("exka6");
			exit7 = exitrect40.getRectangle();

			RectangleMapObject exitrect41 = (RectangleMapObject) Exitlayer
					.getObjects().get("exka7");
			exit8 = exitrect41.getRectangle();

			RectangleMapObject exitrect42 = (RectangleMapObject) Exitlayer
					.getObjects().get("exka8");
			exit9 = exitrect42.getRectangle();

			RectangleMapObject exitrect43 = (RectangleMapObject) Exitlayer
					.getObjects().get("exkd1");
			exit10 = exitrect43.getRectangle();

			RectangleMapObject exitrect44 = (RectangleMapObject) Exitlayer
					.getObjects().get("exkd2");
			exit11 = exitrect44.getRectangle();

			RectangleMapObject exitrect45 = (RectangleMapObject) Exitlayer
					.getObjects().get("exku1");
			exit12 = exitrect45.getRectangle();

			RectangleMapObject exitrect46 = (RectangleMapObject) Exitlayer
					.getObjects().get("exku2");
			exit13 = exitrect46.getRectangle();
			break;

		case "maps/Dach_Tag.tmx":
			RectangleMapObject exitrect47 = (RectangleMapObject) Exitlayer
					.getObjects().get("exdach");
			exit1 = exitrect47.getRectangle();
			break;

		case "maps/Dach_Nacht.tmx":
			RectangleMapObject exitrect48 = (RectangleMapObject) Exitlayer
					.getObjects().get("exdach");
			exit1 = exitrect48.getRectangle();
			break;

		case "maps/Hauptweg_Tag.tmx":
			RectangleMapObject exitrect49 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwo");
			exit1 = exitrect49.getRectangle();

			RectangleMapObject exitrect50 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwese");
			exit2 = exitrect50.getRectangle();

			RectangleMapObject exitrect51 = (RectangleMapObject) Exitlayer
					.getObjects().get("exhof");
			exit3 = exitrect51.getRectangle();

			RectangleMapObject exitrect52 = (RectangleMapObject) Exitlayer
					.getObjects().get("exlich");
			exit4 = exitrect52.getRectangle();
			break;

		case "maps/Hauptweg_Nacht.tmx":
			RectangleMapObject exitrect53 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwo");
			exit1 = exitrect53.getRectangle();

			RectangleMapObject exitrect54 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwese");
			exit2 = exitrect54.getRectangle();

			RectangleMapObject exitrect55 = (RectangleMapObject) Exitlayer
					.getObjects().get("exhof");
			exit3 = exitrect55.getRectangle();

			RectangleMapObject exitrect56 = (RectangleMapObject) Exitlayer
					.getObjects().get("exlich");
			exit4 = exitrect56.getRectangle();
			break;

		case "maps/Lichtung_Tag.tmx":
			RectangleMapObject exitrect57 = (RectangleMapObject) Exitlayer
					.getObjects().get("exhawe");
			exit1 = exitrect57.getRectangle();

			RectangleMapObject exitrect58 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwo");
			exit2 = exitrect58.getRectangle();
			break;

		case "maps/Lichtung_Nacht.tmx":
			RectangleMapObject exitrect59 = (RectangleMapObject) Exitlayer
					.getObjects().get("exhawe");
			exit1 = exitrect59.getRectangle();

			RectangleMapObject exitrect60 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwo");
			exit2 = exitrect60.getRectangle();
			break;

		case "maps/See_Tag.tmx":
			RectangleMapObject exitrect61 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwese");
			exit1 = exitrect61.getRectangle();
			break;

		case "maps/See_Nacht.tmx":
			RectangleMapObject exitrect62 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwese");
			exit1 = exitrect62.getRectangle();
			break;

		case "maps/WegZumSee_Tag.tmx":
			RectangleMapObject exitrect63 = (RectangleMapObject) Exitlayer
					.getObjects().get("exhawe");
			exit1 = exitrect63.getRectangle();

			RectangleMapObject exitrect64 = (RectangleMapObject) Exitlayer
					.getObjects().get("exsee");
			exit2 = exitrect64.getRectangle();
			break;

		case "maps/WegZumSee_Nacht.tmx":
			RectangleMapObject exitrect65 = (RectangleMapObject) Exitlayer
					.getObjects().get("exhawe");
			exit1 = exitrect65.getRectangle();

			RectangleMapObject exitrect66 = (RectangleMapObject) Exitlayer
					.getObjects().get("exsee");
			exit2 = exitrect66.getRectangle();
			break;

		case "maps/Sozialzweig.tmx":
			RectangleMapObject exitrect67 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho1");
			exit1 = exitrect67.getRectangle();

			RectangleMapObject exitrect68 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho2");
			exit2 = exitrect68.getRectangle();

			RectangleMapObject exitrect69 = (RectangleMapObject) Exitlayer
					.getObjects().get("exdach");
			exit3 = exitrect69.getRectangle();

			RectangleMapObject exitrect70 = (RectangleMapObject) Exitlayer
					.getObjects().get("exbi1");
			exit4 = exitrect70.getRectangle();

			RectangleMapObject exitrect71 = (RectangleMapObject) Exitlayer
					.getObjects().get("exbi2");
			exit5 = exitrect71.getRectangle();

			RectangleMapObject exitrect72 = (RectangleMapObject) Exitlayer
					.getObjects().get("exeg");
			exit6 = exitrect72.getRectangle();

			RectangleMapObject exitrect73 = (RectangleMapObject) Exitlayer
					.getObjects().get("exbib1");
			exit7 = exitrect73.getRectangle();

			RectangleMapObject exitrect74 = (RectangleMapObject) Exitlayer
					.getObjects().get("exbib2");
			exit8 = exitrect74.getRectangle();

			RectangleMapObject exitrect75 = (RectangleMapObject) Exitlayer
					.getObjects().get("exbiug");
			exit9 = exitrect75.getRectangle();

			RectangleMapObject exitrect76 = (RectangleMapObject) Exitlayer
					.getObjects().get("ex1s");
			exit10 = exitrect76.getRectangle();

			RectangleMapObject exitrect77 = (RectangleMapObject) Exitlayer
					.getObjects().get("ex12s");
			exit11 = exitrect77.getRectangle();

			RectangleMapObject exitrect78 = (RectangleMapObject) Exitlayer
					.getObjects().get("ex2s");
			exit12 = exitrect78.getRectangle();

			RectangleMapObject exitrect79 = (RectangleMapObject) Exitlayer
					.getObjects().get("exbiog");
			exit13 = exitrect79.getRectangle();
			break;

		case "maps/cafeteria.tmx":
			RectangleMapObject exitrect80 = (RectangleMapObject) Exitlayer
					.getObjects().get("excake");
			exit1 = exitrect80.getRectangle();

			RectangleMapObject exitrect81 = (RectangleMapObject) Exitlayer
					.getObjects().get("exkeca");
			exit2 = exitrect81.getRectangle();

			RectangleMapObject exitrect82 = (RectangleMapObject) Exitlayer
					.getObjects().get("exroca");
			exit3 = exitrect82.getRectangle();

			RectangleMapObject exitrect83 = (RectangleMapObject) Exitlayer
					.getObjects().get("excaro");
			exit4 = exitrect83.getRectangle();

			RectangleMapObject exitrect84 = (RectangleMapObject) Exitlayer
					.getObjects().get("exca");
			exit5 = exitrect84.getRectangle();

			RectangleMapObject exitrect85 = (RectangleMapObject) Exitlayer
					.getObjects().get("excaif");
			exit6 = exitrect85.getRectangle();

			RectangleMapObject exitrect86 = (RectangleMapObject) Exitlayer
					.getObjects().get("exke");
			exit7 = exitrect86.getRectangle();
			break;

		case "maps/altbau.tmx":
			RectangleMapObject exitrect87 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif2");
			exit1 = exitrect87.getRectangle();

			RectangleMapObject exitrect88 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt1");
			exit2 = exitrect88.getRectangle();

			RectangleMapObject exitrect89 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt2");
			exit3 = exitrect89.getRectangle();

			RectangleMapObject exitrect90 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt3");
			exit4 = exitrect90.getRectangle();

			RectangleMapObject exitrect91 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt4");
			exit5 = exitrect91.getRectangle();

			RectangleMapObject exitrect92 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt5");
			exit6 = exitrect92.getRectangle();

			RectangleMapObject exitrect93 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt6");
			exit7 = exitrect93.getRectangle();

			RectangleMapObject exitrect94 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt7");
			exit8 = exitrect94.getRectangle();

			RectangleMapObject exitrect95 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt8");
			exit9 = exitrect95.getRectangle();

			RectangleMapObject exitrect96 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt9");
			exit10 = exitrect96.getRectangle();

			RectangleMapObject exitrect97 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt0");
			exit11 = exitrect97.getRectangle();

			RectangleMapObject exitrect98 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt10");
			exit12 = exitrect98.getRectangle();

			RectangleMapObject exitrect99 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt11");
			exit13 = exitrect99.getRectangle();
			break;

		case "maps/IF2.tmx":
			RectangleMapObject exitrect100 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwa");
			exit1 = exitrect100.getRectangle();

			RectangleMapObject exitrect101 = (RectangleMapObject) Exitlayer
					.getObjects().get("exsz");
			exit2 = exitrect101.getRectangle();

			RectangleMapObject exitrect102 = (RectangleMapObject) Exitlayer
					.getObjects().get("exca1");
			exit3 = exitrect102.getRectangle();

			RectangleMapObject exitrect103 = (RectangleMapObject) Exitlayer
					.getObjects().get("exca2");
			exit4 = exitrect103.getRectangle();

			RectangleMapObject exitrect104 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif1");
			exit5 = exitrect104.getRectangle();

			RectangleMapObject exitrect105 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif2");
			exit6 = exitrect105.getRectangle();

			RectangleMapObject exitrect106 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif3");
			exit7 = exitrect106.getRectangle();

			RectangleMapObject exitrect107 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif4");
			exit8 = exitrect107.getRectangle();

			RectangleMapObject exitrect108 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif5");
			exit9 = exitrect108.getRectangle();

			RectangleMapObject exitrect109 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif6");
			exit10 = exitrect109.getRectangle();

			RectangleMapObject exitrect110 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif7");
			exit11 = exitrect110.getRectangle();

			RectangleMapObject exitrect111 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif8");
			exit12 = exitrect111.getRectangle();

			RectangleMapObject exitrect112 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif9");
			exit13 = exitrect112.getRectangle();

			RectangleMapObject exitrect113 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif10");
			exit14 = exitrect113.getRectangle();

			RectangleMapObject exitrect114 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif11");
			exit15 = exitrect114.getRectangle();

			RectangleMapObject exitrect115 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif12");
			exit16 = exitrect115.getRectangle();

			RectangleMapObject exitrect116 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif13");
			exit17 = exitrect116.getRectangle();

			RectangleMapObject exitrect117 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif14");
			exit18 = exitrect117.getRectangle();

			RectangleMapObject exitrect118 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif15");
			exit19 = exitrect118.getRectangle();

			RectangleMapObject exitrect119 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif16");
			exit20 = exitrect119.getRectangle();

			RectangleMapObject exitrect120 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif17");
			exit21 = exitrect120.getRectangle();

			RectangleMapObject exitrect121 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif18");
			exit22 = exitrect121.getRectangle();

			RectangleMapObject exitrect122 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif19");
			exit23 = exitrect122.getRectangle();

			RectangleMapObject exitrect123 = (RectangleMapObject) Exitlayer
					.getObjects().get("exif20");
			exit24 = exitrect123.getRectangle();

			RectangleMapObject exitrect169 = (RectangleMapObject) Exitlayer
					.getObjects().get("exalt");
			exit25 = exitrect169.getRectangle();
			break;

		case "maps/ho.tmx":
			RectangleMapObject exitrect124 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho1");
			exit1 = exitrect124.getRectangle();

			RectangleMapObject exitrect125 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho2");
			exit2 = exitrect125.getRectangle();

			RectangleMapObject exitrect126 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho3");
			exit3 = exitrect126.getRectangle();

			RectangleMapObject exitrect127 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho4");
			exit4 = exitrect127.getRectangle();

			RectangleMapObject exitrect128 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho5");
			exit5 = exitrect128.getRectangle();

			RectangleMapObject exitrect1282 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho6");
			exit6 = exitrect1282.getRectangle();

			RectangleMapObject exitrect1283 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho7");
			exit7 = exitrect1283.getRectangle();

			RectangleMapObject exitrect129 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho8");
			exit8 = exitrect129.getRectangle();

			RectangleMapObject exitrect130 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho9");
			exit9 = exitrect130.getRectangle();

			RectangleMapObject exitrect131 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho10");
			exit10 = exitrect131.getRectangle();

			RectangleMapObject exitrect132 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho11");
			exit11 = exitrect132.getRectangle();

			RectangleMapObject exitrect133 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho12");
			exit12 = exitrect133.getRectangle();

			RectangleMapObject exitrect134 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho13");
			exit13 = exitrect134.getRectangle();

			RectangleMapObject exitrect135 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho14");
			exit14 = exitrect135.getRectangle();

			RectangleMapObject exitrect136 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho15");
			exit15 = exitrect136.getRectangle();

			RectangleMapObject exitrect137 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho16");
			exit16 = exitrect137.getRectangle();

			RectangleMapObject exitrect138 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho17");
			exit17 = exitrect138.getRectangle();

			RectangleMapObject exitrect139 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho18");
			exit18 = exitrect139.getRectangle();

			RectangleMapObject exitrect140 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho19");
			exit19 = exitrect140.getRectangle();

			RectangleMapObject exitrect141 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho20");
			exit20 = exitrect141.getRectangle();

			RectangleMapObject exitrect142 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho21");
			exit21 = exitrect142.getRectangle();

			RectangleMapObject exitrect143 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho22");
			exit22 = exitrect143.getRectangle();

			RectangleMapObject exitrect144 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho23");
			exit23 = exitrect144.getRectangle();

			RectangleMapObject exitrect145 = (RectangleMapObject) Exitlayer
					.getObjects().get("exho24");
			exit24 = exitrect145.getRectangle();
			break;

		case "maps/maze.tmx":
			RectangleMapObject exitrect146 = (RectangleMapObject) Exitlayer
					.getObjects().get("exlar1");
			exit1 = exitrect146.getRectangle();

			RectangleMapObject exitrect147 = (RectangleMapObject) Exitlayer
					.getObjects().get("exlar2");
			exit2 = exitrect147.getRectangle();

			RectangleMapObject exitrect148 = (RectangleMapObject) Exitlayer
					.getObjects().get("exlar3");
			exit3 = exitrect148.getRectangle();

			RectangleMapObject exitrect149 = (RectangleMapObject) Exitlayer
					.getObjects().get("exlar4");
			exit4 = exitrect149.getRectangle();

			RectangleMapObject exitrect150 = (RectangleMapObject) Exitlayer
					.getObjects().get("exlar5");
			exit5 = exitrect150.getRectangle();

			RectangleMapObject exitrect151 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla1");
			exit6 = exitrect151.getRectangle();

			RectangleMapObject exitrect152 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla2");
			exit7 = exitrect152.getRectangle();

			RectangleMapObject exitrect153 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla3");
			exit8 = exitrect153.getRectangle();

			RectangleMapObject exitrect154 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla4");
			exit9 = exitrect154.getRectangle();

			RectangleMapObject exitrect155 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla5");
			exit10 = exitrect155.getRectangle();

			RectangleMapObject exitrect156 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla6");
			exit11 = exitrect156.getRectangle();

			RectangleMapObject exitrect157 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla7");
			exit12 = exitrect157.getRectangle();

			RectangleMapObject exitrect158 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla8");
			exit13 = exitrect158.getRectangle();

			RectangleMapObject exitrect159 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla9");
			exit14 = exitrect159.getRectangle();

			RectangleMapObject exitrect160 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla10");
			exit15 = exitrect160.getRectangle();

			RectangleMapObject exitrect161 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla11");
			exit16 = exitrect161.getRectangle();

			RectangleMapObject exitrect162 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla12");
			exit17 = exitrect162.getRectangle();

			RectangleMapObject exitrect163 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla13");
			exit18 = exitrect163.getRectangle();

			RectangleMapObject exitrect164 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla14");
			exit19 = exitrect164.getRectangle();

			RectangleMapObject exitrect165 = (RectangleMapObject) Exitlayer
					.getObjects().get("exla15");
			exit20 = exitrect165.getRectangle();
			break;

		case "maps/leonswohnung.tmx":
			RectangleMapObject exitrect166 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwa");
			exit1 = exitrect166.getRectangle();

			RectangleMapObject exitrect167 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwo1");
			exit2 = exitrect167.getRectangle();

			RectangleMapObject exitrect168 = (RectangleMapObject) Exitlayer
					.getObjects().get("exwo2");
			exit3 = exitrect168.getRectangle();
			break;
		}
	}

}