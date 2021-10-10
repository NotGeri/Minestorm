package net.minestorm.server.data.type;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class LongData extends DataType<Long> {
    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull Long value) {
        writer.writeLong(value);
    }

    @NotNull
    @Override
    public Long decode(@NotNull BinaryReader reader) {
        return reader.readLong();
    }
}
