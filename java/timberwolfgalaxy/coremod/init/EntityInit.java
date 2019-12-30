package timberwolfgalaxy.coremod.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.entity.EntityLabrador;
import timberwolfgalaxy.coremod.util.Reference;

public class EntityInit {
	
	public static void registerEntities() {
		registerEntity("labrador", EntityLabrador.class, Reference.ENTITY_DOG, 50, 16772864, 16299520);
	}
	
	private static void registerEntity(String name, Class<? extends Entity> entityClass, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entityClass, name, id, Main.instance, range, 1, true, color1, color2);
	}
	private static void registerEntity(String name, Class<? extends Entity> entityClass, int id, int range) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entityClass, name, id, Main.instance, range, 1, true);
	}
}
