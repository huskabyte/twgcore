package timberwolfgalaxy.coremod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;
import timberwolfgalaxy.coremod.proxy.CommonProxy;
import timberwolfgalaxy.coremod.tabs.TWGBlocks;
import timberwolfgalaxy.coremod.tabs.TWGCombat;
import timberwolfgalaxy.coremod.tabs.TWGCurrency;
import timberwolfgalaxy.coremod.tabs.TWGMaterials;
import timberwolfgalaxy.coremod.tabs.TWGTools;
import timberwolfgalaxy.coremod.util.Reference;
import timberwolfgalaxy.coremod.util.handlers.RegistryHandler;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	@Instance
	public static Main instance;
	
	public static final CreativeTabs TWGBLOCKSTAB = new TWGBlocks("twgblockstab");
	public static final CreativeTabs TWGCURRENCYTAB = new TWGCurrency("twgcurrencytab");
	public static final CreativeTabs TWGTOOLSTAB = new TWGTools("twgtoolstab");
	public static final CreativeTabs TWGCOMBATTAB = new TWGCombat("twgcombattab");
	public static final CreativeTabs TWGMATERIALTAB = new TWGMaterials("twgmaterialtab");
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		RegistryHandler.preInitRegistries();
		proxy.registerEntityRenders();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		PermissionAPI.registerNode("twgcore.animal.admin", DefaultPermissionLevel.NONE, "Animal Administrators - usually co-owners and bonded admins");
		PermissionAPI.registerNode("twgcore.bonded.dog", DefaultPermissionLevel.NONE, "Bonded to dog. Allows access to EntityLabrador");
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event) {
		RegistryHandler.serverRegistries(event);
	}
}
