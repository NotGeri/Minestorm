package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import net.minestorm.server.world.Difficulty;
import org.jetbrains.annotations.NotNull;

public class ServerDifficultyPacket implements ServerPacket {

    public Difficulty difficulty;
    public boolean locked;

    public ServerDifficultyPacket(Difficulty difficulty, boolean locked) {
        this.difficulty = difficulty;
        this.locked = locked;
    }

    public ServerDifficultyPacket() {
        this(Difficulty.NORMAL, false);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeByte((byte) difficulty.ordinal());
        writer.writeBoolean(locked);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        difficulty = Difficulty.values()[reader.readByte()];
        locked = reader.readBoolean();
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.SERVER_DIFFICULTY;
    }
}
