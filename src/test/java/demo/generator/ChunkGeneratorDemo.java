package demo.generator;

import net.minestorm.server.MinecraftServer;
import net.minestorm.server.instance.Chunk;
import net.minestorm.server.instance.ChunkGenerator;
import net.minestorm.server.instance.ChunkPopulator;
import net.minestorm.server.instance.batch.ChunkBatch;
import net.minestorm.server.instance.block.Block;
import net.minestorm.server.world.biomes.Biome;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class ChunkGeneratorDemo implements ChunkGenerator {

    @Override
    public void generateChunkData(@NotNull ChunkBatch batch, int chunkX, int chunkZ) {
        for (byte x = 0; x < Chunk.CHUNK_SIZE_X; x++)
            for (byte z = 0; z < Chunk.CHUNK_SIZE_Z; z++) {
                for (byte y = 0; y < 40; y++) {
                    batch.setBlock(x, y, z, Block.STONE);
                }
            }
    }

    @Override
    public void fillBiomes(@NotNull Biome[] biomes, int chunkX, int chunkZ) {
        Arrays.fill(biomes, MinecraftServer.getBiomeManager().getById(0));
    }

    @Override
    public List<ChunkPopulator> getPopulators() {
        return null;
    }
}
