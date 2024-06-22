package net.strunk.applecat.data;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CatDataProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {

    public static Capability<CatData> CAT_DATA = CapabilityManager.get(new CapabilityToken<CatData>() {});

    private CatData owner = null;
    private final LazyOptional<CatData> optional = LazyOptional.of(this::createCatData);

    private CatData createCatData() {
        if (this.owner == null) {
            this.owner = new CatData();
        }
        return this.owner;
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return cap == CAT_DATA ? optional.cast() : LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        createCatData().saveNBTData(nbt);
        return nbt;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        createCatData().loadNBTData(nbt);
    }
}
