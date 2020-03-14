package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import timberwolfgalaxy.coremod.entity.EntityBondable;
import timberwolfgalaxy.coremod.entity.EntityLabrador;
import timberwolfgalaxy.coremod.init.EntityInit;
import timberwolfgalaxy.coremod.util.packets.PacketBondableSwitch;

public class SwitchPacketHandler implements IMessageHandler<PacketBondableSwitch, IMessage>{
	
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("twgcore.switch");
	private int type;

	@Override
	public IMessage onMessage(PacketBondableSwitch message, MessageContext ctx) {
		EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
		EntityPlayer player = ctx.getServerHandler().player;
		this.type = message.getType();
		serverPlayer.getServerWorld().addScheduledTask(() -> {
			for(Entity entity : player.world.loadedEntityList) {
				if(entity instanceof EntityBondable) {
					if(((EntityBondable)entity).getOwner().equals(player)) {
						entity.setDead();
						EntityBondable bondable = (EntityBondable) EntityBondable.spawnBondable(player.posX, player.posY, player.posZ, EntityInit.bondableIdList.get(type), player.world);
						bondable.tame(player);
						bondable.setHealth(bondable.getMaxHealth());
						return;
					}
				}
			}
		});
		return null;
	}

}
