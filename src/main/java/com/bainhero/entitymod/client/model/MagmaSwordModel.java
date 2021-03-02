package com.bainhero.entitymod.client.model;

import com.bainhero.entitymod.EntityMod;
import com.bainhero.entitymod.common.items.MagmaSwordItem;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MagmaSwordModel extends AnimatedGeoModel<MagmaSwordItem> {

	@Override
	public ResourceLocation getAnimationFileLocation(MagmaSwordItem animatable) {
		// TODO Auto-generated method stub
		return new ResourceLocation(EntityMod.MOD_ID, "animations/magma_sword.animation.json");
	}

	@Override
	public ResourceLocation getModelLocation(MagmaSwordItem object) {
		// TODO Auto-generated method stub
		return new ResourceLocation(EntityMod.MOD_ID, "geo/magma_sword.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(MagmaSwordItem object) {
		// TODO Auto-generated method stub
		return new ResourceLocation(EntityMod.MOD_ID, "textures/items/magma_sword.png");
	}

}
