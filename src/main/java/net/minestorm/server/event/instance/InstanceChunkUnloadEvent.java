package net.minestorm.server.event.instance;

import net.minestorm.server.event.trait.InstanceEvent;
import net.minestorm.server.instance.Chunk;
import net.minestorm.server.instance.Instance;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a chunk in an instance is unloaded.
 */
public class InstanceChunkUnloadEvent implements InstanceEvent {

    private final Instance instance;
    private final Chunk chunk;

    public InstanceChunkUnloadEvent(@NotNull Instance instance, @NotNull Chunk chunk) {
        this.instance = instance;
        this.chunk = chunk;
    }

    @Override
    public @NotNull Instance getInstance() {
        return instance;
    }

    /**
     * Gets the chunk X.
     *
     * @return the chunk X
     */
    public int getChunkX() {
        return chunk.getChunkX();
    }

    /**
     * Gets the chunk Z.
     *
     * @return the chunk Z
     */
    public int getChunkZ() {
        return chunk.getChunkZ();
    }

    /**
     * Gets the chunk.
     *
     * @return the chunk.
     */
    public @NotNull Chunk getChunk() {
        return chunk;
    }
}
