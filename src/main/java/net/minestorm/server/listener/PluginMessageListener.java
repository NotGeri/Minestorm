package net.minestorm.server.listener;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.EventDispatcher;
import net.minestorm.server.event.player.PlayerPluginMessageEvent;
import net.minestorm.server.network.packet.client.play.ClientPluginMessagePacket;

public class PluginMessageListener {

    public static void listener(ClientPluginMessagePacket packet, Player player) {
        PlayerPluginMessageEvent pluginMessageEvent = new PlayerPluginMessageEvent(player, packet.channel, packet.data);
        EventDispatcher.call(pluginMessageEvent);
    }

}
