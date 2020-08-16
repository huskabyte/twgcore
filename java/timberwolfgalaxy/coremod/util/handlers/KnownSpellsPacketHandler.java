package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import timberwolfgalaxy.coremod.capabilty.KnownSpellsProvider;
import timberwolfgalaxy.coremod.util.packets.PacketKnownSpells;

public class KnownSpellsPacketHandler implements IMessageHandler<PacketKnownSpells, IMessage>{
	
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("twgcore.knownspells");

	@Override
	public IMessage onMessage(PacketKnownSpells message, MessageContext ctx) {
		int[] knownSpells = message.getMessage();
		Minecraft.getMinecraft().addScheduledTask(() -> {
			Minecraft.getMinecraft().player.getCapability(KnownSpellsProvider.KNOWN_SPELLS, null).setKnownSpells(knownSpells);
		});
		return null;
	}

}
