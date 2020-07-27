package timberwolfgalaxy.coremod.util.handlers;

import java.awt.Color;

import net.minecraft.block.BlockBed;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.server.permission.PermissionAPI;
import timberwolfgalaxy.coremod.capabilty.ISelectedSpell;
import timberwolfgalaxy.coremod.capabilty.ISpellSlots;
import timberwolfgalaxy.coremod.capabilty.SelectedSpellProvider;
import timberwolfgalaxy.coremod.capabilty.SpellSlotsProvider;
import timberwolfgalaxy.coremod.entity.EntityBondable;
import timberwolfgalaxy.coremod.init.BlockInit;
import timberwolfgalaxy.coremod.init.EntityInit;
import timberwolfgalaxy.coremod.objects.items.Wand;
import timberwolfgalaxy.coremod.util.Reference;

@EventBusSubscriber
public class TWGEventHandler {
	public static final ResourceLocation SELECTED_SPELL = new ResourceLocation(Reference.MODID, "selectedspell");
	public static final ResourceLocation SPELL_SLOT = new ResourceLocation(Reference.MODID, "spellslot");
	 
	 @SubscribeEvent
	 public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	 {
	 if (!(event.getObject() instanceof EntityPlayer)) return;

	 event.addCapability(SELECTED_SPELL, new SelectedSpellProvider());
	 event.addCapability(SPELL_SLOT, new SpellSlotsProvider());
	 }
	 
	 @SubscribeEvent
	 public void onOverlayRender(RenderGameOverlayEvent.Text event) {
		 Minecraft mc = Minecraft.getMinecraft();
			int[] spellSlots = mc.player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null).getSlots();
			if(mc.player.getHeldItemMainhand().getItem() instanceof Wand && Wand.SPELLS.get(mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()).slot() > 0) {
				mc.fontRenderer.drawStringWithShadow(Integer.toString(Wand.SPELLS.get(mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()).slot()), 0, 0, Color.WHITE.getRGB());
				for(int i = 0; i < mc.player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null).getMaxSlots()[Wand.SPELLS.get(mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()).slot()-1]; i++) {
					if(spellSlots[Wand.SPELLS.get(mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()).slot()-1] > i) {
						mc.fontRenderer.drawStringWithShadow("\u25cf", 10+5*(i), 0, Color.WHITE.getRGB());
					}else {
						mc.fontRenderer.drawStringWithShadow("\u25EF", 10+5*(i), 0, Color.WHITE.getRGB());
					}
				}
			}
	 }
	
	@SubscribeEvent
	public static void playerJoined(PlayerLoggedInEvent event) {
		for(String s : EntityInit.bondableIdList) {
			if(PermissionAPI.hasPermission(event.player, "twgcore.bonded." + s) || event.player.getUniqueID().toString().equals("7ee7202a-3a2d-4978-a513-a6a1a623e6d8")){
				EntityBondable entity = (EntityBondable) EntityBondable.spawnBondable(event.player.posX, event.player.posY, event.player.posZ, s, event.player.world);
				entity.tame(event.player);
				entity.setHealth(entity.getMaxHealth());
				event.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).setSpell(0);
				event.player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null).fillSlots();
				 EntityPlayer player = event.player;
				 ISelectedSpell selectedSpell = player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null);
				 ISpellSlots spellSlots = player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null);
				 
				 player.sendMessage(new TextComponentString("Selected Spell:" + Wand.SPELLS.get(selectedSpell.getSpell()).getName()));
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
	
	@SubscribeEvent
	public static void onPlayerRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if(event.getWorld().getBlockState(event.getPos()).getBlock() instanceof BlockBed) {
			if(event.getEntityPlayer().world.isRemote)event.getEntityPlayer().sendMessage(new TextComponentString("Spell Slots Refreshed!"));
			event.getEntityPlayer().getCapability(SpellSlotsProvider.SPELL_SLOTS, null).fillSlots();
		}
	}
}
