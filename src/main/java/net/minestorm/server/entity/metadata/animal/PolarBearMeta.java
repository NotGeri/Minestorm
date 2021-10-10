package net.minestorm.server.entity.metadata.animal;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class PolarBearMeta extends AnimalMeta {
    public static final byte OFFSET = AnimalMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public PolarBearMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public boolean isStandingUp() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setStandingUp(boolean value) {
        super.metadata.setIndex(OFFSET, Metadata.Boolean(value));
    }

}
