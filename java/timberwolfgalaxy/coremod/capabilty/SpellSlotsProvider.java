package timberwolfgalaxy.coremod.capabilty;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SpellSlotsProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject(ISpellSlots.class)
	public static final Capability<ISpellSlots> SPELL_SLOTS = null;

	private ISpellSlots instance = SPELL_SLOTS.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == SPELL_SLOTS;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == SPELL_SLOTS ? SPELL_SLOTS.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return SPELL_SLOTS.getStorage().writeNBT(SPELL_SLOTS, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		SPELL_SLOTS.getStorage().readNBT(SPELL_SLOTS, this.instance, null, nbt);
	}

}
