package de.test.game;

public interface SlotListener {

	/**
	 * Will be called whenever the slot has changed.
	 * 
	 * @param slot
	 *            The changed slot.
	 */
	void hasChanged(Slot slot);

}