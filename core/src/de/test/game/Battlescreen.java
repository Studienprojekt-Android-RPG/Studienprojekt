package de.test.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Battlescreen implements Screen {
	
	SpriteBatch batch;
	TextureAtlas enemies;
	Sprite enemy1 = new Sprite();
	Sprite enemy2 = new Sprite();
	Sprite enemy3 = new Sprite();
	Player player = Gamescreen.player;
	Vector2 playerPosition;
	RectangleMapObject rect1;
	RectangleMapObject rect2;
	RectangleMapObject rect3;
	
	BitmapFont font;
	Skin skin;
	TextureAtlas butwin;
	TextButtonStyle buttonstyle = new TextButtonStyle();
	WindowStyle ws = new WindowStyle();
	ImageButtonStyle angriff = new ImageButtonStyle();
	ImageButtonStyle select = new ImageButtonStyle();
	ImageButton ang;
	ImageButton sel;
	
	Battlemenu battlemenu;
	
	static Music battletheme = Gdx.audio.newMusic(Gdx.files.internal("Battle Theme.mp3"));
	
	OrthographicCamera cam;
	Viewport viewport;
	
	Stage stage;
	Game battle;
	
	public Battlescreen(Game battle){
		
		this.battle = battle;
		
	}
	
	@Override
	public void show() {
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
		angriff.down = skin.getDrawable("Action");
		angriff.up = skin.getDrawable("Action");
		select.up = skin.getDrawable("Sbutton");
		select.down = skin.getDrawable("Sbutton");
		skin.add("ang", angriff);
		skin.add("sel", select);
		ang = new ImageButton(skin, "ang");
		sel = new ImageButton(skin, "sel");
		battlemenu = new Battlemenu(skin);
		
		cam = new OrthographicCamera();
		viewport = new FitViewport(800, 480, cam);
		
		battlemenu.setVisible(true);
		battlemenu.setKeepWithinStage(false);
		battlemenu.setMovable(false);
		
		ang.setVisible(true);
		sel.setVisible(true);
		
		batch = new SpriteBatch();
//		batchTouch = new SpriteBatch();
		
		stage = new Stage(viewport);
		stage.addActor(ang);
		stage.addActor(sel);
		stage.addActor(battlemenu);
		Gdx.input.setInputProcessor(stage);
		
		ang.setPosition(140, 40);
		sel.setPosition(15, 40);
		battlemenu.setPosition(0, Gdx.graphics.getHeight() - battlemenu.getHeight());
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		cam.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
		batch.setProjectionMatrix(cam.combined);
	    cam.update();
		batch.begin();
		batch.draw(player.getCurrentFrame(), player.getPosition().x, player.getPosition().y);
		batch.end();
		stage.act();
		stage.draw();
		battletheme.play();
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
