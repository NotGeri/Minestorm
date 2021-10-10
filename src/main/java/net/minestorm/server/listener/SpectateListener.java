package net.minestorm.server.listener;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Player;
import net.minestorm.server.network.packet.client.play.ClientSpectatePacket;

import java.util.UUID;

public class SpectateListener {

    public static void listener(ClientSpectatePacket packet, Player player) {
        final UUID targetUuid = packet.targetUuid;
        final Entity target = Entity.getEntity(targetUuid);

        // Check if the target is valid
        if (target == null || target == player)
            return;

        // TODO check if 'target' is in a different instance
        player.spectate(target);
    }

}
