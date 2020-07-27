package timberwolfgalaxy.coremod.init;

import java.awt.Color;

import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import timberwolfgalaxy.coremod.potion.FirePotion;

public class PotionEffectInit {
	public static final Potion STRAIGHT_FIRE = new FirePotion("fire_potion", true, Color.GREEN.getRGB());
	
	public static void registerEffects() {
		ForgeRegistries.POTIONS.register(STRAIGHT_FIRE);
	}
}
