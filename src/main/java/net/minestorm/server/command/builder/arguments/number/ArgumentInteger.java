package net.minestorm.server.command.builder.arguments.number;

import net.minestorm.server.utils.binary.BinaryWriter;

public class ArgumentInteger extends ArgumentNumber<Integer> {

    public ArgumentInteger(String id) {
        super(id, "brigadier:integer", Integer::parseInt, Integer::parseInt, BinaryWriter::writeInt, Integer::compare);
    }

    @Override
    public String toString() {
        return String.format("Integer<%s>", getId());
    }
}
