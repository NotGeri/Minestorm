package net.minestorm.server.listener;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import net.minestorm.server.MinecraftServer;
import net.minestorm.server.command.CommandManager;
import net.minestorm.server.entity.Player;
import net.minestorm.server.event.EventDispatcher;
import net.minestorm.server.event.player.PlayerChatEvent;
import net.minestorm.server.message.ChatPosition;
import net.minestorm.server.message.Messenger;
import net.minestorm.server.network.ConnectionManager;
import net.minestorm.server.network.packet.client.play.ClientChatMessagePacket;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Function;

public class ChatMessageListener {

    private static final CommandManager COMMAND_MANAGER = MinecraftServer.getCommandManager();
    private static final ConnectionManager CONNECTION_MANAGER = MinecraftServer.getConnectionManager();

    public static void listener(ClientChatMessagePacket packet, Player player) {
        String message = packet.message;

        final String cmdPrefix = CommandManager.COMMAND_PREFIX;
        if (message.startsWith(cmdPrefix)) {
            // The message is a command
            final String command = message.replaceFirst(cmdPrefix, "");

            // check if we can receive commands
            if (Messenger.canReceiveCommand(player)) {
                COMMAND_MANAGER.execute(player, command);
            } else {
                Messenger.sendRejectionMessage(player);
            }

            // Do not call chat event
            return;
        }

        // check if we can receive messages
        if (!Messenger.canReceiveMessage(player)) {
            Messenger.sendRejectionMessage(player);
            return;
        }

        final Collection<Player> players = CONNECTION_MANAGER.getOnlinePlayers();
        PlayerChatEvent playerChatEvent = new PlayerChatEvent(player, players, () -> buildDefaultChatMessage(player, message), message);

        // Call the event
        EventDispatcher.callCancellable(playerChatEvent, () -> {
            final Function<PlayerChatEvent, Component> formatFunction = playerChatEvent.getChatFormatFunction();

            Component textObject;

            if (formatFunction != null) {
                // Custom format
                textObject = formatFunction.apply(playerChatEvent);
            } else {
                // Default format
                textObject = playerChatEvent.getDefaultChatFormat().get();
            }

            final Collection<Player> recipients = playerChatEvent.getRecipients();
            if (!recipients.isEmpty()) {
                // delegate to the messenger to avoid sending messages we shouldn't be
                Messenger.sendMessage(recipients, textObject, ChatPosition.CHAT, player.getUuid());
            }
        });
    }

    private static @NotNull Component buildDefaultChatMessage(@NotNull Player player, @NotNull String message) {
        final String username = player.getUsername();
        return Component.translatable("chat.type.text")
                .args(Component.text(username)
                                .insertion(username)
                                .clickEvent(ClickEvent.suggestCommand("/msg " + username + " "))
                                .hoverEvent(player),
                        Component.text(message)
                );
    }

}