package timberwolfgalaxy.coremod.objects.items.spells;

import java.awt.Color;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class CantripLevitate extends Spell{
	
	public CantripLevitate() {
		this.color = TextFormatting.WHITE;
		this.name = "Levitate";
	}

	@Override
	public int slot() {
		return 0;
	}

	@Override
	public void cast(EntityPlayer player, World world) {
		player.addPotionEffect(new PotionEffect(MobEffects.LEVITATION, 100));
	}

	@Override
	public Color getColor() {
		return Color.WHITE;
	}

}
