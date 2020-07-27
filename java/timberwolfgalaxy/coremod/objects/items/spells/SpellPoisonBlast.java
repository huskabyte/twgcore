package timberwolfgalaxy.coremod.objects.items.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.entity.EntitySpellPoisonBlast;

public class SpellPoisonBlast extends Spell {

	public SpellPoisonBlast() {
		this.color = "&2";
		this.name = "Poison Blast";
	}

	@Override
	public void cast(EntityPlayer player, World world) {
		if(!world.isRemote) {
			EntitySpellPoisonBlast fireball2 = new EntitySpellPoisonBlast(world, player, 1, 1, 1);
			fireball2.setPosition(player.posX + player.getLookVec().x * 5, player.posY + player.getLookVec().y * 5,
					player.posZ + player.getLookVec().z * 5);
			fireball2.accelerationX = player.getLookVec().x * 0.1;
			fireball2.accelerationY = player.getLookVec().y * 0.1;
			fireball2.accelerationZ = player.getLookVec().z * 0.1;
			fireball2.explosionPower = 3;
			world.spawnEntity(fireball2);
		}
	}

	@Override
	public int slot() {
		return 2;
	}

}
