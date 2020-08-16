package timberwolfgalaxy.coremod.objects.blocks.regen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.BlockInit;
import timberwolfgalaxy.coremod.util.IHasModel;
import timberwolfgalaxy.coremod.util.IMetaName;

public class RegenerativeOre extends RegenerativeBlock implements IHasModel, IMetaName{
	Block dropParent;
	int id;

	public RegenerativeOre(String name, Block dropParent, int id) {
		super(name, dropParent, id);
		this.dropParent = dropParent;
		BlockInit.ORES.add(this);
	}
	
	@Override
	protected RegenerativeBlock regenTo() {
		return null;
	}

	@Override
	protected RegenerativeBlock breakTo() {
		return (RegenerativeBlock) BlockInit.REGEN_STONE;
	}
	
	@Override
	protected Block dropParent() {
		return dropParent;
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return null;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

}
