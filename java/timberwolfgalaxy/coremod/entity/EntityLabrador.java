package timberwolfgalaxy.coremod.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class EntityLabrador extends EntityWolf{

	public EntityLabrador(World worldIn) {
		super(worldIn);
		
		this.setEntityInvulnerable(true);
	}
	
	@Override
	public EntityWolf createChild(EntityAgeable ageable) {
		return null;
	}

}
