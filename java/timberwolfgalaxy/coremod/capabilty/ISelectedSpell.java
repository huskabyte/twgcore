package timberwolfgalaxy.coremod.capabilty;

import net.minecraft.entity.player.EntityPlayer;

public interface ISelectedSpell {
	public void setSpell(int spell);
	public int getSpell();
	public void nextSpell(int max);
}
