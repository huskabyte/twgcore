package timberwolfgalaxy.coremod.objects.items.spells;

import java.awt.Color;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class SpellHealingWord extends Spell{
	
	public SpellHealingWord() {
		this.color = TextFormatting.LIGHT_PURPLE;
		this.name = "Healing Word";
	}

	@Override
	public int slot() {
		return 1;
	}

	@Override
	public void cast(EntityPlayer player, World world) {
		player.heal(5F);
		player.getFoodStats().setFoodLevel(20);
	}

	@Override
	public Color getColor() {
		return Color.PINK;
	}

}
