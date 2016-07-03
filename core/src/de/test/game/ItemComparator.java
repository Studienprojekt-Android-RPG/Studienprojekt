package de.test.game;

import java.util.Comparator;

public class ItemComparator implements Comparator<Slot> {

	@Override
	public int compare(Slot slot0, Slot slot1) {
		if(slot0.getItem() == null && slot1.getItem() == null) {
			return 0;
		}
		if (slot0.getItem() == null ) {
			return -1;
		}
		if (slot1.getItem() == null) {
			return 1;
		}
		if(slot0.getItem().getSort() < slot1.getItem().getSort()) {
			return -1;
		}
		if(slot0.getItem().getSort() > slot1.getItem().getSort()) {
			return 1;
		}
		return slot0.getItem().compareTo(slot1.getItem());
	}

}
