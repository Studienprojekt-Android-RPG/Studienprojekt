package de.test.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;


public class Inventory{

	private int slotAmount = 64;
	private Array<Slot> slots;

	public Inventory() {
		slots = new Array<Slot>(slotAmount);
		for (int i = 0; i < slotAmount; i++) {
			slots.add(new Slot(null, 0));
		}
		/*// create some random items
		for (Slot slot : slots) {
			//slot.add(Item.REICHTUMSELIXIER, 1);
			slot.add(Item.values()[MathUtils.random(0, Item.values().length - 1)], 1);
		}

		// create a few random empty slots
		for (int i = 0; i < 3; i++) {
			Slot randomSlot = slots.get(MathUtils.random(0, slots.size - 1));
			randomSlot.take(randomSlot.getAmount());
		}*/
		//this.store(Item.MESSER, 2);
		//this.store(Item.DONUT, 5);
		//this.store(Item.LEBERKASSEMMEL, 5);
	}

	public int checkInventory(Item item) {
		int amount = 0;

		for (Slot slot : slots) {
			if (slot.getItem() == item) {
				amount += slot.getAmount();
			}
		}

		return amount;
	}

	public boolean store(Item item, int amount) {
		// first check for a slot with the same item type
		Slot itemSlot = firstSlotWithItem(item);
		if (itemSlot != null) {
			itemSlot.add(item, amount);
			return true;
		} else {
			// now check for an available empty slot
			Slot emptySlot = firstSlotWithItem(null);
			if (emptySlot != null) {
				emptySlot.add(item, amount);
				return true;
			}
		}

		// no slot to add
		return false;
	}

	public Array<Slot> getSlots() {
		return slots;
	}

	private Slot firstSlotWithItem(Item item) {
		for (Slot slot : slots) {
			if (slot.getItem() == item) {
				return slot;
			}
		}

		return null;
	}
	
	public void consume(Item item)
	{
		if(item.getConsumable())
		{
			System.out.println(Gamescreen.player.curHP);
			System.out.println(Gamescreen.player.curSP);
			Gamescreen.player.curHP += item.getHP();
			Gamescreen.player.curSP += item.getSP();
			if(Gamescreen.player.curHP > Gamescreen.player.maxHP)
			{
				Gamescreen.player.curHP = Gamescreen.player.maxHP;
			}
			if(Gamescreen.player.curSP > Gamescreen.player.maxSP)
			{
				Gamescreen.player.curSP = Gamescreen.player.maxSP;
			}
		}
	}
}