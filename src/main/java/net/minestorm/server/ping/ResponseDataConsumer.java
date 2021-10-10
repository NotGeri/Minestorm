package net.minestorm.server.ping;

import net.minestorm.server.MinecraftServer;
import net.minestorm.server.network.player.PlayerConnection;
import net.minestorm.server.event.server.ServerListPingEvent;

/**
 * Consumer used to fill a {@link ResponseData} object before being sent to a connection.
 *
 * <p>Can be specified in {@link MinecraftServer#start(String, int,
 * ResponseDataConsumer)}.
 *
 * @deprecated listen to the {@link ServerListPingEvent} instead
 */
@FunctionalInterface
@Deprecated
public interface ResponseDataConsumer {

    /**
     * A method to fill the data of the response.
     *
     * @param playerConnection The player connection to which the response should be sent.
     * @param responseData     The data for the response.
     */
    void accept(PlayerConnection playerConnection, ResponseData responseData);
}
