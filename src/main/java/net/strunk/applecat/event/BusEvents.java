package net.strunk.applecat.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.strunk.applecat.AppleCatMod;
import net.strunk.applecat.entity.RegisterEntity;
import net.strunk.applecat.entity.custom.CatEntity;

@Mod.EventBusSubscriber(modid = AppleCatMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(RegisterEntity.APPLE_CAT.get(), CatEntity.createAttributes().build());
    }
}
