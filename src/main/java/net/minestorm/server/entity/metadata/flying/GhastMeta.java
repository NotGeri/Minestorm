package net.minestorm.server.entity.metadata.flying;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class GhastMeta extends FlyingMeta {
    public static final byte OFFSET = FlyingMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public GhastMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public boolean isAttacking() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setAttacking(boolean value) {
        super.metadata.setIndex(OFFSET, Metadata.Boolean(value));
    }

}
