package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class PingPacket implements ServerPacket {

    public int id;

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.id = reader.readInt();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeInt(id);
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.PING;
    }
}
