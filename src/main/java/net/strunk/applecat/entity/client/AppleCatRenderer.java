package net.strunk.applecat.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.strunk.applecat.AppleCat;
import net.strunk.applecat.entity.custom.AppleCatEntity;
import org.jetbrains.annotations.NotNull;

public class AppleCatRenderer extends MobRenderer<AppleCatEntity, AppleCatModel<AppleCatEntity>> {

    public AppleCatRenderer(EntityRendererProvider.Context context) {
        super(context, new AppleCatModel<>(context.bakeLayer(AppleCatModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull AppleCatEntity appleCatEntity) {
        return ResourceLocation.fromNamespaceAndPath(AppleCat.MOD_ID, "textures/entity/apple_cat.png");
    }

    @Override
    public void render(@NotNull AppleCatEntity entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
