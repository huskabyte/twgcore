package timberwolfgalaxy.coremod.capabilty;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class SelectedSpellProvider implements ICapabilitySerializable<NBTBase> {
	@CapabilityInject(ISelectedSpell.class)
	public static final Capability<ISelectedSpell> SELECTED_SPELL = null;

	private ISelectedSpell instance = SELECTED_SPELL.getDefaultInstance();

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == SELECTED_SPELL;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == SELECTED_SPELL ? SELECTED_SPELL.<T>cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return SELECTED_SPELL.getStorage().writeNBT(SELECTED_SPELL, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		SELECTED_SPELL.getStorage().readNBT(SELECTED_SPELL, this.instance, null, nbt);
	}
}
