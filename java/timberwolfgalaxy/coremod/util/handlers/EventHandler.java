package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import timberwolfgalaxy.coremod.init.PotionEffectInit;
import timberwolfgalaxy.coremod.objects.items.Wand;

@EventBusSubscriber
public class EventHandler {
	@SubscribeEvent
	public static void TWGPotionEffects(LivingUpdateEvent event) {
		if(event.getEntityLiving().isPotionActive(PotionEffectInit.STRAIGHT_FIRE)  && !event.getEntityLiving().isImmuneToFire()) {
			event.getEntityLiving().attackEntityFrom(DamageSource.MAGIC, (float)(6));
			event.getEntityLiving().setFire(5);
		}
	}
	@SubscribeEvent
	public static void onItemToss(ItemTossEvent event) {
		if(event.getEntityItem().getItem().getItem() instanceof Wand) {
			event.getPlayer().addItemStackToInventory(event.getEntityItem().getItem());
			event.setCanceled(true);
		}
	}
}
