package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.commands.CommandLearn;
import timberwolfgalaxy.coremod.commands.CommandTame;
import timberwolfgalaxy.coremod.commands.CommandUnlearn;
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
	}
	
	public static void serverRegistries(FMLServerStartingEvent event) {
		
		event.registerServerCommand(new CommandTame());
		event.registerServerCommand(new CommandLearn());
		event.registerServerCommand(new CommandUnlearn());
	}
	
}
