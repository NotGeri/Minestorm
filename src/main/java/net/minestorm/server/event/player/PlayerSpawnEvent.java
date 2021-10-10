package net.minestorm.server.event.player;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.trait.PlayerEvent;
import net.minestorm.server.instance.Instance;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a new instance is set for a player.
 */
public class PlayerSpawnEvent implements PlayerEvent {

    private final Player player;
    private final Instance spawnInstance;
    private final boolean firstSpawn;

    public PlayerSpawnEvent(@NotNull Player player, @NotNull Instance spawnInstance, boolean firstSpawn) {
        this.player = player;
        this.spawnInstance = spawnInstance;
        this.firstSpawn = firstSpawn;
    }

    /**
     * Gets the entity new instance.
     *
     * @return the instance
     */
    @NotNull
    public Instance getSpawnInstance() {
        return spawnInstance;
    }

    /**
     * 'true' if the player is spawning for the first time. 'false' if this spawn event was triggered by a dimension teleport
     *
     * @return true if this is the first spawn, false otherwise
     */
    public boolean isFirstSpawn() {
        return firstSpawn;
    }

    @Override
    public @NotNull Player getPlayer() {
        return player;
    }
}
