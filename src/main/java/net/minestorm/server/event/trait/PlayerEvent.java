package net.minestorm.server.event.trait;

import net.minestorm.server.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Represents any event called on a {@link Player}.
 */
public interface PlayerEvent extends EntityEvent {

    /**
     * Gets the player.
     *
     * @return the player
     */
    @NotNull Player getPlayer();

    /**
     * Returns {@link #getPlayer()}.
     */
    @Override
    default @NotNull Player getEntity() {
        return getPlayer();
    }
}
