package net.strunk.applecat.event;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.strunk.applecat.AppleCatMod;
import net.strunk.applecat.data.CatData;
import net.strunk.applecat.data.CatDataProvider;
import net.strunk.applecat.entity.custom.CatEntity;

@Mod.EventBusSubscriber(modid = AppleCatMod.MOD_ID)
public class CapabilityRegistrationEvent {

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(CatData.class);
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof CatEntity) {
            if (!event.getObject().getCapability(CatDataProvider.CAT_DATA).isPresent()) {
                event.addCapability(new ResourceLocation(AppleCatMod.MOD_ID, "cat_data"), new CatDataProvider());
            }
        }
    }
}
