package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import timberwolfgalaxy.coremod.commands.CommandLevelUp;
import timberwolfgalaxy.coremod.commands.CommandPassiveBondable;
import timberwolfgalaxy.coremod.commands.CommandSummonBondable;
import timberwolfgalaxy.coremod.commands.CommandTame;
import timberwolfgalaxy.coremod.init.BlockInit;
import timberwolfgalaxy.coremod.init.EntityInit;
import timberwolfgalaxy.coremod.init.ItemInit;
import timberwolfgalaxy.coremod.util.IHasModel;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
	}
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ItemInit.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
			
		}
		for(Block block : BlockInit.BLOCKS) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
	}
	
	public static void preInitRegistries() {
		EntityInit.registerEntities();
	}
	
	public static void InitRegistries() {
		OreDictionary.registerOre("oreCarrack", new ItemStack(BlockInit.ORE_CARRACK));
		OreDictionary.registerOre("oreSilver", new ItemStack(BlockInit.ORE_SILVER));
		OreDictionary.registerOre("oreRadian", new ItemStack(BlockInit.ORE_RADIAN));
		OreDictionary.registerOre("oreArilium", new ItemStack(BlockInit.ORE_ARILIUM));
		GameRegistry.addSmelting(BlockInit.ORE_ARILIUM, new ItemStack(ItemInit.INGOT_ARILIUM, 1), 1.5f);
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandTame());
		event.registerServerCommand(new CommandSummonBondable());
		event.registerServerCommand(new CommandPassiveBondable());
		event.registerServerCommand(new CommandLevelUp());
	}
	
}
