package net.minestorm.server.event.trait;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.event.Event;
import org.jetbrains.annotations.NotNull;

/**
 * Represents any event called on an {@link Entity}.
 */
public interface EntityEvent extends Event {

    /**
     * Gets the entity of this event.
     *
     * @return the entity
     */
    @NotNull Entity getEntity();
}
