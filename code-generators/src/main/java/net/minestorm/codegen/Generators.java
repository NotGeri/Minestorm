package net.minestorm.codegen;

import net.minestorm.codegen.fluid.FluidGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;

public class Generators {
    private static final Logger LOGGER = LoggerFactory.getLogger(Generators.class);

    public static void main(String[] args) {
        if (args.length != 1) {
            LOGGER.error("Usage: <target folder>");
            return;
        }
        File outputFolder = new File(args[0]);
        var generator = new CodeGenerator(outputFolder);
        generator.generate(resource("blocks.json"), "net.Minestorm.server.instance.block", "Block", "BlockImpl", "Blocks");
        generator.generate(resource("items.json"), "net.Minestorm.server.item", "Material", "MaterialImpl", "Materials");
        generator.generate(resource("entities.json"), "net.Minestorm.server.entity", "EntityType", "EntityTypeImpl", "EntityTypes");
        generator.generate(resource("enchantments.json"), "net.Minestorm.server.item", "Enchantment", "EnchantmentImpl", "Enchantments");
        generator.generate(resource("potion_effects.json"), "net.Minestorm.server.potion", "PotionEffect", "PotionEffectImpl", "PotionEffects");
        generator.generate(resource("potions.json"), "net.Minestorm.server.potion", "PotionType", "PotionTypeImpl", "PotionTypes");
        generator.generate(resource("particles.json"), "net.Minestorm.server.particle", "Particle", "ParticleImpl", "Particles");
        generator.generate(resource("sounds.json"), "net.Minestorm.server.sound", "SoundEvent", "SoundEventImpl", "SoundEvents");
        generator.generate(resource("custom_statistics.json"), "net.Minestorm.server.statistic", "StatisticType", "StatisticTypeImpl", "StatisticTypes");

        // Generate fluids
        new FluidGenerator(resource("fluids.json"), outputFolder).generate();
        // TODO: Generate attributes
//        new AttributeGenerator(
//                new File(inputFolder, targetVersion + "_attributes.json"),
//                outputFolder
//        ).generate();
        // TODO: Generate villager professions
//        new VillagerProfessionGenerator(
//                new File(inputFolder, targetVersion + "_villager_professions.json"),
//                outputFolder
//        ).generate();
        // TODO: Generate villager types
//        new VillagerTypeGenerator(
//                new File(inputFolder, targetVersion + "_villager_types.json"),
//                outputFolder
//        ).generate();
        LOGGER.info("Finished generating code");
    }

    private static InputStream resource(String name) {
        return Generators.class.getResourceAsStream("/" + name);
    }
}
