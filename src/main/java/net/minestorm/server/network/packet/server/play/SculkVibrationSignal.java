package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.coordinate.Point;
import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class SculkVibrationSignal implements ServerPacket {

    public Point position;
    public String destinationIdentifier;
    // TODO 'varies' destination
    public int arrivalTicks;

    @Override
    public void read(@NotNull BinaryReader reader) {

    }

    @Override
    public void write(@NotNull BinaryWriter writer) {

    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.SCULK_VIBRATION_SIGNAL;
    }
}
