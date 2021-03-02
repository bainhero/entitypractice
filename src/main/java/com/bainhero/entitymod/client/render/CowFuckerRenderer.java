package com.bainhero.entitymod.client.render;

import com.bainhero.entitymod.EntityMod;
import com.bainhero.entitymod.client.model.CowFuckerModel;
import com.bainhero.entitymod.entities.CowFuckerEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CowFuckerRenderer extends GeoEntityRenderer<CowFuckerEntity> {
	
	protected static final ResourceLocation TEXTURE = new ResourceLocation(EntityMod.MOD_ID, "textures/entity/cow_fucker.png");
	
	public CowFuckerRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CowFuckerModel());
	}

	@Override
	public RenderType getRenderType(CowFuckerEntity animatable, float partialTicks, MatrixStack stack,
			IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.getEntityTranslucent(getTextureLocation(animatable));
	}
}
