package net.strunk.applecat.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;

import java.util.UUID;

@AutoRegisterCapability
public class CatData {
    private UUID owner;

    private DyeColor collar;

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setCollar(DyeColor collar) {
        this.collar = collar;
    }

    public DyeColor getCollar() {
        return collar;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putUUID("Owner", owner);
        nbt.putInt("Collar", collar.getId());
    }

    public void loadNBTData(CompoundTag nbt) {
        owner = nbt.getUUID("Owner");
        collar = DyeColor.byId(nbt.getInt("Collar"));
    }
}
