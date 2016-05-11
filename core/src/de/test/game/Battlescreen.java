package de.test.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.test.game.Testmap.ScreenType;

public class Battlescreen implements Screen {
	
	enum Battlestate{firstStrike, LeonTurn, EnemyTurn, BattleOver, GameOver};
	static Battlestate battlestate;
	static Goblin gobi;
	
	SpriteBatch batch;
	TextureAtlas enemies;
	Texture test;
	Sprite enemy1;
	Sprite enemy2 = new Sprite();
	Sprite enemy3 = new Sprite();
	static Player player = Gamescreen.player;
	Vector2 playerPosition;
	RectangleMapObject rect1;
	RectangleMapObject rect2;
	RectangleMapObject rect3;
	BitmapFont font;
	Skin skin;
	Skin skin2;
	TextureAtlas butwin;
	TextureAtlas baratlas;
	TextButtonStyle buttonstyle = new TextButtonStyle();
	WindowStyle ws = new WindowStyle();
	ImageButtonStyle angriff = new ImageButtonStyle();
	ImageButtonStyle select = new ImageButtonStyle();
	ImageButton ang;
	ImageButton sel;
	static boolean anim = false;
	float stateTime;
	ProgressBar barPlayer;
	ProgressBar barEnemy;
	ProgressBarStyle barStyle;
	Drawable textureBar;
	
	static Battlemenu battlemenu;
	static Skills skills;
	
	OrthographicCamera cam;
	Viewport viewport;
	
	Stage stage;
	static Testmap battle;
	
	public Battlescreen(Testmap battle){
		
		this.battle = battle;

	}
	
	@Override
	public void show() {
		gobi = new Goblin(7, 50, 50, 15, 7, "Gobi");
		Testmap.setHorst("bs");
		player.currentFrame = player.f1.getKeyFrame(0);
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
		skills = new Skills(skin);
		
		cam = new OrthographicCamera();
		viewport = new ExtendViewport(800, 480, cam);
		cam.setToOrtho(false);
		
		battlemenu.setVisible(true);
		battlemenu.setKeepWithinStage(false);
		battlemenu.setMovable(false);
		
		skills.setVisible(false);
		skills.setKeepWithinStage(false);
		skills.setMovable(false);
		
		ang.setVisible(true);
		sel.setVisible(true);
		
		batch = new SpriteBatch();
		
		stage = new Stage(viewport);
		stage.addActor(ang);
		stage.addActor(sel);
		stage.addActor(battlemenu);
		stage.addActor(skills);
		
		skin2 = new Skin();
		baratlas = new TextureAtlas("bar.atlas");
		skin2.addRegions(baratlas);
		
		textureBar = new TextureRegionDrawable(new TextureRegion(skin2.getRegion("barknob")));
		barStyle = new ProgressBarStyle(skin2.newDrawable("barbackground"), textureBar);
		barStyle.knobBefore = barStyle.knob;
		
		barPlayer = new ProgressBar(0, Gamescreen.player.maxHP, 1, false, barStyle);
	    barPlayer.setSize(100, 250);
	    barPlayer.setValue(Gamescreen.player.curHP);
	    barPlayer.setPosition(690, -50);
	    
	    barEnemy = new ProgressBar(0, Battlescreen.gobi.maxHP, 1, false, barStyle);
	    barEnemy.setSize(100, 250);
	    barEnemy.setValue(Battlescreen.gobi.curHP);
	    barEnemy.setPosition(350, -50);

	    stage.addActor(barPlayer);
	    stage.addActor(barEnemy);
		Gdx.input.setInputProcessor(stage);
		
		ang.setPosition(140, 40);
		sel.setPosition(15, 40);
		battlemenu.setPosition(0, 480 - battlemenu.getHeight());
		skills.setPosition(0, 480 - skills.getHeight());
		
		test = new Texture(Gdx.files.internal("DivineShinael.png"));
		enemy1 = new Sprite(test);
		stateTime = 0f;
		
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
		
		barPlayer.setValue(player.getCurrentHP());
		barEnemy.setValue(gobi.getCurrentHP());
		
		if(anim){
			if(stateTime <= 0.8f){
	        	stateTime += Gdx.graphics.getDeltaTime();
	        	player.currentFrame = player.f1.getKeyFrame(stateTime);
	        }
			else{
				stateTime = 0;
				anim = false;
				player.currentFrame = player.f1.getKeyFrame(stateTime);
			}
			
		}
		
		
		
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
					if(gobi.curHP > 0){
						battlestate = Battlestate.EnemyTurn;
					}
					else{
						battlestate = Battlestate.BattleOver;
					}
				}
				
			break;
			
			case EnemyTurn:
				System.out.println(gobi.getName() + " ist dran");
				battlemenu.setTouchable(Touchable.disabled);
				for (int i = 0; i < 2000000; i++){
//					System.out.println(i);
				}
				Fighter.attack(gobi, player);
				System.out.println(gobi.getName() + " greift an!");
				if(player.curHP <= 0){
					battlestate = Battlestate.GameOver;
				}
				else{
					battlestate = Battlestate.LeonTurn;
				}
			break;
			
			case BattleOver:
				battle.setScreen(battle.getScreenType(ScreenType.Gamescreen));
			break;
			
			case GameOver:
				
				
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
	}
	
}
