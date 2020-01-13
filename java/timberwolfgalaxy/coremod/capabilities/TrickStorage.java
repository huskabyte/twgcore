package timberwolfgalaxy.coremod.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import timberwolfgalaxy.coremod.entity.EntityBondable;

public class TrickStorage implements IStorage<ITricks>{

	@Override
	public NBTBase writeNBT(Capability<ITricks> capability, ITricks instance, EnumFacing side) {
		EntityBondable bondable = null;
		
		if(instance.getPlayer() != null) {
			for(Entity entity : instance.getPlayer().world.loadedEntityList) {
				if(entity instanceof EntityBondable) {
					if(((EntityBondable) entity).getOwner().equals(instance.getPlayer())) {
						bondable = (EntityBondable) entity;
					}
				}
			}
			if(bondable != null) {
				NBTTagCompound tag = new NBTTagCompound();
				
				for(int i = 0; i < instance.getArray().length; i++) {
					tag.setBoolean(bondable.getName() + "trick" + Integer.toString(i), instance.getTrick(i));
				}
			
				return tag;
			}
		}
		return null;
	}

	@Override
	public void readNBT(Capability<ITricks> capability, ITricks instance, EnumFacing side, NBTBase nbt) {
		for(int i = 0; i < instance.getArray().length; i++) {
			instance.setTrick(i, ((NBTTagCompound) nbt).getBoolean("trick" + i));
		}
	}

}
