package com.pression.compressed_chemistry.event;

import com.pression.compressed_chemistry.CompressedChemistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT, modid = CompressedChemistry.MODID)
public class ClientEvents {

    @SubscribeEvent
    public static void registerChemlibRetextures(ModelEvent.RegisterAdditional e){
        ResourceManager mahager = Minecraft.getInstance().getResourceManager();
        Map<ResourceLocation, Resource> resources = mahager.listResources("models/item/retextures", rl ->
           rl.getNamespace().equals("chemlib")
        );
        resources.forEach((rl, resource) -> {
            String path = rl.getPath().substring("models/item/".length());
            path = path.substring(0, path.length() - 5); //".json"
            ResourceLocation resourceLocation = new ResourceLocation(rl.getNamespace(), path);
            CompressedChemistry.LOGGER.info("Baking retexture: {}", resourceLocation);
            e.register(new ModelResourceLocation(resourceLocation, "inventory"));
        });
    }

}
