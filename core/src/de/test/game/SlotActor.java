package de.test.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SlotActor extends ImageButton implements SlotListener {

	private Slot slot;
	private Skin skin;
	
	Testmap game;
	
	BitmapFont font;
	LabelStyle labstyle = new LabelStyle();
	Label label;
	Skin skinDialog;
	TextureAtlas butwin;

	public SlotActor(Skin skin, Slot slot) {
		super(createStyle(skin, slot));
		this.slot = slot;
		this.skin = skin;

		slot.addListener(this);

		SlotTooltip tooltip = new SlotTooltip(slot, skin);
		tooltip.setTouchable(Touchable.disabled); // allows for mouse to hit tooltips in the top-right corner of the screen without flashing
		InventoryScreen.stage.addActor(tooltip);
		addListener(new TooltipListener(tooltip, true));
		
		skinDialog = new Skin();
		butwin = new TextureAtlas("butwin.atlas");
		skin.addRegions(butwin);
		skin.add("default", labstyle);
		font = new BitmapFont(Gdx.files.internal("default.fnt"));
		labstyle.font = font;
		label = new Label("Use Item?", labstyle);
		
		Dialog dialog = new Dialog("", skin, "dialog")
		{
			public void result(Object obj)
			{
				if(obj.equals(true))
				{
					System.out.println("true");
					System.out.println(slot.getItem());
					if(slot.getItem().getConsumable())
					{
						slot.take(1);
						game.inventoryscreen.inventoryActor.inv.consume(slot.getItem());
					}
				}
				else
				{
					System.out.println("false");
				}
			}
		};
		
		dialog.text(label);
		dialog.button("Use", true);
		dialog.button("Not use", false);
		dialog.setPosition(300, 200);
		dialog.sizeBy(100, 100);
		dialog.pack();
		
		addListener(new ClickListener()
		{
			public void clicked(InputEvent e, float x, float y)
			{
				if(slot.isEmpty())
				{
					System.out.println("Dialog: Slot empty");
				}
				else
				{
					dialog.setVisible(true);
					System.out.println(slot.toString() + " clicked");
				}
				InventoryScreen.stage.addActor(dialog);
			}
		});
	}

	private static ImageButtonStyle createStyle(Skin skin, Slot slot) {
		TextureAtlas icons = new TextureAtlas("icons.atlas"); //LibgdxUtils.assets.get("icons/icons.atlas", TextureAtlas.class);
		TextureRegion image;
		if (slot.getItem() != null) {
			image = icons.findRegion(slot.getItem().getTextureRegion());
		} else {
			image = icons.findRegion("nothing");
		}
		ImageButtonStyle style = new ImageButtonStyle(skin.get(ButtonStyle.class));
		style.imageUp = new TextureRegionDrawable(image);
		style.imageDown = new TextureRegionDrawable(image);

		return style;
	}

	public Slot getSlot() {
		return slot;
	}

	@Override
	public void hasChanged(Slot slot) {
		setStyle(createStyle(skin, slot));
	}

}