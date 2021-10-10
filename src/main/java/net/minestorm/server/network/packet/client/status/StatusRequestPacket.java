package net.minestorm.server.network.packet.client.status;

import net.minestorm.server.event.EventDispatcher;
import net.minestorm.server.event.server.ServerListPingEvent;
import net.minestorm.server.network.packet.client.ClientPreplayPacket;
import net.minestorm.server.network.packet.server.handshake.ResponsePacket;
import net.minestorm.server.network.player.PlayerConnection;
import net.minestorm.server.ping.ServerListPingType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class StatusRequestPacket implements ClientPreplayPacket {

    @Override
    public void process(@NotNull PlayerConnection connection) {
        final ServerListPingType pingVersion = ServerListPingType.fromModernProtocolVersion(connection.getProtocolVersion());
        final ServerListPingEvent statusRequestEvent = new ServerListPingEvent(connection, pingVersion);
        EventDispatcher.callCancellable(statusRequestEvent, () ->
                connection.sendPacket(new ResponsePacket(pingVersion.getPingResponse(statusRequestEvent.getResponseData()))));
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        // Empty
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        // Empty
    }
}
