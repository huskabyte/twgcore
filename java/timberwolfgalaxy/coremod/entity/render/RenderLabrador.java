package timberwolfgalaxy.coremod.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import timberwolfgalaxy.coremod.entity.EntityLabrador;
import timberwolfgalaxy.coremod.entity.model.ModelLabrador;
import timberwolfgalaxy.coremod.util.Reference;

public class RenderLabrador extends RenderLiving<EntityLabrador>{
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/labrador.png");

	public RenderLabrador(RenderManager manager) {
		super(manager, new ModelLabrador(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLabrador entity) {
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityLabrador entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
