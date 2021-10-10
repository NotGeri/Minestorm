package net.minestorm.server.listener.manager;

import net.minestorm.server.entity.Player;
import net.minestorm.server.network.packet.client.ClientPlayPacket;
import net.minestorm.server.network.packet.server.ServerPacket;

import java.util.Collection;

/**
 * Used to control the output of a packet in {@link ClientPacketConsumer#accept(Player, PacketController, ClientPlayPacket)}
 * and {@link ServerPacketConsumer#accept(Collection, PacketController, ServerPacket)}.
 */
public class PacketController {

    private boolean cancel;

    protected PacketController() {
    }

    /**
     * Gets if the packet is cancelled.
     *
     * @return true if the packet will be cancelled, false otherwise
     */
    public boolean isCancel() {
        return cancel;
    }

    /**
     * Used to cancel the packet.
     *
     * @param cancel true if the packet should be cancelled, false otherwise
     */
    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}
