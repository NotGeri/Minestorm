package net.minestorm.server.event.player;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.event.trait.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a player start flying.
 */
public class PlayerStartFlyingEvent implements PlayerEvent, EntityInstanceEvent {

    private final Player player;

    public PlayerStartFlyingEvent(@NotNull Player player) {
        this.player = player;
    }

    @Override
    public @NotNull Player getPlayer() {
        return player;
    }
}
