package net.minestorm.server.resourcepack;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.player.PlayerResourcePackStatusEvent;

/**
 * Represents the result of {@link Player#setResourcePack(ResourcePack)} in
 * {@link PlayerResourcePackStatusEvent}.
 */
public enum ResourcePackStatus {
    SUCCESS, DECLINED, FAILED_DOWNLOAD, ACCEPTED
}
