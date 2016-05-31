package de.test.game;

import java.io.IOException;

import javax.management.AttributeNotFoundException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.DragAndDrop;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.test.game.Testmap.ScreenType;

public class InventoryScreen implements Screen {

	public InventoryActor inventoryActor;

	public static Stage stage;
	Testmap inv;

	Viewport viewport;
	
	public InventoryScreen(Testmap Inventory){
		this.inv = Inventory;
		
	}
	TextureAtlas butwin;
	ImageButton xbutt;
	ImageButtonStyle xb = new ImageButtonStyle();
	
	@Override
	public void show() {
		viewport = new ExtendViewport(800, 480);
		
		stage = new Stage(viewport);
		Gdx.input.setInputProcessor(stage);
		butwin = new TextureAtlas("butwin.atlas");
		Skin butwi = new Skin();
		butwi.addRegions(butwin);
		xb.down = butwi.getDrawable("xbutt");
		xb.up = butwi.getDrawable("xbutt");
		butwi.add("xbu",xb);
		Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
		DragAndDrop dragAndDrop = new DragAndDrop();
		inventoryActor = new InventoryActor(new Inventory(), dragAndDrop, skin);
		stage.addActor(inventoryActor);
		
		xbutt = new ImageButton(butwi, "xbu");
		xbutt.setWidth(50);
		xbutt.setHeight(50);
		xbutt.setVisible(true);
		xbutt.isTouchable();
		xbutt.setPosition(0, 0);
		stage.addActor(xbutt);
//		this.render(0);
		xbutt.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Inventar geschlossen");
	            try {
					Gamescreen.player.savePlayer(Gamescreen.player);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            Gamescreen.player.saveInventory();
	            inv.setScreen(inv.getScreenType(ScreenType.Gamescreen));
	        }
	    });
		Gamescreen.player.readInventory();
		if(Gamescreen.screen == 1){
			Gamescreen.screen = 0;
			inv.setScreen(inv.getScreenType(ScreenType.Gamescreen));
			
		}
	}

	@Override
	public void resume() {
		LibgdxUtils.assets.finishLoading();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 0f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		if (Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)) {
			inventoryActor.setVisible(true);
		}
		
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void pause() {
		// NOOP
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
		dispose();
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

}