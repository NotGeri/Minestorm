package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class CameraPacket implements ServerPacket {

    public int cameraId;

    public CameraPacket(int cameraId) {
        this.cameraId = cameraId;
    }

    public CameraPacket(@NotNull Entity camera) {
        this(camera.getEntityId());
    }

    public CameraPacket() {
        this(0);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(cameraId);
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        cameraId = reader.readVarInt();
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.CAMERA;
    }
}
