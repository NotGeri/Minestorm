package net.minestorm.server.utils.player;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.Player;
import net.minestorm.server.network.player.PlayerSocketConnection;
import net.minestorm.server.network.player.PlayerConnection;

public final class PlayerUtils {

    private PlayerUtils() {
    }

    public static boolean isSocketClient(PlayerConnection playerConnection) {
        return playerConnection instanceof PlayerSocketConnection;
    }

    public static boolean isSocketClient(Player player) {
        return isSocketClient(player.getPlayerConnection());
    }

    public static boolean isSocketClient(Entity entity) {
        return (entity instanceof Player) && isSocketClient((Player) entity);
    }
}
