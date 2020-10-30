package timberwolfgalaxy.coremod.util.handlers;

import java.awt.Color;

import net.minecraft.block.BlockBed;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
import net.minecraftforge.server.permission.PermissionAPI;
import timberwolfgalaxy.coremod.capabilty.ILevel;
import timberwolfgalaxy.coremod.capabilty.ISelectedSpell;
import timberwolfgalaxy.coremod.capabilty.ISpellSlots;
import timberwolfgalaxy.coremod.capabilty.LevelProvider;
import timberwolfgalaxy.coremod.capabilty.SelectedSpellProvider;
import timberwolfgalaxy.coremod.capabilty.SpellSlotsProvider;
import timberwolfgalaxy.coremod.entity.EntityBondable;
import timberwolfgalaxy.coremod.init.EntityInit;
import timberwolfgalaxy.coremod.objects.blocks.regen.RegenerativeBlock;
import timberwolfgalaxy.coremod.objects.items.Wand;
import timberwolfgalaxy.coremod.util.Reference;
import timberwolfgalaxy.coremod.util.packets.PacketLevel;

@EventBusSubscriber
public class TWGEventHandler {
	public static final ResourceLocation SELECTED_SPELL = new ResourceLocation(Reference.MODID, "selectedspell");
	public static final ResourceLocation SPELL_SLOT = new ResourceLocation(Reference.MODID, "spellslot");
	public static final ResourceLocation LEVEL = new ResourceLocation(Reference.MODID, "level");

	@SubscribeEvent
	public static void attachCapability(AttachCapabilitiesEvent<Entity> event) {
		if (!(event.getObject() instanceof EntityPlayer))
			return;
		event.addCapability(SELECTED_SPELL, new SelectedSpellProvider());
		event.addCapability(SPELL_SLOT, new SpellSlotsProvider());
		event.addCapability(LEVEL, new LevelProvider());
	}

	@SubscribeEvent
	public static void onOverlayRender(RenderGameOverlayEvent.Text event) {
		Minecraft mc = Minecraft.getMinecraft();
		int[] spellSlots = mc.player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null).getSlots();
		if (mc.player.getHeldItemMainhand().getItem() instanceof Wand && Wand.SPELLS
				.get(mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell())
				.slot() > 0) {
			mc.fontRenderer.drawStringWithShadow(
					Integer.toString(Wand.SPELLS.get(
							mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell())
							.slot()),
					0, 0, Color.WHITE.getRGB());
			for (int i = 0; i < mc.player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null)
					.getMaxSlots(mc.player.getCapability(LevelProvider.LEVEL, null).getLevel())[Wand.SPELLS.get(
							mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell())
							.slot() - 1]; i++) {
				if (spellSlots[Wand.SPELLS
						.get(mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell())
						.slot() - 1] > i) {
					mc.fontRenderer.drawStringWithShadow("\u25cf", 10 + 5 * (i), 0, Color.WHITE.getRGB());
				} else {
					mc.fontRenderer.drawStringWithShadow("\u25EF", 10 + 5 * (i), 0, Color.WHITE.getRGB());
				}
			}
			mc.fontRenderer
					.drawStringWithShadow(
							Wand.SPELLS
									.get(mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell())
									.getName(),
							0, 10,
							Wand.SPELLS.get(mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell())
									.getColor().getRGB());
			mc.fontRenderer.drawStringWithShadow(
					"Level: " + mc.player.getCapability(LevelProvider.LEVEL, null).getLevel(), 0, 20,
					Color.WHITE.getRGB());
		} else if (mc.player.getHeldItemMainhand().getItem() instanceof Wand) {
			mc.fontRenderer.drawStringWithShadow("Cantrip", 0, 0, Color.WHITE.getRGB());
			mc.fontRenderer
					.drawStringWithShadow(
							Wand.SPELLS
									.get(mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell())
									.getName(),
							0, 10,
							Wand.SPELLS.get(mc.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell())
									.getColor().getRGB());
		} 
	}

	@SubscribeEvent
	public static void playerJoined(PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		ISelectedSpell selectedSpell = player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null);
		ISpellSlots spellSlots = player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null);

		if (!event.player.world.isRemote) {
			LevelPacketHandler.INSTANCE.sendTo(
					new PacketLevel(player.getCapability(LevelProvider.LEVEL, null).getLevel()),
					(EntityPlayerMP) player);
		}

		event.player.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).setSpell(0);
		player.sendMessage(new TextComponentString(
				"Selected Spell:" + Wand.SPELLS.get(selectedSpell.getSpell()).getName()));

		event.player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null)
				.fillSlots(event.player.getCapability(LevelProvider.LEVEL, null).getLevel());
		for (String s : EntityInit.bondableIdList) {
			if (PermissionAPI.hasPermission(event.player, "twgcore.bonded." + s)
					|| event.player.getUniqueID().toString().equals("7ee7202a-3a2d-4978-a513-a6a1a623e6d8")) {
				EntityBondable entity = (EntityBondable) EntityBondable.spawnBondable(event.player.posX,
						event.player.posY, event.player.posZ, s, event.player.world);
				entity.tame(event.player);
				entity.setHealth(entity.getMaxHealth());
				return;
			}
		}
		return;
	}

	@SubscribeEvent
	public static void playerLeft(PlayerLoggedOutEvent event) {
		for (Entity entity : event.player.world.loadedEntityList) {
			if (entity instanceof EntityBondable) {
				if (((EntityBondable) entity).getOwner().equals(event.player)) {
					entity.setEntityInvulnerable(false);
					entity.setDead();
				}
			}
		}
	}

	@SubscribeEvent
	public static void blockBroken(BlockEvent.BreakEvent event) {
		if (!event.getPlayer().capabilities.isCreativeMode) {
			if (event.getState().getBlock() instanceof RegenerativeBlock) {
				if (event.getState().getBlock().canHarvestBlock(event.getWorld(), event.getPos(), event.getPlayer())) {
					event.getState().getBlock().dropBlockAsItem(event.getWorld(), event.getPos(), event.getState(),
							getRealEnchantmentLevel(35, event.getPlayer().getHeldItemMainhand()));
					event.getState().getBlock().dropXpOnBlockBreak(event.getWorld(), event.getPos(),
							event.getState().getBlock().getExpDrop(event.getState(), event.getWorld(), event.getPos(),
									getRealEnchantmentLevel(35, event.getPlayer().getHeldItemMainhand())));
				}
				((RegenerativeBlock) event.getState().getBlock()).degenerate(event);
				event.setCanceled(true);
			} else if (!PermissionAPI.hasPermission(event.getPlayer(), "twgcore.insurvival")) {
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof BlockBed && !event.getEntityPlayer().isSneaking()) {
			if (event.getEntityPlayer().world.isRemote) {
				event.getEntityPlayer().sendMessage(new TextComponentString("Spell Slots Refreshed!"));
			}
			event.getEntityPlayer().getCapability(SpellSlotsProvider.SPELL_SLOTS, null)
					.fillSlots(event.getEntityPlayer().getCapability(LevelProvider.LEVEL, null).getLevel());
		}else {
			if (!PermissionAPI.hasPermission(event.getEntityPlayer(), "twgcore.insurvival") && event.getEntityPlayer().getHeldItemMainhand().getItem() instanceof ItemBlock && !event.getEntityPlayer().capabilities.isCreativeMode) {
				event.setCanceled(true);
			}
		}
	}

	public static void onPlayerDrop(PlayerDropsEvent event) {
		for (EntityItem i : event.getDrops()) {
			if (i.getItem().getItem() instanceof Wand) {
				event.getDrops().remove(event.getDrops().indexOf(i));
			}
		}
	}

	@SubscribeEvent
	public static void onPlayerClone(PlayerEvent.Clone event) {
		EntityPlayer player = event.getEntityPlayer();
		if (!player.world.isRemote) {
		ILevel level = player.getCapability(LevelProvider.LEVEL, null);
		ILevel oldLevel = event.getOriginal().getCapability(LevelProvider.LEVEL, null);
		
		player.getCapability(LevelProvider.LEVEL, null).setLevel(oldLevel.getLevel());

			LevelPacketHandler.INSTANCE.sendTo(
					new PacketLevel(player.getCapability(LevelProvider.LEVEL, null).getLevel()),
					(EntityPlayerMP) player);
		}
	}

	private static int getRealEnchantmentLevel(int enchantmentId, ItemStack stack) {
		if (stack == null) {
			return 0;
		} else {
			NBTTagList nbttaglist = stack.getEnchantmentTagList();
			if (nbttaglist == null) {
				return 0;
			} else {
				for (int j = 0; j < nbttaglist.tagCount(); ++j) {
					short id = nbttaglist.getCompoundTagAt(j).getShort("id");
					if (id == enchantmentId) {
						return nbttaglist.getCompoundTagAt(j).getShort("lvl");
					}
				}
				return 0;
			}
		}
	}
}
