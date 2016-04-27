package de.test.game;

import java.io.File;
import java.io.IOException;

import com.badlogic.gdx.Application.ApplicationType;
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
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class Gamescreen implements Screen {
	static String map = "maps/IF2.tmx";
	String mapchange = "maps/IF2.tmx";
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
	File test;
	
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
	static ImageButton up;
	static ImageButton down;
	static ImageButton left;
	static ImageButton right;
	static ImageButton warn;
	
	mapManager mapmanager;
	
	static Gamemenu gamenu;
	
	OrthographicCamera cam;
	static OrthogonalTiledMapRenderer renderer;
	Viewport viewport;

	Rectangle battlestart;
	
	Stage stage;
	static Game game;
	
	public Gamescreen(Game game){
		
		Gamescreen.game = game;
		
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
		ibs.down = skin.getDrawable("menubutton");
		ibs.up = skin.getDrawable("menubutton");
		skin.add("menbut", ibs);
		digiup.up = skin.getDrawable("digiup");
		digidown.up = skin.getDrawable("digidown");
		digileft.up = skin.getDrawable("digileft");
		digiright.up = skin.getDrawable("digiright");
		warning.up = skin.getDrawable("warning");
		digiup.down = skin.getDrawable("digiup");
		digidown.down = skin.getDrawable("digidown");
		digileft.down = skin.getDrawable("digileft");
		digiright.down = skin.getDrawable("digiright");
		warning.down = skin.getDrawable("warning");
		skin.add("up", digiup);
		skin.add("down", digidown);
		skin.add("left", digileft);
		skin.add("right", digiright);
		skin.add("warn", warning);
		gammenu = new ImageButton(skin, "menbut");
		up = new ImageButton(skin, "up");
		down = new ImageButton(skin, "down");
		left = new ImageButton(skin, "left");
		right = new ImageButton(skin, "right");
		gamenu = new Gamemenu(skin);
		warn = new ImageButton(skin, "warn");
		
		cam = new OrthographicCamera();
		viewport = new ExtendViewport(800, 480, cam);
		
		gamenu.setVisible(false);
		gamenu.setKeepWithinStage(false);
		gamenu.setMovable(false);
		
		gammenu.setVisible(true);
		
		up.setVisible(true);
		down.setVisible(true);
		left.setVisible(true);
		right.setVisible(true);
		warn.setVisible(false);
		
		batch = new SpriteBatch();
		sr = new ShapeRenderer();
		if(Gdx.app.getType() == ApplicationType.Desktop){
			test = new File("C:/Users/" + userName + "/.prefs/haw");
		}
		else{
			test = new File("/data/data/de.test.game/shared_prefs/haw.xml");
//			test = new File("/storage/emulated/0/Android/data/de.test.game/shared_prefs/haw.xml");
		}
		if(test.exists()){
			player = new Player(new Vector2(playerx, playery), "leon.png", 55, 10, 50, 20, 10, "Leon");
			try {
				player.readPlayer(player);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Player Exists, Reading File");
			tiledMap = new TmxMapLoader().load(map);

		}else{
			player = new Player(new Vector2(playerx, playery), "leon.png", 55, 10, 50, 20, 10, "Leon");
			tiledMap = new TmxMapLoader().load(map);
			layer = tiledMap.getLayers().get("Spawnpoints");
			rect = (RectangleMapObject) layer.getObjects().get("spwa");
		 	player.position.x = (float) rect.getRectangle().x;
		 	player.position.y = (float) rect.getRectangle().y;
			try {
				player.savePlayer(player);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Player Does Not Exist, Creating Player and Saving Player");
		}
		
		renderer = new OrthogonalTiledMapRenderer(tiledMap);
		
	    mapmanager = new mapManager();
		mapmanager.setCollision();
		mapmanager.getSpawnpoints();
		mapmanager.getExitpoints();
		mapmanager.setBattle();		
		
    stage = new Stage(viewport);
	stage.addActor(up);
	stage.addActor(down);
	stage.addActor(left);
	stage.addActor(right);
	stage.addActor(gammenu);
	stage.addActor(gamenu);
	stage.addActor(warn);
	Gdx.input.setInputProcessor(stage);
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

