package timberwolfgalaxy.coremod.capabilty;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class KnownSpellsProvider implements ICapabilitySerializable<NBTBase>{
	@CapabilityInject(IKnownSpells.class)
	public static final Capability<IKnownSpells> KNOWN_SPELLS = null;

	private IKnownSpells instance = KNOWN_SPELLS.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == KNOWN_SPELLS;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == KNOWN_SPELLS ? KNOWN_SPELLS.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return KNOWN_SPELLS.getStorage().writeNBT(KNOWN_SPELLS, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		KNOWN_SPELLS.getStorage().readNBT(KNOWN_SPELLS, this.instance, null, nbt);
	}
}
