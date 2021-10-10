package net.minestorm.server.event.player;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.trait.PlayerEvent;
import net.minestorm.server.coordinate.Pos;
import net.minestorm.server.network.packet.client.play.ClientStatusPacket;
import org.jetbrains.annotations.NotNull;

/**
 * Called when {@link Player#respawn()} is executed (for custom respawn or as a result of
 * {@link ClientStatusPacket}
 */
public class PlayerRespawnEvent implements PlayerEvent {

    private final Player player;
    private Pos respawnPosition;

    public PlayerRespawnEvent(@NotNull Player player) {
        this.player = player;
        this.respawnPosition = player.getRespawnPoint();
    }

    /**
     * Gets the respawn position.
     * <p>
     * Is by default {@link Player#getRespawnPoint()}
     *
     * @return the respawn position
     */
    public @NotNull Pos getRespawnPosition() {
        return respawnPosition;
    }

    /**
     * Changes the respawn position.
     *
     * @param respawnPosition the new respawn position
     */
    public void setRespawnPosition(@NotNull Pos respawnPosition) {
        this.respawnPosition = respawnPosition;
    }

    @Override
    public @NotNull Player getPlayer() {
        return player;
    }
}
