package com.pression.compressed_chemistry.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.smashingmods.chemlib.client.AbbreviationRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AbbreviationRenderer.class)
public class ChemicalRendererMixin {

    @ModifyArg(method = "renderByItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/resources/model/ModelManager;getModel(Lnet/minecraft/client/resources/model/ModelResourceLocation;)Lnet/minecraft/client/resources/model/BakedModel;"), index = 0)
    private ModelResourceLocation changeModel(ModelResourceLocation original, @Local(argsOnly = true) ItemStack pStack){
        ResourceLocation itemRL = ForgeRegistries.ITEMS.getKey(pStack.getItem());
        ResourceLocation newRL = new ResourceLocation(itemRL.getNamespace(), "retextures/"+itemRL.getPath());
        ModelManager manager = Minecraft.getInstance().getItemRenderer().getItemModelShaper().getModelManager();
        BakedModel newModel = manager.getModel(new ModelResourceLocation(newRL, "inventory"));
        if(newModel == manager.getMissingModel()){
            return original;
        }
        else return new ModelResourceLocation(newRL, "inventory");
    }

    /*
    @Inject(method = "renderByItem", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;pushPose()V", ordinal = 0))
    private void switchModel(ItemStack pStack, ItemTransforms.TransformType pTransformType, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay, CallbackInfo ci, @Local BakedModel bakedModel, @Local ModelResourceLocation modelResourceLocation){
        ResourceLocation itemRL = ForgeRegistries.ITEMS.getKey(pStack.getItem());
        ResourceLocation newRL = new ResourceLocation(itemRL.getNamespace(), "retextures/"+itemRL.getPath());
        ModelManager manager = Minecraft.getInstance().getItemRenderer().getItemModelShaper().getModelManager();
        BakedModel newModel = manager.getModel(new ModelResourceLocation(newRL, "inventory"));
        if(newModel == manager.getMissingModel()){
            return;
        }
        bakedModel = newModel;
    }
*/


}
