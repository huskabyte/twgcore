package timberwolfgalaxy.coremod.objects.items;

import net.minecraft.item.Item;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.ItemInit;
import timberwolfgalaxy.coremod.util.IHasModel;

public class ItemDragonbornAmulet extends Item implements IHasModel{
	
	public ItemDragonbornAmulet(String name){
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.TWGCOMBATTAB);
		
		ItemInit.ITEMS.add(this);
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
