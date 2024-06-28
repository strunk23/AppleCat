package net.strunk.applecat.event;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
        Player player = event.getEntity();
        Level level = event.getLevel();
        ItemStack item = event.getItemStack();

        if (entity instanceof Cat cat && item.getItem().toString().equals("apple") && ((Cat) entity).getVariant().equals(BuiltInRegistries.CAT_VARIANT.get(CatVariant.WHITE)) && cat.getOwner() != null) {
            UUID owner = cat.getOwnerUUID();
            DyeColor collar = cat.getCollarColor();
            spawnCustomCat(level, entity, entity.getX(), entity.getY(), entity.getZ(), owner, collar);
            item.shrink(1);
        }
        if (entity instanceof CatEntity) {
            spawnCat(level, entity, entity.getX(), entity.getY(), entity.getZ());
            player.setItemInHand(InteractionHand.MAIN_HAND, new ItemStack(Items.APPLE));
        }
    }

    private static void spawnCustomCat(Level level, Entity entity, double x, double y, double z, UUID owner, DyeColor collar) {
        entity.remove(Entity.RemovalReason.CHANGED_DIMENSION);
        // texture variant should be chosen here and passed to CatEntity
        EntityType<CatEntity> newCat = RegisterEntity.APPLE_CAT.get();
        CatEntity cat = newCat.create(level);
        assert cat != null;
        cat.getCapability(CatDataProvider.CAT_DATA).ifPresent(data -> {
            data.setOwner(owner);
            data.setCollar(collar);
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
                cat.setCollarColor(data.getCollar());
            }
        });
        cat.setPos(x, y, z);
        level.addFreshEntity(cat);
    }
}
