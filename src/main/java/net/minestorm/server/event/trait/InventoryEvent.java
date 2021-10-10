package net.minestorm.server.event.trait;

import net.minestorm.server.event.Event;
import net.minestorm.server.inventory.Inventory;
import org.jetbrains.annotations.Nullable;

/**
 * Represents any event inside an {@link Inventory}.
 */
public interface InventoryEvent extends Event {

    /**
     * Gets the inventory.
     *
     * @return the inventory, null if this is a player's inventory
     */
    @Nullable Inventory getInventory();
}
