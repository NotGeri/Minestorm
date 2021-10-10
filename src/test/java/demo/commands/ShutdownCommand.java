package demo.commands;

import net.minestorm.server.MinecraftServer;
import net.minestorm.server.command.CommandSender;
import net.minestorm.server.command.builder.Command;
import net.minestorm.server.command.builder.CommandContext;
import org.jetbrains.annotations.NotNull;

/**
 * A simple shutdown command.
 */
public class ShutdownCommand extends Command {

    public ShutdownCommand() {
        super("shutdown");
        addSyntax(this::execute);
    }

    private void execute(@NotNull CommandSender commandSender, @NotNull CommandContext commandContext) {
        MinecraftServer.stopCleanly();
    }
}
