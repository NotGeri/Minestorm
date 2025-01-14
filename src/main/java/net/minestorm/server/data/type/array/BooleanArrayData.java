package net.minestorm.server.data.type.array;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class BooleanArrayData extends DataType<boolean[]> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull boolean[] value) {
        writer.writeVarInt(value.length);
        for (boolean val : value) {
            writer.writeBoolean(val);
        }
    }

    @NotNull
    @Override
    public boolean[] decode(@NotNull BinaryReader reader) {
        boolean[] array = new boolean[reader.readVarInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readBoolean();
        }
        return array;
    }
}
