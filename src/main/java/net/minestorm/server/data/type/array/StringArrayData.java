package net.minestorm.server.data.type.array;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class StringArrayData extends DataType<String[]> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull String[] value) {
        writer.writeStringArray(value);
    }

    @NotNull
    @Override
    public String[] decode(@NotNull BinaryReader reader) {
        return reader.readSizedStringArray(Integer.MAX_VALUE);
    }
}
