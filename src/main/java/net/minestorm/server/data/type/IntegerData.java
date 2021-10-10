package net.minestorm.server.data.type;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class IntegerData extends DataType<Integer> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull Integer value) {
        writer.writeVarInt(value);
    }

    @NotNull
    @Override
    public Integer decode(@NotNull BinaryReader reader) {
        return reader.readVarInt();
    }
}