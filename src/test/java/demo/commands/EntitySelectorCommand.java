package demo.commands;

import net.minestorm.server.command.CommandSender;
import net.minestorm.server.command.builder.Command;
import net.minestorm.server.command.builder.CommandContext;
import net.minestorm.server.command.builder.arguments.ArgumentType;
import net.minestorm.server.command.builder.arguments.minecraft.ArgumentEntity;
import net.minestorm.server.entity.Entity;
import net.minestorm.server.utils.entity.EntityFinder;

import java.util.List;

public class EntitySelectorCommand extends Command {

    public EntitySelectorCommand() {
        super("ent");

        setDefaultExecutor((sender, context) -> System.out.println("DEFAULT"));

        ArgumentEntity argumentEntity = ArgumentType.Entity("entities").onlyPlayers(true);

        setArgumentCallback((sender, exception) -> exception.printStackTrace(), argumentEntity);

        addSyntax(this::executor, argumentEntity);

    }

    private void executor(CommandSender commandSender, CommandContext context) {
        EntityFinder entityFinder = context.get("entities");
        List<Entity> entities = entityFinder.find(commandSender);
        System.out.println("found " + entities.size() + " entities");
    }
}
