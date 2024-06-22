package net.strunk.applecat.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;

import java.util.UUID;

@AutoRegisterCapability
public class CatData {
    private UUID owner;

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public UUID getOwner() {
        return owner;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putUUID("Owner", owner);
    }

    public void loadNBTData(CompoundTag nbt) {
        owner = nbt.getUUID("Owner");
    }
}
