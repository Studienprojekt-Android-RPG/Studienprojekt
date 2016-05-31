package de.test.game;


import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
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
	static Monster gegner;
	
	SpriteBatch batch;
	TextureAtlas enemies;
	TextureRegion enemy;
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
	LabelStyle labstyle = new LabelStyle();
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
	
	Dialog dialog;
	Label win;
	
	@SuppressWarnings("static-access")
	public Battlescreen(Testmap battle){
		
		this.battle = battle;

	}
	
	@Override
	public void show() {
		gegner = enemySelect();
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
		labstyle.font = font;
		skin.add("default", labstyle);
		skin.add("default", ws);
		skin.add("default", buttonstyle);
		skin.add("dialog", ws);
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
		
		win = new Label("You WON\n" + "5000k GOLD\n" + "2 EXP", labstyle);
		
		dialog = new Dialog("", skin, "dialog") {
			public void result(Object obj) {
				if(obj.equals(true)){
					battle.setScreen(battle.getScreenType(ScreenType.Gamescreen));
				}
		    }
		};
		dialog.text(win);
		dialog.button("Heap Heap Hurra", true); //sends "true" as the result
		dialog.setVisible(false);
		dialog.setPosition(300, 200);
		dialog.sizeBy(100, 100);

		ang.setVisible(true);
		sel.setVisible(true);
		
		batch = new SpriteBatch();
		
		stage = new Stage(viewport);
		stage.addActor(ang);
		stage.addActor(sel);
		stage.addActor(battlemenu);
		stage.addActor(skills);
		stage.addActor(dialog);
		
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
	    
	    barEnemy = new ProgressBar(0, Battlescreen.gegner.maxHP, 1, false, barStyle);
	    barEnemy.setSize(100, 250);
	    barEnemy.setValue(Battlescreen.gegner.curHP);
	    barEnemy.setPosition(350, -50);

	    stage.addActor(barPlayer);
	    stage.addActor(barEnemy);
		Gdx.input.setInputProcessor(stage);
		
		ang.setPosition(140, 40);
		sel.setPosition(15, 40);
		battlemenu.setPosition(0, 480 - battlemenu.getHeight());
		skills.setPosition(0, 480 - skills.getHeight());
		
//		test = new Texture(Gdx.files.internal("DivineShinael.png"));
		enemy = gegner.texture;
		enemy1 = new Sprite(enemy);
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
		batch.draw(enemy, player.getPosition().x - 400, player.getPosition().y);
		batch.end();
		stage.act();
		stage.draw();
		
		barPlayer.setValue(player.getCurrentHP());
		barEnemy.setValue(gegner.getCurrentHP());
		
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
				if(Fighter.turnSpeed(gegner) < Fighter.turnSpeed(Gamescreen.player)){
					battlestate = Battlestate.LeonTurn;
				}
				else{
					battlestate = Battlestate.EnemyTurn;
				}
			break;
		
			case LeonTurn:
//				System.out.println(player.getName() + " ist dran");
				
				battlemenu.setTouchable(Touchable.enabled);
				
				if(Battlemenu.hasClicked){
					Battlemenu.hasClicked = false;
					if(gegner.curHP > 0){
						battlestate = Battlestate.EnemyTurn;
					}
					else{
						battlestate = Battlestate.BattleOver;
					}
				}
				
			break;
			
			case EnemyTurn:
				System.out.println(gegner.getName() + " ist dran");
				battlemenu.setTouchable(Touchable.disabled);
				
				Fighter.attack(gegner, player);
				System.out.println(gegner.getName() + " greift an!");
				if(player.curHP <= 0){
					battlestate = Battlestate.GameOver;
				}
				else{
					battlestate = Battlestate.LeonTurn;
				}
			break;
			
			case BattleOver:
				battlemenu.setTouchable(Touchable.disabled);
				player.saveBattle();
				if(anim == false){
					dialog.setVisible(true);
				}
					
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
	
	public Monster enemySelect(){
		Random gen = new Random();
		int battleGen = gen.nextInt(3);
		Monster enemy;
		
		switch(battleGen){
			case 0:
				enemy = new Goblin();
			break;
			
			case 1:
				enemy = new Saubaer();
			break;
			
			case 2:
				enemy = new Daemonenhund();
			break;
			
			default:
				enemy = new Goblin();
			break;
		}
		System.out.println("Gegner: " + battleGen);
		return enemy;
	}
	
}
