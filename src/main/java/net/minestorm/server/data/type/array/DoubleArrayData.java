package net.minestorm.server.data.type.array;

import net.minestorm.server.data.DataType;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

public class DoubleArrayData extends DataType<double[]> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull double[] value) {
        writer.writeVarInt(value.length);
        for (double val : value) {
            writer.writeDouble(val);
        }
    }

    @NotNull
    @Override
    public double[] decode(@NotNull BinaryReader reader) {
        double[] array = new double[reader.readVarInt()];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readDouble();
        }
        return array;
    }
}
