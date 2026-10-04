package net.strunk.applecat.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.strunk.applecat.AppleCat;
import net.strunk.applecat.Config;
import net.strunk.applecat.entity.custom.AppleCatEntity;

public class AppleCatRenderer extends MobRenderer<AppleCatEntity, AppleCatModel<AppleCatEntity>> {

    public AppleCatRenderer(EntityRendererProvider.Context context) {
        super(context, new AppleCatModel<>(context.bakeLayer(AppleCatModel.LAYER_LOCATION)), Config.SHADOW_RADIUS.get());
    }

    @Override
    public ResourceLocation getTextureLocation(AppleCatEntity appleCatEntity) {
        return ResourceLocation.fromNamespaceAndPath(AppleCat.MOD_ID, Config.TEXTURE_PATH.get());
    }

    @Override
    public void render(AppleCatEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
