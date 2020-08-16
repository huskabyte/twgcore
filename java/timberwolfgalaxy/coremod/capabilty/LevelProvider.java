package timberwolfgalaxy.coremod.capabilty;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class LevelProvider implements ICapabilitySerializable<NBTBase>{
	@CapabilityInject(ILevel.class)
	public static final Capability<ILevel> LEVEL = null;

	private ILevel instance = LEVEL.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == LEVEL;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == LEVEL ? LEVEL.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return LEVEL.getStorage().writeNBT(LEVEL, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		LEVEL.getStorage().readNBT(LEVEL, this.instance, null, nbt);

	}
}
