package net.minestorm.server.event.instance;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.event.trait.CancellableEvent;
import net.minestorm.server.event.trait.EntityEvent;
import net.minestorm.server.event.trait.InstanceEvent;
import net.minestorm.server.instance.Instance;
import org.jetbrains.annotations.NotNull;

/**
 * Called by an Instance when an entity is added to it.
 * Can be used attach data.
 */
public class AddEntityToInstanceEvent implements InstanceEvent, EntityEvent, CancellableEvent {

    private final Instance instance;
    private final Entity entity;

    private boolean cancelled;

    public AddEntityToInstanceEvent(@NotNull Instance instance, @NotNull Entity entity) {
        this.instance = instance;
        this.entity = entity;
    }

    @Override
    public @NotNull Instance getInstance() {
        return instance;
    }

    /**
     * Entity being added.
     *
     * @return the entity being added
     */
    @NotNull
    public Entity getEntity() {
        return entity;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
