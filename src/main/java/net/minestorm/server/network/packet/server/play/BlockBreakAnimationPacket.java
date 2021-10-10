package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import net.minestorm.server.coordinate.Point;
import net.minestorm.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public class BlockBreakAnimationPacket implements ServerPacket {

    public int entityId;
    public Point blockPosition;
    public byte destroyStage;

    public BlockBreakAnimationPacket() {
        blockPosition = Vec.ZERO;
    }

    public BlockBreakAnimationPacket(int entityId, Point blockPosition, byte destroyStage) {
        this.entityId = entityId;
        this.blockPosition = blockPosition;
        this.destroyStage = destroyStage;
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(entityId);
        writer.writeBlockPosition(blockPosition);
        writer.writeByte(destroyStage);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.entityId = reader.readVarInt();
        this.blockPosition = reader.readBlockPosition();
        this.destroyStage = reader.readByte();
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.BLOCK_BREAK_ANIMATION;
    }
}