package timberwolfgalaxy.coremod.objects.items.baubles.amulets;

import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import baubles.api.cap.IBaublesItemHandler;
import baubles.api.render.IRenderBauble;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.ItemInit;
import timberwolfgalaxy.coremod.util.IHasModel;

public class ItemWolfAmulet extends Item implements IHasModel, IBauble, IRenderBauble{
	
	public ItemWolfAmulet(String name){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.TWGCOMBATTAB);
		setMaxStackSize(1);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> list) {
		if (this.isInCreativeTab(tab)) {
			list.add(new ItemStack(this, 1, 0));
		}
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		if(!world.isRemote) { 
			IBaublesItemHandler baubles = BaublesApi.getBaublesHandler(player);
			for(int i = 0; i < baubles.getSlots(); i++) 
				if((baubles.getStackInSlot(i) == null || baubles.getStackInSlot(i).isEmpty()) && baubles.isItemValidForSlot(i, player.getHeldItem(hand), player)) {
					baubles.setStackInSlot(i, player.getHeldItem(hand).copy());
					if(!player.capabilities.isCreativeMode){
						player.inventory.setInventorySlotContents(player.inventory.currentItem, ItemStack.EMPTY);
					}
					onEquipped(player.getHeldItem(hand), player);
					break;
				}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.getHeldItem(hand));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.COMMON;
	}

	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		return BaubleType.AMULET;
	}

	@Override
	public void onPlayerBaubleRender(ItemStack stack, EntityPlayer player, RenderType renderType, float fl) {
		Main.proxy.onWolfRender(stack, player, renderType, fl);
	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if(!player.isPotionActive(MobEffects.HEALTH_BOOST)) {
			player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, Integer.MAX_VALUE, 0, false, false));
		}
	}
	
	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		if(player.isPotionActive(MobEffects.HEALTH_BOOST)) {
			player.removePotionEffect(MobEffects.HEALTH_BOOST);
		}
	}
}
