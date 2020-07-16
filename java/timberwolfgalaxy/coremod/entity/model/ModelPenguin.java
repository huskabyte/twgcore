package timberwolfgalaxy.coremod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import timberwolfgalaxy.coremod.entity.EntityPenguin;

/**
 * ModelPenguin - Undefined
 * Created using Tabula 7.0.0
 */
public class ModelPenguin extends ModelBase {
    public ModelRenderer BodyBase;
    public ModelRenderer BodyFront;
    public ModelRenderer BodyBack;
    public ModelRenderer FaceBase;
    public ModelRenderer NeckIsh;
    public ModelRenderer RightLeg;
    public ModelRenderer LeftLeg;
    public ModelRenderer BodyRight;
    public ModelRenderer BodyLeft;
    public ModelRenderer RightWing;
    public ModelRenderer LeftWing;
    public ModelRenderer FaceTop;
    public ModelRenderer FaceLeft;
    public ModelRenderer FaceRight;
    public ModelRenderer FaceFront;
    public ModelRenderer FaceBack;
    public ModelRenderer Nose;
    public ModelRenderer RightFoot;
    public ModelRenderer LeftFoot;
    
    private int counter;
    private boolean counterSet;
    
    public void setCounter(int counter) {
    	this.counter = counter;
    	this.counterSet = true;
    }

    public ModelPenguin() {
    	this.textureWidth = 128;
        this.textureHeight = 64;
        this.BodyRight = new ModelRenderer(this, 86, 0);
        this.BodyRight.setRotationPoint(-0.1F, -0.9F, 0.5F);
        this.BodyRight.addBox(-3.0F, -5.5F, -3.0F, 6, 11, 6, 0.0F);
        this.RightFoot = new ModelRenderer(this, 111, 21);
        this.RightFoot.setRotationPoint(-1.4F, 1.5F, 0.6F);
        this.RightFoot.addBox(0.0F, -0.0F, -3.7F, 3, 1, 4, 0.0F);
        this.setRotateAngle(RightFoot, 0.9320414395164146F, -0.2452187599052033F, 0.0F);
        this.LeftLeg = new ModelRenderer(this, 38, 0);
        this.LeftLeg.setRotationPoint(-1.3F, 6.0F, 0.0F);
        this.LeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.FaceLeft = new ModelRenderer(this, 20, 15);
        this.FaceLeft.setRotationPoint(-0.8F, 0.0F, 0.0F);
        this.FaceLeft.addBox(-2.0F, -1.5F, -2.0F, 4, 3, 4, 0.0F);
        this.LeftFoot = new ModelRenderer(this, 12, 22);
        this.LeftFoot.setRotationPoint(0.0F, 1.5F, 0.3F);
        this.LeftFoot.addBox(-1.6F, 0.0F, -3.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(LeftFoot, 0.9320058205649718F, 0.2452187599052033F, 0.0F);
        this.BodyBase = new ModelRenderer(this, 0, 0);
        this.BodyBase.setRotationPoint(0.0F, 22.0F, 0.0F);
        this.BodyBase.addBox(-3.0F, -6.5F, -3.0F, 6, 13, 6, 0.0F);
        this.setRotateAngle(BodyBase, 1.5707963267948966F, 0.0F, 0.0F);
        this.FaceBack = new ModelRenderer(this, 0, 19);
        this.FaceBack.setRotationPoint(0.0F, 0.0F, 0.8F);
        this.FaceBack.addBox(-2.0F, -1.5F, -2.0F, 4, 3, 4, 0.0F);
        this.NeckIsh = new ModelRenderer(this, 80, 0);
        this.NeckIsh.setRotationPoint(0.0F, -7.2F, 0.0F);
        this.NeckIsh.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, 0.0F);
        this.FaceBase = new ModelRenderer(this, 60, 0);
        this.FaceBase.setRotationPoint(0.0F, -8.7F, 0.0F);
        this.FaceBase.addBox(-2.5F, -2.0F, -2.5F, 5, 4, 5, 0.0F);
        this.FaceTop = new ModelRenderer(this, 106, 14);
        this.FaceTop.setRotationPoint(0.0F, -0.9F, 0.0F);
        this.FaceTop.addBox(-2.0F, -1.5F, -2.0F, 4, 3, 4, 0.0F);
        this.LeftWing = new ModelRenderer(this, 78, 12);
        this.LeftWing.setRotationPoint(-3.0F, -4.7F, -2.8F);
        this.LeftWing.addBox(0.0F, 0.0F, -2.0F, 1, 9, 5, 0.0F);
        this.setRotateAngle(LeftWing, 0.0F, 0.0F, 2.231054382824351F);
        this.BodyBack = new ModelRenderer(this, 42, 0);
        this.BodyBack.setRotationPoint(-2.5F, -5.3F, -0.6F);
        this.BodyBack.addBox(0.0F, 0.0F, 0.0F, 5, 11, 4, 0.0F);
        this.RightLeg = new ModelRenderer(this, 18, 0);
        this.RightLeg.setRotationPoint(1.3F, 6.0F, 0.0F);
        this.RightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
        this.BodyLeft = new ModelRenderer(this, 54, 9);
        this.BodyLeft.setRotationPoint(-0.9F, -1.0F, 3.0F);
        this.BodyLeft.addBox(-3.0F, -5.5F, -5.5F, 6, 11, 6, 0.0F);
        this.Nose = new ModelRenderer(this, 103, 21);
        this.Nose.setRotationPoint(0.0F, 0.75F, -1.5F);
        this.Nose.addBox(-1.5F, -1.0F, -1.5F, 3, 1, 3, 0.0F);
        this.BodyFront = new ModelRenderer(this, 24, 0);
        this.BodyFront.setRotationPoint(0.5F, 0.9F, -0.5F);
        this.BodyFront.addBox(-3.0F, -6.5F, -3.0F, 5, 11, 4, 0.0F);
        this.RightWing = new ModelRenderer(this, 110, 0);
        this.RightWing.setRotationPoint(3.0F, -4.7F, 0.0F);
        this.RightWing.addBox(-1.0F, 0.0F, -2.5F, 1, 9, 5, 0.0F);
        this.setRotateAngle(RightWing, 0.0F, 0.0F, -2.231054382824351F);
        this.FaceRight = new ModelRenderer(this, 36, 15);
        this.FaceRight.setRotationPoint(0.9F, 0.0F, 0.0F);
        this.FaceRight.addBox(-2.0F, -1.5F, -2.0F, 4, 3, 4, 0.0F);
        this.FaceFront = new ModelRenderer(this, 90, 17);
        this.FaceFront.setRotationPoint(0.0F, 0.0F, -0.7F);
        this.FaceFront.addBox(-2.0F, -1.5F, -2.0F, 4, 3, 4, 0.0F);
        this.BodyFront.addChild(this.BodyRight);
        this.RightLeg.addChild(this.RightFoot);
        this.BodyBase.addChild(this.LeftLeg);
        this.FaceBase.addChild(this.FaceLeft);
        this.LeftLeg.addChild(this.LeftFoot);
        this.FaceBase.addChild(this.FaceBack);
        this.BodyBase.addChild(this.NeckIsh);
        this.BodyBase.addChild(this.FaceBase);
        this.FaceBase.addChild(this.FaceTop);
        this.BodyLeft.addChild(this.LeftWing);
        this.BodyBase.addChild(this.BodyBack);
        this.BodyBase.addChild(this.RightLeg);
        this.BodyFront.addChild(this.BodyLeft);
        this.FaceFront.addChild(this.Nose);
        this.BodyBase.addChild(this.BodyFront);
        this.BodyRight.addChild(this.RightWing);
        this.FaceBase.addChild(this.FaceRight);
        this.FaceBase.addChild(this.FaceFront);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.BodyBase.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    	if (!((EntityPenguin) entityIn).isSitting()) {
    		this.RightLeg.rotateAngleX = -(MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount);
    		this.LeftLeg.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount);
		}
    }
    
    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
    		float partialTickTime) {
    	if(((EntityPenguin)entitylivingbaseIn).isSitting()) {
    		if(((EntityPenguin)entitylivingbaseIn).isTrick2()) {
    			this.BodyBase.setRotationPoint(0.0F, 22.0F, 0.0F);
    			this.LeftLeg.setRotationPoint(-1.3F, 7.0F, 0.0F);
        		this.RightLeg.setRotationPoint(1.3F, 7.0F, 0.0F);
        		this.LeftFoot.setRotationPoint(0.0F, 1.5F, 1F);
        		this.RightFoot.setRotationPoint(-1.4F, 1.0F, 0.6F);
        		
        		this.RightLeg.rotateAngleX = 0F;
        		this.LeftLeg.rotateAngleX = 0F;
        		
    			this.LeftWing.rotateAngleZ = (float) (127.83 * Math.PI/180);
    			this.RightWing.rotateAngleZ = (float) -(127.83 * Math.PI/180);
    			this.LeftFoot.rotateAngleX = (float) (53 * Math.PI/180);
    			this.RightFoot.rotateAngleX = (float) (53 * Math.PI/180);
    			this.BodyBase.rotateAngleX = (float) (90 * Math.PI/180);
    		}else if(((EntityPenguin)entitylivingbaseIn).isTrick3()){
    			this.BodyBase.setRotationPoint(0.0F, 18.5F, 0.0F);
        		this.LeftLeg.setRotationPoint(-1.3F, 5.0F, -3.5F);
        		this.RightLeg.setRotationPoint(1.3F, 5.0F, -3.5F);
        		this.LeftFoot.setRotationPoint(0.0F, 1.5F, 0.3F);
        		this.RightFoot.setRotationPoint(-1.4F, 1.5F, 0.6F);
        		
        		this.BodyBase.rotateAngleX = 0F;
        		
        		this.RightLeg.rotateAngleX = (float) -(90 * Math.PI/180);
        		this.LeftLeg.rotateAngleX = (float) -(90 * Math.PI/180);
        		
        		this.setRotateAngle(RightWing, 0.0F, 0.0F, -0.18203784098300857F);
        		this.setRotateAngle(RightFoot, 0.0F, -0.2452187599052033F, 0.0F);
        		this.setRotateAngle(LeftFoot, 0.0F, 0.2452187599052033F, 0.0F);
    			
    			EntityPenguin penguin = (EntityPenguin)entitylivingbaseIn;
    			
    			if(!counterSet)setCounter(40);;
    			int frame = counter % 10;
    			int oddEven = (counter / 10) % 2;
    			
    			if(oddEven == 0) {
    				oddEven = -1;
    			}
    			
    			this.setRotateAngle(LeftWing, 0.0F, 0.0F, (float) ((150 + frame * 2 * (oddEven)) * Math.PI/180));
    			
    			if(this.counter <= 0) {
    	    		counterSet = false;
    	    	}
    	    	counter--;
    		}else {
    			this.BodyBase.setRotationPoint(0.0F, 18.5F, 0.0F);
        		this.LeftLeg.setRotationPoint(-1.3F, 5.0F, -3.5F);
        		this.RightLeg.setRotationPoint(1.3F, 5.0F, -3.5F);
        		this.LeftFoot.setRotationPoint(0.0F, 1.5F, 0.3F);
        		this.RightFoot.setRotationPoint(-1.4F, 1.5F, 0.6F);
        		
        		this.BodyBase.rotateAngleX = 0F;
        		
        		this.RightLeg.rotateAngleX = (float) -(90 * Math.PI/180);
        		this.LeftLeg.rotateAngleX = (float) -(90 * Math.PI/180);
        		
        		this.setRotateAngle(LeftWing, 0.0F, 0.0F, 0.19198621771937624F);
        		this.setRotateAngle(RightWing, 0.0F, 0.0F, -0.18203784098300857F);
        		this.setRotateAngle(RightFoot, 0.0F, -0.2452187599052033F, 0.0F);
        		this.setRotateAngle(LeftFoot, 0.0F, 0.2452187599052033F, 0.0F);
    		}
    	}else {
    		this.BodyBase.setRotationPoint(0.0F, 14.0F, 0.0F);
    		this.LeftLeg.setRotationPoint(-1.3F, 7.0F, 0.0F);
    		this.RightLeg.setRotationPoint(1.3F, 7.0F, 0.0F);
    		this.LeftFoot.setRotationPoint(0.0F, 1.5F, 0.3F);
    		this.RightFoot.setRotationPoint(-1.4F, 1.5F, 0.6F);
    		
    		this.BodyBase.rotateAngleX = 0F;
    		this.RightLeg.rotateAngleX = 0F;
    		this.LeftLeg.rotateAngleX = 0F;
    		
    		this.setRotateAngle(LeftWing, 0.0F, 0.0F, 0.19198621771937624F);
    		this.setRotateAngle(RightWing, 0.0F, 0.0F, -0.18203784098300857F);
    		this.setRotateAngle(RightFoot, 0.0F, -0.2452187599052033F, 0.0F);
    		this.setRotateAngle(LeftFoot, 0.0F, 0.2452187599052033F, 0.0F);
    	}
    }
}
