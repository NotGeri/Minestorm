package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SelectAdvancementTabPacket implements ServerPacket {

    @Nullable
    public String identifier;

    public SelectAdvancementTabPacket() {
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        final boolean hasId = identifier != null;

        writer.writeBoolean(hasId);
        if (hasId) {
            writer.writeSizedString(identifier);
        }
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        boolean hasID = reader.readBoolean();
        if (hasID) {
            identifier = reader.readSizedString();
        } else {
            identifier = null;
        }
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.SELECT_ADVANCEMENT_TAB;
    }
}
