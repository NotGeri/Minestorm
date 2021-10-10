package net.minestorm.server.network.packet.server;

import net.minestorm.server.adventure.ComponentHolder;

/**
 * A server packet that can hold components.
 */
public interface ComponentHoldingServerPacket extends ServerPacket, ComponentHolder<ServerPacket> { }
