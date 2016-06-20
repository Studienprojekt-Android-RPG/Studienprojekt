package de.test.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class InventoryActor extends Window {
	
	Inventory inv;

	public InventoryActor(Inventory inventory, Skin skin) {
		super("Inventar", skin);
		
		inv = inventory;

		/*TextButton closeButton = new TextButton("X", skin);
		closeButton.addListener(new HidingClickListener(this));
		getButtonTable().add(closeButton).height(getPadTop());
		*/
		setPosition(500, 500);
		defaults().space(2);
		row().fill().expandX();

		int i = 0;
		for (Slot slot : inventory.getSlots()) {
			SlotActor slotActor = new SlotActor(skin, slot);
			add(slotActor);			

			i++;
			if (i % 8 == 0) {
				row();
			}
		}

		pack();

		// it is hidden by default
		setVisible(true);
		setMovable(true);
	}
	
}