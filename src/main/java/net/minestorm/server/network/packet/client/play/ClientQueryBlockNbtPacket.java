package net.minestorm.server.network.packet.client.play;

import net.minestorm.server.network.packet.client.ClientPlayPacket;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import net.minestorm.server.coordinate.Point;
import net.minestorm.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public class ClientQueryBlockNbtPacket extends ClientPlayPacket {

    public int transactionId;
    public Point blockPosition = Vec.ZERO;

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.transactionId = reader.readVarInt();
        this.blockPosition = reader.readBlockPosition();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(transactionId);
        writer.writeBlockPosition(blockPosition);
    }
}
