package net.minestorm.server.listener;

import net.minestorm.server.entity.Player;
import net.minestorm.server.network.packet.client.play.ClientCraftRecipeRequest;
import net.minestorm.server.network.packet.server.play.CraftRecipeResponse;

public class RecipeListener {

    public static void listener(ClientCraftRecipeRequest packet, Player player) {
        CraftRecipeResponse recipeResponse = new CraftRecipeResponse();
        recipeResponse.windowId = packet.windowId;
        recipeResponse.recipe = packet.recipe;
        player.getPlayerConnection().sendPacket(recipeResponse);
    }
}
