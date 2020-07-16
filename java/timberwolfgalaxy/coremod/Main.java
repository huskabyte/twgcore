package timberwolfgalaxy.coremod;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;
import timberwolfgalaxy.coremod.proxy.CommonProxy;
import timberwolfgalaxy.coremod.tabs.TWGBlocks;
import timberwolfgalaxy.coremod.tabs.TWGCombat;
import timberwolfgalaxy.coremod.tabs.TWGCurrency;
import timberwolfgalaxy.coremod.tabs.TWGMaterials;
import timberwolfgalaxy.coremod.tabs.TWGTools;
import timberwolfgalaxy.coremod.tabs.TWGWands;
import timberwolfgalaxy.coremod.util.Reference;
import timberwolfgalaxy.coremod.util.handlers.BondablePacketHandler;
import timberwolfgalaxy.coremod.util.handlers.RegistryHandler;
import timberwolfgalaxy.coremod.util.handlers.SwitchPacketHandler;
import timberwolfgalaxy.coremod.util.handlers.TWGEventHandler;
import timberwolfgalaxy.coremod.util.packets.PacketBondableSwitch;
import timberwolfgalaxy.coremod.util.packets.PacketBondableTricks;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	public static File config;
	
	@Instance
	public static Main instance;
	
	public static final CreativeTabs TWGBLOCKSTAB = new TWGBlocks("twgblockstab");
	public static final CreativeTabs TWGCURRENCYTAB = new TWGCurrency("twgcurrencytab");
	public static final CreativeTabs TWGTOOLSTAB = new TWGTools("twgtoolstab");
	public static final CreativeTabs TWGCOMBATTAB = new TWGCombat("twgcombattab");
	public static final CreativeTabs TWGMATERIALTAB = new TWGMaterials("twgmaterialtab");
	public static final CreativeTabs TWGWANDSTAB = new TWGWands("twgwandstab");
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		RegistryHandler.preInitRegistries();
		proxy.registerEntityRenders();
		FMLCommonHandler.instance().bus().register(new TWGEventHandler());
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
		PermissionAPI.registerNode("twgcore.developer", DefaultPermissionLevel.NONE, "Developer - Testers and developers. CAN BREAK THINGS.");
		
		PermissionAPI.registerNode("twgcore.animal.admin", DefaultPermissionLevel.NONE, "Animal Administrators - usually co-owners and bonded admins");
		
		PermissionAPI.registerNode("twgcore.bonded", DefaultPermissionLevel.NONE, "Bonded to dog. Allows access to EntityLabrador");
		
		PermissionAPI.registerNode("twgcore.bonded.dog", DefaultPermissionLevel.NONE, "Bonded to dog. Allows access to EntityLabrador");
		
		PermissionAPI.registerNode("twgcore.bonded.dog.trick0", DefaultPermissionLevel.NONE, "Labrador - SIT - Useless w/o twgcore.bonded.dog");
		PermissionAPI.registerNode("twgcore.bonded.dog.trick1", DefaultPermissionLevel.NONE, "Labrador - STAND - Useless w/o twgcore.bonded.dog");
		PermissionAPI.registerNode("twgcore.bonded.dog.trick2", DefaultPermissionLevel.NONE, "Labrador - DOWN - Useless w/o twgcore.bonded.dog");
		PermissionAPI.registerNode("twgcore.bonded.dog.trick3", DefaultPermissionLevel.NONE, "Labrador - BEG - Useless w/o twgcore.bonded.dog");
		
		PermissionAPI.registerNode("twgcore.bonded.wolf", DefaultPermissionLevel.NONE, "Bonded to wolf. Allows access to EntityWolf");
		
		PermissionAPI.registerNode("twgcore.bonded.wolf.trick0", DefaultPermissionLevel.NONE, "Wolf - SIT - Useless w/o twgcore.bonded.wolf");
		PermissionAPI.registerNode("twgcore.bonded.wolf.trick1", DefaultPermissionLevel.NONE, "Wolf - STAND - Useless w/o twgcore.bonded.wolf");
		PermissionAPI.registerNode("twgcore.bonded.wolf.trick2", DefaultPermissionLevel.NONE, "Wolf - DOWN - Useless w/o twgcore.bonded.wolf");
		PermissionAPI.registerNode("twgcore.bonded.wolf.trick3", DefaultPermissionLevel.NONE, "Wolf - BEG - Useless w/o twgcore.bonded.wolf");
		
		PermissionAPI.registerNode("twgcore.bonded.wolfdog", DefaultPermissionLevel.NONE, "Bonded to wolfdog. Allows access to EntityWolfdog");
		
		PermissionAPI.registerNode("twgcore.bonded.wolfdog.trick0", DefaultPermissionLevel.NONE, "Wolfdog - SIT - Useless w/o twgcore.bonded.wolfdog");
		PermissionAPI.registerNode("twgcore.bonded.wolfdog.trick1", DefaultPermissionLevel.NONE, "Wolfdog - STAND - Useless w/o twgcore.bonded.wolfdog");
		PermissionAPI.registerNode("twgcore.bonded.wolfdog.trick2", DefaultPermissionLevel.NONE, "Wolfdog - DOWN - Useless w/o twgcore.bonded.wolfdog");
		PermissionAPI.registerNode("twgcore.bonded.wolfdog.trick3", DefaultPermissionLevel.NONE, "Wolfdog - BEG - Useless w/o twgcore.bonded.wolfdog");
		
		PermissionAPI.registerNode("twgcore.bonded.penguin", DefaultPermissionLevel.NONE, "Bonded to wolfdog. Allows access to EntityWolfdog");
		
		PermissionAPI.registerNode("twgcore.bonded.penguin.trick0", DefaultPermissionLevel.NONE, "Wolfdog - SIT - Useless w/o twgcore.bonded.wolfdog");
		PermissionAPI.registerNode("twgcore.bonded.penguin.trick1", DefaultPermissionLevel.NONE, "Wolfdog - STAND - Useless w/o twgcore.bonded.wolfdog");
		PermissionAPI.registerNode("twgcore.bonded.penguin.trick2", DefaultPermissionLevel.NONE, "Wolfdog - DOWN - Useless w/o twgcore.bonded.wolfdog");
		PermissionAPI.registerNode("twgcore.bonded.penguin.trick3", DefaultPermissionLevel.NONE, "Wolfdog - BEG - Useless w/o twgcore.bonded.wolfdog");
		
		BondablePacketHandler.INSTANCE.registerMessage(BondablePacketHandler.class, PacketBondableTricks.class, 0, Side.SERVER);
		SwitchPacketHandler.INSTANCE.registerMessage(SwitchPacketHandler.class, PacketBondableSwitch.class, 0, Side.SERVER);
		
		RegistryHandler.InitRegistries();
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@EventHandler
	public static void serverInit(FMLServerStartingEvent event){
		RegistryHandler.serverRegistries(event);
	}
}
