package timberwolfgalaxy.coremod.util.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketQuery implements IMessage{
	
	public static final int CAP_SPELL = 0;
	public static final int CAP_LEVEL = 1;
	
private int capability;
	
	public PacketQuery() {
	}

	public PacketQuery(int capability) {
		this.capability = capability;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(capability);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		capability = buf.readInt();
	}
	
	public int getCapability() {
		return capability;
	}
}
