package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ClearTitlesPacket implements ServerPacket {

    public boolean reset;

    public ClearTitlesPacket() {
    }

    public ClearTitlesPacket(boolean reset) {
        this.reset = reset;
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.reset = reader.readBoolean();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeBoolean(reset);
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.CLEAR_TITLES;
    }
}
