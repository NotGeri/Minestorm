package net.minestorm.server.extras.query.event;

import net.minestorm.server.extras.query.response.BasicQueryResponse;
import org.jetbrains.annotations.NotNull;

import java.net.SocketAddress;

/**
 * An event called when a basic query is received and ready to be responded to.
 */
public class BasicQueryEvent extends QueryEvent<BasicQueryResponse> {

    /**
     * Creates a new basic query event.
     *
     * @param sessionID the session ID
     * @param sender the sender
     */
    public BasicQueryEvent(@NotNull SocketAddress sender, int sessionID) {
        super(sender, sessionID, new BasicQueryResponse());
    }
}
