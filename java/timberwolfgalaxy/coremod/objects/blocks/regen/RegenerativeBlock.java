package timberwolfgalaxy.coremod.objects.blocks.regen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.oredict.OreDictionary;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.BlockInit;
import timberwolfgalaxy.coremod.init.ItemInit;

public abstract class RegenerativeBlock extends Block {
	
	int oreId;
	public static final IProperty<Integer> ore = PropertyInteger.create("ore", 0, getOreNumber()+1);

	public RegenerativeBlock(String name) {
		super(Material.ROCK);
		this.setCreativeTab(Main.TWGBLOCKSTAB);
		this.setUnlocalizedName(name);
		setRegistryName(name);
		this.setTickRandomly(true);

		this.setHarvestLevel(dropParent().getHarvestTool(dropParent().getDefaultState()), dropParent().getHarvestLevel(dropParent().getDefaultState()));
		
		try {
			this.setHardness(ReflectionHelper.findField(Block.class, "blockHardness", "field_149782_v").getFloat(dropParent()));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		setRegenDefaultState();
	}
	
	public RegenerativeBlock(String name, Block dropParent, int id) {
		super(Material.ROCK);
		this.oreId = id;
		this.setCreativeTab(Main.TWGBLOCKSTAB);
		this.setUnlocalizedName(name);
		setRegistryName(name);
		this.setTickRandomly(true);

		this.setHarvestLevel(dropParent.getHarvestTool(dropParent.getDefaultState()), dropParent.getHarvestLevel(dropParent.getDefaultState()));
		
		try {
			this.setHardness(ReflectionHelper.findField(Block.class, "blockHardness", "field_149782_v").getFloat(dropParent));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		setRegenDefaultState(id);
	}

	protected void setRegenDefaultState() {
		this.setDefaultState(this.blockState.getBaseState().withProperty(ore, 0));
	}
	
	protected void setRegenDefaultState(int id) {
		this.setDefaultState(this.blockState.getBaseState().withProperty(ore, id));
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		regenerate(worldIn, pos, state, rand);
	}

	/**
	 * Regenerates a block, eg. cobblestone to stone. Set to null if the next step
	 * the block is currently in the ore form.
	 */
	protected abstract RegenerativeBlock regenTo();

	/**
	 * Sets the block created when this one is broken, eg. stone to cobblestone. DO
	 * NOT SET TO NULL. SET TO BEDROCK IF BEDROCK.
	 */
	protected abstract RegenerativeBlock breakTo();
	
	/**
	 * Set this to the block you are mimicing.
	 */
	protected abstract Block dropParent();

	protected void regenerate(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if(worldIn.getBlockState(pos).getBlock() instanceof RegenerativeBlock) {
			if (regenTo() != null) {
				worldIn.setBlockState(pos, regenTo().getDefaultState().withProperty(ore, worldIn.getBlockState(pos).getValue(ore)));
			}
		}else {
			System.out.println("Tried to regenerate a non-regenerative block!");
		}
	}
	
	public void degenerate(BlockEvent.BreakEvent event) {
		event.getWorld().setBlockState(event.getPos(), breakTo().getDefaultState().withProperty(ore, event.getWorld().getBlockState(event.getPos()).getValue(ore)));
	}

	private static int getOreNumber() {
		int i = 0;
		String[] oreDictEntries = OreDictionary.getOreNames();
		for (String entry : oreDictEntries) {
			if (entry.startsWith("ore")) {
				i++;
			}
		}
		return i;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
			int fortune) {
		dropParent().getDrops(drops, world, pos, dropParent().getDefaultState(), fortune);
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, ore);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		if (state.getPropertyKeys().isEmpty()) {
			return 0;
		}else {
			return state.getValue(ore);
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(ore, meta);
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		return dropParent().getExpDrop(state, world, pos, fortune);
	}
}
