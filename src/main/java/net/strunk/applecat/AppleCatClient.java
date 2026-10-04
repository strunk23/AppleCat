package net.strunk.applecat;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.NeoForge;
import net.strunk.applecat.entity.AppleCatEntities;
import net.strunk.applecat.entity.client.AppleCatRenderHandler;
import net.strunk.applecat.entity.client.AppleCatRenderer;

@Mod(value = AppleCat.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = AppleCat.MOD_ID, value = Dist.CLIENT)
public class AppleCatClient {
    public AppleCatClient(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        NeoForge.EVENT_BUS.register(AppleCatRenderHandler.class);
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(AppleCatEntities.APPLE_CAT.get(), AppleCatRenderer::new);
    }
}
