package net.minestorm.server.instance;

import net.minestorm.server.instance.batch.ChunkBatch;

public interface ChunkPopulator {

    void populateChunk(ChunkBatch batch, Chunk chunk);

}
