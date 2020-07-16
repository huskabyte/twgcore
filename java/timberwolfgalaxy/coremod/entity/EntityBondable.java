package timberwolfgalaxy.coremod.entity;

import java.util.HashMap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.server.permission.PermissionAPI;
import timberwolfgalaxy.coremod.Main;
import timberwolfgalaxy.coremod.init.EntityInit;
import timberwolfgalaxy.coremod.util.Reference;

public abstract class EntityBondable extends EntityWolf {

	protected static final DataParameter<Byte> TRICK2 = EntityDataManager.<Byte>createKey(EntityBondable.class,
			DataSerializers.BYTE);
	protected static final DataParameter<Byte> TRICK3 = EntityDataManager.<Byte>createKey(EntityBondable.class,
			DataSerializers.BYTE);
	protected static final DataParameter<Byte> KNOWSTRICK2 = EntityDataManager.<Byte>createKey(EntityBondable.class,
			DataSerializers.BYTE);
	protected static final DataParameter<Byte> KNOWSTRICK3 = EntityDataManager.<Byte>createKey(EntityBondable.class,
			DataSerializers.BYTE);
	
	public HashMap<String, DataParameter<Byte>> hasBondable = new HashMap<String, DataParameter<Byte>>();

	public EntityBondable(World worldIn) {
		super(worldIn);

		this.dataManager.register(TRICK2, Byte.valueOf((byte) 0));
		this.dataManager.register(TRICK3, Byte.valueOf((byte) 0));
		
		this.dataManager.register(KNOWSTRICK2, Byte.valueOf((byte) 0));
		this.dataManager.register(KNOWSTRICK3, Byte.valueOf((byte) 0));
		
		
		
		this.registerKnownTricks();
		this.setEntityInvulnerable(true);
	}
	
	protected abstract void registerKnownTricks();
	
	@Override
	protected void updateAITasks() {
		if(this.getAttackTarget() instanceof EntityPlayer) {
			this.setAttackTarget(null);
		}

		if(FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUUID(this.getOwnerId()) == null) {
			this.setDead();
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
				this.registerKnownTricks();
				if (!this.world.isRemote) {
					this.isJumping = false;
				}
				Main.proxy.processInteractHelper(this);
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
		
		this.dataManager.setDirty(TRICK2);
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
		
		this.dataManager.setDirty(TRICK3);
	}

	public void thisSetSitting(boolean sitting) {
		this.aiSit.setSitting(sitting);
	}

	public abstract void thisSetTrick2(boolean trick2);

	public abstract void thisSetTrick3(boolean trick3);
	
	
	public abstract boolean knows(int i);
	
	public static boolean hasBondable(EntityPlayer player, Class<? extends EntityBondable> bondable) {
		return PermissionAPI.hasPermission(player, "twgcore.bonded." + bondable.getName()) || player.getUniqueID().toString().equals("7ee7202a-3a2d-4978-a513-a6a1a623e6d8");
	}
	
	
	public void tame(EntityPlayer player) {
		this.setTamedBy(player);
        this.navigator.clearPath();
        this.setAttackTarget((EntityLivingBase)null);
        this.aiSit.setSitting(true);
        this.playTameEffect(false);
        this.world.setEntityState(this, (byte)7);
	}
	
	public static Entity spawnBondable(double posX, double posY, double posZ, String name, World worldIn) {
		Entity entity = null;
		 for (int i = 0; i < 1; ++i)
         {
             entity = EntityList.createEntityByIDFromName(new ResourceLocation(Reference.MODID + ":" + name), worldIn);

             if (entity instanceof EntityLiving)
             {
                 EntityLiving entityliving = (EntityLiving)entity;
                 entity.setLocationAndAngles(posX, posY, posZ, MathHelper.wrapDegrees(worldIn.rand.nextFloat() * 360.0F), 0.0F);
                 entityliving.rotationYawHead = entityliving.rotationYaw;
                 entityliving.renderYawOffset = entityliving.rotationYaw;
                 entityliving.onInitialSpawn(worldIn.getDifficultyForLocation(new BlockPos(entityliving)), (IEntityLivingData)null);
                 worldIn.spawnEntity(entity);
                 entityliving.playLivingSound();
             }
         }

         return entity;
	}
	
	@Override
	public void setDead() {
		super.setDead();
	}
}
