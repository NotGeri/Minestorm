package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class EndCombatEventPacket implements ServerPacket {

    public int duration;
    public int entityId;

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.duration = reader.readVarInt();
        this.entityId = reader.readInt();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(duration);
        writer.writeInt(entityId);
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.END_COMBAT_EVENT;
    }
}
