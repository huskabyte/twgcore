package timberwolfgalaxy.coremod.util.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import timberwolfgalaxy.coremod.entity.EntityBondable;

public class PacketBondableTricks implements IMessage {
	public PacketBondableTricks() {
	}

	private int trick;

	public PacketBondableTricks(int trick) {
		this.trick = trick;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(trick);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		trick = buf.readInt();
	}
	
	public int getTrick() {
		return trick;
	}
}
