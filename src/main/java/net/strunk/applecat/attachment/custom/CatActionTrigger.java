package net.strunk.applecat.attachment.custom;

import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.strunk.applecat.AppleCat;
import net.strunk.applecat.attachment.AppleCatAttachments;

@EventBusSubscriber(modid = AppleCat.MOD_ID)
public class CatActionTrigger {

    @SubscribeEvent
    public static void onCatClick(PlayerInteractEvent.EntityInteract event) {
        if (event.getLevel().isClientSide()) {
            return;
        }

        if (!(event.getTarget() instanceof Cat cat)) {
            return;
        }

        if (!event.getItemStack().is(Items.APPLE)) {
            return;
        }

        CatActionAttachment action =
                cat.getData(AppleCatAttachments.CAT_ACTION);

        action.print();
    }
}
