package timberwolfgalaxy.coremod.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAISit;
import timberwolfgalaxy.coremod.entity.EntityBondable;

public class EntityAISitPretty extends EntityAISit
{
    private final EntityBondable tameable;
    /** If the EntityTameable is sitting. */
    private boolean isSitPretty;

    public EntityAISitPretty(EntityBondable entityIn)
    {
    	super(entityIn);
    	
        this.tameable = entityIn;
        this.setMutexBits(5);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.tameable.isTamed())
        {
            return false;
        }
        else if (this.tameable.isInWater())
        {
            return false;
        }
        else if (!this.tameable.onGround)
        {
            return false;
        }
        else
        {
            EntityLivingBase entitylivingbase = this.tameable.getOwner();

            if (entitylivingbase == null)
            {
                return true;
            }
            else
            {
                return this.tameable.getDistanceSq(entitylivingbase) < 144.0D && entitylivingbase.getRevengeTarget() != null ? false : this.isSitPretty;
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.tameable.getNavigator().clearPath();
        this.tameable.thisSetTrick3(true);
    }
    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        this.tameable.thisSetTrick3(false);
    }

    /**
     * Sets the down flag.
     */
    public void setSitPretty(boolean sitpretty)
    {
        this.tameable.setTrick3(sitpretty);
        this.isSitPretty = sitpretty;
    }
    public boolean getSitPretty() {
    	return this.tameable.isTrick3();
    }
}
