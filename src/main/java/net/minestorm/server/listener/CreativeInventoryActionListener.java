package net.minestorm.server.listener;

import net.minestorm.server.entity.Player;
import net.minestorm.server.inventory.PlayerInventory;
import net.minestorm.server.item.ItemStack;
import net.minestorm.server.network.packet.client.play.ClientCreativeInventoryActionPacket;
import net.minestorm.server.utils.inventory.PlayerInventoryUtils;

import java.util.Objects;

public final class CreativeInventoryActionListener {
    public static void listener(ClientCreativeInventoryActionPacket packet, Player player) {
        if (!player.isCreative()) return;
        short slot = packet.slot;
        final ItemStack item = packet.item;
        if (slot == -1) {
            // Drop item
            player.dropItem(item);
            return;
        }
        // Set item
        slot = (short) PlayerInventoryUtils.convertPlayerInventorySlot(slot, PlayerInventoryUtils.OFFSET);
        PlayerInventory inventory = player.getInventory();
        if (Objects.equals(inventory.getItemStack(slot), item)) {
            // Item is already present, ignore
            return;
        }
        inventory.setItemStack(slot, item);
    }
}
