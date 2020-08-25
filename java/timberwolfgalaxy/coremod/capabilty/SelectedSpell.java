package timberwolfgalaxy.coremod.capabilty;

import net.minecraft.entity.player.EntityPlayer;
import timberwolfgalaxy.coremod.objects.items.Wand;

public class SelectedSpell implements ISelectedSpell{
	private int selectedSpell = 0;

	@Override
	public void setSpell(int spell) {
		selectedSpell = spell;
		if(selectedSpell < 0) selectedSpell = 0;
	}

	@Override
	public int getSpell() {
		return selectedSpell;
	}

	@Override
	public void nextSpell(int max) {
		if(selectedSpell < 0 || selectedSpell >= max-1) {
			selectedSpell = 0;
		}else {
			selectedSpell++;
		}
	}
}
