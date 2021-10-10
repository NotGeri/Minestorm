package net.minestorm.server.event.item;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.ItemEntity;
import net.minestorm.server.entity.LivingEntity;
import net.minestorm.server.event.trait.CancellableEvent;
import net.minestorm.server.event.trait.EntityEvent;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.event.trait.ItemEvent;
import net.minestorm.server.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PickupItemEvent implements EntityEvent, EntityInstanceEvent, ItemEvent, CancellableEvent {

    private final LivingEntity livingEntity;
    private final ItemEntity itemEntity;

    private boolean cancelled;

    public PickupItemEvent(@NotNull LivingEntity livingEntity, @NotNull ItemEntity itemEntity) {
        this.livingEntity = livingEntity;
        this.itemEntity = itemEntity;
    }

    @NotNull
    public LivingEntity getLivingEntity() {
        return livingEntity;
    }

    @NotNull
    public ItemEntity getItemEntity() {
        return itemEntity;
    }

    @NotNull
    public ItemStack getItemStack() {
        return getItemEntity().getItemStack();
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
    public @NotNull Entity getEntity() {
        return livingEntity;
    }
}
