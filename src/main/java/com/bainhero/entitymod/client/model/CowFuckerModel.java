package com.bainhero.entitymod.client.model;

import com.bainhero.entitymod.EntityMod;
import com.bainhero.entitymod.entities.CowFuckerEntity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CowFuckerModel extends AnimatedGeoModel<CowFuckerEntity>{

	@Override
	public ResourceLocation getAnimationFileLocation(CowFuckerEntity animatable) {
		return new ResourceLocation(EntityMod.MOD_ID, "animations/cow_fucker_walk.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(CowFuckerEntity object) {
		return new ResourceLocation(EntityMod.MOD_ID, "geo/cow_fucker.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(CowFuckerEntity object) {
		return new ResourceLocation(EntityMod.MOD_ID, "textures/entity/cow_fucker.png");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setLivingAnimations(CowFuckerEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
		super.setLivingAnimations(entity, uniqueID, customPredicate);
		IBone head = this.getAnimationProcessor().getBone("head");

		LivingEntity entityIn = (LivingEntity) entity;
		EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
		head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
		head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
	}
}
