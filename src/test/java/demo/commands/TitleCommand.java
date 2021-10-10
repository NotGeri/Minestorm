package demo.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import net.minestorm.server.command.CommandSender;
import net.minestorm.server.command.builder.Command;
import net.minestorm.server.command.builder.CommandContext;
import net.minestorm.server.command.builder.arguments.ArgumentType;
import net.minestorm.server.command.builder.condition.Conditions;
import net.minestorm.server.entity.Player;

public class TitleCommand extends Command {
    public TitleCommand() {
        super("title");
        setDefaultExecutor((source, args) -> source.sendMessage(Component.text("Unknown syntax (note: title must be quoted)")));
        setCondition(Conditions::playerOnly);

        var content = ArgumentType.String("content");

        addSyntax(this::handleTitle, content);
    }

    private void handleTitle(CommandSender source, CommandContext context) {
        Player player = source.asPlayer();
        String titleContent = context.get("content");

        player.showTitle(Title.title(Component.text(titleContent), Component.empty(), Title.DEFAULT_TIMES));
    }
}
