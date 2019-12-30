package timberwolfgalaxy.coremod.util.handlers;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import timberwolfgalaxy.coremod.entity.EntityLabrador;
import timberwolfgalaxy.coremod.entity.render.RenderLabrador;

public class RenderHandler {
	public static void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityLabrador.class, new IRenderFactory<EntityLabrador>() {

			@Override
			public Render<? super EntityLabrador> createRenderFor(RenderManager manager) {
				return new RenderLabrador(manager);
			}
		
		});
	}
}
