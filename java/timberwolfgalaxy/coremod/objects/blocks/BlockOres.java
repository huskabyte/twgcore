package timberwolfgalaxy.coremod.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.item.Item;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.BlockInit;
import timberwolfgalaxy.coremod.init.ItemInit;
import timberwolfgalaxy.coremod.objects.blocks.item.ItemBlockVariants;
import timberwolfgalaxy.coremod.util.IHasModel;
import timberwolfgalaxy.coremod.util.IMetaName;
import timberwolfgalaxy.coremod.util.handlers.EnumHandler;
import timberwolfgalaxy.coremod.util.handlers.EnumHandler.EnumType;

public class BlockOres extends Block implements IHasModel, IMetaName{
	
	public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class);
	
	private String name, dimension;

	public BlockOres(String name, String dimension) {
		super(Material.IRON);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.TWGBLOCKSTAB);
		this.setHardness(6.0F);
		this.setHarvestLevel("pickaxe", 3);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumType.ARILIUM));
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
		
		this.name = name;
		this.dimension = dimension;
	}

	@Override
	public void registerModels() {
		for(int i = 0; i < EnumHandler.EnumType.values().length; i++) {
			Main.proxy.registerVariantRenderer(this, i, "ore_" + this.dimension + EnumHandler.EnumType.values()[i].getName(), "inventory");
		}
	}

}
