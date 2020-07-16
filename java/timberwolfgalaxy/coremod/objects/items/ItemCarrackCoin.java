package timberwolfgalaxy.coremod.objects.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.ItemInit;
import timberwolfgalaxy.coremod.util.IHasModel;

public class ItemCarrackCoin extends Item implements IHasModel{
	
	public ItemCarrackCoin(String name){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.TWGCURRENCYTAB);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}