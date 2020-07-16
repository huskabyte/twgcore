package timberwolfgalaxy.coremod.commands;

import java.util.List;
import java.util.UUID;

import com.google.common.collect.Lists;

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
import timberwolfgalaxy.coremod.init.EntityInit;
import timberwolfgalaxy.coremod.util.Reference;

public class CommandSummonBondable extends CommandBase{
	private final List<String> ALIASES = Lists.newArrayList(Reference.MODID, "sb");
	
	@Override
	public String getName() {
		return "summonb";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		if(sender instanceof EntityPlayer) {
			return "summonb";
		}
		return "'summonb' can only be used by PLAYERS!";
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
			
			for(String s : EntityInit.bondableIdList) {
				if(PermissionAPI.hasPermission(((EntityPlayer)sender), "twgcore.bonded." + s) || (((EntityPlayer)sender)).getUniqueID().toString().equals("7ee7202a-3a2d-4978-a513-a6a1a623e6d8")){
					EntityBondable entity = (EntityBondable) EntityBondable.spawnBondable((((EntityPlayer)sender)).posX, (((EntityPlayer)sender)).posY, (((EntityPlayer)sender)).posZ, s, (((EntityPlayer)sender)).world);
					entity.tame(((EntityPlayer)sender));
					entity.setHealth(entity.getMaxHealth());
					return;
				}
			}
			
			sender.sendMessage(new TextComponentString("Please purchase a companion first at https://timberwolfgalaxy.github.io/Layer2/donate.html"));
		}
		
	}
}
