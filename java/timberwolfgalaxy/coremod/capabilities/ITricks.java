package timberwolfgalaxy.coremod.capabilities;

import net.minecraft.entity.player.EntityPlayer;

public interface ITricks{
	
	public void setTrick(int trick, boolean state);
	public boolean getTrick(int trick);
	
	public boolean[] getArray();
	
	public void setPlayer(EntityPlayer player);
	public EntityPlayer getPlayer();
}
