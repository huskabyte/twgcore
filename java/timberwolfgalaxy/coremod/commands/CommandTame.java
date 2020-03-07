package timberwolfgalaxy.coremod.commands;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.server.permission.PermissionAPI;
import timberwolfgalaxy.coremod.entity.EntityBondable;
import timberwolfgalaxy.coremod.util.Reference;

public class CommandTame extends CommandBase{
	
	private final List<String> ALIASES = Lists.newArrayList(Reference.MODID, "tame");
	
	@Override
	public String getName() {
		return "tame";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		if(sender instanceof EntityPlayer) {
			return "tame <player> [entityUUID]";
		}
		return "tame can only be used by DEVELOPERS!";
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		if(sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender;
			if(!(player.getUniqueID().toString().equals("7ee7202a-3a2d-4978-a513-a6a1a623e6d8"))) {
				return PermissionAPI.hasPermission(player, "twgcore.developer");
			}
		}
		return true;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 1) {
			sender.sendMessage(new TextComponentString("Too few arguments.\n" + getUsage(sender)));
		}else if(!(sender instanceof EntityPlayer)) {
			sender.sendMessage(new TextComponentString("This command may be used only by DEVELOPERS!"));
		}else {
			EntityPlayer player = (EntityPlayer) sender;
			
			NBTTagCompound tag = player.getEntityData();
			if(tag.getString("entitySelected") == null) {
				sender.sendMessage(new TextComponentString("Select an entity first!"));
			}else {
				if(server.getPlayerList().getPlayerByUsername(args[0]) == null) {
            		sender.sendMessage(new TextComponentString("Invalid player!"));
            	}else {
            		UUID entityID = UUID.fromString(tag.getString("entitySelected"));
    				
   				 	for (Entity entity : player.world.loadedEntityList) {
   			            if (entity.getPersistentID().equals(entityID)) {
   			            	EntityBondable entityBondable = (EntityBondable) entity;
   			            	entityBondable.tame(server.getPlayerList().getPlayerByUsername(args[0]));
   			            	
   			            	tag.setString("Bonded", entityBondable.getName());
   			            	return;
   			            }
   				 	}
   				 	sender.sendMessage(new TextComponentString(TextFormatting.DARK_RED + "Invalid Entity Selected!"));
            	}
				
			}
		}
	}

}
