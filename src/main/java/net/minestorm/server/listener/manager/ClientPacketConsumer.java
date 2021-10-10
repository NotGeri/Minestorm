package net.minestorm.server.listener.manager;

import net.minestorm.server.entity.Player;
import net.minestorm.server.network.ConnectionManager;
import net.minestorm.server.network.packet.client.ClientPlayPacket;
import org.jetbrains.annotations.NotNull;

/**
 * Interface used to add a listener for incoming packets with {@link ConnectionManager#onPacketReceive(ClientPacketConsumer)}.
 */
@FunctionalInterface
public interface ClientPacketConsumer {

    /**
     * Called when a packet is received from a client.
     *
     * @param player           the player concerned by the packet
     * @param packetController the packet controller, can be used to cancel the packet
     * @param packet           the packet
     */
    void accept(@NotNull Player player, @NotNull PacketController packetController, @NotNull ClientPlayPacket packet);
}
