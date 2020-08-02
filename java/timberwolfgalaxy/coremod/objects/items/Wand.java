package timberwolfgalaxy.coremod.objects.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.capabilty.SelectedSpellProvider;
import timberwolfgalaxy.coremod.capabilty.SpellSlotsProvider;
import timberwolfgalaxy.coremod.init.ItemInit;
import timberwolfgalaxy.coremod.objects.items.spells.Spell;
import timberwolfgalaxy.coremod.objects.items.spells.SpellFireball;
import timberwolfgalaxy.coremod.objects.items.spells.SpellPoisonBlast;
import timberwolfgalaxy.coremod.util.IHasModel;

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
		playerIn.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).nextSpell();
		String message = String.format("Selected Spell:", Wand.SPELLS
				.get(playerIn.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()).getName());
		if (playerIn.world.isRemote) {
			playerIn.sendMessage(new TextComponentString(Wand.SPELLS
					.get(playerIn.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()).getName()));
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		if (entityLiving instanceof EntityPlayer) {
			System.out.println(SPELLS
					.get(entityLiving.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()).getName());
			cast(SPELLS.get(entityLiving.getCapability(SelectedSpellProvider.SELECTED_SPELL, null).getSpell()),
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
		if (player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null).getSlots()[s.slot() - 1] > 0) {
			s.message(s, player);
			s.cast(player, player.world);
			player.getCapability(SpellSlotsProvider.SPELL_SLOTS, null).consume(s.slot(), 1);
		} else {
			if (player.world.isRemote) {
				player.sendMessage(new TextComponentString(
						"You're out of level " + s.slot() + " spell slots! Rest to gain them back!"));
			}
		}
	}

	private static void addSpells() {
		SPELLS.add(new SpellFireball());
		SPELLS.add(new SpellPoisonBlast());
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
		int[] defaultSlots = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		switch (level) {
		case 1:
			defaultSlots[0] = 2;
		case 2:
			defaultSlots[0] = 3;
		case 3:
			defaultSlots[0] = 4;
			defaultSlots[1] = 2;
		case 4:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
		case 5:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 2;
		case 6:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
		case 7:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 1;
		case 8:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 2;
		case 9:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 1;
		case 10:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 2;
		case 11:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 2;
			defaultSlots[5] = 1;
		case 12:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 2;
			defaultSlots[5] = 1;
		case 13:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 2;
			defaultSlots[5] = 1;
			defaultSlots[6] = 1;
		case 14:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 2;
			defaultSlots[5] = 1;
			defaultSlots[6] = 1;
		case 15:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 2;
			defaultSlots[5] = 1;
			defaultSlots[6] = 1;
			defaultSlots[7] = 1;
		case 16:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 2;
			defaultSlots[5] = 1;
			defaultSlots[6] = 1;
			defaultSlots[7] = 1;
		case 17:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 2;
			defaultSlots[5] = 1;
			defaultSlots[6] = 1;
			defaultSlots[7] = 1;
			defaultSlots[8] = 1;
		case 18:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 3;
			defaultSlots[5] = 1;
			defaultSlots[6] = 1;
			defaultSlots[7] = 1;
			defaultSlots[8] = 1;
		case 19:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 3;
			defaultSlots[5] = 2;
			defaultSlots[6] = 1;
			defaultSlots[7] = 1;
			defaultSlots[8] = 1;
		case 20:
			defaultSlots[0] = 4;
			defaultSlots[1] = 3;
			defaultSlots[2] = 3;
			defaultSlots[3] = 3;
			defaultSlots[4] = 3;
			defaultSlots[5] = 2;
			defaultSlots[6] = 2;
			defaultSlots[7] = 1;
			defaultSlots[8] = 1;
		}
		return defaultSlots;
	}
}
