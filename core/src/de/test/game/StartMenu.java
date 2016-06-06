/**
 * 
 */
package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.test.game.Testmap.ScreenType;

/**
 * @author User
 *
 */
public class StartMenu implements Screen
{
	Testmap game;
	Gamescreen gamescreen;
	
	Viewport viewport;
	public Stage stage;
	SpriteBatch batch = new SpriteBatch();
	
	TextureAtlas butwin;
	BitmapFont font;
	Table table = new Table();
	TextButton newGame;
	TextButton loadGame;
	TextButton options;
	TextButton exitGame;
	TextButtonStyle button = new TextButtonStyle();
	
	public StartMenu(Testmap game)
	{
		this.game = game;
	}

	@Override
	public void show()
	{
		Testmap.setHorst("sm");
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
		
		table.setPosition(300, 120);
		
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
				NewGameDialog dialog = new NewGameDialog();
				
				dispose();
			}
		});
		
		loadGame.addListener(new ClickListener()
		{
			public void clicked(InputEvent e, float x, float y)
			{
				System.out.println("LoadGame clicked.");
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
	}

	@Override
	public void render(float delta)
	{		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		/*batch.setProjectionMatrix(cam.combined);
		batch.begin();
		table.draw(batch, 1);
		batch.end();*/
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height)
	{
		viewport.update(width, height);
		
	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose()
	{
		table.clear();
		stage.dispose();
		
	}
}
