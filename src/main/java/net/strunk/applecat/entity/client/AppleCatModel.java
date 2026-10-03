package net.strunk.applecat.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.strunk.applecat.AppleCat;
import net.strunk.applecat.entity.custom.AppleCatEntity;

public class AppleCatModel<T extends AppleCatEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(AppleCat.MOD_ID, "applecat"), "main");
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart backLegL;
    private final ModelPart backLegR;
    private final ModelPart frontLegL;
    private final ModelPart frontLegR;
    private final ModelPart bone;

    public AppleCatModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = this.body.getChild("head");
        this.tail1 = this.body.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.backLegL = this.body.getChild("backLegL");
        this.backLegR = this.body.getChild("backLegR");
        this.frontLegL = this.body.getChild("frontLegL");
        this.frontLegR = this.body.getChild("frontLegR");
        this.bone = root.getChild("bone");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 17.0F, 1.0F));

        PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(20, 0).addBox(-2.0F, -8.0F, -3.0F, 4.0F, 16.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 24).addBox(-1.5F, -0.0156F, -4.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 10).addBox(-2.0F, -3.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -10.0F));

        PartDefinition tail1 = body.addOrReplaceChild("tail1", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 7.0F));

        PartDefinition tail1_r1 = tail1.addOrReplaceChild("tail1_r1", CubeListBuilder.create().texOffs(0, 15).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8988F, 0.0F, 0.0F));

        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 8.0F));

        PartDefinition tail2_r1 = tail2.addOrReplaceChild("tail2_r1", CubeListBuilder.create().texOffs(4, 15).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -1.7F, 1.5708F, 0.0F, 0.0F));

        PartDefinition backLegL = body.addOrReplaceChild("backLegL", CubeListBuilder.create(), PartPose.offset(-1.1F, 1.0F, 6.0F));

        PartDefinition backLegL_r1 = backLegL.addOrReplaceChild("backLegL_r1", CubeListBuilder.create().texOffs(8, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -1.5708F, 0.4363F, 0.0F));

        PartDefinition backLegR = body.addOrReplaceChild("backLegR", CubeListBuilder.create(), PartPose.offset(1.1F, 1.0F, 6.0F));

        PartDefinition backLegR_r1 = backLegR.addOrReplaceChild("backLegR_r1", CubeListBuilder.create().texOffs(8, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -1.5708F, -0.4363F, 0.0F));

        PartDefinition frontLegL = body.addOrReplaceChild("frontLegL", CubeListBuilder.create(), PartPose.offset(-1.2F, 3.0F, -5.0F));

        PartDefinition frontLegL_r1 = frontLegL.addOrReplaceChild("frontLegL_r1", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -0.2F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -1.5708F, 0.1745F, 0.0F));

        PartDefinition frontLegR = body.addOrReplaceChild("frontLegR", CubeListBuilder.create(), PartPose.offset(1.2F, -3.0F, -5.0F));

        PartDefinition frontLegR_r1 = frontLegR.addOrReplaceChild("frontLegR_r1", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -0.2F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -1.5708F, -0.1745F, 0.0F));

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(16, 23).addBox(-10.0F, -3.0F, -5.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 24.0F, -8.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(AppleCatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }
}