package timberwolfgalaxy.coremod.entity.ai;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAISit;
import timberwolfgalaxy.coremod.entity.EntityLabrador;

public class EntityAIDown extends EntityAISit
{
    private final EntityLabrador tameable;
    /** If the EntityTameable is sitting. */
    private boolean isDown;

    public EntityAIDown(EntityLabrador entityIn)
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
                return this.tameable.getDistanceSq(entitylivingbase) < 144.0D && entitylivingbase.getRevengeTarget() != null ? false : this.isDown;
            }
        }
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.tameable.getNavigator().clearPath();
        this.setDown(true);
    }

    /**
     * Reset the task's internal state. Called when this task is interrupted by another one
     */
    public void resetTask()
    {
        this.setDown(false);
    }

    /**
     * Sets the down flag.
     */
    public void setDown(boolean down)
    {
        this.tameable.setDown(down);
        this.isDown = down;
    }
    public boolean getDown() {
    	return this.tameable.isDown();
    }
}
