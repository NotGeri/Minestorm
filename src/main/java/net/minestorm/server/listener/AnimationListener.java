package net.minestorm.server.listener;

import net.minestorm.server.entity.Player;
import net.minestorm.server.event.EventDispatcher;
import net.minestorm.server.event.player.PlayerHandAnimationEvent;
import net.minestorm.server.item.ItemStack;
import net.minestorm.server.network.packet.client.play.ClientAnimationPacket;

public class AnimationListener {

    public static void animationListener(ClientAnimationPacket packet, Player player) {
        final Player.Hand hand = packet.hand;
        final ItemStack itemStack = player.getItemInHand(hand);
        //itemStack.onLeftClick(player, hand);
        PlayerHandAnimationEvent handAnimationEvent = new PlayerHandAnimationEvent(player, hand);
        EventDispatcher.callCancellable(handAnimationEvent, () -> {
            switch (hand) {
                case MAIN:
                    player.swingMainHand();
                    break;
                case OFF:
                    player.swingOffHand();
                    break;
            }
        });
    }

}
