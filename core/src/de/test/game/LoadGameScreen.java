package de.test.game;

import java.io.File;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
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

public class LoadGameScreen implements Screen {
	public static Stage stage;
	Testmap game;

	Viewport viewport;
	SpriteBatch batch = new SpriteBatch();
	
	TextureAtlas butwin;
	BitmapFont font;
	Table table = new Table();
	Dialog dialog;
	TextButtonStyle button = new TextButtonStyle();

	ImageButton xButton;
	ImageButtonStyle xButtonStyle = new ImageButtonStyle();
	
	String userName = System.getProperty("user.name");
	//String userName = "Michel";
	File folder;
	File[] listOfFiles;
	
	public LoadGameScreen(Testmap game)
	{
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
		
		if(Gdx.app.getType() == ApplicationType.Desktop)
		{
			folder = new File("C:/Users/" + userName + "/.prefs/");
			listOfFiles = folder.listFiles();
		}
		else
		{
			folder = new File("/data/data/de.test.game/shared_prefs/");
			listOfFiles = folder.listFiles();
		}
		TextButton[] buttons = new TextButton [10];
		
		table.setPosition(300, 80);
		
		for(int i = 0; i<=9; i++)
		{
			buttons[i] = new TextButton("", skin, "buttonSkin");
			buttons[i].setName(Integer.toString(i));
			
			try 
			{
				Preferences prefs = Gdx.app.getPreferences(listOfFiles[i].getName());
				String time = prefs.getString("saveTime");
				buttons[i].setText("Save" + i + ": " + time);
			} 
			catch (ArrayIndexOutOfBoundsException e) 
			{
				buttons[i].setText("Save" + i + ": empty");
				buttons[i].setTouchable(Touchable.disabled);
			}
			catch (NullPointerException e)
			{
				buttons[i].setText("Save" + i + ": empty");
				buttons[i].setTouchable(Touchable.disabled);
			}
			
			table.add(buttons[i]).width(200).align(Align.center);
			table.row();
			
			final int fI = i;
			buttons[i].addListener(new ClickListener()
			{
				public void clicked(InputEvent e, float x, float y)
				{
					System.out.println(buttons[fI].getName() + " clicked.");
					game.setSaveFile(listOfFiles[fI]);
					
					Skin dialogSkin = new Skin(Gdx.files.internal("uiskin.json"));
					BitmapFont font = new BitmapFont(Gdx.files.internal("default.fnt")); 
					
					LabelStyle labstyle = new LabelStyle();
					labstyle.font = font;
					Label label = new Label(buttons[fI].getText(), labstyle);
					
					dialog = new Dialog("Options for saved Game", dialogSkin, "dialog")
					{
						public void result(Object obj)
						{
							if(obj.equals(1))
							{
								game.setScreen(game.getScreenType(ScreenType.Gamescreen));
								game.render();
							}
							else if(obj.equals(-1))
							{
								deleteFile(fI);
								game.setScreen(game.getScreenType(ScreenType.LoadGameScreen));
							}
						}
					};
					
					dialog.button("Load", 1);
					dialog.button("Delete", -1);
					dialog.button("Cancel", 0);
					dialog.setSize(300, 300);
					
					dialog.text(label);
					dialog.pack();
					dialog.setPosition(250, 300);
					dialog.setVisible(true);
					
					stage.addActor(dialog);
				}
			});
		}
		table.pack();
		
		Table.debugCellColor.set(0, 0, 0, 0);
		Table.debugTableColor.set(0, 0, 0, 0);
		Table.debugActorColor.set(0, 0, 0, 0);
		
		stage.addActor(table);
		Gdx.input.setInputProcessor(stage);
		
		Skin butwi = new Skin();
		butwi.addRegions(butwin);
		xButtonStyle.down = butwi.getDrawable("xbutt");
		xButtonStyle.up = butwi.getDrawable("xbutt");
		butwi.add("xbu",xButtonStyle);
				
		xButton = new ImageButton(butwi, "xbu");
		xButton.setWidth(50);
		xButton.setHeight(50);
		xButton.setVisible(true);
		xButton.isTouchable();
		xButton.setPosition(0, 0);
		stage.addActor(xButton);
		
		xButton.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("LoadGameScreen closed");

	            game.setScreen(game.getScreenType(ScreenType.StartMenu));
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
		table.clear();
		stage.dispose();
	}
	
	void deleteFile(int pI)
	{
		File delFile;
		if(Gdx.app.getType() == ApplicationType.Desktop)
		{
			delFile = new File("C:/Users/" + userName + "/.prefs/haw" + pI);
		}
		else
		{
			delFile = new File("/data/data/de.test.game/shared_prefs/haw" + pI);
		}
		if(delFile != null)
		{
			delFile.delete();
		}
	}
}