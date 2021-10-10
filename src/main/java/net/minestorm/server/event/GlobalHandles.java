package net.minestorm.server.event;

import net.minestorm.server.MinecraftServer;
import net.minestorm.server.event.entity.EntityTickEvent;
import net.minestorm.server.event.instance.InstanceChunkLoadEvent;
import net.minestorm.server.event.instance.InstanceTickEvent;
import net.minestorm.server.event.inventory.InventoryItemChangeEvent;
import net.minestorm.server.event.inventory.PlayerInventoryItemChangeEvent;
import net.minestorm.server.event.player.PlayerChunkLoadEvent;
import net.minestorm.server.event.player.PlayerMoveEvent;
import net.minestorm.server.event.player.PlayerPacketEvent;
import net.minestorm.server.event.player.PlayerTickEvent;
import org.jetbrains.annotations.ApiStatus;

/**
 * Contains handles to the main node {@link MinecraftServer#getGlobalEventHandler()}
 * (compatible with {@link EventDispatcher}).
 */
@ApiStatus.Internal
public final class GlobalHandles {
    public static final ListenerHandle<PlayerTickEvent> PLAYER_TICK = EventDispatcher.getHandle(PlayerTickEvent.class);
    public static final ListenerHandle<PlayerPacketEvent> PLAYER_PACKET = EventDispatcher.getHandle(PlayerPacketEvent.class);
    public static final ListenerHandle<PlayerMoveEvent> PLAYER_MOVE = EventDispatcher.getHandle(PlayerMoveEvent.class);
    public static final ListenerHandle<EntityTickEvent> ENTITY_TICK = EventDispatcher.getHandle(EntityTickEvent.class);
    public static final ListenerHandle<InstanceTickEvent> INSTANCE_TICK = EventDispatcher.getHandle(InstanceTickEvent.class);
    public static final ListenerHandle<PlayerChunkLoadEvent> PLAYER_CHUNK_LOAD = EventDispatcher.getHandle(PlayerChunkLoadEvent.class);
    public static final ListenerHandle<InstanceChunkLoadEvent> INSTANCE_CHUNK_LOAD = EventDispatcher.getHandle(InstanceChunkLoadEvent.class);
    public static final ListenerHandle<InventoryItemChangeEvent> INVENTORY_ITEM_CHANGE_EVENT = EventDispatcher.getHandle(InventoryItemChangeEvent.class);
    public static final ListenerHandle<PlayerInventoryItemChangeEvent> PLAYER_INVENTORY_ITEM_CHANGE_EVENT = EventDispatcher.getHandle(PlayerInventoryItemChangeEvent.class);
}
