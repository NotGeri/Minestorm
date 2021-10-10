package improveextensions;

import net.minestorm.server.MinecraftServer;
import net.minestorm.server.extensions.Extension;
import net.minestorm.server.instance.InstanceContainer;
import net.minestorm.server.world.DimensionType;
import org.junit.jupiter.api.Assertions;
import org.opentest4j.AssertionFailedError;

import java.util.UUID;

/**
 * Extensions should be able to use Mixins for classes loaded very early by Minestom (InstanceContainer for instance)
 */
public class DisableEarlyLoad extends Extension {

    @Override
    public void initialize() {
        // force load of InstanceContainer class
        InstanceContainer c = new InstanceContainer(UUID.randomUUID(), DimensionType.OVERWORLD);
        System.out.println(c.toString());
        try {
            Assertions.assertFalse(MixinIntoMinestomCore.success, "InstanceContainer must NOT have been mixed in with improveextensions.InstanceContainerMixin, because early loading has been disabled");
        } catch (AssertionFailedError e) {
            e.printStackTrace();
        }
        MinecraftServer.stopCleanly();
    }

    @Override
    public void terminate() {
        getLogger().info("Terminate extension");
    }
}
