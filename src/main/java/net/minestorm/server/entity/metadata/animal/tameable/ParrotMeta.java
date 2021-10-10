package net.minestorm.server.entity.metadata.animal.tameable;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class ParrotMeta extends TameableAnimalMeta {
    public static final byte OFFSET = TameableAnimalMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    public ParrotMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    @NotNull
    public Color getColor() {
        return Color.VALUES[super.metadata.getIndex(OFFSET, 0)];
    }

    public void setColor(@NotNull Color value) {
        super.metadata.setIndex(OFFSET, Metadata.VarInt(value.ordinal()));
    }

    public enum Color {
        RED_BLUE,
        BLUE,
        GREEN,
        YELLOW_BLUE,
        GREY;

        private final static Color[] VALUES = values();
    }

}
