package timberwolfgalaxy.coremod.proxy;

import baubles.api.render.IRenderBauble.RenderType;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import timberwolfgalaxy.coremod.client.gui.BondableGui;
import timberwolfgalaxy.coremod.entity.EntityBondable;

public class CommonProxy {
	public void registerItemRenderer(Item item, int meta, String id) {
	}
	public void registerVariantRenderer(Item item, int meta, String filename, String id) {
	}
	public void registerEntityRenders() {
	}
	public void processInteractHelper(EntityBondable entity) {
	}
	public void onDragonbornRender(ItemStack stack, EntityPlayer player, RenderType renderType, float fl) {
	}
}
