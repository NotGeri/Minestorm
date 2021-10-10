package net.minestorm.server.entity.metadata.monster.raider;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import org.jetbrains.annotations.NotNull;

public class EvokerMeta extends SpellcasterIllagerMeta {
    public static final byte OFFSET = SpellcasterIllagerMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    public EvokerMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

}
