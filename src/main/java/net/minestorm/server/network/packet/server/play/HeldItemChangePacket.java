package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class HeldItemChangePacket implements ServerPacket {

    public byte slot;

    public HeldItemChangePacket(byte slot) {
        this.slot = slot;
    }

    public HeldItemChangePacket() {
        this((byte) 0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeByte(slot);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        slot = reader.readByte();
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.HELD_ITEM_CHANGE;
    }
}
