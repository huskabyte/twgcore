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

public class CommandLearn extends CommandBase{
	
	private final List<String> ALIASES = Lists.newArrayList(Reference.MODID, "learn");
	
	@Override
	public String getName() {
		return "learn";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		if(sender instanceof EntityPlayer) {
			return "learn <trick#> [player]";
		}
		return "learn <trick#> <player>";
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		if(sender instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) sender;
			if(!(player.getUniqueID().toString().equals("7ee7202a-3a2d-4978-a513-a6a1a623e6d8"))) {
				return PermissionAPI.hasPermission(player, "twgcore.animal.admin");
			}
		}
		return true;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 1) {
			sender.sendMessage(new TextComponentString("Too few arguments.\n" + getUsage(sender)));
		}else if(!(sender instanceof EntityPlayer)) {
			if (args.length < 2) {
				sender.sendMessage(new TextComponentString("Too few arguments.\n" + getUsage(sender)));
			}else if(server.getPlayerList().getPlayerByUsername(args[1]) == null) {
        		sender.sendMessage(new TextComponentString("Invalid player!"));
			}
		}
		else {
			EntityPlayer player = (EntityPlayer) sender;
			for (Entity entity : player.world.loadedEntityList) {
		            if (entity instanceof EntityBondable) {
		            	EntityBondable entityBondable = (EntityBondable) entity;
		            	if(args.length < 2) {
		            			if(entityBondable.getOwner().equals(player)) {
			            		entityBondable.learn(Integer.parseInt(args[0]));
			            }else if(server.getPlayerList().getPlayerByUsername(args[1]) == null){
			            	sender.sendMessage(new TextComponentString("No player with username " + args[1] + "found"));
			            }else {
			            	if(entityBondable.getOwner().equals(server.getPlayerList().getPlayerByUsername(args[1]))) {
			            		entityBondable.learn(Integer.parseInt(args[0]));
			            	}
			            }
		            }
		            	return;
		        }
			 }
		}
	}

}
