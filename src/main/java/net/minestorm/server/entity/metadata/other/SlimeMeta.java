package net.minestorm.server.entity.metadata.other;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import net.minestorm.server.entity.metadata.MobMeta;
import org.jetbrains.annotations.NotNull;

public class SlimeMeta extends MobMeta {
    public static final byte OFFSET = MobMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public SlimeMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public int getSize() {
        return super.metadata.getIndex(OFFSET, 0);
    }

    public void setSize(int value) {
        float boxSize = 0.51000005f * value;
        setBoundingBox(boxSize, boxSize);
        super.metadata.setIndex(OFFSET, Metadata.VarInt(value));
    }

}
