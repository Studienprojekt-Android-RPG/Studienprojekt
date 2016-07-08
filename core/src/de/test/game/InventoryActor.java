package de.test.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class InventoryActor extends Window {
	
	static Inventory inv;

	public InventoryActor(Inventory inventory, String cTitle, Skin skin, int cRow, int cPosX, int cPosY, String dialogLabel, String buttonText) {
		super(cTitle, skin);
		
		inv = inventory; 

		setPosition(cPosX, cPosY);
		defaults().space(2);

		int i = 0;
		for (Slot slot : inventory.getSlots()) {
			InventorySlotActor slotActor = new InventorySlotActor(skin, slot, dialogLabel, buttonText);
			add(slotActor);			

			i++;
			if (i % cRow == 0) {
				row();
			}
		}

		pack();

		// it is hidden by default
		setVisible(true);
		setMovable(false);
	}
	
}