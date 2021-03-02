package com.bainhero.entitymod.util;

import com.bainhero.entitymod.EntityMod;
import com.bainhero.entitymod.common.items.MagmaSwordItem;
import com.bainhero.entitymod.common.items.ModItemTier;
import com.bainhero.entitymod.client.render.MagmaSwordRenderer;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EntityMod.MOD_ID);
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	public static final RegistryObject<SwordItem> UWU_SWORD = ITEMS.register("uwu_sword", () ->
			new SwordItem(ModItemTier.UWU, -1, 4F, new Item.Properties().maxStackSize(64).isImmuneToFire().group(ItemGroup.COMBAT)));
	
	public static final RegistryObject<MagmaSwordItem> MAGMA_SWORD = ITEMS.register("magma_sword", () ->
			new MagmaSwordItem(ModItemTier.MAGMA, 100, -1F, new Item.Properties().maxStackSize(1).isImmuneToFire()
					.group(ItemGroup.COMBAT).setISTER(() -> MagmaSwordRenderer::new)));
	
	
}
