package timberwolfgalaxy.coremod.util.handlers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.util.Reference;

public class ConfigHandler {
	public static Configuration config;
	
	public static void init(File file) {
		config = new Configuration(file);
		
		String category;
		
		
	}
	
	public static void RegisterConfig(FMLPreInitializationEvent event) {
		Main.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MODID);
		Main.config.mkdirs();
		init(new File(Main.config.getPath(), Reference.MODID + ".cfg"));
	}
}
