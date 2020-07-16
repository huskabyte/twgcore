package timberwolfgalaxy.coremod.objects.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.BlockInit;
import timberwolfgalaxy.coremod.init.ItemInit;
import timberwolfgalaxy.coremod.util.IHasModel;
import timberwolfgalaxy.coremod.util.IMetaName;

public class RegenerativeCobblestone extends Block implements IHasModel, IMetaName{
	public RegenerativeCobblestone(String name) {
		super(Material.ROCK);
		this.setCreativeTab(Main.TWGBLOCKSTAB);
		this.setUnlocalizedName(name);
		setRegistryName(name);
		this.setTickRandomly(true);
		
		this.setHarvestLevel("pickaxe", 0);
		this.setHardness(1.5F);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		
		drops.add(new ItemStack(Blocks.COBBLESTONE, 1));
		
		return drops;
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		worldIn.setBlockState(pos, BlockInit.REGEN_STONE.getDefaultState());
	}
	
	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(Blocks.COBBLESTONE, 1);
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
