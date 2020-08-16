package timberwolfgalaxy.coremod.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import timberwolfgalaxy.coremod.objects.blocks.BlockAriliumOre;
import timberwolfgalaxy.coremod.objects.blocks.BlockCarrackOre;
import timberwolfgalaxy.coremod.objects.blocks.BlockRadianOre;
import timberwolfgalaxy.coremod.objects.blocks.BlockSilverOre;
import timberwolfgalaxy.coremod.objects.blocks.regen.RegenerativeBedrock;
import timberwolfgalaxy.coremod.objects.blocks.regen.RegenerativeCobble;
import timberwolfgalaxy.coremod.objects.blocks.regen.RegenerativeOre;
import timberwolfgalaxy.coremod.objects.blocks.regen.RegenerativeStone;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	public static final ArrayList<Block> ORES = new ArrayList<Block>();
	
	public static final Block ORE_CARRACK = new BlockCarrackOre("ore_carrack", "overworld");
	public static final Block ORE_SILVER = new BlockSilverOre("ore_silver", "overworld");
	public static final Block ORE_RADIAN = new BlockRadianOre("ore_radian", "overworld");
	public static final Block ORE_ARILIUM = new BlockAriliumOre("ore_arilium", "overworld");
	
	public static final Block REGEN_STONE = new RegenerativeStone("regen_stone");
	public static final Block REGEN_COBBLE = new RegenerativeCobble("regen_cobble");
	public static final Block REGEN_BEDROCK = new RegenerativeBedrock("regen_bedrock");
	
	public static final Block REGEN_COAL = new RegenerativeOre("regen_coal", Blocks.COAL_ORE, 1);
	public static final Block REGEN_IRON = new RegenerativeOre("regen_iron", Blocks.IRON_ORE, 2);
	public static final Block REGEN_GOLD = new RegenerativeOre("regen_gold", Blocks.GOLD_ORE, 3);
	public static final Block REGEN_LAPIS = new RegenerativeOre("regen_lapis", Blocks.LAPIS_ORE, 4);
	public static final Block REGEN_REDSTONE = new RegenerativeOre("regen_redstone", Blocks.REDSTONE_ORE, 5);
	public static final Block REGEN_DIAMOND = new RegenerativeOre("regen_diamond", Blocks.DIAMOND_ORE, 6);
	public static final Block REGEN_EMERALD = new RegenerativeOre("regen_emerald", Blocks.EMERALD_ORE, 7);
	public static final Block REGEN_ARILIUM = new RegenerativeOre("regen_arilium", ORE_ARILIUM, 8);
	public static final Block REGEN_CARRACK = new RegenerativeOre("regen_carrack", ORE_CARRACK, 9);
}
