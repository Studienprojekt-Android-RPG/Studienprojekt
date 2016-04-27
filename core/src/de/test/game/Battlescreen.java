package de.test.game;

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
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Battlescreen implements Screen {
	
	enum Battlestate{firstStrike, LeonTurn, EnemyTurn};
	static Battlestate battlestate;
	static Goblin gobi = new Goblin(7, 50, 50, 15, 7, "Gobi");
	
	SpriteBatch batch;
	TextureAtlas enemies;
	Texture test;
	Sprite enemy1;
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
	
//	static Music battletheme = Gdx.audio.newMusic(Gdx.files.internal("Battle Theme.mp3"));
//	static Music finalbattle = Gdx.audio.newMusic(Gdx.files.internal("Final Battle.mp3"));
	
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
		viewport = new ExtendViewport(800, 480, cam);
		cam.setToOrtho(false);
		
		battlemenu.setVisible(true);
		battlemenu.setKeepWithinStage(false);
		battlemenu.setMovable(false);
		
		ang.setVisible(true);
		sel.setVisible(true);
		
		batch = new SpriteBatch();
		
		stage = new Stage(viewport);
		stage.addActor(ang);
		stage.addActor(sel);
		stage.addActor(battlemenu);
		Gdx.input.setInputProcessor(stage);
		
		ang.setPosition(140, 40);
		sel.setPosition(15, 40);
		battlemenu.setPosition(0, 480 - battlemenu.getHeight());
//		battletheme.play();
//		finalbattle.play();
		
		test = new Texture(Gdx.files.internal("DivineShinael.png"));
		enemy1 = new Sprite(test);
		
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(cam.combined);
	    cam.update();
		batch.begin();
		batch.draw(player.getCurrentFrame(), player.getPosition().x, player.getPosition().y);
		batch.draw(test, 250, 150, 300, 300);
		batch.end();
		stage.act();
		stage.draw();
		
		
		switch (battlestate){
			
			case firstStrike:
				if(Fighter.turnSpeed(gobi) < Fighter.turnSpeed(Gamescreen.player)){
					battlestate = Battlestate.LeonTurn;
				}
				else{
					battlestate = Battlestate.EnemyTurn;
				}
		
			case LeonTurn:
//				System.out.println(player.getName() + " ist dran");
				
				battlemenu.setTouchable(Touchable.enabled);
				
				if(Battlemenu.hasClicked){
					Battlemenu.hasClicked = false;			
					battlestate = Battlestate.EnemyTurn;
				}
				
			break;
			
			case EnemyTurn:
				System.out.println(gobi.getName() + " ist dran");
				battlemenu.setTouchable(Touchable.disabled);
				for (int i = 0; i < 200000; i++){
//					System.out.println(i);
				}
				System.out.println(gobi.getName() + " greift an!");
				battlestate = Battlestate.LeonTurn;
			break;
			
		}
				
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
		cam.update();
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
		stage.dispose();
		batch.dispose();
		font.dispose();
		skin.dispose();
		butwin.dispose();
//		battletheme.dispose();
	}
	
}
