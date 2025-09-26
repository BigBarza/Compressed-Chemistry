package com.pression.compressed_chemistry;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.OnDatapackSyncEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(CompressedChemistry.MODID)
public class CompressedChemistry {
    public static final String MODID = "compressed_chemistry";
    public static final Logger LOGGER = LogUtils.getLogger();


    public CompressedChemistry() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(EventHandler.class);
        //ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CTCommonConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }


    public static class EventHandler {
        @SubscribeEvent
        public static void onReloadServerResources(OnDatapackSyncEvent e){

        }
    }

}
