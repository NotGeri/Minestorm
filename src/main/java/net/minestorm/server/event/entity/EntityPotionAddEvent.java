package net.minestorm.server.event.entity;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.potion.Potion;
import org.jetbrains.annotations.NotNull;

public class EntityPotionAddEvent implements EntityInstanceEvent {

    private final Entity entity;
    private final Potion potion;

    public EntityPotionAddEvent(@NotNull Entity entity, @NotNull Potion potion) {
        this.entity = entity;
        this.potion = potion;
    }

    @NotNull
    @Override
    public Entity getEntity() {
        return entity;
    }

    /**
     * Returns the potion that was added.
     *
     * @return the added potion.
     */
    @NotNull
    public Potion getPotion() {
        return potion;
    }
}
