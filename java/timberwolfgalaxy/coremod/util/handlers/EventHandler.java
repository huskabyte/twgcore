package timberwolfgalaxy.coremod.util.handlers;

import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import timberwolfgalaxy.coremod.objects.items.Wand;

@EventBusSubscriber
public class EventHandler {
	@SubscribeEvent
	public static void onItemToss(ItemTossEvent event) {
		if(event.getEntityItem().getItem().getItem() instanceof Wand) {
			event.getPlayer().addItemStackToInventory(event.getEntityItem().getItem());
			event.setCanceled(true);
		}
	}
}
