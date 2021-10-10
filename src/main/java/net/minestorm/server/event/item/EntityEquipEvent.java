package net.minestorm.server.event.item;

import net.minestorm.server.entity.Entity;
import net.minestorm.server.entity.EquipmentSlot;
import net.minestorm.server.event.trait.EntityEvent;
import net.minestorm.server.event.trait.EntityInstanceEvent;
import net.minestorm.server.event.trait.ItemEvent;
import net.minestorm.server.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class EntityEquipEvent implements EntityEvent, EntityInstanceEvent, ItemEvent {

    private final Entity entity;
    private ItemStack equippedItem;
    private final EquipmentSlot slot;

    public EntityEquipEvent(@NotNull Entity entity, @NotNull ItemStack equippedItem, @NotNull EquipmentSlot slot) {
        this.entity = entity;
        this.equippedItem = equippedItem;
        this.slot = slot;
    }

    public @NotNull ItemStack getEquippedItem() {
        return equippedItem;
    }

    public void setEquippedItem(@NotNull ItemStack armorItem) {
        this.equippedItem = armorItem;
    }

    public @NotNull EquipmentSlot getSlot() {
        return slot;
    }

    /**
     * Same as {@link #getEquippedItem()}.
     */
    @Override
    public @NotNull ItemStack getItemStack() {
        return equippedItem;
    }

    @Override
    public @NotNull Entity getEntity() {
        return entity;
    }
}
