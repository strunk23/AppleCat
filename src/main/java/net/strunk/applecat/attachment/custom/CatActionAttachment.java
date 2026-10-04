package net.strunk.applecat.attachment.custom;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class CatActionAttachment {

    public static final StreamCodec<ByteBuf, CatActionAttachment> STREAM_CODEC =
            StreamCodec.of(
                    (buf, data) -> buf.writeBoolean(data.isActive()),
                    buf -> {
                        CatActionAttachment data = new CatActionAttachment();
                        data.setActive(buf.readBoolean());
                        return data;
                    }
            );

    private boolean active;

    public CatActionAttachment() {
        this.active = false;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
