package net.minestorm.server.event.entity;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.LivingEntity;
import net.minestorm.server.entity.damage.DamageType;
import net.minestorm.server.event.trait.CancellableEvent;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Called with {@link LivingEntity#damage(DamageType, float)}.
 */
public class EntityDamageEvent implements EntityInstanceEvent, CancellableEvent {

    private final Entity entity;
    private final DamageType damageType;
    private float damage;

    private boolean cancelled;

    public EntityDamageEvent(@NotNull LivingEntity entity, @NotNull DamageType damageType, float damage) {
        this.entity = entity;
        this.damageType = damageType;
        this.damage = damage;
    }

    @NotNull
    @Override
    public LivingEntity getEntity() {
        return (LivingEntity) entity;
    }

    /**
     * Gets the damage type.
     *
     * @return the damage type
     */
    @NotNull
    public DamageType getDamageType() {
        return damageType;
    }

    /**
     * Gets the damage amount.
     *
     * @return the damage amount
     */
    public float getDamage() {
        return damage;
    }

    /**
     * Changes the damage amount.
     *
     * @param damage the new damage amount
     */
    public void setDamage(float damage) {
        this.damage = damage;
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
