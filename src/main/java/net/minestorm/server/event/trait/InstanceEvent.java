package net.minestorm.server.event.trait;

import net.minestorm.server.event.Event;
import net.minestorm.server.instance.Instance;
import org.jetbrains.annotations.NotNull;

/**
 * Represents any event targeting an {@link Instance}.
 */
public interface InstanceEvent extends Event {

    /**
     * Gets the instance.
     *
     * @return instance
     */
    @NotNull Instance getInstance();
}
