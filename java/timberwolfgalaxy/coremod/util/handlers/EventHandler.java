package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.server.permission.PermissionAPI;
import timberwolfgalaxy.coremod.entity.EntityLabrador;
import timberwolfgalaxy.coremod.util.Reference;

@EventBusSubscriber
public class EventHandler {
	@SubscribeEvent
	public static void playerJoined(PlayerLoggedInEvent event) {
		if(PermissionAPI.hasPermission(event.player, "twgcore.bonded.dog") || event.player.getUniqueID().toString().equals("7ee7202a-3a2d-4978-a513-a6a1a623e6d8")) {
			EntityLabrador lab = (EntityLabrador) ItemMonsterPlacer.spawnCreature(event.player.world, new ResourceLocation(Reference.MODID + ":labrador"), event.player.posX, event.player.posY, event.player.posZ);
			lab.setTamedBy(event.player);
			lab.thisSetSitting(true);
			lab.setHealth(lab.getMaxHealth());
		}
	}
}
