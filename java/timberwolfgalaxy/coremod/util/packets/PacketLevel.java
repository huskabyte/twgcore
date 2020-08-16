package timberwolfgalaxy.coremod.util.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketLevel implements IMessage {
	private int level;
	
	public PacketLevel() {
	}

	public PacketLevel(int level) {
		this.level = level;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(level);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		level = buf.readInt();
	}
	
	public int getLevel() {
		return level;
	}
}
