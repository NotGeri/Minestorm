package net.minestorm.server.network.packet.client.play;

import net.minestorm.server.entity.Player;
import net.minestorm.server.instance.block.BlockFace;
import net.minestorm.server.network.packet.client.ClientPlayPacket;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import net.minestorm.server.coordinate.Point;
import net.minestorm.server.coordinate.Vec;
import org.jetbrains.annotations.NotNull;

public class ClientPlayerBlockPlacementPacket extends ClientPlayPacket {

    public Player.Hand hand = Player.Hand.MAIN;
    public Point blockPosition = Vec.ZERO;
    public BlockFace blockFace = BlockFace.TOP;
    public float cursorPositionX, cursorPositionY, cursorPositionZ;
    public boolean insideBlock;

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.hand = Player.Hand.values()[reader.readVarInt()];
        this.blockPosition = reader.readBlockPosition();
        this.blockFace = BlockFace.values()[reader.readVarInt()];
        this.cursorPositionX = reader.readFloat();
        this.cursorPositionY = reader.readFloat();
        this.cursorPositionZ = reader.readFloat();
        this.insideBlock = reader.readBoolean();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeVarInt(hand.ordinal());
        writer.writeBlockPosition(blockPosition);
        writer.writeVarInt(blockFace.ordinal());
        writer.writeFloat(cursorPositionX);
        writer.writeFloat(cursorPositionY);
        writer.writeFloat(cursorPositionZ);
        writer.writeBoolean(insideBlock);
    }
}
