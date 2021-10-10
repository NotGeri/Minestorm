package net.minestorm.server.event.player;

import net.minestorm.server.entity.Player;
import net.minestorm.server.entity.PlayerSkin;
import net.minestorm.server.event.trait.PlayerEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Called at the player connection to initialize his skin.
 */
public class PlayerSkinInitEvent implements PlayerEvent {

    private final Player player;
    private PlayerSkin skin;

    public PlayerSkinInitEvent(@NotNull Player player, @Nullable PlayerSkin currentSkin) {
        this.player = player;
        this.skin = currentSkin;
    }

    /**
     * Gets the spawning skin of the player.
     *
     * @return the player skin, or null if not any
     */
    @Nullable
    public PlayerSkin getSkin() {
        return skin;
    }

    /**
     * Sets the spawning skin of the player.
     *
     * @param skin the new player skin
     */
    public void setSkin(@Nullable PlayerSkin skin) {
        this.skin = skin;
    }

    @Override
    public @NotNull Player getPlayer() {
        return player;
    }
}
