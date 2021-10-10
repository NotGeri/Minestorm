package net.minestorm.server.data.type.array;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class IntegerArrayData extends DataType<int[]> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull int[] value) {
        writer.writeVarInt(value.length);
        for (int val : value) {
            writer.writeInt(val);
        }
    }

    @NotNull
    @Override
    public int[] decode(@NotNull BinaryReader reader) {
        int[] array = new int[reader.readVarInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readInteger();
        }
        return array;
    }
}
