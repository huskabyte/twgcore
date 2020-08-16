package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import timberwolfgalaxy.coremod.capabilty.LevelProvider;
import timberwolfgalaxy.coremod.util.packets.PacketLevel;

public class LevelPacketHandler implements IMessageHandler<PacketLevel, IMessage>{
	
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("twgcore.level");

	@Override
	public IMessage onMessage(PacketLevel message, MessageContext ctx) {
		int level = message.getLevel();
		Minecraft.getMinecraft().addScheduledTask(() -> {
			Minecraft.getMinecraft().player.getCapability(LevelProvider.LEVEL, null).setLevel(level);
		});
		return null;
	}

}
