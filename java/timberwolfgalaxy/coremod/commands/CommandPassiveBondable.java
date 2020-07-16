package timberwolfgalaxy.coremod.commands;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.server.permission.PermissionAPI;
import timberwolfgalaxy.coremod.entity.EntityBondable;
import timberwolfgalaxy.coremod.init.EntityInit;
import timberwolfgalaxy.coremod.util.Reference;

public class CommandPassiveBondable extends CommandBase{
private final List<String> ALIASES = Lists.newArrayList(Reference.MODID, "pb");
	
	@Override
	public String getName() {
		return "passiveb";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		if(sender instanceof EntityPlayer) {
			return "passiveb";
		}
		return "'passive' can only be used by PLAYERS!";
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		if(sender instanceof EntityPlayer) {
			return true;
		}
		return false;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer) {
			for(Entity entity : ((EntityPlayer)sender).world.loadedEntityList) {
				if(entity instanceof EntityBondable) {
					if(((EntityBondable)entity).getOwner().equals((EntityPlayer)sender)) {
						entity.setEntityInvulnerable(false);
						entity.setDead();
					}
				}
			}
		}
		
	}
}
