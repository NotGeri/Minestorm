package net.minestorm.server.entity.metadata.other;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class GlowItemFrameMeta extends ItemFrameMeta {
    public static final byte OFFSET = ItemFrameMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public GlowItemFrameMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }
}
