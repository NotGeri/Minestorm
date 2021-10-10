package net.minestorm.server.event.entity;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.potion.Potion;
import org.jetbrains.annotations.NotNull;

public class EntityPotionRemoveEvent implements EntityInstanceEvent {

    private final Entity entity;
    private final Potion potion;

    public EntityPotionRemoveEvent(@NotNull Entity entity, @NotNull Potion potion) {
        this.entity = entity;
        this.potion = potion;
    }

    /**
     * Returns the potion that was removed.
     *
     * @return the removed potion.
     */
    @NotNull
    public Potion getPotion() {
        return potion;
    }

    @Override
    public @NotNull Entity getEntity() {
        return entity;
    }
}
