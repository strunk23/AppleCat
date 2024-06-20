package net.strunk.applecat.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.strunk.applecat.AppleCatMod;
import net.strunk.applecat.entity.client.AppleCat;
import net.strunk.applecat.entity.client.CatModelLayers;

@Mod.EventBusSubscriber(modid = AppleCatMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class BusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CatModelLayers.APPLE_CAT_LAYER, AppleCat::createBodyLayer);
    }
}
