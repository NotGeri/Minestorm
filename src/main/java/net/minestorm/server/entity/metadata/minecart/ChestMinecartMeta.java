package net.minestorm.server.entity.metadata.minecart;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class ChestMinecartMeta extends AbstractMinecartContainerMeta {
    public static final byte OFFSET = AbstractMinecartContainerMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public ChestMinecartMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    @Override
    public int getObjectData() {
        return 1;
    }

}
