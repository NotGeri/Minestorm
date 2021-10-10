package net.minestorm.server.event.trait;

import net.minestorm.server.event.Event;
import net.minestorm.server.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Represents any event called about an {@link ItemStack}.
 */
public interface ItemEvent extends Event {
    @NotNull ItemStack getItemStack();
}
