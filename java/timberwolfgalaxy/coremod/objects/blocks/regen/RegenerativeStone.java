package timberwolfgalaxy.coremod.objects.blocks.regen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.BlockInit;
import timberwolfgalaxy.coremod.util.IHasModel;
import timberwolfgalaxy.coremod.util.IMetaName;

public class RegenerativeStone extends RegenerativeBlock implements IHasModel, IMetaName{

	public RegenerativeStone(String name) {
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
		return this;
	}
	
	protected void regenerate(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(worldIn.getBlockState(pos).getBlock() instanceof RegenerativeBlock) {
			if (worldIn.getBlockState(pos).getValue(ore) > 0) {
				worldIn.setBlockState(pos, BlockInit.ORES.get(worldIn.getBlockState(pos).getValue(ore)-1).getDefaultState().withProperty(ore, worldIn.getBlockState(pos).getValue(ore)));
			}
		}
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		regenerate(worldIn, pos, state, rand);
	}

	@Override
	protected RegenerativeBlock breakTo() {
		return (RegenerativeBlock) BlockInit.REGEN_COBBLE;
	}

	@Override
	protected Block dropParent() {
		return Blocks.STONE;
	}
}
