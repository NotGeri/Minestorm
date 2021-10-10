package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class EnterCombatEventPacket  implements ServerPacket {

    @Override
    public void read(@NotNull BinaryReader reader) {
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.ENTER_COMBAT_EVENT;
    }
}
