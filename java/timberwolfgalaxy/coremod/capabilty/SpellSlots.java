package timberwolfgalaxy.coremod.capabilty;

import timberwolfgalaxy.coremod.objects.items.Wand;

public class SpellSlots implements ISpellSlots{
	private int[] spellSlots= {0, 0, 0, 0, 0, 0, 0, 0, 0};

	@Override
	public void fillSlots(int level) {
		spellSlots=getMaxSlots(level);
	}

	@Override
	public void consume(int level, int number) {
		if(level > 0) {
			spellSlots[level-1]-=number;
		}
		
	}

	@Override
	public void set(int level, int number) {
		if(level > 0) {
			spellSlots[level-1]=number;
		}
		
	}

	@Override
	public int[] getSlots() {
		return spellSlots;
	}

	@Override
	public int[] getMaxSlots(int level) {
		return Wand.getSpellSlotsByLevel(level);
	}

}
