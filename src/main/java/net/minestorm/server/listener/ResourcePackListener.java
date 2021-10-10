package net.minestorm.server.listener;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.EventDispatcher;
import net.minestorm.server.event.player.PlayerResourcePackStatusEvent;
import net.minestorm.server.network.packet.client.play.ClientResourcePackStatusPacket;
import net.minestorm.server.resourcepack.ResourcePackStatus;

public class ResourcePackListener {

    public static void listener(ClientResourcePackStatusPacket packet, Player player) {
        final ResourcePackStatus result = packet.result;
        PlayerResourcePackStatusEvent resourcePackStatusEvent = new PlayerResourcePackStatusEvent(player, result);
        EventDispatcher.call(resourcePackStatusEvent);
    }
}
