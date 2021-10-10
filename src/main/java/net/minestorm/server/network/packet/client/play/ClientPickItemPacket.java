package net.minestorm.server.network.packet.client.play;

import net.minestorm.server.network.packet.client.ClientPlayPacket;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ClientPickItemPacket extends ClientPlayPacket {

    public int slotToUse;

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.slotToUse = reader.readVarInt();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(slotToUse);
    }
}