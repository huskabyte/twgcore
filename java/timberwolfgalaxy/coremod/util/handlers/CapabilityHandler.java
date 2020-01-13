package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import timberwolfgalaxy.coremod.capabilities.ITricks;
import timberwolfgalaxy.coremod.capabilities.TrickProvider;
import timberwolfgalaxy.coremod.util.Reference;

public class CapabilityHandler {
	public static final ResourceLocation TRICKS = new ResourceLocation(Reference.MODID, "tricks");
	
	@SubscribeEvent
	public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
		if(!(event.getObject() instanceof EntityPlayer)) return;
		EntityPlayer e = (EntityPlayer) event.getObject();
		event.addCapability(TRICKS, new TrickProvider());
		
		e.getCapability(TrickProvider.TRICKS, null).setPlayer(e);
	}
}
