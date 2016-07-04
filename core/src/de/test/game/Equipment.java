package de.test.game;

import com.badlogic.gdx.utils.Array;

public class Equipment{
	Testmap game;
	private Array<Slot> slots;

	public Equipment(int cSlotAmount) {
		slots = new Array<Slot>(cSlotAmount);
		for (int i = 0; i < cSlotAmount; i++) {
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

	public Item equip(Item item, int amount) {
		// first check for a slot with the same item type
		Slot itemSlot = firstSlotWithItem(item);
		if (itemSlot != null) {
			Item equipped = itemSlot.getItem();
			itemSlot.take(itemSlot.getAmount());
			itemSlot.add(item, amount);
			return equipped;
		}
		// no slot to add
		return null;
	}

	public Array<Slot> getSlots() {
		return slots;
	}

	public Slot firstSlotWithItem(Item item) {
		for (Slot slot : slots) {
			if (slot.getItem() != null) {
				if(slot.getItem().getSort() == item.getSort()) {
					return slot;
				}
			}
			else {
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