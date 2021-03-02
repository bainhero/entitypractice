package com.bainhero.entitymod.init;

import com.bainhero.entitymod.EntityMod;
import com.bainhero.entitymod.entities.CowFuckerEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
	public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, EntityMod.MOD_ID);
	
	// Entity Types
	
	public static final RegistryObject<EntityType<CowFuckerEntity>> COW_FUCKER = ENTITY_TYPES.register("cow_fucker",
			() -> EntityType.Builder.create(CowFuckerEntity::new, EntityClassification.CREATURE)
					.size(1.0F, 2.0F)
					.build(new ResourceLocation(EntityMod.MOD_ID, "cow_fucker").toString()));
}
