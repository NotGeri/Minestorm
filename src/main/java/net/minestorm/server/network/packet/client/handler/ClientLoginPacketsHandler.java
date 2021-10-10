package net.minestorm.server.network.packet.client.handler;

import net.minestorm.server.network.packet.client.login.EncryptionResponsePacket;
import net.minestorm.server.network.packet.client.login.LoginPluginResponsePacket;
import net.minestorm.server.network.packet.client.login.LoginStartPacket;

public class ClientLoginPacketsHandler extends ClientPacketsHandler {

    public ClientLoginPacketsHandler() {
        register(0, LoginStartPacket::new);
        register(1, EncryptionResponsePacket::new);
        register(2, LoginPluginResponsePacket::new);
    }

}
