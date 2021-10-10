package demo.commands;

import net.kyori.adventure.inventory.Book;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestorm.server.command.CommandSender;
import net.minestorm.server.command.builder.Command;
import net.minestorm.server.command.builder.CommandContext;
import net.minestorm.server.command.builder.condition.Conditions;
import net.minestorm.server.entity.Player;

public class BookCommand extends Command {
    public BookCommand() {
        super("book");

        setCondition(Conditions::playerOnly);

        setDefaultExecutor(this::execute);
    }

    private void execute(CommandSender sender, CommandContext context) {
        Player player = sender.asPlayer();

        player.openBook(Book.builder()
                .author(Component.text(player.getUsername()))
                .title(Component.text(player.getUsername() + "'s Book"))
                .pages(Component.text("Page one", NamedTextColor.RED),
                        Component.text("Page two", NamedTextColor.GREEN),
                        Component.text("Page three", NamedTextColor.BLUE)));
    }
}
