package timberwolfgalaxy.coremod.objects.items.spells;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.entity.EntitySpellFireball;

public class SpellFireball extends Spell {

	public SpellFireball() {
		this.color = "§C";
		this.name = "Fireball";
	}

	@Override
	public void cast(EntityPlayer player, World world) {
		if (!world.isRemote) {
			EntitySpellFireball fireball2 = new EntitySpellFireball(world, player, 1, 1, 1);
			fireball2.setPosition(player.posX + player.getLookVec().x * 5, player.posY + player.getLookVec().y * 5,
					player.posZ + player.getLookVec().z * 5);
			fireball2.accelerationX = player.getLookVec().x * 0.1;
			fireball2.accelerationY = player.getLookVec().y * 0.1;
			fireball2.accelerationZ = player.getLookVec().z * 0.1;
			fireball2.explosionPower = 3;
			world.spawnEntity(fireball2);
		}
	}

}
