package improveextensions.unloadextensiononstop;

import net.minestorm.server.MinecraftServer;
import net.minestorm.server.extensions.Extension;
import net.minestorm.server.utils.time.TimeUnit;
import org.junit.jupiter.api.Assertions;

public class UnloadExtensionOnStop extends Extension {

    private boolean terminated = false;

    @Override
    public void initialize() {
        MinecraftServer.getSchedulerManager().buildShutdownTask(() -> {
            Assertions.assertTrue(terminated, "Extension should have been terminated on shutdown.");
            System.out.println("All tests passed.");
        }).makeTransient().schedule();

        MinecraftServer.getSchedulerManager().buildTask(MinecraftServer::stopCleanly).makeTransient().delay(1L, TimeUnit.SECOND).schedule();
    }

    @Override
    public void terminate() {
        terminated = true;
    }
}
