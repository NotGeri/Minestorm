package net.minestorm.server.network.packet.client.play;

import net.minestorm.server.network.packet.client.ClientPlayPacket;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ClientSelectTradePacket extends ClientPlayPacket {

    public int selectedSlot;

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.selectedSlot = reader.readVarInt();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(selectedSlot);
    }
}
