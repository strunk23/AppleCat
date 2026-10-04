package net.strunk.applecat.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.strunk.applecat.AppleCat;
import net.strunk.applecat.entity.AppleCatEntities;
import net.strunk.applecat.entity.client.AppleCatModel;
import net.strunk.applecat.entity.custom.AppleCatEntity;

@EventBusSubscriber(modid = AppleCat.MOD_ID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(AppleCatModel.LAYER_LOCATION, AppleCatModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(AppleCatEntities.APPLE_CAT.get(), AppleCatEntity.createMobAttributes().build());
    }
}
