package timberwolfgalaxy.coremod.capabilty;

import timberwolfgalaxy.coremod.objects.items.Wand;

public class SelectedSpell implements ISelectedSpell{
	private int selectedSpell = 0;

	@Override
	public void setSpell(int spell) {
		selectedSpell = spell;
		if(selectedSpell < 0 || selectedSpell > Wand.SPELLS.size()-1) selectedSpell = 0;
	}

	@Override
	public int getSpell() {
		return selectedSpell;
	}

	@Override
	public void nextSpell() {
		selectedSpell++;
		if(selectedSpell < 0 || selectedSpell > Wand.SPELLS.size()-1) selectedSpell = 0;
	}
}
