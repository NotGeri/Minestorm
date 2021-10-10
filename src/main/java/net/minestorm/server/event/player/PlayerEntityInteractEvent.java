package net.minestorm.server.event.player;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Player;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.event.trait.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a {@link Player} interacts (right-click) with an {@link Entity}.
 */
public class PlayerEntityInteractEvent implements PlayerEvent, EntityInstanceEvent {

    private final Player player;
    private final Entity entityTarget;
    private final Player.Hand hand;

    public PlayerEntityInteractEvent(@NotNull Player player, @NotNull Entity entityTarget, @NotNull Player.Hand hand) {
        this.player = player;
        this.entityTarget = entityTarget;
        this.hand = hand;
    }

    /**
     * Gets the {@link Entity} with who {@link #getPlayer()} is interacting.
     *
     * @return the {@link Entity}
     */
    @NotNull
    public Entity getTarget() {
        return entityTarget;
    }

    /**
     * Gets with which hand the player interacted with the entity.
     *
     * @return the hand
     */
    @NotNull
    public Player.Hand getHand() {
        return hand;
    }

    @Override
    public @NotNull Player getPlayer() {
        return player;
    }
}