package timberwolfgalaxy.coremod.proxy;

import baubles.api.render.IRenderBauble.RenderType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import timberwolfgalaxy.coremod.client.gui.BondableGui;
import timberwolfgalaxy.coremod.entity.EntityBondable;
import timberwolfgalaxy.coremod.util.Reference;
import timberwolfgalaxy.coremod.util.handlers.RenderHandler;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	@Override
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(Reference.MODID, filename), id));
	}
	
	@Override
	public void registerEntityRenders() {
		RenderHandler.registerEntityRenders();
	}
	public void processInteractHelper(EntityBondable entity) {
		Minecraft.getMinecraft().displayGuiScreen(new BondableGui(entity));
	}
	
	@Override
	public void onDragonbornRender(ItemStack stack, EntityPlayer player, RenderType renderType, float fl) {
		if(renderType==RenderType.BODY) {
			GlStateManager.popMatrix();
			GlStateManager.translate(0.0, -1.25, -0.52);
			GlStateManager.scale(0.45, 0.45, 0.45);
			GlStateManager.rotate(180F, 1F, 0F, 0F);
			GlStateManager.translate(0F, -3.2F, -0.85F);
			if(player.isSneaking()){
				GlStateManager.translate(0F, -0.2F, 0F);
				GlStateManager.rotate(90F / (float) Math.PI, 1.0F, 0.0F, 0.0F);
			}
			Minecraft.getMinecraft().getItemRenderer().renderItem(player, stack, TransformType.HEAD);
			GlStateManager.pushMatrix();
		}
	}
}
