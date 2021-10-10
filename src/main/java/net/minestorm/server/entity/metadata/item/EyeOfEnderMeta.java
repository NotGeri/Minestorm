package net.minestorm.server.entity.metadata.item;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import net.minestorm.server.item.Material;
import org.jetbrains.annotations.NotNull;

public class EyeOfEnderMeta extends ItemContainingMeta {
    public static final byte OFFSET = ItemContainingMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public EyeOfEnderMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata, Material.ENDER_EYE);
    }

}
