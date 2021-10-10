package net.minestorm.server.data.type.array;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class FloatArrayData extends DataType<float[]> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull float[] value) {
        writer.writeVarInt(value.length);
        for (float val : value) {
            writer.writeFloat(val);
        }
    }

    @NotNull
    @Override
    public float[] decode(@NotNull BinaryReader reader) {
        float[] array = new float[reader.readVarInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readFloat();
        }
        return array;
    }
}
