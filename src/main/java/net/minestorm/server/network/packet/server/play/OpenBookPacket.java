package net.minestorm.server.network.packet.server.play;

import net.minestorm.server.entity.Player;
import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.network.packet.server.ServerPacketIdentifier;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class OpenBookPacket implements ServerPacket {

    public Player.Hand hand;

    public OpenBookPacket(Player.Hand hand) {
        this.hand = hand;
    }

    public OpenBookPacket() {
        this(Player.Hand.MAIN);
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(hand.ordinal());
    }

    @Override
    public void read(@NotNull BinaryReader reader) {
        hand = Player.Hand.values()[reader.readVarInt()];
    }

    @Override
    public int getId() {
        return ServerPacketIdentifier.OPEN_BOOK;
    }
}
