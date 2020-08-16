package timberwolfgalaxy.coremod.capabilty;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class KnownSpellsStorage implements IStorage<IKnownSpells>{

	@Override
	public NBTBase writeNBT(Capability<IKnownSpells> capability, IKnownSpells instance, EnumFacing side) {
		return new NBTTagIntArray(instance.getKnownSpells());
	}

	@Override
	public void readNBT(Capability<IKnownSpells> capability, IKnownSpells instance, EnumFacing side, NBTBase nbt) {
		instance.setKnownSpells(((NBTTagIntArray) nbt).getIntArray());
	}
	
}
