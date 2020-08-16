package timberwolfgalaxy.coremod.commands;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import timberwolfgalaxy.coremod.capabilty.LevelProvider;
import timberwolfgalaxy.coremod.util.Reference;
import timberwolfgalaxy.coremod.util.handlers.LevelPacketHandler;
import timberwolfgalaxy.coremod.util.packets.PacketLevel;

public class CommandLevelUp extends CommandBase{
private final List<String> ALIASES = Lists.newArrayList(Reference.MODID, "levelup");
	
	@Override
	public String getName() {
		return "levelup";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		if(sender instanceof EntityPlayer) {
			return "levelup";
		}
		return "'levelup' can only be used by PLAYERS!";
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if(sender instanceof EntityPlayer) {
			if(!sender.getEntityWorld().isRemote) {
				EntityPlayer player = (EntityPlayer) sender;
				if(((player.getCapability(LevelProvider.LEVEL, null).getLevel()+1)*5 <= player.experienceLevel || player.capabilities.isCreativeMode) && player.getCapability(LevelProvider.LEVEL, null).getLevel() < 20) {
					player.addExperienceLevel(-(player.getCapability(LevelProvider.LEVEL, null).getLevel()+1)*5);
					player.getCapability(LevelProvider.LEVEL, null).levelUp();
					LevelPacketHandler.INSTANCE.sendTo(new PacketLevel(player.getCapability(LevelProvider.LEVEL, null).getLevel()), (EntityPlayerMP) player);
				}else {
					if(!(player.getCapability(LevelProvider.LEVEL, null).getLevel() < 20)) {
						player.sendMessage(new TextComponentString(TextFormatting.DARK_RED + "20 levels is powerful enough, master."));
					}else {
						player.sendMessage(new TextComponentString(TextFormatting.DARK_RED + "you need " + Integer.toString((player.getCapability(LevelProvider.LEVEL, null).getLevel()+1)*5) + " experience levels to complete this levelup."));
					}
				}
			}
		}
		
	}
}
