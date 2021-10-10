package net.minestorm.server.event.inventory;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.event.trait.PlayerEvent;
import net.minestorm.server.inventory.AbstractInventory;
import net.minestorm.server.inventory.PlayerInventory;
import net.minestorm.server.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Called when {@link AbstractInventory#safeItemInsert(int, ItemStack)} is being invoked on a {@link PlayerInventory}.
 * This event cannot be cancelled and items related to the change are already moved.
 * <p>
 * When this event is being called, {@link InventoryItemChangeEvent} listeners will also be triggered, so you can
 * listen only for an ancestor event and check whether it is an instance of that class.
 */
@SuppressWarnings("JavadocReference")
public class PlayerInventoryItemChangeEvent extends InventoryItemChangeEvent implements PlayerEvent, EntityInstanceEvent {

    private final Player player;

    public PlayerInventoryItemChangeEvent(@NotNull Player player, int slot, @NotNull ItemStack previousItem, @NotNull ItemStack newItem) {
        super(null, slot, previousItem, newItem);
        this.player = player;
    }

    @Override
    public @NotNull Player getPlayer() {
        return player;
    }
}
