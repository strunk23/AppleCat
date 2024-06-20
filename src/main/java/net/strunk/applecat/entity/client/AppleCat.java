package net.strunk.applecat.entity.client;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class AppleCat<T extends Entity> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "catcustom1"), "main");
    private final ModelPart cat;

    public AppleCat(ModelPart root) {
        this.cat = root.getChild("cat");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition cat = partdefinition.addOrReplaceChild("cat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition tail2 = cat.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(4, 15).addBox(-0.5F, -1.0F, -8.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 16.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition tail = cat.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.5F, 8.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, -9.5F, -1.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.5F, -8.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition front_right_leg = cat.addOrReplaceChild("front_right_leg", CubeListBuilder.create(), PartPose.offset(-1.1F, -9.9F, -5.0F));

        PartDefinition front_right_leg_r1 = front_right_leg.addOrReplaceChild("front_right_leg_r1", CubeListBuilder.create().texOffs(40, 0).addBox(-3.1F, -11.9F, 0.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 9.9F, 5.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition back_left_leg = cat.addOrReplaceChild("back_left_leg", CubeListBuilder.create(), PartPose.offset(1.1F, -6.0F, 5.0F));

        PartDefinition back_left_leg_r1 = back_left_leg.addOrReplaceChild("back_left_leg_r1", CubeListBuilder.create().texOffs(8, 13).addBox(1.1F, -8.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 6.0F, -5.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition back_right_leg = cat.addOrReplaceChild("back_right_leg", CubeListBuilder.create(), PartPose.offset(-1.1F, -6.0F, 5.0F));

        PartDefinition back_right_leg_r1 = back_right_leg.addOrReplaceChild("back_right_leg_r1", CubeListBuilder.create().texOffs(8, 13).addBox(-3.1F, -8.0F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 6.0F, -5.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition front_left_leg = cat.addOrReplaceChild("front_left_leg", CubeListBuilder.create(), PartPose.offset(1.1F, -9.9F, -5.0F));

        PartDefinition front_left_leg_r1 = front_left_leg.addOrReplaceChild("front_left_leg_r1", CubeListBuilder.create().texOffs(40, 0).addBox(1.1F, -11.9F, 0.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 9.9F, 5.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition body = cat.addOrReplaceChild("body", CubeListBuilder.create().texOffs(20, 0).addBox(-2.0F, 3.0F, -12.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -10.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition head = cat.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 2.0F, -3.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-1.5F, 3.98F, -4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-2.0F, 1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 10).addBox(1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, -9.0F));

        PartDefinition apple = cat.addOrReplaceChild("apple", CubeListBuilder.create().texOffs(38, 21).addBox(-2.0F, -3.0F, -13.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        cat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}