package timberwolfgalaxy.coremod.capabilty;

public class SpellSlots implements ISpellSlots{
	private int[] spellSlots= {4, 3, 2, 0, 0, 0, 0, 0, 0};

	@Override
	public void fillSlots() {
		spellSlots[0] = 4;
		spellSlots[1] = 3;
		spellSlots[2] = 2;
		spellSlots[3] = 0;
		spellSlots[4] = 0;
		spellSlots[5] = 0;
		spellSlots[6] = 0;
		spellSlots[7] = 0;
		spellSlots[8] = 0;
	}

	@Override
	public void consume(int level, int number) {
		spellSlots[level-1]-=number;
		
	}

	@Override
	public void set(int level, int number) {
		spellSlots[level-1]=number;
		
	}

	@Override
	public int[] getSlots() {
		return spellSlots;
	}

	@Override
	public int[] getMaxSlots() {
		int[] spellSlots= {4, 3, 2, 0, 0, 0, 0, 0, 0};
		return spellSlots;
	}

}
