package timberwolfgalaxy.coremod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import timberwolfgalaxy.coremod.entity.EntityLabrador;

/**
 * Dog - SolarAlpha
 * Created using Tabula 7.0.0
 */
public class ModelLabrador extends ModelBase {
    public ModelRenderer Pivot;
    public ModelRenderer Body;
    public ModelRenderer RLeg1;
    public ModelRenderer RLeg1_1;
    public ModelRenderer Neck;
    public ModelRenderer BUTT;
    public ModelRenderer RBackLeg1;
    public ModelRenderer LBackLeg1;
    public ModelRenderer Tail1;
    public ModelRenderer RBackLeg2;
    public ModelRenderer RBackLeg3;
    public ModelRenderer RBackLeg4;
    public ModelRenderer RBackLeg4_1;
    public ModelRenderer LBackLeg2;
    public ModelRenderer LBackLeg3;
    public ModelRenderer RBackLeg4_2;
    public ModelRenderer RBackLeg4_3;
    public ModelRenderer Tail2;
    public ModelRenderer Tail3;
    public ModelRenderer Tail4;
    public ModelRenderer RLeg1Extension;
    public ModelRenderer RLeg2;
    public ModelRenderer RLeg3;
    public ModelRenderer RLeg4;
    public ModelRenderer RLeg1Extension_1;
    public ModelRenderer RLeg2_1;
    public ModelRenderer RLeg3_1;
    public ModelRenderer RLeg4_1;
    public ModelRenderer Head;
    public ModelRenderer REarLobe;
    public ModelRenderer REarLobe_1;
    public ModelRenderer Nose;
    public ModelRenderer REar1;
    public ModelRenderer REar2;
    public ModelRenderer REar1_1;
    public ModelRenderer REar2_1;
    public ModelRenderer Jaw;

    public ModelLabrador() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.RLeg1 = new ModelRenderer(this, 25, 0);
        this.RLeg1.setRotationPoint(-3.0F, 0.0F, 0.0F);
        this.RLeg1.addBox(-2.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.REarLobe_1 = new ModelRenderer(this, 28, 32);
        this.REarLobe_1.setRotationPoint(1.0F, -4.0F, 6.0F);
        this.REarLobe_1.addBox(0.0F, -2.5F, 0.0F, 3, 5, 2, 0.0F);
        this.Neck = new ModelRenderer(this, 71, 0);
        this.Neck.setRotationPoint(0.0F, -3.0F, 2.0F);
        this.Neck.addBox(-3.0F, -6.0F, -5.0F, 6, 7, 6, 0.0F);
        this.setRotateAngle(Neck, 0.8508480103472356F, 0.0F, 0.0F);
        this.Body = new ModelRenderer(this, 34, 0);
        this.Body.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.Body.addBox(-3.5F, -4.0F, 0.0F, 7, 9, 11, 0.0F);
        this.RLeg1Extension = new ModelRenderer(this, 107, 21);
        this.RLeg1Extension.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.RLeg1Extension.addBox(-2.0F, 1.0F, -2.0F, 3, 4, 4, 0.0F);
        this.setRotateAngle(RLeg1Extension, 0.2617993877991494F, 0.0F, 0.0F);
        this.RLeg1_1 = new ModelRenderer(this, 59, 0);
        this.RLeg1_1.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.RLeg1_1.addBox(-2.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.RBackLeg4_3 = new ModelRenderer(this, 95, 21);
        this.RBackLeg4_3.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.RBackLeg4_3.addBox(0.0F, 3.0F, -1.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(RBackLeg4_3, 0.17453292519943295F, 0.0F, 0.0F);
        this.LBackLeg3 = new ModelRenderer(this, 83, 21);
        this.LBackLeg3.setRotationPoint(0.0F, 2.1F, 0.0F);
        this.LBackLeg3.addBox(-1.0F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(LBackLeg3, 0.6806784082777886F, 0.0F, 0.0F);
        this.LBackLeg1 = new ModelRenderer(this, 0, 19);
        this.LBackLeg1.setRotationPoint(3.0F, 0.0F, 4.0F);
        this.LBackLeg1.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 5, 0.0F);
        this.setRotateAngle(LBackLeg1, -0.17453292519943295F, 0.0F, 0.0F);
        this.BUTT = new ModelRenderer(this, 86, 4);
        this.BUTT.setRotationPoint(0.0F, -1.0F, 8.0F);
        this.BUTT.addBox(-4.0F, -3.0F, 0.0F, 8, 8, 9, 0.0F);
        this.REar2 = new ModelRenderer(this, 78, 13);
        this.REar2.setRotationPoint(0.0F, 1.0F, -6.0F);
        this.REar2.addBox(0.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(REar2, 0.0F, -0.15638150097869194F, 0.0F);
        this.Jaw = new ModelRenderer(this, 71, 0);
        this.Jaw.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.Jaw.addBox(-1.0F, -2.0F, 0.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(Jaw, 0.3490658503988659F, 0.0F, 0.0F);
        this.REar1_1 = new ModelRenderer(this, 8, 33);
        this.REar1_1.setRotationPoint(2.0F, -2.5F, 1.0F);
        this.REar1_1.addBox(0.0F, 0.0F, -4.0F, 1, 5, 4, 0.0F);
        this.setRotateAngle(REar1_1, 0.0F, -0.3124139361069849F, 0.0F);
        this.RBackLeg2 = new ModelRenderer(this, 111, 5);
        this.RBackLeg2.setRotationPoint(0.0F, 4.0F, 1.0F);
        this.RBackLeg2.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(RBackLeg2, -0.17453292519943295F, 0.0F, 0.0F);
        this.RBackLeg3 = new ModelRenderer(this, 18, 19);
        this.RBackLeg3.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.RBackLeg3.addBox(-2.0F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(RBackLeg3, 0.6806784082777886F, 0.0F, 0.0F);
        this.RLeg3 = new ModelRenderer(this, 68, 25);
        this.RLeg3.setRotationPoint(-1.0F, 3.0F, 0.0F);
        this.RLeg3.addBox(-1.0F, 0.0F, 0.0F, 2, 6, 3, 0.0F);
        this.setRotateAngle(RLeg3, 0.15707963267948966F, 0.0F, 0.0F);
        this.RBackLeg4 = new ModelRenderer(this, 34, 4);
        this.RBackLeg4.setRotationPoint(0.0F, 3.0F, 1.0F);
        this.RBackLeg4.addBox(-2.0F, 0.0F, 0.0F, 2, 4, 3, 0.0F);
        this.setRotateAngle(RBackLeg4, -0.5235987755982988F, 0.0F, 0.0F);
        this.LBackLeg2 = new ModelRenderer(this, 42, 20);
        this.LBackLeg2.setRotationPoint(0.0F, 4.0F, 1.0F);
        this.LBackLeg2.addBox(-2.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(LBackLeg2, -0.17453292519943295F, 0.0F, 0.0F);
        this.REar1 = new ModelRenderer(this, 84, 32);
        this.REar1.setRotationPoint(-3.0F, -2.5F, 1.0F);
        this.REar1.addBox(0.0F, 0.0F, -4.0F, 1, 5, 4, 0.0F);
        this.setRotateAngle(REar1, 0.0F, 0.31247969326575686F, 0.0F);
        this.RLeg4_1 = new ModelRenderer(this, 0, 29);
        this.RLeg4_1.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.RLeg4_1.addBox(0.0F, 0.0F, -3.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(RLeg4_1, -0.2792526803190927F, 0.0F, 0.0F);
        this.REar2_1 = new ModelRenderer(this, 119, 26);
        this.REar2_1.setRotationPoint(0.0F, 1.0F, -6.0F);
        this.REar2_1.addBox(0.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
        this.setRotateAngle(REar2_1, 0.0F, 0.15638150097869194F, 0.0F);
        this.Tail4 = new ModelRenderer(this, 37, 0);
        this.Tail4.setRotationPoint(0.0F, 1.0F, 1.0F);
        this.Tail4.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Tail4, 0.2792526803190927F, 0.0F, 0.0F);
        this.Head = new ModelRenderer(this, 98, 29);
        this.Head.setRotationPoint(0.0F, -1.0F, -4.0F);
        this.Head.addBox(-3.5F, -7.0F, 0.0F, 7, 7, 7, 0.0F);
        this.setRotateAngle(Head, 0.6995279641993272F, 0.0F, 0.0F);
        this.Pivot = new ModelRenderer(this, 0, 0);
        this.Pivot.setRotationPoint(0.0F, 12.0F, -9.0F);
        this.Pivot.addBox(-4.0F, -4.0F, -2.0F, 8, 10, 9, 0.0F);
        this.Tail3 = new ModelRenderer(this, 34, 0);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.Tail3.addBox(-0.5F, 1.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Tail3, 0.5585053606381855F, 0.0F, 0.0F);
        this.RLeg4 = new ModelRenderer(this, 26, 26);
        this.RLeg4.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.RLeg4.addBox(-1.0F, 0.0F, -3.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(RLeg4, -0.2792526803190927F, 0.0F, 0.0F);
        this.Tail1 = new ModelRenderer(this, 111, 0);
        this.Tail1.setRotationPoint(0.0F, -3.0F, 8.0F);
        this.Tail1.addBox(-0.5F, 1.0F, 0.0F, 1, 1, 4, 0.0F);
        this.setRotateAngle(Tail1, 0.24434609527920614F, 0.0F, 0.0F);
        this.RBackLeg1 = new ModelRenderer(this, 65, 15);
        this.RBackLeg1.setRotationPoint(-3.0F, 0.0F, 4.0F);
        this.RBackLeg1.addBox(-2.0F, 0.0F, 0.0F, 4, 5, 5, 0.0F);
        this.setRotateAngle(RBackLeg1, -0.17453292519943295F, 0.0F, 0.0F);
        this.RBackLeg4_2 = new ModelRenderer(this, 117, 18);
        this.RBackLeg4_2.setRotationPoint(0.0F, 3.0F, 1.0F);
        this.RBackLeg4_2.addBox(0.0F, 0.0F, 0.0F, 2, 4, 3, 0.0F);
        this.setRotateAngle(RBackLeg4_2, -0.5235987755982988F, 0.0F, 0.0F);
        this.RLeg2_1 = new ModelRenderer(this, 14, 28);
        this.RLeg2_1.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.RLeg2_1.addBox(-2.0F, 0.0F, 0.0F, 3, 5, 4, 0.0F);
        this.setRotateAngle(RLeg2_1, 0.15707963267948966F, 0.0F, 0.0F);
        this.Tail2 = new ModelRenderer(this, 0, 0);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 3.0F);
        this.Tail2.addBox(-0.5F, 1.0F, 0.0F, 1, 1, 3, 0.0F);
        this.setRotateAngle(Tail2, 0.47123889803846897F, 0.0F, 0.0F);
        this.RLeg2 = new ModelRenderer(this, 54, 24);
        this.RLeg2.setRotationPoint(0.0F, 3.0F, -1.0F);
        this.RLeg2.addBox(-2.0F, 0.0F, 0.0F, 3, 5, 4, 0.0F);
        this.setRotateAngle(RLeg2, 0.15707963267948966F, 0.0F, 0.0F);
        this.RLeg3_1 = new ModelRenderer(this, 38, 28);
        this.RLeg3_1.setRotationPoint(-1.0F, 3.0F, 0.0F);
        this.RLeg3_1.addBox(0.0F, 0.0F, 0.0F, 2, 6, 3, 0.0F);
        this.setRotateAngle(RLeg3_1, 0.15707963267948966F, 0.0F, 0.0F);
        this.Nose = new ModelRenderer(this, 48, 33);
        this.Nose.setRotationPoint(0.0F, -7.0F, 1.0F);
        this.Nose.addBox(-2.0F, -3.0F, 0.0F, 4, 5, 2, 0.0F);
        this.RLeg1Extension_1 = new ModelRenderer(this, 91, 27);
        this.RLeg1Extension_1.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.RLeg1Extension_1.addBox(-2.0F, 1.0F, -2.0F, 3, 4, 4, 0.0F);
        this.setRotateAngle(RLeg1Extension_1, 0.2617993877991494F, 0.0F, 0.0F);
        this.REarLobe = new ModelRenderer(this, 78, 29);
        this.REarLobe.setRotationPoint(-1.0F, -4.0F, 6.0F);
        this.REarLobe.addBox(-3.0F, -2.5F, 0.0F, 3, 5, 2, 0.0F);
        this.RBackLeg4_1 = new ModelRenderer(this, 30, 20);
        this.RBackLeg4_1.setRotationPoint(0.0F, 0.0F, -1.0F);
        this.RBackLeg4_1.addBox(-2.0F, 3.0F, -1.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(RBackLeg4_1, 0.17453292519943295F, 0.0F, 0.0F);
        this.Pivot.addChild(this.RLeg1);
        this.Head.addChild(this.REarLobe_1);
        this.Pivot.addChild(this.Neck);
        this.Pivot.addChild(this.Body);
        this.RLeg1.addChild(this.RLeg1Extension);
        this.Pivot.addChild(this.RLeg1_1);
        this.RBackLeg4_2.addChild(this.RBackLeg4_3);
        this.LBackLeg2.addChild(this.LBackLeg3);
        this.BUTT.addChild(this.LBackLeg1);
        this.Body.addChild(this.BUTT);
        this.REar1.addChild(this.REar2);
        this.Nose.addChild(this.Jaw);
        this.REarLobe_1.addChild(this.REar1_1);
        this.RBackLeg1.addChild(this.RBackLeg2);
        this.RBackLeg2.addChild(this.RBackLeg3);
        this.RLeg2.addChild(this.RLeg3);
        this.RBackLeg3.addChild(this.RBackLeg4);
        this.LBackLeg1.addChild(this.LBackLeg2);
        this.REarLobe.addChild(this.REar1);
        this.RLeg3_1.addChild(this.RLeg4_1);
        this.REar1_1.addChild(this.REar2_1);
        this.Tail3.addChild(this.Tail4);
        this.Neck.addChild(this.Head);
        this.Tail2.addChild(this.Tail3);
        this.RLeg3.addChild(this.RLeg4);
        this.BUTT.addChild(this.Tail1);
        this.BUTT.addChild(this.RBackLeg1);
        this.LBackLeg3.addChild(this.RBackLeg4_2);
        this.RLeg1_1.addChild(this.RLeg2_1);
        this.Tail1.addChild(this.Tail2);
        this.RLeg1.addChild(this.RLeg2);
        this.RLeg2_1.addChild(this.RLeg3_1);
        this.Head.addChild(this.Nose);
        this.RLeg1_1.addChild(this.RLeg1Extension_1);
        this.Head.addChild(this.REarLobe);
        this.RBackLeg4.addChild(this.RBackLeg4_1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Pivot.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    float headAngleX = 40.08F;
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    	
    	this.RLeg1_1.rotateAngleX = MathHelper.cos(-limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    	this.RLeg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * -limbSwingAmount;
    	this.LBackLeg1.rotateAngleX = (float) (MathHelper.cos(-limbSwing * 0.6662F) * 1.4F * -limbSwingAmount - (10 * Math.PI/180));
    	this.RBackLeg1.rotateAngleX = (float) (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - (10 * Math.PI/180));
    	
    	this.RLeg2_1.rotateAngleX = -(MathHelper.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount);
    	this.RLeg2.rotateAngleX = -(MathHelper.cos(limbSwing * 0.6662F) * 0.7F * -limbSwingAmount);
    	this.LBackLeg2.rotateAngleX = (float) ((float) -(MathHelper.cos(limbSwing * 0.6662F) * 0.7F * -limbSwingAmount) + (10 * Math.PI/180));
    	this.RBackLeg2.rotateAngleX = (float) ((float) -(MathHelper.cos(limbSwing * 0.6662F) * 0.7F * limbSwingAmount) + (10 * Math.PI/180));
    	
    	this.Head.rotateAngleX =   headPitch * 0.017453292F + headAngleX * (float) Math.PI/180;
    	this.Neck.rotateAngleY = netHeadYaw * 0.017453292F;
    }
    
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
    	EntityLabrador thisEntity = (EntityLabrador)entitylivingbaseIn;
    	
    	//===========START ANGRY ANIMATION=============
    	
        if (thisEntity.isAngry())
        {
            this.Tail1.rotateAngleX = (float) (-31.0F * Math.PI/180);
            this.Tail2.rotateAngleX = (float) (14.0F * Math.PI/180);
            this.Tail3.rotateAngleX = (float) (14.0F * Math.PI/180);
            this.Tail4.rotateAngleX = (float) (14.0F * Math.PI/180);
            
            this.Neck.rotateAngleX = (float) (83.75F * Math.PI/180);
            this.Head.rotateAngleX = (float) (8.08F * Math.PI/180);
            
            headAngleX = 8.08F;
            
            this.REar1.rotateAngleX = (float) (12.0F * Math.PI/180);
            this.REar1.rotateAngleY = (float) (6.90F * Math.PI/180);
            this.REar1_1.rotateAngleX = (float) (12.0F * Math.PI/180);
            this.REar1_1.rotateAngleX = (float) (-6.90F * Math.PI/180);
            this.Jaw.rotateAngleX = (float) (-9.0F * Math.PI/180);
            
            this.Pivot.setRotationPoint(0.0F, 13.0F, -9.0F);
            this.Body.setRotationPoint(0.0F, 1.0F, 3.0F);
            this.BUTT.setRotationPoint(0.0F, 0.0F, 8.0F);
        }
        else
        {
            this.Tail1.rotateAngleX = (float) (14.0F * Math.PI/180);
            this.Tail2.rotateAngleX = (float) (27.0F * Math.PI/180);
            this.Tail3.rotateAngleX = (float) (32.0F * Math.PI/180);
            this.Tail4.rotateAngleX = (float) (16.0F * Math.PI/180);
            
            this.Neck.rotateAngleX = (float) (48.75F * Math.PI/180);
            this.Head.rotateAngleX = (float) (40.08F * Math.PI/180);
            
            headAngleX = 40.08F;
            
            this.REar1.rotateAngleX = (float) (0.0F * Math.PI/180);
            this.REar1.rotateAngleY = (float) (17.9F * Math.PI/180);
            this.REar1_1.rotateAngleX = (float) (0.0F * Math.PI/180);
            this.REar1_1.rotateAngleX = (float) (-17.9F * Math.PI/180);
            this.Jaw.rotateAngleX = (float) (20.0F * Math.PI/180);
            
            this.Pivot.setRotationPoint(0.0F, 12.0F, -9.0F);
            this.Body.setRotationPoint(0.0F, 0.0F, 3.0F);
            this.BUTT.setRotationPoint(0.0F, -1.0F, 8.0F);
        }
        
        //=============END ANGRY ANIMATION=============
        
        //=============START SIT ANIMATION=============
        
        if(thisEntity.isSitting()) {
        	this.Body.rotateAngleX = (float) (-37.0F * Math.PI/180);
        	this.BUTT.rotateAngleX = (float) (-47.0F * Math.PI/180);
        	
        	this.RBackLeg1.rotateAngleX = (float) (-28.0F * Math.PI/180);
        	this.RBackLeg4.rotateAngleX = (float) (72.0F * Math.PI/180);
        	
        	this.LBackLeg1.rotateAngleX = (float) (-28.0F * Math.PI/180);
        	this.RBackLeg4_2.rotateAngleX = (float) (72.0F * Math.PI/180);
        	
        	this.Tail1.rotateAngleX = (float) (110.0F * Math.PI/180);
        }
        else {
        	this.Body.rotateAngleX = (float) (0.0F * Math.PI/180);
        	this.BUTT.rotateAngleX = (float) (0.0F * Math.PI/180);
        	
        	this.RBackLeg1.rotateAngleX = (float) (-10.0F * Math.PI/180);
        	this.RBackLeg4.rotateAngleX = (float) (-30.0F * Math.PI/180);
        	
        	this.LBackLeg1.rotateAngleX = (float) (-10.0F * Math.PI/180);
        	this.RBackLeg4_2.rotateAngleX = (float) (-30.0F * Math.PI/180);
        	
        	this.Tail1.rotateAngleX = (float) (14.0F * Math.PI/180);
        }
        
        //==============END SIT ANIMATION==============
    }
}
