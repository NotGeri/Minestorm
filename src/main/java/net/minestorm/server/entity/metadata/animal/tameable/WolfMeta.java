package net.minestorm.server.entity.metadata.animal.tameable;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class WolfMeta extends TameableAnimalMeta {
    public static final byte OFFSET = TameableAnimalMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 3;

    public WolfMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public boolean isBegging() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setBegging(boolean value) {
        super.metadata.setIndex(OFFSET, Metadata.Boolean(value));
    }

    public int getCollarColor() {
        return super.metadata.getIndex(OFFSET + 1, 14);
    }

    public void setCollarColor(int value) {
        super.metadata.setIndex(OFFSET + 1, Metadata.VarInt(value));
    }

    public int getAngerTime() {
        return super.metadata.getIndex(OFFSET + 2, 0);
    }

    public void setAngerTime(int value) {
        super.metadata.setIndex(OFFSET + 2, Metadata.VarInt(value));
    }

}
