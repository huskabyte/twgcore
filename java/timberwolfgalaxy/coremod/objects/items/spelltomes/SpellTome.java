package timberwolfgalaxy.coremod.objects.items.spelltomes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.capabilty.KnownSpellsProvider;
import timberwolfgalaxy.coremod.init.ItemInit;
import timberwolfgalaxy.coremod.util.IHasModel;

public class SpellTome extends Item implements IHasModel{
	int spell;
	
	public SpellTome(String name, int spell) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.TWGWANDSTAB);
		setMaxStackSize(1);
		ItemInit.ITEMS.add(this);
		this.spell = spell;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if(playerIn.getCapability(KnownSpellsProvider.KNOWN_SPELLS, null).learn(this.spell)) {
			playerIn.getCapability(KnownSpellsProvider.KNOWN_SPELLS, null).learn(this.spell);
			playerIn.getHeldItemMainhand().shrink(1);
		}else if(!playerIn.world.isRemote) {
			playerIn.sendMessage(new TextComponentString(TextFormatting.RED + "You know this spell already!"));
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
