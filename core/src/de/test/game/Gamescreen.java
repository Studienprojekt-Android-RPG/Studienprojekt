package de.test.game;

import java.io.File;
import java.io.IOException;

import com.badlogic.gdx.Application.ApplicationType;
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
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.test.game.Testmap.ScreenType;


public class Gamescreen implements Screen {
	static String map = "maps/maze.tmx";
	String mapchange = "maps/maze.tmx";
	SpriteBatch batch;
	Texture menbut;
	static Sprite gamemenu = new Sprite();
	static Player player;
	ShapeRenderer sr;
	float playerx;
	float playery;
	static TiledMap tiledMap;
	MapLayer layer;
	RectangleMapObject rect;
	String userName = System.getProperty("user.name");
	public static File saveFile;
	
	static Gamescreen gamescreen;
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
	ImageButtonStyle warning = new ImageButtonStyle();
	ImageButtonStyle action = new ImageButtonStyle();
	static ImageButton up;
	static ImageButton down;
	static ImageButton left;
	static ImageButton right;
	static ImageButton warn;
	static ImageButton act;
	
	mapManager mapmanager;
	
	static Gamemenu gamenu;
	
	OrthographicCamera cam;
	static OrthogonalTiledMapRenderer renderer;
	Viewport viewport;

	Rectangle battlestart;
	
	Stage stage;
	static Testmap game;
	
	static int screen = 1;
	
	public Gamescreen(Testmap game){
		
		this.game = game;
		
		cam = new OrthographicCamera();
		viewport = new ExtendViewport(800, 480, cam);
		stage = new Stage(viewport);
		
		createSave();
	}
	
	@Override
	public void show () 
	{
		Testmap.setHorst("gs");
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
		ibs.down = skin.getDrawable("menubutton");
		ibs.up = skin.getDrawable("menubutton");
		skin.add("menbut", ibs);
		digiup.up = skin.getDrawable("digiup");
		digidown.up = skin.getDrawable("digidown");
		digileft.up = skin.getDrawable("digileft");
		digiright.up = skin.getDrawable("digiright");
		warning.up = skin.getDrawable("warning");
		action.up = skin.getDrawable("Action");
		digiup.down = skin.getDrawable("digiup");
		digidown.down = skin.getDrawable("digidown");
		digileft.down = skin.getDrawable("digileft");
		digiright.down = skin.getDrawable("digiright");
		warning.down = skin.getDrawable("warning");
		action.down = skin.getDrawable("Action");
		skin.add("up", digiup);
		skin.add("down", digidown);
		skin.add("left", digileft);
		skin.add("right", digiright);
		skin.add("warn", warning);
		skin.add("act", action);
		gammenu = new ImageButton(skin, "menbut");
		up = new ImageButton(skin, "up");
		down = new ImageButton(skin, "down");
		left = new ImageButton(skin, "left");
		right = new ImageButton(skin, "right");
		gamenu = new Gamemenu(skin);
		warn = new ImageButton(skin, "warn");
		act = new ImageButton(skin, "act");
		
		gamenu.setVisible(false);
		gamenu.setKeepWithinStage(false);
		gamenu.setMovable(false);
		
		gammenu.setVisible(true);
		
		up.setVisible(true);
		down.setVisible(true);
		left.setVisible(true);
		right.setVisible(true);
		warn.setVisible(false);
		act.setVisible(true);
				
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
			
			/*if(saveFile.exists()){
				player = new Player(new Vector2(playerx, playery), "leon.png", 55, 55, 10, 10, 200, 20, 10, 600, 10, 500);
				try {
					player.readPlayer(player);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Player Exists, Reading File");
				tiledMap = new TmxMapLoader().load(map);*/

		player = new Player(new Vector2(playerx, playery), "leon.png", 55, 55, 10, 10, 200, 20, 10, 600, 10, 500);
		tiledMap = new TmxMapLoader().load(map);
		layer = tiledMap.getLayers().get("Spawnpoints");
		rect = (RectangleMapObject) layer.getObjects().get("spla1");
		player.position.x = (float) rect.getRectangle().x;
		player.position.y = (float) rect.getRectangle().y;
		
		renderer = new OrthogonalTiledMapRenderer(tiledMap);
		
	    mapmanager = new mapManager();
		mapmanager.setCollision();
		mapmanager.getSpawnpoints();
		mapmanager.getExitpoints();
		mapmanager.setBattle();		
		
    
		stage.addActor(up);
		stage.addActor(down);
		stage.addActor(left);
		stage.addActor(right);
		stage.addActor(gammenu);
		stage.addActor(gamenu);
		stage.addActor(warn);
		stage.addActor(act);
		Gdx.input.setInputProcessor(stage);
}

	/**
	 * 
	 */
	public void createSave() 
	{
		int i = 0;
		if(Gdx.app.getType() == ApplicationType.Desktop)
		{
			File folder = new File("C:/Users/" + userName + "/.prefs/");
			File[] listOfFiles = folder.listFiles();

			for (File file : listOfFiles) 
			{
			    if (file.isFile()) 
			    {
			        i = Character.getNumericValue(file.getName().charAt(3));
			        i++;
			    }
			}
			
			if(i <= 9)
			{
				saveFile = new File("C:/Users/" + userName + "/.prefs/haw" + i);
			}
			else
			{
				Skin dialogSkin = new Skin(Gdx.files.internal("uiskin.json"));
				BitmapFont font = new BitmapFont(Gdx.files.internal("default.fnt"));
				LabelStyle labelStyle = new LabelStyle();
				labelStyle.font = font;
				Label label =  new Label("You can't have more then 10 saves.\nPlease load a saved Game or delete one.", labelStyle);
				
				Dialog dialog = new Dialog("Error", dialogSkin, "dialog")
				{
					public void result(Object obj)
					{
						if(obj.equals(true))
						{
							game.setScreen(game.getScreenType(ScreenType.StartMenu));
						}
					}
				};
				dialog.text(label);
				dialog.button("OK", true);
				dialog.setPosition(300, 200);
				dialog.sizeBy(100, 100);
				dialog.pack();
				dialog.setVisible(true);
				stage.addActor(dialog);
			}
		}
		else
		{
			File folder = new File("/data/data/de.test.game/shared_prefs/");
			File[] listOfFiles = folder.listFiles();

			for (File file : listOfFiles) 
			{
			    if (file.isFile()) 
			    {
			        i = Character.getNumericValue(file.getName().charAt(3));
			        i++;
			    }
			}
			
			if(i <= 9)
			{
				saveFile = new File("/data/data/de.test.game/shared_prefs/haw" + i + ".xml");
			}
			else
			{
				Skin dialogSkin = new Skin(Gdx.files.internal("uiskin.json"));
				BitmapFont font = new BitmapFont(Gdx.files.internal("default.fnt"));
				LabelStyle labelStyle = new LabelStyle();
				labelStyle.font = font;
				Label label =  new Label("You can't have more then 10 saves.\nPlease load a saved Game or delete one.", labelStyle);
				
				Dialog dialog = new Dialog("Error", dialogSkin, "dialog")
				{
					public void result(Object obj)
					{
						if(obj.equals(true))
						{
							game.setScreen(game.getScreenType(ScreenType.StartMenu));
						}
					}
				};
				dialog.text(label);
				dialog.button("OK", true);
				dialog.setPosition(300, 200);
				dialog.sizeBy(100, 100);
				dialog.pack();
				dialog.setVisible(true);
				stage.addActor(dialog);
			}
		}
	}
	
	@Override
	public void dispose(){
		stage.dispose();
		tiledMap.dispose();
		renderer.dispose();
		batch.dispose();
		font.dispose();
		skin.dispose();
		butwin.dispose();
	}

	@Override
	public void render (float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		player.update();
		renderer.setView(cam);
		renderer.render();
		cam.position.set(player.getPosition().x + (player.getCurrentFrame().getRegionWidth() / 2), player.getPosition().y + (player.getCurrentFrame().getRegionHeight() / 2), 0);
	    batch.setProjectionMatrix(cam.combined);
	    cam.update();
	    mapmanager.update();
		batch.begin();
		batch.draw(player.getCurrentFrame(), player.getPosition().x, player.getPosition().y);
		batch.end();
		stage.act();
		stage.draw();
		warn.setVisible(false);
		
		if(act.isPressed()){
			player.curHP = player.maxHP;
			System.out.println("Geheilt!!!");
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

