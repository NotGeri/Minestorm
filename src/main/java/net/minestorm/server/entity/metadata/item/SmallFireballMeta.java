package net.minestorm.server.entity.metadata.item;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import net.minestorm.server.entity.metadata.ObjectDataProvider;
import net.minestorm.server.entity.metadata.ProjectileMeta;
import net.minestorm.server.item.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SmallFireballMeta extends ItemContainingMeta implements ObjectDataProvider, ProjectileMeta {
    public static final byte OFFSET = ItemContainingMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 0;

    private Entity shooter;

    public SmallFireballMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata, Material.FIRE_CHARGE);
    }

    @Override
    @Nullable
    public Entity getShooter() {
        return shooter;
    }

    @Override
    public void setShooter(@Nullable Entity shooter) {
        this.shooter = shooter;
    }

    @Override
    public int getObjectData() {
        return this.shooter == null ? 0 : this.shooter.getEntityId();
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return true;
    }

}
