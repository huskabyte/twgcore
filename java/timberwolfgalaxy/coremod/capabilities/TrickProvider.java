package timberwolfgalaxy.coremod.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class TrickProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject(ITricks.class)
	public static final Capability<ITricks> TRICKS = null;
	
	private ITricks instance = TRICKS.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing)
	{
	return capability == TRICKS;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing)
	{
	return capability == TRICKS ? TRICKS.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT()
	{
	return TRICKS.getStorage().writeNBT(TRICKS, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt)
	{
	TRICKS.getStorage().readNBT(TRICKS, this.instance, null, nbt);
	}

}
