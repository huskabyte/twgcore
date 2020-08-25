package timberwolfgalaxy.coremod.objects.items.spelltomes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.Main;
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
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
