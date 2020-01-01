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
import timberwolfgalaxy.coremod.client.gui.MyGui;
import timberwolfgalaxy.coremod.entity.ai.EntityAIDown;

public class EntityLabrador extends EntityWolf {

	protected static final DataParameter<Byte> DOWN = EntityDataManager.<Byte>createKey(EntityLabrador.class,
			DataSerializers.BYTE);

	protected EntityAIDown aiDown;

	public EntityLabrador(World worldIn) {
		super(worldIn);
		
		this.dataManager.register(DOWN, Byte.valueOf((byte)0));
		this.setEntityInvulnerable(true);
	}

	protected void initEntityAI() {
		this.aiSit = new EntityAISit(this);
		this.aiDown = new EntityAIDown(this);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, this.aiSit);
		this.tasks.addTask(2, this.aiDown);
		this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(7, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(9, new EntityAIBeg(this, 8.0F));
		this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(10, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
		this.targetTasks.addTask(4,
				new EntityAITargetNonTamed(this, EntityAnimal.class, false, new Predicate<Entity>() {
					public boolean apply(@Nullable Entity p_apply_1_) {
						return p_apply_1_ instanceof EntitySheep || p_apply_1_ instanceof EntityRabbit;
					}
				}));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, AbstractSkeleton.class, false));
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
				Minecraft.getMinecraft().displayGuiScreen(new MyGui(this));
				if(!this.world.isRemote) {
					this.isJumping = false;
				}
				}
			}
		return true;
	}

	public boolean isDown() {
		return (this.dataManager.get(DOWN).byteValue() & 2) != 0;
	}
	public void setDown(boolean down) {
		byte b0 = (this.dataManager.get(DOWN)).byteValue();

		if (down) {
			this.dataManager.set(DOWN, Byte.valueOf((byte) (b0 | 2)));
		} else {
			this.dataManager.set(DOWN, Byte.valueOf((byte) (b0 & -3)));
		}
	}
	
	public void thisSetSitting(boolean sitting){
		this.aiSit.setSitting(sitting);
    }
	public void thisSetDown(boolean down){
		this.aiDown.setDown(down);
    }
}
