package net.minestorm.server.event.player;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.trait.CancellableEvent;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.event.trait.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Called when the player swings his hand.
 */
public class PlayerHandAnimationEvent implements PlayerEvent, EntityInstanceEvent, CancellableEvent {

    private final Player player;
    private final Player.Hand hand;

    private boolean cancelled;

    public PlayerHandAnimationEvent(@NotNull Player player, @NotNull Player.Hand hand) {
        this.player = player;
        this.hand = hand;
    }

    /**
     * Gets the hand used.
     *
     * @return the hand
     */
    @NotNull
    public Player.Hand getHand() {
        return hand;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public @NotNull Player getPlayer() {
        return player;
    }
}
