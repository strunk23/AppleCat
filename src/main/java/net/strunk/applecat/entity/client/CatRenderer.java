package net.strunk.applecat.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.strunk.applecat.AppleCatMod;
import net.strunk.applecat.entity.custom.CatEntity;
import org.jetbrains.annotations.NotNull;

public class CatRenderer extends MobRenderer<CatEntity, AppleCat<CatEntity>> {
    public CatRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new AppleCat<>(pContext.bakeLayer(CatModelLayers.APPLE_CAT_LAYER)), 0.4f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull CatEntity pEntity) {
        return new ResourceLocation(AppleCatMod.MOD_ID, "textures/entity/collar_red.png");
    }

    @Override
    protected void scale(@NotNull CatEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float scale = 0.9F;
        pMatrixStack.scale(scale, scale, scale);
        super.scale(pLivingEntity, pMatrixStack, pPartialTickTime);
    }
}
