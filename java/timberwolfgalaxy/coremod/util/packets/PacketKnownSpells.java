package timberwolfgalaxy.coremod.util.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketKnownSpells implements IMessage{
	private NBTTagCompound message = new NBTTagCompound();
	
	public PacketKnownSpells(){
	}
	
	public PacketKnownSpells(int[] a) {
		message.setIntArray("message", a);;
	}
	
	public int[] getMessage() {
		return message.getIntArray("message");
	}

	@Override
	public void fromBytes(ByteBuf buf) {	
		ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, message);
	}

}
