package demo.commands;

import net.minestorm.server.command.CommandSender;
import net.minestorm.server.command.builder.Command;
import net.minestorm.server.command.builder.CommandContext;
import net.minestorm.server.command.builder.arguments.ArgumentType;
import net.minestorm.server.command.builder.arguments.minecraft.ArgumentEntity;
import net.minestorm.server.command.builder.condition.Conditions;
import net.minestorm.server.entity.Entity;
import net.minestorm.server.utils.entity.EntityFinder;

public class RemoveCommand extends Command {

    public RemoveCommand() {
        super("remove");
        addSubcommand(new RemoveEntities());
    }

    static class RemoveEntities extends Command {
        private final ArgumentEntity entity;

        public RemoveEntities() {
            super("entities");
            setCondition(Conditions::playerOnly);
            entity = ArgumentType.Entity("entity");
            addSyntax(this::remove, entity);
        }

        private void remove(CommandSender commandSender, CommandContext commandContext) {
            final EntityFinder entityFinder = commandContext.get(entity);
            entityFinder.find(commandSender).forEach(Entity::remove);
        }
    }
}