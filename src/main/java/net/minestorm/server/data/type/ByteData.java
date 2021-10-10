package net.minestorm.server.data.type;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class ByteData extends DataType<Byte> {
    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull Byte value) {
        writer.writeByte(value);
    }

    @NotNull
    @Override
    public Byte decode(@NotNull BinaryReader reader) {
        return reader.readByte();
    }
}
