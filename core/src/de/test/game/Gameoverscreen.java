package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.test.game.Testmap.ScreenType;

public class Gameoverscreen implements Screen{
	
	Testmap game;
	SpriteBatch batch;
	Texture gmovr = new Texture(Gdx.files.internal("GameOver.png"));
	OrthographicCamera cam;
	Stage stage;
	Viewport viewport;
	
	TextureAtlas butwin;
	BitmapFont font;
	Table table = new Table();
	TextButton cont;
	TextButtonStyle button = new TextButtonStyle();
	
	public Gameoverscreen(Testmap game){
		
		this.game = game;
		

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		cam = new OrthographicCamera();
		viewport = new ExtendViewport(800, 480, cam);
		cam.setToOrtho(false);
		
		butwin = new TextureAtlas("butwin.atlas");
		font = new BitmapFont(Gdx.files.internal("default.fnt"));
		Skin skin = new Skin();
		skin.addRegions(butwin);
		button.down = skin.getDrawable("start");
		button.up = skin.getDrawable("start");
		button.font = font;
		button.fontColor.rgb565(255, 0, 0);
		skin.add("buttonSkin", button);
		
		cont = new TextButton("Continue?", skin, "buttonSkin");
		
		table.setPosition(300, 120);
		
		table.add(cont).width(200).align(Align.center);
		table.pack();
		
		table.debugCellColor.set(0, 0, 0, 0);
		table.debugTableColor.set(0, 0, 0, 0);
		table.debugActorColor.set(0, 0, 0, 0);
		
		cont.addListener(new ClickListener()
		{
			public void clicked(InputEvent e, float x, float y)
			{
				System.out.println("Continue clicked.");
				game.setScreen(game.getScreenType(ScreenType.StartMenu));
				dispose();
				game.render();
				
			}
		});
		
		stage = new Stage(viewport);
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Testmap.setHorst("go");
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(cam.combined);
	    cam.update();
	    batch.begin();
		batch.draw(gmovr,0, 0, 920, 480);
		batch.end();
		stage.act();
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
		table.clear();
		stage.dispose();
	}

}
