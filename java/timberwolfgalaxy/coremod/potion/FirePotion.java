package timberwolfgalaxy.coremod.potion;

import net.minecraft.potion.Potion;
import timberwolfgalaxy.coremod.util.Reference;

public class FirePotion extends Potion {

	public FirePotion(String name, boolean isBadEffectIn, int liquidColorIn) {
		super(isBadEffectIn, liquidColorIn);
		setPotionName("effect."+name);
		setRegistryName(Reference.MODID+":"+name);
	}
	
	@Override
	public boolean hasStatusIcon() {
		return false;
	}

}
