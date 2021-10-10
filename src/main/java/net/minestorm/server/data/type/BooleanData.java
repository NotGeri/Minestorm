package net.minestorm.server.data.type;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class BooleanData extends DataType<Boolean> {
    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull Boolean value) {
        writer.writeBoolean(value);
    }

    @NotNull
    @Override
    public Boolean decode(@NotNull BinaryReader reader) {
        return reader.readBoolean();
    }
}
