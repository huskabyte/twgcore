package timberwolfgalaxy.coremod.objects.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.capabilty.KnownSpellsProvider;
import timberwolfgalaxy.coremod.capabilty.LevelProvider;
import timberwolfgalaxy.coremod.capabilty.SelectedSpellProvider;
import timberwolfgalaxy.coremod.capabilty.SpellSlotsProvider;
import timberwolfgalaxy.coremod.init.ItemInit;
import timberwolfgalaxy.coremod.objects.items.spells.CantripLevitate;
import timberwolfgalaxy.coremod.objects.items.spells.Spell;
import timberwolfgalaxy.coremod.objects.items.spells.SpellFireball;
import timberwolfgalaxy.coremod.objects.items.spells.SpellHealingWord;
import timberwolfgalaxy.coremod.objects.items.spells.SpellPoisonBlast;
import timberwolfgalaxy.coremod.util.IHasModel;
import timberwolfgalaxy.coremod.util.handlers.KnownSpellsPacketHandler;
import timberwolfgalaxy.coremod.util.handlers.LevelPacketHandler;
import timberwolfgalaxy.coremod.util.handlers.SpellPacketHandler;
import timberwolfgalaxy.coremod.util.packets.PacketKnownSpells;
import timberwolfgalaxy.coremod.util.packets.PacketLevel;
import timberwolfgalaxy.coremod.util.packets.PacketSpell;

public class Wand extends Item implements IHasModel {

	public static final List<Spell> SPELLS = new ArrayList<Spell>();

	public Wand(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.TWGWANDSTAB);
		if (SPELLS.isEmpty()) {
			addSpells();
		}
		ItemInit.ITEMS.add(this);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {

		if (!playerIn.world.isRemote) {
			playerIn.sendMessage(new TextComponentString(Wand.SPELLS
					.get(playerIn.getCapability(KnownSpellsProvider.KNOWN_SPELLS, null).getKnownSpells()[playerIn
							.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()])
					.getName()));
			LevelPacketHandler.INSTANCE.sendTo(
					new PacketLevel(playerIn.getCapability(LevelProvider.LEVEL, null).getLevel()),
					(EntityPlayerMP) playerIn);
			KnownSpellsPacketHandler.INSTANCE.sendTo(
					new PacketKnownSpells(
							playerIn.getCapability(KnownSpellsProvider.KNOWN_SPELLS, null).getKnownSpells()),
					(EntityPlayerMP) playerIn);
			SpellPacketHandler.INSTANCE.sendTo(
					new PacketSpell(playerIn.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()),
					(EntityPlayerMP) playerIn);

		}
		
		playerIn.getCapability(SelectedSpellProvider.SELECTED_SPELL, null)
		.nextSpell(playerIn.getCapability(KnownSpellsProvider.KNOWN_SPELLS, null).getKnownSpells().length - 1);

		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer playerIn = (EntityPlayer) entityLiving;
			if (!playerIn.world.isRemote) {
				LevelPacketHandler.INSTANCE.sendTo(
						new PacketLevel(playerIn.getCapability(LevelProvider.LEVEL, null).getLevel()),
						(EntityPlayerMP) playerIn);
				SpellPacketHandler.INSTANCE.sendTo(
						new PacketSpell(playerIn.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()),
						(EntityPlayerMP) playerIn);
				KnownSpellsPacketHandler.INSTANCE.sendTo(
						new PacketKnownSpells(
								playerIn.getCapability(KnownSpellsProvider.KNOWN_SPELLS, null).getKnownSpells()),
						(EntityPlayerMP) playerIn);
			}
			cast(SPELLS.get(playerIn.getCapability(KnownSpellsProvider.KNOWN_SPELLS, null).getKnownSpells()[entityLiving
					.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()]),
					(EntityPlayer) entityLiving);
			return false;
		}
		return super.onEntitySwing(entityLiving, stack);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

	private static void cast(Spell s, EntityPlayer player) {
		if (s.slot() > 0) {
			if (player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null).getSlots()[s.slot() - 1] > 0) {
				s.message(s, player);
				s.cast(player, player.world);
				player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null).consume(s.slot(), 1);
			} else {
				if (!player.world.isRemote) {
					player.sendMessage(new TextComponentString(
							"You're out of level " + s.slot() + " spell slots! Rest to gain them back!"));
				}
			}
			return;
		}
		s.message(s, player);
		s.cast(player, player.world);
	}

	private static void addSpells() {
		SPELLS.add(new SpellFireball());
		SPELLS.add(new SpellPoisonBlast());
		SPELLS.add(new SpellHealingWord());
		SPELLS.add(new CantripLevitate());
	}

	public void registerSpell(Spell s) {
		SPELLS.add(s);
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		return false;
	}

	@Deprecated
	private int getSpellByName(String spellname) {
		for (int i = 0; i < SPELLS.size(); i++) {
			if (SPELLS.get(i).getName().equals(spellname)) {
				return i;
			}
		}
		return 0;
	}

	public static int[] getSpellSlotsByLevel(int level) {
		int[][] defaultSlots = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 2, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 3, 0, 0, 0, 0, 0, 0, 0, 0 }, { 4, 2, 0, 0, 0, 0, 0, 0, 0 }, { 4, 3, 0, 0, 0, 0, 0, 0, 0 },
				{ 4, 3, 2, 0, 0, 0, 0, 0, 0 }, { 4, 3, 3, 0, 0, 0, 0, 0, 0 }, { 4, 3, 3, 1, 0, 0, 0, 0, 0 },
				{ 4, 3, 3, 2, 0, 0, 0, 0, 0 }, { 4, 3, 3, 3, 1, 0, 0, 0, 0 }, { 4, 3, 3, 3, 2, 0, 0, 0, 0 },
				{ 4, 3, 3, 3, 2, 1, 0, 0, 0 }, { 4, 3, 3, 3, 2, 1, 0, 0, 0 }, { 4, 3, 3, 3, 2, 1, 1, 0, 0 },
				{ 4, 3, 3, 3, 2, 1, 1, 0, 0 }, { 4, 3, 3, 3, 2, 1, 1, 1, 0 }, { 4, 3, 3, 3, 2, 1, 1, 1, 0 },
				{ 4, 3, 3, 3, 2, 1, 1, 1, 1 }, { 4, 3, 3, 3, 3, 1, 1, 1, 1 }, { 4, 3, 3, 3, 3, 2, 1, 1, 1 },
				{ 4, 3, 3, 3, 3, 2, 2, 1, 1 } };
		return defaultSlots[level];
	}
}
