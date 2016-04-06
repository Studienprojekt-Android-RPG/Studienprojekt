package de.test.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Gamescreen implements Screen {
	String map = "data/demondus1.tmx";
	String mapchange = "data/demondus2.tmx";
	SpriteBatch batch;
	SpriteBatch batchTouch;
	Texture menbut;
	static Sprite gamemenu = new Sprite();
	Player player;
	ShapeRenderer sr;
	
	BitmapFont font;
	Skin skin;
	TextureAtlas butwin;
	TextButtonStyle buttonstyle = new TextButtonStyle();
	WindowStyle ws = new WindowStyle();
	static ImageButton gammenu;
	ImageButtonStyle ibs = new ImageButtonStyle();
	ImageButtonStyle digiup = new ImageButtonStyle();
	ImageButtonStyle digidown = new ImageButtonStyle();
	ImageButtonStyle digileft = new ImageButtonStyle();
	ImageButtonStyle digiright = new ImageButtonStyle();
	static ImageButton up;
	static ImageButton down;
	static ImageButton left;
	static ImageButton right;
	
	static Gamemenu gamenu;
	
	TiledMap tiledMap = new TmxMapLoader().load(map);
	OrthographicCamera cam;
	OrthogonalTiledMapRenderer renderer;
	Viewport viewport;
	Viewport viewport2;
	
	ArrayList<Rectangle> bounds = new ArrayList<Rectangle>();
	
	MapProperties prop = tiledMap.getProperties();
    int mapWidth = prop.get("width", Integer.class);
    int mapHeight = prop.get("height", Integer.class);
     
    MapLayer layer = tiledMap.getLayers().get("Spawnpoints");
 	RectangleMapObject rect = (RectangleMapObject) layer.getObjects().get("spawnpoint1");
 	float playerx = (float) rect.getRectangle().x;
 	float playery = (float) rect.getRectangle().y;
	
	Vector2 position = new Vector2(playerx, playery);
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
	
	/**/
	static Touchpad touchpad;
	static Skin touchpadSkin; 
	static TouchpadStyle touchpadStyle;
	static Drawable touchBackground;
	static Drawable touchKnob;
	Stage stage;
	Game game;

	
	public Gamescreen(Game game){
		
		this.game = game;
		
	}
	
	@Override
	public void show () {
		skin = new Skin();
		font = new BitmapFont(Gdx.files.internal("default.fnt"));
		butwin = new TextureAtlas("butwin.atlas");
		skin.addRegions(butwin);
		ws.background = skin.getDrawable("default-window");
		ws.titleFont = font;
		buttonstyle.down = skin.getDrawable("testbutton2");
		buttonstyle.up = skin.getDrawable("testbutton");
		buttonstyle.font = font;		
		skin.add("default", ws);
		skin.add("Button", buttonstyle);
		ibs.down = skin.getDrawable("test");
		ibs.up = skin.getDrawable("test");
		skin.add("menbut", ibs);
		digiup.up = skin.getDrawable("digiup");
		digidown.up = skin.getDrawable("digidown");
		digileft.up = skin.getDrawable("digileft");
		digiright.up = skin.getDrawable("digiright");
		digiup.down = skin.getDrawable("digiup");
		digidown.down = skin.getDrawable("digidown");
		digileft.down = skin.getDrawable("digileft");
		digiright.down = skin.getDrawable("digiright");
		skin.add("up", digiup);
		skin.add("down", digidown);
		skin.add("left", digileft);
		skin.add("right", digiright);
		gammenu = new ImageButton(skin, "menbut");
		up = new ImageButton(skin, "up");
		down = new ImageButton(skin, "down");
		left = new ImageButton(skin, "left");
		right = new ImageButton(skin, "right");
		gamenu = new Gamemenu(skin);
		
		getSpawnpoints();
		getExitpoints();
		cam = new OrthographicCamera();
		viewport = new FitViewport(800, 480, cam);
		
		gamenu.setVisible(false);
		gamenu.setKeepWithinStage(false);
		gamenu.setMovable(false);
		
		gammenu.setVisible(true);
		
		up.setVisible(true);
		down.setVisible(true);
		left.setVisible(true);
		right.setVisible(true);
		
		batch = new SpriteBatch();
		batchTouch = new SpriteBatch();
		sr = new ShapeRenderer();
		setCollision();
		
		if(Gdx.files.local("Player.dat").exists()){
			try {
				player = new Player(new Vector2(playerx, playery), "badlogic.png");
				player.position.x = Player.readPlayer().x;
				player.position.y = Player.readPlayer().y;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Player Exists, Reading File");
		}else{
			player = new Player(new Vector2(playerx, playery), "badlogic.jpg");
			try {
				Player.savePlayer(player);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Player Does Not Exist, Creating Player and Saving Player");
		}
		
      renderer = new OrthogonalTiledMapRenderer(tiledMap);      

    //Create a touchpad skin	
    touchpadSkin = new Skin();
    //Set background image
    touchpadSkin.add("touchBackground", new Texture("data/stopper.png"));
    //Set knob image
    touchpadSkin.add("touchKnob", new Texture("data/stopper.png"));
   	//Create TouchPad Style
    touchpadStyle = new TouchpadStyle();
    //Create Drawable's from TouchPad skin
   	touchBackground = touchpadSkin.getDrawable("touchBackground");
   	touchKnob = touchpadSkin.getDrawable("touchKnob");
   	//Apply the Drawables to the TouchPad Style
    touchpadStyle.background = touchBackground;
    touchpadStyle.knob = touchKnob;
    //Create new TouchPad with the created style
    touchpad = new Touchpad(20, touchpadStyle);
    //setBounds(x,y,width,height)
//    touchpad.setBounds(player.getPosition().x - 290, player.getPosition().y - 210, 200, 200);
    
   
    
    stage = new Stage(viewport);
	stage.addActor(up);
	stage.addActor(down);
	stage.addActor(left);
	stage.addActor(right);
	stage.addActor(gammenu);
	stage.addActor(gamenu);
	Gdx.input.setInputProcessor(stage);
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void dispose(){
		try {
			player.savePlayer(player);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render (float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		player.update();
	
		//check for Collision
		for (int i = 0; i < bounds.size(); i++){
			if(bounds.get(i).overlaps(player.getBounds())){
				player.reAdjust();
			}
		}
		//check for Mapchange
		switch(map){  
			case "data/demondus1.tmx":	if(Intersector.overlaps(exit1, player.getBounds())){
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
			
			case "data/demondus2.tmx":	if(Intersector.overlaps(exit1, player.getBounds())){
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
			
			case "data/demondus3.tmx": 	if(Intersector.overlaps(exit1, player.getBounds())){
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
			
			case "data/demondus4.tmx":	if(Intersector.overlaps(exit1, player.getBounds())){
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
			
			case "data/demondus5.tmx": if(Intersector.overlaps(exit1, player.getBounds())){
											mapchange = "data/demondus4.tmx";
											changeMap(mapchange, map, spawn3);
										}
			break;
			
			case "data/wehhh.tmx":		if(Intersector.overlaps(exit1, player.getBounds())){
											mapchange = "data/room.tmx";
											changeMap(mapchange, map, spawn7);
										}
			
			case "data/room.tmx":		if(Intersector.overlaps(exit1, player.getBounds())){
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
			break;
		}
		renderer.setView(cam);
		renderer.render();
		cam.position.set(player.getPosition().x + (player.getCurrentFrame().getRegionWidth() / 2), player.getPosition().y + (player.getCurrentFrame().getRegionHeight() / 2), 0);
	    batch.setProjectionMatrix(cam.combined);
	    cam.update();
		batch.begin();
		batch.draw(player.getCurrentFrame(), player.getPosition().x, player.getPosition().y);
//		System.out.println("Digi X: " + digipad.getX());
//		System.out.println("Digi Y: " + digipad.getY());
//		System.out.println("Touch X: " + touchpad.getKnobX());
//		System.out.println("Touch Y: " + touchpad.getKnobY());
//		System.out.println("Touchpad X: " + touchpad.getX());
//		System.out.println("Touchpad Y: " + touchpad.getY());
		batch.end();
		stage.act();
		stage.draw();
	}
	
	void changeMap(String map, String mapchange, Vector2 spawn) {
		this.map = map;
	        tiledMap = new TmxMapLoader().load(map); //load the new map
	        renderer.getMap().dispose(); //dispose the old map
	        renderer.setMap(tiledMap); //set the map in your renderer
		    setCollision();
			getSpawnpoints();
			this.mapchange = mapchange;
			playerx = spawn.x;
			playery = spawn.y;
		    player.position.x = playerx;
		    player.position.y = playery;
		    getExitpoints();		
	}
	
	void setCollision(){
		bounds.clear();
		prop = tiledMap.getProperties();
	    mapWidth = prop.get("width", Integer.class);
	    mapHeight = prop.get("height", Integer.class);
	      for (int i = 0; i < mapWidth; i++){
	    	  for (int j = 0; j < mapHeight; j++){
	    		  TiledMapTileLayer cur = (TiledMapTileLayer) tiledMap.getLayers().get("Collision");
	    		  Cell cell = new Cell();
	    		  
	    		  if(cur.getCell(i, j) != null){
	    			  cell = cur.getCell(i, j);
	    			  bounds.add(new Rectangle(i * 32, j * 32, 32, 32));
	    		  }
	    	  }
	      }
	}

	void getSpawnpoints(){
		int playerx;
		int playery;
		MapLayer layer = tiledMap.getLayers().get("Spawnpoints");
		
		
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
//			case "data/cafeteria.tmx": RectangleMapObject rect9 = (RectangleMapObject) layer.getObjects().get("spawnpoint1");
//										playerx = (int) rect9.getRectangle().x;
//										playery = (int) rect9.getRectangle().y;
//										spawn1.x = playerx;
//										spawn1.y = playery;
//			break;
		}
	}
	
	void getExitpoints(){
		MapLayer Exitlayer = tiledMap.getLayers().get("Exitpoints");
		
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
		}
	}
	
	@Override
	public void resize(int width, int height) {
		
		viewport.update(width, height);
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
}

