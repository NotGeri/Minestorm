package net.minestorm.server.extras.optifine;

import net.minestorm.server.MinecraftServer;
import net.minestorm.server.utils.NamespaceID;
import net.minestorm.server.utils.validate.Check;
import net.minestorm.server.world.biomes.Biome;
import net.minestorm.server.world.biomes.BiomeManager;

/**
 * Hacky class for Optifine because of an issue making the client crash if biomes 'swamp' and 'swamp_hills'
 * are not registered.
 * <p>
 * Can be removed anytime, hope that it will be fixed.
 */
public final class OptifineSupport {

    private static volatile boolean enabled;

    /**
     * Enables optifine support by registering the required biomes.
     *
     * @throws IllegalStateException if optifine support is already enabled
     */
    public static void enable() {
        Check.stateCondition(enabled, "Optifine support is already enabled!");
        OptifineSupport.enabled = true;

        BiomeManager biomeManager = MinecraftServer.getBiomeManager();
        biomeManager.addBiome(Biome.builder().name(NamespaceID.from("minecraft:swamp")).build());
        biomeManager.addBiome(Biome.builder().name(NamespaceID.from("minecraft:swamp_hills")).build());
    }

    public static boolean isEnabled() {
        return enabled;
    }
}
