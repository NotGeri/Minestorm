package net.minestorm.server.event.item;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.event.trait.ItemEvent;
import net.minestorm.server.event.trait.PlayerEvent;
import net.minestorm.server.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ItemUpdateStateEvent implements PlayerEvent, EntityInstanceEvent, ItemEvent {

    private final Player player;
    private final Player.Hand hand;
    private final ItemStack itemStack;
    private boolean handAnimation;

    public ItemUpdateStateEvent(@NotNull Player player, @NotNull Player.Hand hand, @NotNull ItemStack itemStack) {
        this.player = player;
        this.hand = hand;
        this.itemStack = itemStack;
    }

    @NotNull
    public Player.Hand getHand() {
        return hand;
    }

    public void setHandAnimation(boolean handAnimation) {
        this.handAnimation = handAnimation;
    }

    public boolean hasHandAnimation() {
        return handAnimation;
    }

    @Override
    public @NotNull ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public @NotNull Player getPlayer() {
        return player;
    }
}
