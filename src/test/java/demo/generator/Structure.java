package demo.generator;

import net.minestorm.server.coordinate.Point;
import net.minestorm.server.coordinate.Vec;
import net.minestorm.server.instance.Chunk;
import net.minestorm.server.instance.batch.ChunkBatch;
import net.minestorm.server.instance.block.Block;

import java.util.HashMap;
import java.util.Map;

public class Structure {

    private final Map<Point, Block> blocks = new HashMap<>();

    public void build(ChunkBatch batch, Point pos) {
        blocks.forEach((bPos, block) -> {
            if (bPos.x() + pos.x() >= Chunk.CHUNK_SIZE_X || bPos.x() + pos.x() < 0)
                return;
            if (bPos.z() + pos.z() >= Chunk.CHUNK_SIZE_Z || bPos.z() + pos.z() < 0)
                return;
            batch.setBlock(bPos.add(pos), block);
        });
    }

    public void addBlock(Block block, int localX, int localY, int localZ) {
        blocks.put(new Vec(localX, localY, localZ), block);
    }

}
