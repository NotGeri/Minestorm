package net.minestorm.server.entity.metadata.animal;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class PigMeta extends AnimalMeta {
    public static final byte OFFSET = AnimalMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 2;

    public PigMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public boolean isHasSaddle() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setHasSaddle(boolean value) {
        super.metadata.setIndex(OFFSET, Metadata.Boolean(value));
    }

    public int getTimeToBoost() {
        return super.metadata.getIndex(OFFSET + 1, 0);
    }

    public void setTimeToBoost(int value) {
        super.metadata.getIndex(OFFSET + 1, Metadata.VarInt(value));
    }

}
