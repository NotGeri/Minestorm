package net.minestorm.server.entity.metadata.monster.raider;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class WitchMeta extends RaiderMeta {
    public static final byte OFFSET = RaiderMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public WitchMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public boolean isDrinkingPotion() {
        return super.metadata.getIndex(OFFSET, false);
    }

    public void setDrinkingPotion(boolean value) {
        super.metadata.setIndex(OFFSET, Metadata.Boolean(value));
    }

}
