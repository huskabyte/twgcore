package timberwolfgalaxy.coremod.entity;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.server.permission.PermissionAPI;
import timberwolfgalaxy.coremod.entity.ai.EntityAIDown;
import timberwolfgalaxy.coremod.entity.ai.EntityAISitPretty;

public class EntityWolfdog extends EntityBondable{
	protected EntityAIDown aiDown;
	protected EntityAISitPretty aiSitPretty;
	private int counter;

	public EntityWolfdog(World worldIn) {
		super(worldIn);
	}

	protected void initEntityAI() {
		this.aiSit = new EntityAISit(this);
		this.aiDown = new EntityAIDown(this);
		this.aiSitPretty = new EntityAISitPretty(this);
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
	public void thisSetTrick2(boolean down) {
		this.aiDown.setDown(down);
	}

	@Override
	public void thisSetTrick3(boolean sitPretty) {
		this.aiSitPretty.setSitPretty(sitPretty);
		counter = 40;
	}
	
	@Override
	protected void updateAITasks()
    {	
		counter--;
		if(this.isTrick3() && counter <= 0) {
			this.aiSitPretty.setSitPretty(false);
		}
		
        super.updateAITasks();
    }
	
	@Override
	public boolean knows(int trick) {
		if(this.isTamed()) {
			return PermissionAPI.hasPermission((EntityPlayer) this.getOwner(), "twgcore.bonded.wolfdog.trick" + Integer.toString(trick)) || this.getOwner().getUniqueID().toString().equals("7ee7202a-3a2d-4978-a513-a6a1a623e6d8");
		}
		return false;
	}
}
