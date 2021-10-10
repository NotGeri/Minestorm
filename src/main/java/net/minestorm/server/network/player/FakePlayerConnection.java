package net.minestorm.server.network.player;

import net.minestorm.server.MinecraftServer;
import net.minestorm.server.entity.Player;
import net.minestorm.server.entity.fakeplayer.FakePlayer;
import net.minestorm.server.network.packet.server.ServerPacket;
import net.minestorm.server.utils.validate.Check;
import org.jetbrains.annotations.NotNull;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class FakePlayerConnection extends PlayerConnection {

    @Override
    public void sendPacket(@NotNull ServerPacket serverPacket, boolean skipTranslating) {
        if (shouldSendPacket(serverPacket)) {
            getFakePlayer().getController().consumePacket(serverPacket);
        }
    }

    @NotNull
    @Override
    public SocketAddress getRemoteAddress() {
        return new InetSocketAddress(0);
    }

    @Override
    public void disconnect() {
        if (getFakePlayer().getOption().isRegistered())
            MinecraftServer.getConnectionManager().removePlayer(this);
    }

    public FakePlayer getFakePlayer() {
        return (FakePlayer) getPlayer();
    }


    @Override
    public void setPlayer(Player player) {
        Check.argCondition(!(player instanceof FakePlayer), "FakePlayerController needs a FakePlayer object");
        super.setPlayer(player);
    }
}
