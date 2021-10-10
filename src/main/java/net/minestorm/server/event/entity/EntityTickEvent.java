package net.minestorm.server.event.entity;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Called when an entity ticks itself.
 * Same event instance used for all tick events for the same entity.
 */
public class EntityTickEvent implements EntityInstanceEvent {

    private final Entity entity;

    public EntityTickEvent(@NotNull Entity entity) {
        this.entity = entity;
    }

    @Override
    public @NotNull Entity getEntity() {
        return entity;
    }
}
