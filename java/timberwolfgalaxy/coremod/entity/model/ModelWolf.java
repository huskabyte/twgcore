package timberwolfgalaxy.coremod.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import timberwolfgalaxy.coremod.entity.EntityWolf;

/**
 * SiberianHusky - Undefined Created using Tabula 7.1.0
 */
public class ModelWolf extends ModelBase {
	
	public ModelRenderer Body;
	public ModelRenderer Under;
	public ModelRenderer Butt;
	public ModelRenderer Under2;
	public ModelRenderer Front;
	public ModelRenderer Tail;
	public ModelRenderer BackLeftLeg;
	public ModelRenderer BackRightLeg;
	public ModelRenderer Tail2;
	public ModelRenderer Tail3;
	public ModelRenderer Tail4;
	public ModelRenderer Tail5;
	public ModelRenderer Tail6;
	public ModelRenderer BackLeftLeg2;
	public ModelRenderer BackRightLeg2;
	public ModelRenderer FrontUnder;
	public ModelRenderer Neck;
	public ModelRenderer FrontLeftLeg;
	public ModelRenderer FrontRightLeg;
	public ModelRenderer Head;
	public ModelRenderer Muzzle;
	public ModelRenderer NoseHelper;
	public ModelRenderer LEar1;
	public ModelRenderer REar1;
	public ModelRenderer Nose;
	public ModelRenderer Mouth;
	public ModelRenderer LEar2;
	public ModelRenderer REar2;
	public ModelRenderer FrontLeftLeg2;
	public ModelRenderer FrontRightLeg2;

	public ModelWolf() {
		this.textureWidth = 128;
		this.textureHeight = 45;
		this.Under2 = new ModelRenderer(this, 71, 15);
		this.Under2.setRotationPoint(0.0F, 1.0F, -0.9F);
		this.Under2.addBox(-3.5F, 0.0F, -4.5F, 7, 4, 13, 0.0F);
		this.setRotateAngle(Under2, 0.15707963267948966F, 0.0F, 0.0F);
		this.BackRightLeg = new ModelRenderer(this, 110, 0);
		this.BackRightLeg.setRotationPoint(-4.0F, 6.0F, 4.5F);
		this.BackRightLeg.addBox(0.0F, 0.0F, 0.0F, 3, 4, 5, 0.0F);
		this.Tail6 = new ModelRenderer(this, 5, 0);
		this.Tail6.setRotationPoint(0.0F, 0.0F, 2.0F);
		this.Tail6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.setRotateAngle(Tail6, 0.5585053606381855F, 0.0F, 0.0F);
		this.Under = new ModelRenderer(this, 42, 0);
		this.Under.setRotationPoint(0.0F, 1.0F, -0.9F);
		this.Under.addBox(-3.5F, 0.0F, -5.5F, 7, 3, 14, 0.0F);
		this.setRotateAngle(Under, -0.19687313962496036F, 0.0F, 0.0F);
		this.LEar1 = new ModelRenderer(this, 9, 0);
		this.LEar1.setRotationPoint(1.0F, -5.0F, 0.0F);
		this.LEar1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.BackLeftLeg2 = new ModelRenderer(this, 6, 3);
		this.BackLeftLeg2.setRotationPoint(0.0F, 2.0F, 0.0F);
		this.BackLeftLeg2.addBox(0.0F, -1.0F, 1.0F, 2, 8, 2, 0.0F);
		this.LEar2 = new ModelRenderer(this, 27, 0);
		this.LEar2.setRotationPoint(1.0F, 0.0F, 0.0F);
		this.LEar2.addBox(0.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
		this.REar1 = new ModelRenderer(this, 43, 0);
		this.REar1.setRotationPoint(-1.0F, -5.0F, 0.0F);
		this.REar1.addBox(-2.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
		this.REar2 = new ModelRenderer(this, 51, 0);
		this.REar2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.REar2.addBox(-2.0F, -1.0F, 0.0F, 1, 2, 1, 0.0F);
		this.Front = new ModelRenderer(this, 35, 17);
		this.Front.setRotationPoint(0.0F, -3.5F, -2.0F);
		this.Front.addBox(-3.5F, 0.0F, -7.0F, 7, 9, 7, 0.0F);
		this.Tail = new ModelRenderer(this, 0, 0);
		this.Tail.setRotationPoint(0.0F, 0.0F, 9.0F);
		this.Tail.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(Tail, 0.3740240587023848F, -0.05899212871740834F, 0.0F);
		this.Tail2 = new ModelRenderer(this, 38, 0);
		this.Tail2.setRotationPoint(0.0F, 0.0F, 2.0F);
		this.Tail2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(Tail2, 0.593411945678072F, 0.0F, 0.0F);
		this.Head = new ModelRenderer(this, 104, 33);
		this.Head.setRotationPoint(0.0F, -2.5F, -1.8F);
		this.Head.addBox(-3.0F, -4.0F, -3.0F, 6, 6, 6, 0.0F);
		this.setRotateAngle(Head, -0.6799802765769908F, 0.0F, 0.0F);
		this.Mouth = new ModelRenderer(this, 75, 0);
		this.Mouth.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.Mouth.addBox(-1.0F, 0.0F, -1.5F, 2, 1, 1, 0.0F);
		this.setRotateAngle(Mouth, -0.15455541180735036F, 0.0F, 0.0F);
		this.Tail3 = new ModelRenderer(this, 46, 0);
		this.Tail3.setRotationPoint(0.0F, 0.0F, 2.0F);
		this.Tail3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(Tail3, 0.8377580409572781F, 0.0F, 0.0F);
		this.BackRightLeg2 = new ModelRenderer(this, 110, 9);
		this.BackRightLeg2.setRotationPoint(0.0F, 2.0F, 0.0F);
		this.BackRightLeg2.addBox(1.0F, -1.0F, 1.0F, 2, 9, 2, 0.0F);
		this.FrontUnder = new ModelRenderer(this, 98, 20);
		this.FrontUnder.setRotationPoint(0.0F, 7.1F, -3.5F);
		this.FrontUnder.addBox(-3.5F, 0.0F, -2.5F, 7, 2, 6, 0.0F);
		this.setRotateAngle(FrontUnder, -0.15707963267948966F, 0.0F, 0.0F);
		this.FrontRightLeg2 = new ModelRenderer(this, 68, 17);
		this.FrontRightLeg2.setRotationPoint(0.0F, 2.0F, 0.0F);
		this.FrontRightLeg2.addBox(-1.0F, -1.0F, 1.0F, 2, 8, 2, 0.0F);
		this.Tail5 = new ModelRenderer(this, 78, 0);
		this.Tail5.setRotationPoint(0.0F, 0.0F, 2.0F);
		this.Tail5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(Tail5, 1.1344640137963142F, 0.0F, 0.0F);
		this.BackLeftLeg = new ModelRenderer(this, 27, 0);
		this.BackLeftLeg.setRotationPoint(1.0F, 7.0F, 4.5F);
		this.BackLeftLeg.addBox(0.0F, -1.0F, 0.0F, 3, 4, 5, 0.0F);
		this.Butt = new ModelRenderer(this, 84, 0);
		this.Butt.setRotationPoint(0.0F, -3.5F, 0.0F);
		this.Butt.addBox(-3.5F, 0.0F, 4.0F, 7, 9, 6, 0.0F);
		this.FrontRightLeg = new ModelRenderer(this, 39, 5);
		this.FrontRightLeg.setRotationPoint(-2.0F, 7.0F, -5.0F);
		this.FrontRightLeg.addBox(-2.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
		this.FrontLeftLeg = new ModelRenderer(this, 70, 4);
		this.FrontLeftLeg.setRotationPoint(2.0F, 7.0F, -5.0F);
		this.FrontLeftLeg.addBox(-1.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
		this.NoseHelper = new ModelRenderer(this, 104, 0);
		this.NoseHelper.setRotationPoint(0.0F, -1.1F, -5.0F);
		this.NoseHelper.addBox(-1.5F, -0.3F, 0.0F, 3, 1, 2, 0.0F);
		this.setRotateAngle(NoseHelper, 0.2935643801854462F, 0.0F, 0.0F);
		this.Nose = new ModelRenderer(this, 56, 17);
		this.Nose.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Nose.addBox(-1.5F, -1.5F, -2.0F, 3, 3, 3, 0.0F);
		this.Muzzle = new ModelRenderer(this, 27, 9);
		this.Muzzle.setRotationPoint(0.0F, 0.0F, -4.0F);
		this.Muzzle.addBox(-2.0F, -1.0F, -1.0F, 4, 3, 2, 0.0F);
		this.Neck = new ModelRenderer(this, 0, 22);
		this.Neck.setRotationPoint(0.0F, 2.0F, -5.0F);
		this.Neck.addBox(-3.0F, -4.0F, -4.0F, 6, 6, 6, 0.0F);
		this.setRotateAngle(Neck, 0.6799802765769908F, 0.0F, 0.0F);
		this.Body = new ModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 12.0F, 0.0F);
		this.Body.addBox(-3.0F, -3.0F, -7.5F, 6, 7, 15, 0.0F);
		this.FrontLeftLeg2 = new ModelRenderer(this, 118, 9);
		this.FrontLeftLeg2.setRotationPoint(0.0F, 2.0F, 0.0F);
		this.FrontLeftLeg2.addBox(-1.0F, -1.0F, 1.0F, 2, 8, 2, 0.0F);
		this.Tail4 = new ModelRenderer(this, 70, 0);
		this.Tail4.setRotationPoint(0.0F, 0.0F, 2.0F);
		this.Tail4.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
		this.setRotateAngle(Tail4, 0.7155849933176751F, 0.0F, 0.0F);
		this.Body.addChild(this.Under2);
		this.Butt.addChild(this.BackRightLeg);
		this.Tail5.addChild(this.Tail6);
		this.Body.addChild(this.Under);
		this.Head.addChild(this.LEar1);
		this.BackLeftLeg.addChild(this.BackLeftLeg2);
		this.LEar1.addChild(this.LEar2);
		this.Head.addChild(this.REar1);
		this.REar1.addChild(this.REar2);
		this.Body.addChild(this.Front);
		this.Butt.addChild(this.Tail);
		this.Tail.addChild(this.Tail2);
		this.Neck.addChild(this.Head);
		this.Muzzle.addChild(this.Mouth);
		this.Tail2.addChild(this.Tail3);
		this.BackRightLeg.addChild(this.BackRightLeg2);
		this.Front.addChild(this.FrontUnder);
		this.FrontRightLeg.addChild(this.FrontRightLeg2);
		this.Tail4.addChild(this.Tail5);
		this.Butt.addChild(this.BackLeftLeg);
		this.Body.addChild(this.Butt);
		this.Front.addChild(this.FrontRightLeg);
		this.Front.addChild(this.FrontLeftLeg);
		this.Head.addChild(this.NoseHelper);
		this.Muzzle.addChild(this.Nose);
		this.Head.addChild(this.Muzzle);
		this.Front.addChild(this.Neck);
		this.FrontLeftLeg.addChild(this.FrontLeftLeg2);
		this.Tail3.addChild(this.Tail4);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.Body.render(f5);
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
		if (!((EntityWolf) entityIn).isSitting()) {
			this.FrontRightLeg2.rotateAngleX = MathHelper.cos(-limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
			this.FrontLeftLeg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * -limbSwingAmount;
			this.BackLeftLeg2.rotateAngleX = (float) (MathHelper.cos(-limbSwing * 0.6662F) * 1.4F * -limbSwingAmount
					- (10 * Math.PI / 180));
			this.BackRightLeg2.rotateAngleX = (float) (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount
					- (10 * Math.PI / 180));
		}
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount,
			float partialTickTime) {
		if (((EntityWolf) entitylivingbaseIn).isSitting()) {
			if(((EntityWolf) entitylivingbaseIn).isTrick2()){
				Body.rotateAngleX = 0F;
				Butt.rotateAngleX = 0F;
				Front.rotateAngleX = 0F;
				
				Neck.rotateAngleX = (float) (38.96 * Math.PI / 180);
				
				BackLeftLeg2.rotateAngleX = (float) (-88 * Math.PI / 180);
				BackRightLeg2.rotateAngleX = (float) (-88 * Math.PI / 180);
				FrontLeftLeg2.rotateAngleX = (float) (-97 * Math.PI / 180);
				FrontRightLeg2.rotateAngleX = (float) (-97 * Math.PI / 180);
				
				this.Body.setRotationPoint(0.0F, 17.0F, 0.0F);
			}else if(((EntityWolf) entitylivingbaseIn).isTrick3()) {
				Body.rotateAngleX = (float) (-90 * Math.PI / 180);
				Butt.rotateAngleX = (float) (0 * Math.PI / 180);
				Front.rotateAngleX = (float) (18 * Math.PI / 180);
				
				Neck.rotateAngleX = (float) (90 * Math.PI / 180);
				
				BackLeftLeg2.rotateAngleX = 0F;
				BackRightLeg2.rotateAngleX = 0F;
				FrontLeftLeg2.rotateAngleX = 0F;
				FrontRightLeg2.rotateAngleX = 0F;
				
				this.Body.setRotationPoint(0.0F, 15.0F, 0.0F);
			}else {
				Body.rotateAngleX = (float) (-57 * Math.PI / 180);
				Butt.rotateAngleX = (float) (-25 * Math.PI / 180);
				Front.rotateAngleX = (float) (18 * Math.PI / 180);
				
				Neck.rotateAngleX = (float) (90 * Math.PI / 180);
				
				BackLeftLeg2.rotateAngleX = 0F;
				BackRightLeg2.rotateAngleX = 0F;
				FrontLeftLeg2.rotateAngleX = 0F;
				FrontRightLeg2.rotateAngleX = 0F;
				
				this.Body.setRotationPoint(0.0F, 15.0F, 0.0F);
			}
		} else {
			Body.rotateAngleX = 0F;
			Butt.rotateAngleX = 0F;
			Front.rotateAngleX = 0F;
			
			Neck.rotateAngleX = (float) (38.96 * Math.PI / 180);
			
			this.Body.setRotationPoint(0.0F, 12.0F, 0.0F);
		}
	}
}
