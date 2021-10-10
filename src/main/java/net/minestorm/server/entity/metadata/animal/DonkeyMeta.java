package net.minestorm.server.entity.metadata.animal;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class DonkeyMeta extends ChestedHorseMeta {
    public static final byte OFFSET = AnimalMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public DonkeyMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

}