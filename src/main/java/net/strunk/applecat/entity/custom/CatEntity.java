package net.strunk.applecat.entity.custom;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.animal.CatVariant;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class CatEntity extends Mob {
    public CatEntity(EntityType<? extends Mob> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 6.0f));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10d)
                .add(Attributes.FOLLOW_RANGE, 0d);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource pDamageSource) {
        return SoundEvents.CAT_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.CAT_DEATH;
    }

    @Override
    protected void dropCustomDeathLoot(@NotNull DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);

        if (!this.level().isClientSide) {
            ItemStack stack = new ItemStack(Items.APPLE);
            this.spawnAtLocation(stack);
        }
    }

    @Override
    protected @NotNull InteractionResult mobInteract(Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if (item.equals(Items.AIR)) {
            stack = new ItemStack(Items.APPLE);
            player.setItemInHand(hand, stack);
            this.remove(RemovalReason.CHANGED_DIMENSION);
            spawnCat(this.level(), this.getX(), this.getY(), this.getZ());
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    private static void spawnCat(Level level, double x, double y, double z) {
        EntityType<Cat> newCat = EntityType.CAT;
        Cat cat = newCat.create(level);
        if (cat != null) {
            cat.setVariant(Objects.requireNonNull(BuiltInRegistries.CAT_VARIANT.get(CatVariant.WHITE)));
            cat.setPos(x, y, z);
            level.addFreshEntity(cat);
        }
    }
}
