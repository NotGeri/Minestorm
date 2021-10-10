package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class DisplayScoreboardPacket implements ServerPacket {

    public byte position;
    public String scoreName;

    public DisplayScoreboardPacket() {
        scoreName = "";
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeByte(position);
        writer.writeSizedString(scoreName);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        position = reader.readByte();
        scoreName = reader.readSizedString();
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.DISPLAY_SCOREBOARD;
    }
}
