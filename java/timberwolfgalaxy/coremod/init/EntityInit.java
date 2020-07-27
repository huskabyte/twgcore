package timberwolfgalaxy.coremod.init;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.entity.EntityBondable;
import timberwolfgalaxy.coremod.entity.EntityLabrador;
import timberwolfgalaxy.coremod.entity.EntityPenguin;
import timberwolfgalaxy.coremod.entity.EntityWolf;
import timberwolfgalaxy.coremod.entity.EntityWolfdog;
import timberwolfgalaxy.coremod.util.Reference;

public class EntityInit {
	
	public static final ArrayList<String> bondableIdList = new ArrayList<String>();
	public static final HashMap<String, Class<? extends EntityBondable>> bondableIdMap = new HashMap<String, Class<? extends EntityBondable>>();
	
	public static final int AQUATIC_CRATE = 0;
	public static final int COMMON_CRATE = 1;
	public static final int UNCOMMON_CRATE = 2;
	public static final int RARE_CRATE = 3;
	public static final int EPIC_CRATE = 4;
	public static final int LEGENDARY_CRATE = 5;
	public static final int MYTHIC_CRATE = 6;
	public static final int GREAT_BEAST_CRATE = 7;
	
	public static void registerEntities() {
		registerEntity("dog", EntityLabrador.class, Reference.ENTITY_DOG, Integer.MAX_VALUE, UNCOMMON_CRATE);
		registerEntity("wolf", EntityWolf.class, Reference.ENTITY_WOLF, Integer.MAX_VALUE, EPIC_CRATE);
		registerEntity("wolfdog", EntityWolfdog.class, Reference.ENTITY_WOLFDOG, Integer.MAX_VALUE, RARE_CRATE);
		registerEntity("penguin", EntityPenguin.class, Reference.ENTITY_PENGUIN, Integer.MAX_VALUE, AQUATIC_CRATE);
	}
	
	private static void registerEntity(String name, Class<? extends EntityBondable> entityClass, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entityClass, name, id, Main.instance, range, 1, true, color1, color2);
		bondableIdList.add(name);
		bondableIdMap.put(name, entityClass);
	}
	private static void registerEntity(String name, Class<? extends EntityBondable> entityClass, int id, int range, int crate) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entityClass, name, id, Main.instance, range, 1, true);
		bondableIdList.add(name);
		bondableIdMap.put(name, entityClass);
	}
}
