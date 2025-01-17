package net.minestorm.server.event.player;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.trait.CancellableEvent;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.event.trait.ItemEvent;
import net.minestorm.server.event.trait.PlayerEvent;
import net.minestorm.server.item.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Event when an item is used without clicking on a block.
 */
public class PlayerUseItemEvent implements PlayerEvent, EntityInstanceEvent, ItemEvent, CancellableEvent {

    private final Player player;
    private final Player.Hand hand;
    private final ItemStack itemStack;

    private boolean cancelled;

    public PlayerUseItemEvent(@NotNull Player player, @NotNull Player.Hand hand, @NotNull ItemStack itemStack) {
        this.player = player;
        this.hand = hand;
        this.itemStack = itemStack;
    }

    /**
     * Gets which hand the player used.
     *
     * @return the hand used
     */
    @NotNull
    public Player.Hand getHand() {
        return hand;
    }

    /**
     * Gets the item which have been used.
     *
     * @return the item
     */
    @NotNull
    public ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    @Override
    public @NotNull Player getPlayer() {
        return player;
    }
}
