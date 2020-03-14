package timberwolfgalaxy.coremod.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import timberwolfgalaxy.coremod.entity.EntityWolfdog;
import timberwolfgalaxy.coremod.entity.model.ModelWolfdog;
import timberwolfgalaxy.coremod.util.Reference;

public class RenderWolfdog extends RenderLiving<EntityWolfdog>{
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/wolfdog.png");

	public RenderWolfdog(RenderManager manager) {
		super(manager, new ModelWolfdog(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityWolfdog entity) {
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityWolfdog entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
