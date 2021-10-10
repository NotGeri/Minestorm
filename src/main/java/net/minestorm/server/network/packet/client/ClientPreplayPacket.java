package net.minestorm.server.network.packet.client;

import net.minestorm.server.MinecraftServer;
import net.minestorm.server.network.ConnectionManager;
import net.minestorm.server.network.player.PlayerConnection;
import org.jetbrains.annotations.NotNull;

public interface ClientPreplayPacket extends ClientPacket {

    ConnectionManager CONNECTION_MANAGER = MinecraftServer.getConnectionManager();

    /**
     * Called when the packet is received.
     *
     * @param connection the connection who sent the packet
     */
    void process(@NotNull PlayerConnection connection);
}
