package net.minestorm.server.data.type.array;

import net.minestorm.server.data.DataType;
import net.minestorm.server.item.ItemStack;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ItemStackArrayData extends DataType<ItemStack[]> {
    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull ItemStack[] value) {
        writer.writeVarInt(value.length);
        for (ItemStack itemStack : value) {
            writer.writeItemStack(itemStack);
        }
    }

    @NotNull
    @Override
    public ItemStack[] decode(@NotNull BinaryReader reader) {
        ItemStack[] items = new ItemStack[reader.readVarInt()];
        for (int i = 0; i < items.length; i++) {
            items[i] = reader.readItemStack();
        }
        return items;
    }
}
