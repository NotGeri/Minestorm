package net.minestorm.server.network.packet.client.play;

import net.minestorm.server.network.packet.client.ClientPlayPacket;
import net.minestorm.server.resourcepack.ResourcePackStatus;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ClientResourcePackStatusPacket extends ClientPlayPacket {

    public ResourcePackStatus result = ResourcePackStatus.SUCCESS;

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.result = ResourcePackStatus.values()[reader.readVarInt()];
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(result.ordinal());
    }
}
