package net.strunk.applecat.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.strunk.applecat.AppleCat;
import net.strunk.applecat.entity.custom.AppleCatEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, AppleCat.MOD_ID);

    public static final Supplier<EntityType<AppleCatEntity>> APPLE_CAT =
            ENTITY_TYPES.register("apple_cat", () -> EntityType.Builder.of(AppleCatEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.5f).build("apple_cat"));

    public static void register(IEventBus bus) {
        ENTITY_TYPES.register(bus);
    }
}
