package timberwolfgalaxy.coremod.capabilty;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class SelectedSpellStorage implements IStorage<ISelectedSpell>{

	@Override
	public NBTBase writeNBT(Capability<ISelectedSpell> capability, ISelectedSpell instance, EnumFacing side) {
		return new NBTTagInt(instance.getSpell());
	}

	@Override
	public void readNBT(Capability<ISelectedSpell> capability, ISelectedSpell instance, EnumFacing side, NBTBase nbt) {
		instance.setSpell(((NBTPrimitive)nbt).getInt());
	}

}
