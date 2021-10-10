package net.minestorm.server.event.player;

import net.minestorm.server.event.Event;
import net.minestorm.server.network.packet.server.play.TagsPacket;
import org.jetbrains.annotations.NotNull;

@Deprecated
public class UpdateTagListEvent implements Event {

    private TagsPacket packet;

    public UpdateTagListEvent(@NotNull TagsPacket packet) {
        this.packet = packet;
    }

    @NotNull
    public TagsPacket getTags() {
        return packet;
    }
}
