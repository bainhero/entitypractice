package com.bainhero.entitymod;

import com.bainhero.entitymod.entities.CowFuckerEntity;
import com.bainhero.entitymod.init.ModEntityTypes;
import com.bainhero.entitymod.util.RegistryHandler;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.example.GeckoLibMod;
// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(EntityMod.MOD_ID)
public class EntityMod {
    // Directly reference a log4j logger.
    // private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "entitymod";

    public EntityMod() {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::doClientStuff);
        
        GeckoLibMod.DISABLE_IN_DEV = true;
        GeckoLib.initialize();
        
        RegistryHandler.init();
        ModEntityTypes.ENTITY_TYPES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SuppressWarnings("deprecation")
	private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() ->{
        	GlobalEntityTypeAttributes.put(ModEntityTypes.COW_FUCKER.get(), CowFuckerEntity.setCustomAttributes().create());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        
    }

}
