package timberwolfgalaxy.coremod.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.client.gui.BondableGui;

public abstract class EntityBondable extends EntityWolf {

	protected static final DataParameter<Byte> TRICK2 = EntityDataManager.<Byte>createKey(EntityBondable.class,
			DataSerializers.BYTE);
	protected static final DataParameter<Byte> TRICK3 = EntityDataManager.<Byte>createKey(EntityBondable.class,
			DataSerializers.BYTE);

	public EntityBondable(World worldIn) {
		super(worldIn);

		this.dataManager.register(TRICK2, Byte.valueOf((byte) 0));
		this.dataManager.register(TRICK3, Byte.valueOf((byte) 0));
		this.setEntityInvulnerable(true);
	}
	
	@Override
	protected void updateAITasks() {
		if(this.getAttackTarget() instanceof EntityPlayer) {
			this.setAttackTarget(null);
		}
		super.updateAITasks();
	}

	@Override
	public EntityWolf createChild(EntityAgeable ageable) {
		return null;
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);

		if (this.isTamed()) {
			if (this.isOwner(player)) {
				if (!this.world.isRemote) {
					this.isJumping = false;
				}
				processInteractHelper();
			}
		}else{
	        NBTTagCompound tag = player.getEntityData();
	        	if(tag.getString("entitySelected") != this.getPersistentID().toString()) {
	        		player.sendMessage(new TextComponentString("Entity Selected!"));
	        	}
	        	tag.setString("entitySelected", this.getPersistentID().toString());
		}
		return true;
	}

	public boolean isTrick2() {
		return (this.dataManager.get(TRICK2).byteValue() & 2) != 0;
	}

	public void setTrick2(boolean trick2) {
		byte b0 = (this.dataManager.get(TRICK2)).byteValue();

		if (trick2) {
			this.dataManager.set(TRICK2, Byte.valueOf((byte) (b0 | 2)));
		} else {
			this.dataManager.set(TRICK2, Byte.valueOf((byte) (b0 & -3)));
		}
	}

	public boolean isTrick3() {
		return (this.dataManager.get(TRICK3).byteValue() & 2) != 0;
	}

	public void setTrick3(boolean trick3) {
		byte b0 = (this.dataManager.get(TRICK3)).byteValue();

		if (trick3) {
			this.dataManager.set(TRICK3, Byte.valueOf((byte) (b0 | 2)));
		} else {
			this.dataManager.set(TRICK3, Byte.valueOf((byte) (b0 & -3)));
		}
	}

	public void thisSetSitting(boolean sitting) {
		this.aiSit.setSitting(sitting);
	}

	public abstract void thisSetTrick2(boolean trick2);

	public abstract void thisSetTrick3(boolean trick3);
	
	public abstract void learn(int trick);
	public abstract void unlearn(int trick);
	
	
	public abstract boolean knows(int i);
	
	
	public void tame(EntityPlayer player) {
		this.setTamedBy(player);
        this.navigator.clearPath();
        this.setAttackTarget((EntityLivingBase)null);
        this.aiSit.setSitting(true);
        this.playTameEffect(true);
        this.world.setEntityState(this, (byte)7);
	}

	@SideOnly(Side.CLIENT)
	public void processInteractHelper(){
		Minecraft.getMinecraft().displayGuiScreen(new BondableGui(this));
	}
}
