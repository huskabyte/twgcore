package timberwolfgalaxy.coremod.objects.items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.ItemInit;
import timberwolfgalaxy.coremod.objects.items.spells.Spell;
import timberwolfgalaxy.coremod.objects.items.spells.SpellFireball;
import timberwolfgalaxy.coremod.util.IHasModel;

public class Wand extends Item implements IHasModel{
	
	public static final List<Spell> SPELLS = new ArrayList<Spell>();
	
	public Wand(String name){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.TWGWANDSTAB);
		
		addSpells();
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		if(entityLiving instanceof EntityPlayer) {
			cast(SPELLS.get(0), (EntityPlayer) entityLiving);
			return false;
		}
		return super.onEntitySwing(entityLiving, stack);
	}
	
	@Override 
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	private static void cast(Spell s, EntityPlayer player){
		s.message(s, player);
		s.cast(player, player.world);
	}
	
	private static void addSpells() {
		SPELLS.add(new SpellFireball());
	}
	
	public void registerSpell(Spell s) {
		SPELLS.add(s);
	}
	
	@Override
	public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {
		return false;
	}
	
	private int getSpellByName(String spellname) {
		for(int i = 0; i < SPELLS.size(); i++) {
			if(SPELLS.get(i).getName().equals(spellname)) {
				return i;
			}
		}
		return 0;
	}
}
