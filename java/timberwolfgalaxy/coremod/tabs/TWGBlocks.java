package timberwolfgalaxy.coremod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import timberwolfgalaxy.coremod.init.BlockInit;
import timberwolfgalaxy.coremod.init.ItemInit;

public class TWGBlocks extends CreativeTabs{

	public TWGBlocks(String label) {
		super(label);
		this.setBackgroundImageName("twgtabs.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(BlockInit.ORE_ARILIUM));
	}

}
