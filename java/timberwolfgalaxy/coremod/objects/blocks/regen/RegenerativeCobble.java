package timberwolfgalaxy.coremod.objects.blocks.regen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.BlockInit;
import timberwolfgalaxy.coremod.util.IHasModel;
import timberwolfgalaxy.coremod.util.IMetaName;

public class RegenerativeCobble extends RegenerativeBlock implements IHasModel, IMetaName{

	public RegenerativeCobble(String name) {
		super(name);
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return null;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");	
	}

	@Override
	protected RegenerativeBlock regenTo() {
		return (RegenerativeBlock) BlockInit.REGEN_STONE;
	}

	@Override
	protected RegenerativeBlock breakTo() {
		return (RegenerativeBlock) BlockInit.REGEN_BEDROCK;
	}

	@Override
	protected Block dropParent() {
		return Blocks.COBBLESTONE;
	}
	
}
