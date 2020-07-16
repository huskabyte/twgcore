package timberwolfgalaxy.coremod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import timberwolfgalaxy.coremod.objects.blocks.BlockAriliumOre;
import timberwolfgalaxy.coremod.objects.blocks.BlockCarrackOre;
import timberwolfgalaxy.coremod.objects.blocks.BlockRadianOre;
import timberwolfgalaxy.coremod.objects.blocks.BlockSilverOre;
import timberwolfgalaxy.coremod.objects.blocks.RegenerativeBedrock;
import timberwolfgalaxy.coremod.objects.blocks.RegenerativeCobblestone;
import timberwolfgalaxy.coremod.objects.blocks.RegenerativeStone;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ORE_CARRACK = new BlockCarrackOre("ore_carrack", "overworld");
	public static final Block ORE_SILVER = new BlockSilverOre("ore_silver", "overworld");
	public static final Block ORE_RADIAN = new BlockRadianOre("ore_radian", "overworld");
	public static final Block ORE_ARILIUM = new BlockAriliumOre("ore_arilium", "overworld");
	
	public static final Block REGEN_STONE = new RegenerativeStone("regen_stone");
	public static final Block REGEN_COBBLE = new RegenerativeCobblestone("regen_cobble");
	public static final Block REGEN_BEDROCK = new RegenerativeBedrock("regen_bedrock");
	
}
