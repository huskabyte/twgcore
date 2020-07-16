package timberwolfgalaxy.coremod.objects.items.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public abstract class Spell{
	protected String color;
	protected String name;
	protected int slot;
	
	public abstract void cast(EntityPlayer player, World world);
	
	public String getName() {
		return this.color+this.name;
	}
	
	public void message(Spell s, EntityPlayer player) {
		if(player.world.isRemote) {
			player.sendMessage(new TextComponentString(s.getName()+"!"));
		}
	}
}
