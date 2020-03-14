package timberwolfgalaxy.coremod.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import timberwolfgalaxy.coremod.entity.EntityLabrador;
import timberwolfgalaxy.coremod.entity.EntityWolf;
import timberwolfgalaxy.coremod.entity.model.ModelWolf;
import timberwolfgalaxy.coremod.util.Reference;

public class RenderWolf extends RenderLiving<EntityWolf>{
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/wolf.png");

	public RenderWolf(RenderManager manager) {
		super(manager, new ModelWolf(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityWolf entity) {
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityWolf entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
