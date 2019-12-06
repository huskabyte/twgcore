package timberwolfgalaxy.coremod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import timberwolfgalaxy.coremod.proxy.CommonProxy;
import timberwolfgalaxy.coremod.tabs.TWGBlocks;
import timberwolfgalaxy.coremod.tabs.TWGCombat;
import timberwolfgalaxy.coremod.tabs.TWGCurrency;
import timberwolfgalaxy.coremod.tabs.TWGMaterials;
import timberwolfgalaxy.coremod.tabs.TWGTools;
import timberwolfgalaxy.coremod.util.Reference;

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
		
	}
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}

}
