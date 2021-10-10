package net.minestorm.server.data.type;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class FloatData extends DataType<Float> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull Float value) {
        writer.writeFloat(value);
    }

    @NotNull
    @Override
    public Float decode(@NotNull BinaryReader reader) {
        return reader.readFloat();
    }
}
