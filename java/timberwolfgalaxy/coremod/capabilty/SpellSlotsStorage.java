package timberwolfgalaxy.coremod.capabilty;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class SpellSlotsStorage implements IStorage<ISpellSlots>{

	@Override
	public NBTBase writeNBT(Capability<ISpellSlots> capability, ISpellSlots instance, EnumFacing side) {
		return new NBTTagIntArray(instance.getSlots());
	}

	@Override
	public void readNBT(Capability<ISpellSlots> capability, ISpellSlots instance, EnumFacing side, NBTBase nbt) {
		instance.set(1, ((NBTTagIntArray)nbt).getIntArray()[0]);
		instance.set(2, ((NBTTagIntArray)nbt).getIntArray()[1]);
		instance.set(3, ((NBTTagIntArray)nbt).getIntArray()[2]);
		instance.set(4, ((NBTTagIntArray)nbt).getIntArray()[3]);
		instance.set(5, ((NBTTagIntArray)nbt).getIntArray()[4]);
		instance.set(6, ((NBTTagIntArray)nbt).getIntArray()[5]);
		instance.set(7, ((NBTTagIntArray)nbt).getIntArray()[6]);
		instance.set(8, ((NBTTagIntArray)nbt).getIntArray()[7]);
		instance.set(9, ((NBTTagIntArray)nbt).getIntArray()[8]);
	}

}
