package timberwolfgalaxy.coremod.util.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketSpell implements IMessage{
private int spell;
	
	public PacketSpell() {
	}

	public PacketSpell(int spell) {
		this.spell = spell;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(spell);
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		spell = buf.readInt();
	}
	
	public int getSpell() {
		return spell;
	}
}
