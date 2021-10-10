package net.minestorm.server.data.type;

import net.minestorm.server.data.DataType;
import net.minestorm.server.data.SerializableData;
import net.minestorm.server.data.SerializableDataImpl;
import net.minestorm.server.utils.binary.BinaryReader;
import net.minestorm.server.utils.binary.BinaryWriter;
import org.jetbrains.annotations.NotNull;

// Pretty weird name huh?
public class SerializableDataData extends DataType<SerializableData> {

    @Override
    public void encode(@NotNull BinaryWriter writer, @NotNull SerializableData value) {
        writer.writeBytes(value.getIndexedSerializedData());
    }

    @NotNull
    @Override
    public SerializableData decode(@NotNull BinaryReader reader) {
        SerializableData serializableData = new SerializableDataImpl();
        serializableData.readIndexedSerializedData(reader);
        return serializableData;
    }
}
