package net.minestorm.server.network.packet.client.play;

import net.minestorm.server.network.packet.client.ClientPlayPacket;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ClientSetBeaconEffectPacket extends ClientPlayPacket {

    public int primaryEffect;
    public int secondaryEffect;

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.primaryEffect = reader.readVarInt();
        this.secondaryEffect = reader.readVarInt();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(primaryEffect);
        writer.writeVarInt(secondaryEffect);
    }
}
