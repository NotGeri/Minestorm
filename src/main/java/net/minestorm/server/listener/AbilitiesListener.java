package net.minestorm.server.listener;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.EventDispatcher;
import net.minestorm.server.event.player.PlayerStartFlyingEvent;
import net.minestorm.server.event.player.PlayerStopFlyingEvent;
import net.minestorm.server.network.packet.client.play.ClientPlayerAbilitiesPacket;

public class AbilitiesListener {

    public static void listener(ClientPlayerAbilitiesPacket packet, Player player) {
        final boolean canFly = player.isAllowFlying() || player.isCreative();

        if (canFly) {
            final boolean isFlying = (packet.flags & 0x2) > 0;

            player.refreshFlying(isFlying);

            if (isFlying) {
                PlayerStartFlyingEvent startFlyingEvent = new PlayerStartFlyingEvent(player);
                EventDispatcher.call(startFlyingEvent);
            } else {
                PlayerStopFlyingEvent stopFlyingEvent = new PlayerStopFlyingEvent(player);
                EventDispatcher.call(stopFlyingEvent);
            }
        }
    }
}
