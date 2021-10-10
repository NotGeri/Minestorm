package demo.commands;

import net.kyori.adventure.text.Component;
import net.minestorm.server.MinecraftServer;
import net.minestorm.server.command.CommandSender;
import net.minestorm.server.command.builder.Command;
import net.minestorm.server.command.builder.CommandContext;
import net.minestorm.server.entity.Player;

import java.util.Collection;
import java.util.stream.Collectors;

public class PlayersCommand extends Command {

    public PlayersCommand() {
        super("players");
        setDefaultExecutor(this::usage);
    }

    private void usage(CommandSender sender, CommandContext context) {
        final Collection<Player> players = MinecraftServer.getConnectionManager().getOnlinePlayers();
        final int playerCount = players.size();
        sender.sendMessage(Component.text("Total players: " + playerCount));
        final int limit = 15;
        if (playerCount <= limit) {
            for (final Player player : players) {
                sender.sendMessage(Component.text(player.getUsername()));
            }
        } else {
            for (final Player player : players.stream().limit(limit).collect(Collectors.toList())) {
                sender.sendMessage(Component.text(player.getUsername()));
            }
            sender.sendMessage(Component.text("..."));
        }
    }

}
