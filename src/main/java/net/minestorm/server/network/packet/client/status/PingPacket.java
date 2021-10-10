package net.minestorm.server.network.packet.client.status;

import net.minestorm.server.MinecraftServer;
import net.minestorm.server.event.EventDispatcher;
import net.minestorm.server.event.server.ClientPingServerEvent;
import net.minestorm.server.network.packet.client.ClientPreplayPacket;
import net.minestorm.server.network.packet.server.status.PongPacket;
import net.minestorm.server.network.player.PlayerConnection;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class PingPacket implements ClientPreplayPacket {

    private long number;

    public PingPacket() {
    }

    @Override
    public void process(@NotNull PlayerConnection connection) {
        final ClientPingServerEvent clientPingEvent = new ClientPingServerEvent(connection, number);
        EventDispatcher.call(clientPingEvent);

        if (clientPingEvent.isCancelled()) {
            connection.disconnect();
        } else {
            if (clientPingEvent.getDelay().isZero()) {
                connection.sendPacket(new PongPacket(clientPingEvent.getPayload()));
                connection.disconnect();
            } else {
                MinecraftServer.getSchedulerManager().buildTask(() -> {
                    connection.sendPacket(new PongPacket(clientPingEvent.getPayload()));
                    connection.disconnect();
                }).delay(clientPingEvent.getDelay()).schedule();
            }
        }
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.number = reader.readLong();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeLong(number);
    }
}
