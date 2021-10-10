package demo.commands;

import net.minestorm.server.command.CommandSender;
import net.minestorm.server.command.builder.Command;
import net.minestorm.server.command.builder.CommandContext;
import net.minestorm.server.command.builder.arguments.Argument;
import net.minestorm.server.command.builder.arguments.ArgumentEnum;
import net.minestorm.server.command.builder.arguments.ArgumentType;
import net.minestorm.server.command.builder.arguments.minecraft.registry.ArgumentEntityType;
import net.minestorm.server.command.builder.condition.Conditions;
import net.minestorm.server.coordinate.Vec;
import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.EntityCreature;
import net.minestorm.server.entity.EntityType;
import net.minestorm.server.entity.LivingEntity;
import net.minestorm.server.utils.location.RelativeVec;
import org.jetbrains.annotations.NotNull;

public class SummonCommand extends Command {

    private final ArgumentEntityType entity;
    private final Argument<RelativeVec> pos;
    private final Argument<EntityClass> entityClass;

    public SummonCommand() {
        super("summon");
        setCondition(Conditions::playerOnly);

        entity = ArgumentType.EntityType("entity type");
        pos = ArgumentType.RelativeVec3("pos").setDefaultValue(() -> new RelativeVec(
                new Vec(0, 0, 0),
                RelativeVec.CoordinateType.RELATIVE,
                true, true, true
        ));
        entityClass = ArgumentType.Enum("class", EntityClass.class)
                .setFormat(ArgumentEnum.Format.LOWER_CASED)
                .setDefaultValue(EntityClass.CREATURE);;
        addSyntax(this::execute, entity, pos, entityClass);
        setDefaultExecutor((sender, context) -> sender.sendMessage("Usage: /summon <type> <x> <y> <z> <class>"));
    }

    private void execute(@NotNull CommandSender commandSender, @NotNull CommandContext commandContext) {
        final Entity entity = commandContext.get(entityClass).instantiate(commandContext.get(this.entity));
        //noinspection ConstantConditions - One couldn't possibly execute a command without being in an instance
        entity.setInstance(commandSender.asPlayer().getInstance(), commandContext.get(pos).fromSender(commandSender));
    }

    @SuppressWarnings("unused")
    enum EntityClass {
        BASE(Entity::new),
        LIVING(LivingEntity::new),
        CREATURE(EntityCreature::new);
        private final EntityFactory factory;

        EntityClass(EntityFactory factory) {
            this.factory = factory;
        }

        public Entity instantiate(EntityType type) {
            return factory.newInstance(type);
        }
    }

    interface EntityFactory {
        Entity newInstance(EntityType type);
    }
}
