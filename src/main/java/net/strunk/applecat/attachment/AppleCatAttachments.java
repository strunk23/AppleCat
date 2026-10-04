package net.strunk.applecat.attachment;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.strunk.applecat.AppleCat;
import net.strunk.applecat.attachment.custom.CatActionAttachment;

import java.util.function.Supplier;

public class AppleCatAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
            DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, AppleCat.MOD_ID);

    public static final Supplier<AttachmentType<CatActionAttachment>> CAT_ACTION =
            ATTACHMENT_TYPES.register("cat_action", () -> AttachmentType.builder(CatActionAttachment::new).build());

    public static void register(IEventBus modBus) {
        ATTACHMENT_TYPES.register(modBus);
    }
}
