package net.minestorm.server.data.type;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ShortData extends DataType<Short> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull Short value) {
        writer.writeShort(value);
    }

    @NotNull
    @Override
    public Short decode(@NotNull BinaryReader reader) {
        return reader.readShort();
    }
}
