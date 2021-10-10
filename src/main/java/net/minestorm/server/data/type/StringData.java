package net.minestorm.server.data.type;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class StringData extends DataType<String> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull String value) {
        writer.writeSizedString(value);
    }

    @NotNull
    @Override
    public String decode(@NotNull BinaryReader reader) {
        return reader.readSizedString();
    }
}
