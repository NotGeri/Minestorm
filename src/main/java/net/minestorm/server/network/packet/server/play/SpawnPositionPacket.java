package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.coordinate.Point;
import net.minestorm.server.coordinate.Vec;
import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class SpawnPositionPacket implements ServerPacket {

    public Point position;
    public float angle;

    public SpawnPositionPacket(Point position, float angle) {
        this.position = position;
        this.angle = angle;
    }

    public SpawnPositionPacket() {
        this(Vec.ZERO, 0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeBlockPosition(position);
        writer.writeFloat(angle);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.position = reader.readBlockPosition();
        this.angle = reader.readFloat();
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.SPAWN_POSITION;
    }
}
