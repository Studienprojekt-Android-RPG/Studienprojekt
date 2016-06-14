package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.test.game.Testmap.ScreenType;

public class LoadGameScreen implements Screen {
	public static Stage stage;
	Testmap game;

	Viewport viewport;
	SpriteBatch batch = new SpriteBatch();
	
	TextureAtlas butwin;
	BitmapFont font;
	Table table = new Table();
	TextButton newGame;
	TextButton loadGame;
	TextButton options;
	TextButton exitGame;
	TextButtonStyle button = new TextButtonStyle();

	ImageButton xbutt;
	ImageButtonStyle xb = new ImageButtonStyle();
	
	public LoadGameScreen(Testmap game){
		this.game = game;
		
	}
	
	
	@Override
	public void show() {
		viewport = new ExtendViewport(800, 480);
		stage = new Stage(viewport);
		Gdx.input.setInputProcessor(stage);
		
		butwin = new TextureAtlas("butwin.atlas");
		font = new BitmapFont(Gdx.files.internal("default.fnt"));
		Skin skin = new Skin();
		skin.addRegions(butwin);
		button.down = skin.getDrawable("start");
		button.up = skin.getDrawable("start");
		button.font = font;
		Color.rgb565(255, 0, 0);
		skin.add("buttonSkin", button);
		
		newGame = new TextButton("Neues Spiel", skin, "buttonSkin");
		loadGame = new TextButton("Spiel laden", skin, "buttonSkin");
		options = new TextButton("Optionen", skin, "buttonSkin");
		exitGame = new TextButton("Spiel verlassen", skin, "buttonSkin");
		
		table.setPosition(300, 240);
		
		table.add(newGame).width(200).align(Align.center);
		table.row();
		table.add(loadGame);
		table.row();
		table.add(options);
		table.row();
		table.add(exitGame);
		table.pack();
		
		Table.debugCellColor.set(0, 0, 0, 0);
		Table.debugTableColor.set(0, 0, 0, 0);
		Table.debugActorColor.set(0, 0, 0, 0);

		
		newGame.addListener(new ClickListener()
		{
			public void clicked(InputEvent e, float x, float y)
			{
				System.out.println("StartGame clicked.");
				dispose();
			}
		});
		
		loadGame.addListener(new ClickListener()
		{
			public void clicked(InputEvent e, float x, float y)
			{
				game.setScreen(game.getScreenType(ScreenType.LoadGameScreen));
				System.out.println("LoadGame clicked.");
				dispose();
			}
		});
		
		options.addListener(new ClickListener()
		{
			public void clicked(InputEvent e, float x, float y)
			{
				System.out.println("Options clicked.");
			}
		});
		
		exitGame.addListener(new ClickListener()
		{
			public void clicked(InputEvent e, float x, float y)
			{
				System.out.println("exitGame clicked.");
				Gdx.app.exit();
			}
		});
		
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
		
		Skin butwi = new Skin();
		butwi.addRegions(butwin);
		xb.down = butwi.getDrawable("xbutt");
		xb.up = butwi.getDrawable("xbutt");
		butwi.add("xbu",xb);
				
		xbutt = new ImageButton(butwi, "xbu");
		xbutt.setWidth(50);
		xbutt.setHeight(50);
		xbutt.setVisible(true);
		xbutt.isTouchable();
		xbutt.setPosition(0, 0);
		stage.addActor(xbutt);
		
		xbutt.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("LoadGameScreen closed");

	            game.setScreen(game.getScreenType(ScreenType.StartMenu));
	            dispose();
	        }
	    });
	}

	@Override
	public void resume() {

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void pause() {

	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void dispose() {
		stage.dispose();
	}
}