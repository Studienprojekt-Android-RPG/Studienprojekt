package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class ItemDialog
{
	private Slot slot;
	private Skin skin;
	
	Testmap game;
	
	BitmapFont font;
	LabelStyle labstyle = new LabelStyle();
	Label label;
	Skin skinDialog;
	TextureAtlas butwin;
	
	Dialog dialog;
	
	public ItemDialog(Slot slot, Skin skin)
	{		
		if(slot.getItem().getConsumable()) {
			skinDialog = new Skin();
			butwin = new TextureAtlas("butwin.atlas");
			skin.addRegions(butwin);
			skin.add("default", labstyle);
			font = new BitmapFont(Gdx.files.internal("default.fnt"));
			labstyle.font = font;
			label = new Label("Use Item?", labstyle);
			
			dialog = new Dialog(slot.getItem().toString(), skin, "dialog")
			{
				public void result(Object obj)
				{
					if(obj.equals(true))
					{
						Gamescreen.game.inventoryscreen.inventoryActor.inv.consume(slot.getItem());
						slot.take(1);
						Gamescreen.player.clearInventorySlots();
						Gamescreen.player.saveInventory();
					}
				}
			};
			
			dialog.text(label);
			dialog.button("Use", true);
			dialog.button("Cancel", false);
			dialog.setPosition(300, 200);
			dialog.sizeBy(100, 100);
			dialog.pack();
		}
		if(!slot.getItem().getConsumable()) {
			skinDialog = new Skin();
			butwin = new TextureAtlas("butwin.atlas");
			skin.addRegions(butwin);
			skin.add("default", labstyle);
			font = new BitmapFont(Gdx.files.internal("default.fnt"));
			labstyle.font = font;
			label = new Label("Equip Item?", labstyle);
			
			dialog = new Dialog(slot.getItem().toString(), skin, "dialog")
			{
				public void result(Object obj)
				{
					if(obj.equals(true))
					{
						Gamescreen.game.inventoryscreen.equipItem(slot.getItem());
						slot.take(1);
						Gamescreen.player.clearInventorySlots();
						Gamescreen.player.saveInventory();
					}
				}
			};
			
			dialog.text(label);
			dialog.button("Equip", true);
			dialog.button("Cancel", false);
			dialog.setPosition(300, 200);
			dialog.sizeBy(100, 100);
			dialog.pack();
		}
		
		dialog.setVisible(true);
		System.out.println(slot.toString() + " clicked");
		InventoryScreen.stage.addActor(dialog);
	}
}
