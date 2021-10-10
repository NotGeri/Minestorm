package net.minestorm.server.entity.metadata;

import net.minestorm.server.entity.Entity;
import org.jetbrains.annotations.Nullable;

public interface ProjectileMeta {

    @Nullable
    Entity getShooter();

    void setShooter(@Nullable Entity shooter);

}
