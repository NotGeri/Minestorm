package net.minestorm.server.command.builder.arguments.minecraft.registry;

import net.minestorm.server.command.builder.NodeMaker;
import net.minestorm.server.network.packet.server.play.DeclareCommandsPacket;
import net.minestorm.server.particle.Particle;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an argument giving a {@link Particle}.
 */
public class ArgumentParticle extends ArgumentRegistry<Particle> {

    public ArgumentParticle(String id) {
        super(id);
    }

    @Override
    public Particle getRegistry(@NotNull String value) {
        return Particle.fromNamespaceId(value);
    }

    @Override
    public void processNodes(@NotNull NodeMaker nodeMaker, boolean executable) {
        DeclareCommandsPacket.Node argumentNode = simpleArgumentNode(this, executable, false, false);
        argumentNode.parser = "minecraft:particle";

        nodeMaker.addNodes(new DeclareCommandsPacket.Node[]{argumentNode});
    }

    @Override
    public String toString() {
        return String.format("Particle<%s>", getId());
    }
}
