package demo.commands;

import net.minestorm.server.command.builder.Command;
import net.minestorm.server.command.builder.arguments.minecraft.ArgumentBlockState;
import net.minestorm.server.command.builder.arguments.relative.ArgumentRelativeBlockPosition;
import net.minestorm.server.entity.Player;

import static net.minestorm.server.command.builder.arguments.ArgumentType.BlockState;
import static net.minestorm.server.command.builder.arguments.ArgumentType.RelativeBlockPosition;

public class SetBlockCommand extends Command {
    public SetBlockCommand() {
        super("setblock");

        final ArgumentRelativeBlockPosition position = RelativeBlockPosition("position");
        final ArgumentBlockState block = BlockState("block");

        addSyntax((sender, context) -> {
            final Player player = sender.asPlayer();
            player.getInstance().setBlock(context.get(position).from(player), context.get(block));
        }, position, block);
    }
}
