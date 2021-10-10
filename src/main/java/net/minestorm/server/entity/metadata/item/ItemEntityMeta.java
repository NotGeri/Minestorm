package net.minestorm.server.entity.metadata.item;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import net.minestorm.server.entity.metadata.ObjectDataProvider;
import net.minestorm.server.item.Material;
import org.jetbrains.annotations.NotNull;

public class ItemEntityMeta extends ItemContainingMeta implements ObjectDataProvider {
    public static final byte OFFSET = ItemContainingMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public ItemEntityMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata, Material.AIR);
    }

    @Override
    public int getObjectData() {
        return 1;
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return true;
    }

}
