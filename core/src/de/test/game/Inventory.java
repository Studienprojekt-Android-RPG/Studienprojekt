package de.test.game;

import java.util.Comparator;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class Inventory{

	private Array<Slot> slots;
	private Comparator<Slot> comparator = new ItemComparator();

	public Inventory(int cSlotAmount) {
		slots = new Array<Slot>(cSlotAmount);
		for (int i = 0; i < cSlotAmount; i++) {
			slots.add(new Slot(null, 0));
		}
		// create some random items
		/*for (Slot slot : slots) {
			slot.add(Item.values()[MathUtils.random(0, Item.values().length - 1)], 1);
		}*/
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
			slots.sort(comparator);
			return true;
		} else {
			// now check for an available empty slot
			Slot emptySlot = firstSlotWithItem(null);
			if (emptySlot != null) {
				emptySlot.add(item, amount);
				slots.sort(comparator);
				return true;
			}
		}

		// no slot to add
		slots.sort(comparator);
		return false;
	}

	public Array<Slot> getSlots() {
		return slots;
	}

	public Slot firstSlotWithItem(Item item) {
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
		slots.sort(comparator);
	}
	
	public void sortInventory() {
		Array<Slot> inventory = getSlots();
		slots.clear();
		inventory.sort(comparator);
		slots.addAll(inventory);
	}
}