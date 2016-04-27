package de.test.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class StartScreen implements Screen
{
	static Game game;
	//Table table = new Table();

	@Override
	public void show()
	{
		//table.setBounds(10, 100, 50, 50);
		
		//table.add("New Game");
		
		/*table.addListener(new ClickListener() 
		{
			public void clicked(InputEvent e, float x, float y)
			{
				game.setScreen(new Gamescreen(Testmap.gameT));
			}
		});*/
	}

	@Override
	public void render(float delta)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub

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
		// TODO Auto-generated method stub

	}

}