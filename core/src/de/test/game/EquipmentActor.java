package de.test.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

public class EquipmentActor extends Window {
	
	Equipment equip;

	public EquipmentActor(Equipment equipment, String cTitle, Skin skin, int cRow, int cPosX, int cPosY, String dialogLabel, String buttonText) {
		super(cTitle, skin);
		
		equip = equipment;

		setPosition(cPosX, cPosY);
		defaults().space(2);

		int i = 0;
		for (Slot slot : equipment.getSlots()) {
			EquipmentSlotActor slotActor = new EquipmentSlotActor(skin, slot);
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