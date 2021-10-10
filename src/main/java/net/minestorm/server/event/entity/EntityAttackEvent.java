package net.minestorm.server.event.entity;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.entity.EntityCreature;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a player does a left click on an entity or with
 * {@link EntityCreature#attack(Entity)}.
 */
public class EntityAttackEvent implements EntityInstanceEvent {

    private final Entity entity;
    private final Entity target;

    public EntityAttackEvent(@NotNull Entity source, @NotNull Entity target) {
        this.entity = source;
        this.target = target;
    }

    @Override
    public @NotNull Entity getEntity() {
        return entity;
    }

    /**
     * @return the target of the attack
     */
    @NotNull
    public Entity getTarget() {
        return target;
    }
}
