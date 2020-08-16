package timberwolfgalaxy.coremod.objects.items.spells;

import java.awt.Color;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public abstract class Spell{
	protected TextFormatting color = TextFormatting.WHITE;
	protected String name;
	public abstract int slot();
	
	public abstract void cast(EntityPlayer player, World world);
	
	public String getName() {
		return this.name;
	}
	
	public void message(Spell s, EntityPlayer player) {
		if(!player.world.isRemote) {
			player.sendMessage(new TextComponentString(s.color+s.getName()+"!"));
		}
	}
	
	public abstract Color getColor();
}
