package timberwolfgalaxy.coremod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import timberwolfgalaxy.coremod.init.ItemInit;

public class TWGCurrency extends CreativeTabs{

	public TWGCurrency(String label) {
		super(label);
		this.setBackgroundImageName("twgtabs.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemInit.COIN_RADIAN);
	}

}
