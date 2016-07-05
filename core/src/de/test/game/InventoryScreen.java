package de.test.game;

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
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import de.test.game.Testmap.ScreenType;

public class InventoryScreen implements Screen {

	public static InventoryActor inventoryActor;
	public EquipmentActor equipment;

	public static Stage stage;
	Testmap game;

	Viewport viewport;

	TextureAtlas butwin;
	ImageButton xbutt;
	ImageButtonStyle xb = new ImageButtonStyle();
	
	public InventoryScreen(Testmap Inventory){
		this.game = Inventory;
		
	}
	
	
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
		inventoryActor = new InventoryActor(new Inventory(64), "Inventar", skin, 8, 500, 500, "Use Item?", "Use");
		equipment = new EquipmentActor(new Equipment(5), "Equipment", skin, 1, 0, 500, "Equip Item?", "Equip");
		stage.addActor(inventoryActor);
		stage.addActor(equipment);
				
		xbutt = new ImageButton(butwi, "xbu");
		xbutt.setWidth(50);
		xbutt.setHeight(50);
		xbutt.setVisible(true);
		xbutt.isTouchable();
		xbutt.setPosition(0, 0);
		stage.addActor(xbutt);

		Gamescreen.player.readInventory();
		Gamescreen.player.readEquipment();
		
		xbutt.addListener(new ClickListener() {
	        public void clicked(InputEvent e, float x, float y) {
	            System.out.println("Inventar geschlossen");
	            Gamescreen.player.saveInventory();
	            Gamescreen.player.saveEquipment();
	            Gamescreen.player.saveBattle();
	            game.setScreen(game.getScreenType(ScreenType.Gamescreen));
	        }
	    });
		
		/*// create some random items
				for (Slot slot : inventoryActor.inv.getSlots()) {
					//slot.add(Item.REICHTUMSELIXIER, 1);
					slot.add(Item.values()[MathUtils.random(0, Item.values().length - 1)], 1);
				}

				// create a few random empty slots
				for (int i = 0; i < 3; i++) {
					Slot randomSlot = inventoryActor.inv.getSlots().get(MathUtils.random(0, inventoryActor.inv.getSlots().size - 1));
					randomSlot.take(randomSlot.getAmount());
				}*/
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
			equipment.setVisible(true);
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