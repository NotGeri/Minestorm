package demo.commands;

import net.minestorm.server.command.CommandSender;
import net.minestorm.server.command.builder.Command;
import net.minestorm.server.command.builder.CommandContext;
import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Player;

import java.util.Collection;

public class FindCommand extends Command {
    public FindCommand() {
        super("find");

        this.addSyntax(
                this::executorEntity,
                Literal("entity"),
                Float("range")
        );
    }

    private void executorEntity(CommandSender sender, CommandContext context) {
        Player player = sender.asPlayer();
        float range = context.get("range");

        Collection<Entity> entities = player.getInstance().getNearbyEntities(player.getPosition(), range);

        player.sendMessage("Search result: ");

        for (Entity entity : entities) {
            player.sendMessage("    " + entity.getEntityType() + ": ");
            player.sendMessage("        Meta: " + entity.getEntityMeta());
            player.sendMessage("        Permissions: " + entity.getAllPermissions());
            player.sendMessage("        Position: " + entity.getPosition());
        }

        player.sendMessage("End result.");
    }
}
