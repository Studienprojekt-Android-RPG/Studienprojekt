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
		else {
			Item equipped = slots.get(item.getSort()).getItem();
			Slot slot = slots.get(item.getSort());
			slot.take(slot.getAmount());
			slot.add(item, amount);
			return equipped;
		}
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