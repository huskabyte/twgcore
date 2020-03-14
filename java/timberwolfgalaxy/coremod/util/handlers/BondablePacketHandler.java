package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import timberwolfgalaxy.coremod.entity.EntityBondable;
import timberwolfgalaxy.coremod.util.packets.PacketBondableTricks;

public class BondablePacketHandler implements IMessageHandler<PacketBondableTricks, IMessage>{
	
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("twgcore.bondable");
	private int trick;
	
	@Override
	public IMessage onMessage(PacketBondableTricks message, MessageContext ctx) {
		EntityPlayerMP serverPlayer = ctx.getServerHandler().player;
		EntityPlayer player = ctx.getServerHandler().player;
		this.trick = message.getTrick();
		serverPlayer.getServerWorld().addScheduledTask(() -> {
		      for(Entity entity : player.world.loadedEntityList) {
		    	  if(entity instanceof EntityBondable) {
		    		  if(((EntityBondable) entity).getOwner().equals(player) && player.getDistance(entity) < 10) {
		    			  switch (trick) {
		    			  	case 1:
		    			  		((EntityBondable) entity).thisSetSitting(true);
		    			  		((EntityBondable) entity).thisSetTrick2(false);
		    			  		((EntityBondable) entity).thisSetTrick3(false);
		    			  		break;
		    			  	case 2:
		    			  		((EntityBondable) entity).thisSetSitting(false);
		    			  		((EntityBondable) entity).thisSetTrick2(false);
		    			  		((EntityBondable) entity).thisSetTrick3(false);
		    			  		break;
		    			  	case 4:
		    			  		((EntityBondable) entity).thisSetSitting(true);
		    			  		((EntityBondable) entity).thisSetTrick2(true);
		    			  		((EntityBondable) entity).thisSetTrick3(false);
		    			  		break;
		    			  	case 5:
		    			  		((EntityBondable) entity).thisSetSitting(true);
		    			  		((EntityBondable) entity).thisSetTrick2(false);
		    			  		((EntityBondable) entity).thisSetTrick3(true);
		    			  		break;
		    				  
		    			  }
		    		  }
		    	  }
		      }
		    });
		return null;
	}

}
