package net.minestorm.server.event.player;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.trait.PlayerEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Called after the player signals the server that his settings has been modified.
 */
public class PlayerSettingsChangeEvent implements PlayerEvent {

    private final Player player;

    public PlayerSettingsChangeEvent(@NotNull Player player) {
        this.player = player;
    }

    /**
     * Gets the player who changed his settings.
     * <p>
     * You can retrieve the new player settings with {@link Player#getSettings()}.
     *
     * @return the player
     */
    @NotNull
    @Override
    public Player getPlayer() {
        return player;
    }

}
