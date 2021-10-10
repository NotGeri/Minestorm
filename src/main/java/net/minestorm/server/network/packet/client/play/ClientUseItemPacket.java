package net.minestorm.server.network.packet.client.play;

import net.minestorm.server.entity.Player;
import net.minestorm.server.network.packet.client.ClientPlayPacket;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ClientUseItemPacket extends ClientPlayPacket {

    public Player.Hand hand = Player.Hand.MAIN;

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.hand = Player.Hand.values()[reader.readVarInt()];
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(hand.ordinal());
    }
}
