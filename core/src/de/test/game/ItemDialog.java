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
	
	public ItemDialog(final Slot slot, Skin skin, String dialogLabel, String buttonText)
	{		
		if(slot.getItem().getConsumable()) {
			skinDialog = new Skin();
			butwin = new TextureAtlas("butwin.atlas");
			skin.addRegions(butwin);
			skin.add("default", labstyle);
			font = new BitmapFont(Gdx.files.internal("default.fnt"));
			labstyle.font = font;
			label = new Label(dialogLabel, labstyle);
			
			dialog = new Dialog(slot.getItem().toString(), skin, "dialog")
			{
				public void result(Object obj)
				{
					if(obj.equals(true))
					{
						InventoryScreen.inventoryActor.inv.consume(slot.getItem());
						slot.take(1);
						Gamescreen.player.clearInventorySlots();
						Gamescreen.player.clearEquipmentSlots();
						Gamescreen.player.saveInventory();
						Gamescreen.player.saveEquipment();
					}
				}
			};
			
			dialog.text(label);
			dialog.button(buttonText, true);
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
						Item item = Gamescreen.game.inventoryscreen.equipment.equip.equip(slot.getItem(), 1);
						InventoryScreen.inventoryActor.inv.store(item, 1);
						slot.take(1);
						Gamescreen.player.clearInventorySlots();
						Gamescreen.player.clearEquipmentSlots();
						Gamescreen.player.saveInventory();
						Gamescreen.player.saveEquipment();
						Gamescreen.player.equippedItems();
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

	public Skin getSkin() {
		return skin;
	}

	public void setSkin(Skin skin) {
		this.skin = skin;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}
}
