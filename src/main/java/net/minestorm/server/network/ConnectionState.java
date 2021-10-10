package net.minestorm.server.network;

import net.minestorm.server.network.player.PlayerConnection;

/**
 * Represents the current connection state of a {@link PlayerConnection}.
 */
public enum ConnectionState {
    UNKNOWN, STATUS, LOGIN, PLAY
}
