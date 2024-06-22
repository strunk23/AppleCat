package net.strunk.applecat.event;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.strunk.applecat.AppleCatMod;
import net.strunk.applecat.data.CatData;
import net.strunk.applecat.data.CatDataProvider;
import net.strunk.applecat.entity.RegisterEntity;
import net.strunk.applecat.entity.custom.CatEntity;

import java.util.Objects;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = AppleCatMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RegisterCatEvents {
    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteractSpecific event) {
        Entity entity = event.getTarget();
        Level level = event.getLevel();
        ItemStack item = event.getItemStack();

        if (entity instanceof Cat cat && item.getItem().toString().equals("apple") && ((Cat) entity).getVariant().equals(BuiltInRegistries.CAT_VARIANT.get(CatVariant.WHITE)) && cat.getOwner() != null) {
            UUID owner = cat.getOwnerUUID();
            spawnCustomCat(level, entity, entity.getX(), entity.getY(), entity.getZ(), owner, event);
            item.shrink(1);
        }
        if (entity instanceof CatEntity) {
            spawnCat(level, entity, entity.getX(), entity.getY(), entity.getZ());
        }
    }

    private static void spawnCustomCat(Level level, Entity entity, double x, double y, double z, UUID owner, PlayerInteractEvent.EntityInteractSpecific event) {
        entity.remove(Entity.RemovalReason.CHANGED_DIMENSION);
        EntityType<CatEntity> newCat = RegisterEntity.APPLE_CAT.get();
        CatEntity cat = newCat.create(level);
        assert cat != null;
        cat.getCapability(CatDataProvider.CAT_DATA).ifPresent(data -> {
            data.setOwner(owner);
        });
        cat.setPos(x, y, z);
        level.addFreshEntity(cat);
    }

    private static void spawnCat(Level level, Entity entity, double x, double y, double z) {
        LazyOptional<CatData> capability = entity.getCapability(CatDataProvider.CAT_DATA);
        entity.remove(Entity.RemovalReason.CHANGED_DIMENSION);
        EntityType<Cat> newCat = EntityType.CAT;
        Cat cat = newCat.create(level);
        assert cat != null;
        cat.setVariant(Objects.requireNonNull(BuiltInRegistries.CAT_VARIANT.get(CatVariant.WHITE)));
        capability.ifPresent(data -> {
            if (data.getOwner() != null) {
                cat.tame(Objects.requireNonNull(level.getPlayerByUUID(data.getOwner())));
            }
        });
        cat.setPos(x, y, z);
        level.addFreshEntity(cat);
    }
}
