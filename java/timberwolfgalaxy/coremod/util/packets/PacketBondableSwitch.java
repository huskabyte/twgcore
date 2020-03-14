package timberwolfgalaxy.coremod.util.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketBondableSwitch implements IMessage {
	public PacketBondableSwitch() {
	}

	private int type;

	public PacketBondableSwitch(int type) {
		this.type = type;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(type);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		type = buf.readInt();
	}
	
	public int getType() {
		return type;
	}
}
