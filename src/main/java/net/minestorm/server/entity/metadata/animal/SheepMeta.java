package net.minestorm.server.entity.metadata.animal;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class SheepMeta extends AnimalMeta {
    public static final byte OFFSET = AnimalMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    private final static byte COLOR_BITS = 0x0F;
    private final static byte SHEARED_BIT = 0x10;

    public SheepMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public int getColor() {
        return getMask(OFFSET) & COLOR_BITS;
    }

    public void setColor(byte color) {
        byte before = getMask(OFFSET);
        byte mask = before;
        mask &= ~COLOR_BITS;
        mask |= (color & COLOR_BITS);
        if (mask != before) {
            setMask(OFFSET, mask);
        }
    }

    public boolean isSheared() {
        return getMaskBit(OFFSET, SHEARED_BIT);
    }

    public void setSheared(boolean value) {
        setMaskBit(OFFSET, SHEARED_BIT, value);
    }

}
