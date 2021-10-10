package net.minestorm.server.entity.metadata.flying;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class PhantomMeta extends FlyingMeta {
    public static final byte OFFSET = FlyingMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public PhantomMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public int getSize() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setSize(int value) {
        super.metadata.setIndex(OFFSET, Metadata.VarInt(value));
    }

}
