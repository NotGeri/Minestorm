package net.minestorm.server.entity.metadata.arrow;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Metadata;
import net.minestorm.server.entity.metadata.ObjectDataProvider;
import net.minestorm.server.entity.metadata.ProjectileMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArrowMeta extends AbstractArrowMeta implements ObjectDataProvider, ProjectileMeta {
    public static final byte OFFSET = AbstractArrowMeta.MAX_OFFSET;
    public static final byte MAX_OFFSET = OFFSET + 1;

    private Entity shooter;

    public ArrowMeta(@NotNull Entity entity, @NotNull Metadata metadata) {
        super(entity, metadata);
    }

    public int getColor() {
        return super.metadata.getIndex(OFFSET, -1);
    }

    public void setColor(int value) {
        super.metadata.setIndex(OFFSET, Metadata.VarInt(value));
    }

    @Override
    @Nullable
    public Entity getShooter() {
        return this.shooter;
    }

    @Override
    public void setShooter(@Nullable Entity shooter) {
        this.shooter = shooter;
    }

    @Override
    public int getObjectData() {
        return this.shooter == null ? 0 : this.shooter.getEntityId() + 1;
    }

    @Override
    public boolean requiresVelocityPacketAtSpawn() {
        return true;
    }

}