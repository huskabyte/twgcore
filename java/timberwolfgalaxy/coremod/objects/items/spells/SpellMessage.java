package timberwolfgalaxy.coremod.objects.items.spells;

import java.util.ArrayList;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.objects.items.Wand;

public class SpellMessage extends Spell {

	public SpellMessage() {
		this.color = "§2";
		this.name = "Message";
	}

	@Override
	public void cast(EntityPlayer player, World world) {
		if(world.isRemote) {
			player.sendMessage(new TextComponentString(ChatFormatting.DARK_GREEN + "Yes!"));
		}
	}

}
