package net.minestorm.server.utils.entity;

import net.minestorm.server.coordinate.Point;
import net.minestorm.server.coordinate.Pos;
import net.minestorm.server.entity.Entity;
import net.minestorm.server.instance.Chunk;
import net.minestorm.server.instance.Instance;
import net.minestorm.server.instance.block.Block;
import net.minestorm.server.utils.chunk.ChunkUtils;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public final class EntityUtils {

    private EntityUtils() {
    }

    public static void forEachRange(@NotNull Instance instance, @NotNull Point point,
                                    int viewDistance,
                                    @NotNull Consumer<Entity> consumer) {
        final long[] chunksInRange = ChunkUtils.getChunksInRange(point, viewDistance);
        for (long chunkIndex : chunksInRange) {
            final int chunkX = ChunkUtils.getChunkCoordX(chunkIndex);
            final int chunkZ = ChunkUtils.getChunkCoordZ(chunkIndex);
            final Chunk chunk = instance.getChunk(chunkX, chunkZ);
            if (chunk == null)
                continue;
            instance.getChunkEntities(chunk).forEach(consumer);
        }
    }

    public static boolean isOnGround(@NotNull Entity entity) {
        final Chunk chunk = entity.getChunk();
        if (chunk == null)
            return false;
        final Pos entityPosition = entity.getPosition();
        // TODO: check entire bounding box
        try {
            final Block block = chunk.getBlock(entityPosition.sub(0, 1, 0));
            return block.isSolid();
        } catch (NullPointerException e) {
            // Probably an entity at the border of an unloaded chunk
            return false;
        }
    }
}
