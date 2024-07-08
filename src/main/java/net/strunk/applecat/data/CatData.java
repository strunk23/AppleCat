package net.strunk.applecat.data;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.common.capabilities.AutoRegisterCapability;

import java.util.UUID;

@AutoRegisterCapability
public class CatData {
    private UUID owner;

    private DyeColor collar;

    private net.minecraft.network.chat.Component tag;

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

    public net.minecraft.network.chat.Component getTag() {
        return tag;
    }

    public void setTag(net.minecraft.network.chat.Component tag) {
        this.tag = tag;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putUUID("Owner", owner);
        nbt.putInt("Collar", collar.getId());
        if (tag != null) {
            nbt.put("Tag", (Tag) tag);
        }
    }

    public void loadNBTData(CompoundTag nbt) {
        owner = nbt.getUUID("Owner");
        collar = DyeColor.byId(nbt.getInt("Collar"));
        if (nbt.get("Tag") != null) {
            tag = (Component) nbt.get("Tag");
        }
    }
}
