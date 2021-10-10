package net.minestorm.server.event.entity;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import org.jetbrains.annotations.NotNull;

public class EntityDeathEvent implements EntityInstanceEvent {

    // TODO cause
    private final Entity entity;

    public EntityDeathEvent(@NotNull Entity entity) {
        this.entity = entity;
    }

    @Override
    public @NotNull Entity getEntity() {
        return entity;
    }
}
