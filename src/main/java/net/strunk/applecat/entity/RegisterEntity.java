package net.strunk.applecat.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.strunk.applecat.AppleCatMod;
import net.strunk.applecat.entity.custom.CatEntity;

public class RegisterEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AppleCatMod.MOD_ID);

    public static final RegistryObject<EntityType<CatEntity>> APPLE_CAT =
            ENTITY_TYPES.register("apple_cat", () -> EntityType.Builder.of(CatEntity::new, MobCategory.CREATURE)
                    .sized(0.8f, 0.8f).build("apple_cat"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
