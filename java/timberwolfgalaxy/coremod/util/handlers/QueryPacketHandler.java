package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import timberwolfgalaxy.coremod.capabilty.LevelProvider;
import timberwolfgalaxy.coremod.capabilty.SelectedSpellProvider;
import timberwolfgalaxy.coremod.util.packets.PacketLevel;
import timberwolfgalaxy.coremod.util.packets.PacketQuery;
import timberwolfgalaxy.coremod.util.packets.PacketSpell;

public class QueryPacketHandler implements IMessageHandler<PacketQuery, IMessage>{
	
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("twgcore.query");
	private int capability;

	@Override
	public IMessage onMessage(PacketQuery message, MessageContext ctx) {
		EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
		EntityPlayer player = ctx.getServerHandler().player;
		this.capability = message.getCapability();
		switch(capability) {
		case 0:
			return new PacketSpell(player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell());
		case 1:
			return new PacketLevel(player.getCapability(LevelProvider.LEVEL, null).getLevel());
		}
		return null;
	}

}
