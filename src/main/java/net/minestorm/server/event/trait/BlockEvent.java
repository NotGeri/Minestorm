package net.minestorm.server.event.trait;

import net.minestorm.server.event.Event;
import net.minestorm.server.instance.block.Block;
import org.jetbrains.annotations.NotNull;

public interface BlockEvent extends Event {
    @NotNull Block getBlock();
}
