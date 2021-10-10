package net.minestorm.server.entity.metadata.other;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import net.minestorm.server.entity.metadata.EntityMeta;
import org.jetbrains.annotations.NotNull;

public class PrimedTntMeta extends EntityMeta {
    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public PrimedTntMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public int getFuseTime() {
        return super.metadata.getIndex(OFFSET, 80);
    }

    public void setFuseTime(int value) {
        super.metadata.setIndex(OFFSET, Metadata.VarInt(value));
    }

}
