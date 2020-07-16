package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import timberwolfgalaxy.coremod.entity.EntityLabrador;
import timberwolfgalaxy.coremod.entity.EntityPenguin;
import timberwolfgalaxy.coremod.entity.EntityWolf;
import timberwolfgalaxy.coremod.entity.EntityWolfdog;
import timberwolfgalaxy.coremod.entity.render.RenderLabrador;
import timberwolfgalaxy.coremod.entity.render.RenderPenguin;
import timberwolfgalaxy.coremod.entity.render.RenderWolf;
import timberwolfgalaxy.coremod.entity.render.RenderWolfdog;

public class RenderHandler {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLabrador.class, new IRenderFactory<EntityLabrador>() {

			@Override
			public Render<? super EntityLabrador> createRenderFor(RenderManager manager) {
				return new RenderLabrador(manager);
			}
		
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityWolf.class, new IRenderFactory<EntityWolf>() {

			@Override
			public Render<? super EntityWolf> createRenderFor(RenderManager manager) {
				return new RenderWolf(manager);
			}
		
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityWolfdog.class, new IRenderFactory<EntityWolfdog>() {

			@Override
			public Render<? super EntityWolfdog> createRenderFor(RenderManager manager) {
				return new RenderWolfdog(manager);
			}
		
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPenguin.class, new IRenderFactory<EntityPenguin>() {

			@Override
			public Render<? super EntityPenguin> createRenderFor(RenderManager manager) {
				return new RenderPenguin(manager);
			}
		
		});
	}
}
