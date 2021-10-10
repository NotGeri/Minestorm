package net.minestorm.server.data.type;

import net.minestorm.server.data.DataType;
import net.minestorm.server.item.ItemStack;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ItemStackData extends DataType<ItemStack> {
    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull ItemStack value) {
        writer.writeItemStack(value);
    }

    @NotNull
    @Override
    public ItemStack decode(@NotNull BinaryReader reader) {
        return reader.readItemStack();
    }
}
