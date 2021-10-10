package net.minestorm.server.listener.manager;

import net.minestorm.server.entity.Player;
import net.minestorm.server.network.packet.client.ClientPlayPacket;

/**
 * Small convenient interface to use method references with {@link PacketListenerManager#setListener(Class, PacketListenerConsumer)}.
 *
 * @param <T> the packet type
 */
@FunctionalInterface
public interface PacketListenerConsumer<T extends ClientPlayPacket> {
    void accept(T packet, Player player);
}
