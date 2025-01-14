package net.minestorm.server.network.packet.server.status;

import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class PongPacket implements ServerPacket {

    public long number;

    /**
     * Default constructor, required for reflection operations.
     */
    public PongPacket() {}

    public PongPacket(long number) {
        this.number = number;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeLong(number);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        number = reader.readLong();
    }

    @Override
    public int getId() {
        return 0x01;
    }
}
