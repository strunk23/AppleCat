package net.strunk.applecat.entity.client;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Cat;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.strunk.applecat.attachment.AppleCatAttachments;

public class AppleCatRenderHandler {

    @SubscribeEvent
    public static void renderCat(RenderLivingEvent.Pre<? extends LivingEntity, ?> event) {
        LivingEntity entity = event.getEntity();

        if (!(entity instanceof Cat cat)) { return; }
        if (!cat.hasData(AppleCatAttachments.CAT_ACTION)) { return; }
        if (!cat.getData(AppleCatAttachments.CAT_ACTION).isActive()) { return; }

        event.setCanceled(true);
    }
}