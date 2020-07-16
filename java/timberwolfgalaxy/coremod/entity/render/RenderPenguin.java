package timberwolfgalaxy.coremod.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import timberwolfgalaxy.coremod.entity.EntityPenguin;
import timberwolfgalaxy.coremod.entity.model.ModelPenguin;
import timberwolfgalaxy.coremod.util.Reference;

public class RenderPenguin extends RenderLiving<EntityPenguin>{
	
	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MODID + ":textures/entity/penguin.png");

	public RenderPenguin(RenderManager manager) {
		super(manager, new ModelPenguin(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPenguin entity) {
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityPenguin entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}