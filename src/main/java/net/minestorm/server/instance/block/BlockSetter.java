package net.minestorm.server.instance.block;

import net.minestorm.server.coordinate.Point;
import net.minestorm.server.instance.Instance;
import net.minestorm.server.instance.batch.Batch;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an element which can place blocks at position.
 * <p>
 * Notably used by {@link Instance}, {@link Batch}.
 */
public interface BlockSetter {
    void setBlock(int x, int y, int z, @NotNull Block block);

    default void setBlock(@NotNull Point blockPosition, @NotNull Block block) {
        setBlock(blockPosition.blockX(), blockPosition.blockY(), blockPosition.blockZ(), block);
    }
}
