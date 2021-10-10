package net.minestorm.server.network.packet.client.status;

import net.minestorm.server.network.packet.client.ClientPreplayPacket;
import net.minestorm.server.network.player.PlayerConnection;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class LegacyServerListPingPacket implements ClientPreplayPacket {

    private byte payload;

    @Override
    public void process(@NotNull PlayerConnection connection) {

    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.payload = reader.readByte();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeByte(payload);
    }
}
