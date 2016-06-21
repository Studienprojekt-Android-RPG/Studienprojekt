/**
 * 
 */
package de.test.game;

import java.io.File;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
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
	
	String userName = System.getProperty("user.name");
	//String userName = "Michel";
	
	Dialog dialog;
	
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

		Skin dialogSkin = new Skin(Gdx.files.internal("uiskin.json"));
		BitmapFont font = new BitmapFont(Gdx.files.internal("default.fnt")); 
		
		LabelStyle labstyle = new LabelStyle();
		labstyle.font = font;
		Label label = new Label("Number of maximum Saves reached\nPlease delete a old game or load another game.", labstyle);
		
		dialog = new Dialog("Warning", dialogSkin, "dialog")
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
		dialog.setPosition(150, 200);
		dialog.setSize(200, 200);
		dialog.pack();
		dialog.setVisible(false);
		
		newGame.addListener(new ClickListener()
		{
			public void clicked(InputEvent e, float x, float y)
			{
				System.out.println("StartGame clicked.");
				
				int i = 0;
				if(Gdx.app.getType() == ApplicationType.Desktop)
				{
					File folder = new File("C:/Users/" + userName + "/.prefs/");
					System.out.println(userName);
					File[] listOfFiles = folder.listFiles();
					
					if(listOfFiles != null)
					{
						for (File file : listOfFiles) 
						{
						    if (file.isFile()) 
						    {
						        i = Character.getNumericValue(file.getName().charAt(3));
						        i++;
						    }
						}
					}
					else
					{
						i = 0;
					}
					
					if(i <= 9)
					{
						game.setSaveFile(new File("C:/Users/" + userName + "/.prefs/haw" + i));
						game.setScreen(game.getScreenType(ScreenType.Gamescreen));
						game.render();
						table.clear();
					}
					else
					{
						dialog.setVisible(true);
						table.clear();
					}
				}
				else
				{
					File folder = new File("/data/data/de.test.game/shared_prefs/");
					File[] listOfFiles = folder.listFiles();

					if(listOfFiles != null)
					{
						for (File file : listOfFiles) 
						{
						    if (file.isFile()) 
						    {
						        i = Character.getNumericValue(file.getName().charAt(3));
						        i++;
						    }
						}
					}
					else
					{
						i = 0;
					}
					
					if(i <= 9)
					{
						game.setSaveFile(new File("/data/data/de.test.game/shared_prefs/haw" + i + ".xml"));	
						game.setScreen(game.getScreenType(ScreenType.Gamescreen));
						game.render();
						table.clear();
					}
					else
					{
						dialog.setVisible(true);
						table.clear();
					}
				}
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
		stage.addActor(dialog);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta)
	{		
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
