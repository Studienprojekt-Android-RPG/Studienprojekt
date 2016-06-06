package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import de.test.game.Testmap.ScreenType;

public class NewGameDialog
{
	Testmap game;
	
	Dialog dialog;
	
	public NewGameDialog()
	{
		Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
		BitmapFont font = new BitmapFont(Gdx.files.internal("default.fnt")); 
		
		LabelStyle labstyle = new LabelStyle();
		labstyle.font = font;
		Label label = new Label("Name of new Game:", labstyle);
		
		TextField textfield = new TextField("TextField", skin);
		textfield.setVisible(true);
		
		dialog = new Dialog("", skin, "dialog")
		{
			public void result(Object obj)
			{
				if(obj.equals(true))
				{
					game.setScreen(game.getScreenType(ScreenType.Gamescreen));
					game.render();
				}
				else
				{
					game.setScreen(game.getScreenType(ScreenType.StartMenu));
				}
			}
		};
		
		dialog.text(label);
		dialog.addActor(textfield);
		dialog.button("Create", true);
		dialog.button("Cancel", false);
		dialog.setPosition(300, 200);
		dialog.sizeBy(100, 100);
		dialog.pack();
		
		dialog.setVisible(true);
		game.startMenu.stage.addActor(dialog);
	}
}
