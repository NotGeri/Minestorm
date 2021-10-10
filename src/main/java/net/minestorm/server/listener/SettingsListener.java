package net.minestorm.server.listener;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.EventDispatcher;
import net.minestorm.server.event.player.PlayerSettingsChangeEvent;
import net.minestorm.server.network.packet.client.play.ClientSettingsPacket;

public final class SettingsListener {
    public static void listener(ClientSettingsPacket packet, Player player) {
        Player.PlayerSettings settings = player.getSettings();
        final byte viewDistance = (byte) Math.abs(packet.viewDistance);
        settings.refresh(packet.locale, viewDistance, packet.chatMessageType, packet.chatColors, packet.displayedSkinParts, packet.mainHand);
        EventDispatcher.call(new PlayerSettingsChangeEvent(player));
    }
}
