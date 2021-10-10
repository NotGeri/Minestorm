package net.minestorm.server.network.packet.client.play;

import net.minestorm.server.item.ItemStack;
import net.minestorm.server.network.packet.client.ClientPlayPacket;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ClientCreativeInventoryActionPacket extends ClientPlayPacket {

    public short slot;
    public ItemStack item = ItemStack.AIR;

    @Override
    public void read(@NotNull BinaryReader reader) {
        this.slot = reader.readShort();
        this.item = reader.readItemStack();
    }

    @Override
    public void write(@NotNull BinaryWriter writer) {
        writer.writeShort(slot);
        writer.writeItemStack(item);
    }
}
