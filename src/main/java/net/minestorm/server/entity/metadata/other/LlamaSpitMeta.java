package net.minestorm.server.entity.metadata.other;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import net.minestorm.server.entity.metadata.EntityMeta;
import net.minestorm.server.entity.metadata.ObjectDataProvider;
import org.jetbrains.annotations.NotNull;

public class LlamaSpitMeta extends EntityMeta implements ObjectDataProvider {
    public static final byte OFFSET = EntityMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public LlamaSpitMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    @Override
    public int getObjectData() {
        return 0;
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return true;
    }

}
