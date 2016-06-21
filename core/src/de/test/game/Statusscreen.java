package de.test.game;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Window.WindowStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.test.game.Testmap.ScreenType;

public class Statusscreen implements Screen {
	
	SpriteBatch batch;
	static Player player = Gamescreen.player;
	BitmapFont font;
	Skin skin;
	TextureAtlas butwin, avatar;
	TextButtonStyle buttonstyle = new TextButtonStyle();
	WindowStyle ws = new WindowStyle();
	OrthographicCamera cam;
	Viewport viewport;
	
	Label name;
	Label hp;
	Label lvl;
	Label sp;
	Label exp;
	Label money;
	
	Label stats;
	Label atk;
	Label satk;
	Label def;
	Label sdef;
	Label speed;
	
	Label gear;
	
	TextureRegion json;
	
	ImageButton xbutt;
	ImageButtonStyle xb = new ImageButtonStyle();
	
	LabelStyle labstyle = new LabelStyle();
	Table tablename = new Table();
	Table tablestats = new Table();
	Table tablegear = new Table();
	
	Stage stage;
	Testmap status;
	
	public Statusscreen(Testmap status){
		
		this.status = status;

	}
	
	@Override
	public void show() {
		skin = new Skin();
		font = new BitmapFont(Gdx.files.internal("default.fnt"));
		butwin = new TextureAtlas("butwin.atlas");
		avatar = new TextureAtlas("avatare.atlas");
		skin.addRegions(butwin);
		skin.addRegions(avatar);
		ws.background = skin.getDrawable("default-window");
		ws.titleFont = font;
		
		labstyle.font = font;
		
		skin.add("label", labstyle);
		skin.add("default", ws);
		
		xb.down = skin.getDrawable("xbutt");
		xb.up = skin.getDrawable("xbutt");
		skin.add("xbu",xb);
		
		xbutt = new ImageButton(skin, "xbu");
		xbutt.setWidth(50);
		xbutt.setHeight(50);
		xbutt.setVisible(true);
		xbutt.isTouchable();
		xbutt.setPosition(0, 0);
		
		cam = new OrthographicCamera();
		viewport = new ExtendViewport(800, 480, cam);
		cam.setToOrtho(false);
		
		batch = new SpriteBatch();
		
		json = new TextureRegion(avatar.findRegion("LeonAvatar"));
		
		name = new Label(Gamescreen.player.getName(), labstyle);
		hp = new Label("HP: " + Gamescreen.player.getCurrentHP() + "/" + Gamescreen.player.getMaxHP(), labstyle);
		lvl = new Label("Lvl: " + Fighter.getLevel(Gamescreen.player), labstyle);	
		sp = new Label("SP: " + Fighter.getCurSP(Gamescreen.player) + "/" + Fighter.getMaxSP(Gamescreen.player) , labstyle);
		exp = new Label("NextLvl: " + Fighter.getExp(Gamescreen.player), labstyle);
		money = new Label("Geld: " + Fighter.getMoney(Gamescreen.player), labstyle);
		
		stats = new Label("Statuswerte: ", labstyle);
		atk = new Label("Angr: " + Fighter.getAttack(Gamescreen.player), labstyle);
		satk = new Label("SpezAngr: " + Fighter.getSpAttack(Gamescreen.player), labstyle);
		def = new Label("Vert: " + Fighter.getDefense(Gamescreen.player), labstyle);
		sdef = new Label("SpezVert: " + Fighter.getSpDefense(Gamescreen.player), labstyle);
		speed = new Label("Init: " + Fighter.getSpeed(Gamescreen.player), labstyle);
		
		gear = new Label("Ausrüstung: ", labstyle);
		
		tablename.add(name).width(200).height(50).align(Align.center).padLeft(25);
		tablename.row();
		tablename.add(hp).width(200).height(50).align(Align.center).padLeft(25);
		tablename.add(lvl).width(200).height(50).align(Align.center).padLeft(25);
		tablename.row();
		tablename.add(sp).width(200).height(50).align(Align.center).padLeft(25);
		tablename.add(exp).width(200).height(50).align(Align.center).padLeft(25);
		tablename.row();
		tablename.add(money).width(200).height(50).align(Align.center).padLeft(25);
		tablename.pack();
		tablename.setBackground(skin.getDrawable("default-window"));
		tablename.setPosition(20, 480 - tablename.getHeight());
		
		tablestats.add(stats).width(200).height(50).align(Align.center).padLeft(25);
		tablestats.row();
		tablestats.add(atk).width(200).height(50).align(Align.center).padLeft(25);
		tablestats.add(satk).width(200).height(50).align(Align.center).padLeft(25);
		tablestats.row();
		tablestats.add(def).width(200).height(50).align(Align.center).padLeft(25);
		tablestats.add(sdef).width(200).height(50).align(Align.center).padLeft(25);
		tablestats.row();
		tablestats.add(speed).width(200).height(50).align(Align.center).padLeft(25);
		tablestats.pack();
		tablestats.setBackground(skin.getDrawable("default-window"));
		tablestats.setPosition(20, tablename.getY() - tablestats.getHeight() - 20);
		
		tablegear.add(gear).width(200).height(50).align(Align.center).padLeft(25);
		tablegear.row();
		tablegear.pack();
		tablegear.setBackground(skin.getDrawable("default-window"));
		tablegear.setPosition(600, tablename.getY() - tablegear.getHeight() - 20);
				
		stage = new Stage(viewport);
		stage.addActor(tablename);
		stage.addActor(tablestats);
		stage.addActor(tablegear);
		stage.addActor(xbutt);
		Gdx.input.setInputProcessor(stage);
		
		xbutt.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Inventar geschlossen");
	            try {
					Gamescreen.player.savePlayer(Gamescreen.player);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            status.setScreen(status.getScreenType(ScreenType.Gamescreen));
	            dispose();
	        }
	    });
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		batch.setProjectionMatrix(cam.combined);
	    cam.update();
		batch.begin();
		batch.draw(json, 600, 480 - tablename.getHeight(), 100, 100);
		batch.end();
		stage.act();
		stage.draw();
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
		tablename.clear();
		tablestats.clear();
		tablegear.clear();
		stage.dispose();
		batch.dispose();
		font.dispose();
		skin.dispose();
		butwin.dispose();
	}

}
