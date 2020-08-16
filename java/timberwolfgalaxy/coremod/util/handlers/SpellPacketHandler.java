package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import timberwolfgalaxy.coremod.capabilty.SelectedSpellProvider;
import timberwolfgalaxy.coremod.util.packets.PacketLevel;
import timberwolfgalaxy.coremod.util.packets.PacketSpell;

public class SpellPacketHandler implements IMessageHandler<PacketSpell, IMessage>{
	
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("twgcore.spell");

	@Override
	public IMessage onMessage(PacketSpell message, MessageContext ctx) {
		int spell = message.getSpell();
		Minecraft.getMinecraft().addScheduledTask(() -> {
			Minecraft.getMinecraft().player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).setSpell(spell);
		});
		return null;
	}

}
