package timberwolfgalaxy.coremod.objects.blocks;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.BlockInit;
import timberwolfgalaxy.coremod.init.ItemInit;
import timberwolfgalaxy.coremod.util.IHasModel;
import timberwolfgalaxy.coremod.util.IMetaName;

public class BlockRadianOre extends Block implements IHasModel, IMetaName{
	
	private String name, dimension;

	public BlockRadianOre(String name, String dimension) {
		super(Material.IRON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.TWGBLOCKSTAB);
		this.setHardness(8.0F);
		this.setHarvestLevel("pickaxe", 4);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
		this.name = name;
		this.dimension = dimension;
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		return null;
	}
	
	@Override 
	public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune){
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		
		drops.add(new ItemStack(ItemInit.COIN_RADIAN, 1));
		
		return drops;
	}
}
