package net.minestorm.server.data.type;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class CharacterData extends DataType<Character> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull Character value) {
        writer.writeChar(value);
    }

    @NotNull
    @Override
    public Character decode(@NotNull BinaryReader reader) {
        return reader.readChar();
    }
}
