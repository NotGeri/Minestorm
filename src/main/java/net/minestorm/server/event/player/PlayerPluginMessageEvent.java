package net.minestorm.server.event.player;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.event.trait.PlayerEvent;
import net.minestorm.server.network.packet.client.play.ClientPluginMessagePacket;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a player send {@link ClientPluginMessagePacket}.
 */
public class PlayerPluginMessageEvent implements PlayerEvent, EntityInstanceEvent {

    private final Player player;
    private final String identifier;
    private final byte[] message;

    public PlayerPluginMessageEvent(@NotNull Player player, @NotNull String identifier, @NotNull byte[] message) {
        this.player = player;
        this.identifier = identifier;
        this.message = message;
    }

    /**
     * Gets the message identifier.
     *
     * @return the identifier
     */
    @NotNull
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Gets the message data as a byte array.
     *
     * @return the message
     */
    @NotNull
    public byte[] getMessage() {
        return message;
    }

    /**
     * Gets the message data as a String.
     *
     * @return the message
     */
    @NotNull
    public String getMessageString() {
        return new String(message);
    }

    @Override
    public @NotNull Player getPlayer() {
        return player;
    }
}
