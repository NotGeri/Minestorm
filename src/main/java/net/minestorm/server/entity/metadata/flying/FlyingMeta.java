package net.minestorm.server.entity.metadata.flying;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import net.minestorm.server.entity.metadata.MobMeta;
import org.jetbrains.annotations.NotNull;

public class FlyingMeta extends MobMeta {
    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    protected FlyingMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

}
