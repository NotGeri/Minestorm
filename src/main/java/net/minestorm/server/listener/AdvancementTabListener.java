package net.minestorm.server.listener;

import net.minestorm.server.advancements.AdvancementAction;
import net.minestorm.server.entity.Player;
import net.minestorm.server.event.EventDispatcher;
import net.minestorm.server.event.player.AdvancementTabEvent;
import net.minestorm.server.network.packet.client.play.ClientAdvancementTabPacket;

public class AdvancementTabListener {

    public static void listener(ClientAdvancementTabPacket packet, Player player) {
        final AdvancementAction action = packet.action;
        final String tabId = packet.tabIdentifier;
        AdvancementTabEvent advancementTabEvent = new AdvancementTabEvent(player, action, tabId);

        EventDispatcher.call(advancementTabEvent);
    }
}
