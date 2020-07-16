package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.entity.Entity;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.server.permission.PermissionAPI;
import timberwolfgalaxy.coremod.entity.EntityBondable;
import timberwolfgalaxy.coremod.init.BlockInit;
import timberwolfgalaxy.coremod.init.EntityInit;

@EventBusSubscriber
public class TWGEventHandler {
	@SubscribeEvent
	public static void playerJoined(PlayerLoggedInEvent event) {
		for(String s : EntityInit.bondableIdList) {
			if(PermissionAPI.hasPermission(event.player, "twgcore.bonded." + s) || event.player.getUniqueID().toString().equals("7ee7202a-3a2d-4978-a513-a6a1a623e6d8")){
				EntityBondable entity = (EntityBondable) EntityBondable.spawnBondable(event.player.posX, event.player.posY, event.player.posZ, s, event.player.world);
				entity.tame(event.player);
				entity.setHealth(entity.getMaxHealth());
				return;
			}
		}
	}
	
	@SubscribeEvent
	public static void playerLeft(PlayerLoggedOutEvent event) {
		for(Entity entity : event.player.world.loadedEntityList) {
			if(entity instanceof EntityBondable) {
				if(((EntityBondable)entity).getOwner().equals(event.player)) {
					entity.setEntityInvulnerable(false);
					entity.setDead();
				}
			}
		}
	}
	
	@SubscribeEvent
	public static void blockBroken(BlockEvent.BreakEvent event) {
		if(!event.getPlayer().capabilities.isCreativeMode) {
			if(event.getState().equals(BlockInit.REGEN_STONE.getDefaultState())) {
				event.getWorld().setBlockState(event.getPos(), BlockInit.REGEN_COBBLE.getDefaultState());
				if(event.getPlayer().canHarvestBlock(event.getState())) {
					BlockInit.REGEN_STONE.dropBlockAsItem(event.getWorld(), event.getPos(), event.getState(), 0);
				}
				event.setCanceled(true);
			}else if(event.getState().equals(BlockInit.REGEN_COBBLE.getDefaultState())){
				event.getWorld().setBlockState(event.getPos(), BlockInit.REGEN_BEDROCK.getDefaultState());
				if(event.getPlayer().canHarvestBlock(event.getState())) {
					BlockInit.REGEN_COBBLE.dropBlockAsItem(event.getWorld(), event.getPos(), event.getState(), 0);
				}
				event.setCanceled(true);
			}else if(event.getState().equals(BlockInit.REGEN_BEDROCK.getDefaultState())) {
				event.setCanceled(true);
			}
		}
	}
}
