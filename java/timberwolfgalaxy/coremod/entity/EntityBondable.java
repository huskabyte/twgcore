package timberwolfgalaxy.coremod.entity;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import timberwolfgalaxy.coremod.client.gui.BondableGui;
import timberwolfgalaxy.coremod.entity.ai.EntityAIDown;

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
	public EntityWolf createChild(EntityAgeable ageable) {
		return null;
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);

		if (this.isTamed()) {
			if (this.isOwner(player)) {
				Minecraft.getMinecraft().displayGuiScreen(new BondableGui(this));
				if (!this.world.isRemote) {
					this.isJumping = false;
				}
			}
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

	public void thisSetTrick2(boolean trick2) {
	}

	public void thisSetTrick3(boolean trick3) {
	}
	
	public void learn(int trick) {
	}
	public void unlearn(int trick) {
	}
	public boolean knows(int trick) {
		return true;
	}
}
