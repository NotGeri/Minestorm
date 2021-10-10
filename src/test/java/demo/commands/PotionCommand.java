package demo.commands;

import net.kyori.adventure.text.Component;
import net.minestorm.server.MinecraftServer;
import net.minestorm.server.command.CommandSender;
import net.minestorm.server.command.builder.Command;
import net.minestorm.server.command.builder.CommandContext;
import net.minestorm.server.command.builder.arguments.ArgumentType;
import net.minestorm.server.command.builder.arguments.minecraft.registry.ArgumentPotionEffect;
import net.minestorm.server.command.builder.arguments.number.ArgumentInteger;
import net.minestorm.server.command.builder.condition.Conditions;
import net.minestorm.server.entity.Player;
import net.minestorm.server.potion.Potion;
import net.minestorm.server.potion.PotionEffect;

public class PotionCommand extends Command {

    private final ArgumentPotionEffect potion;
    private final ArgumentInteger duration;

    public PotionCommand() {
        super("potion");

        setCondition(Conditions::playerOnly);

        setDefaultExecutor(((sender, args) -> sender.sendMessage(Component.text("Usage: /potion <type> <duration (seconds)>"))));

        potion = ArgumentType.Potion("potion");
        duration = ArgumentType.Integer("duration");

        addSyntax(this::onPotionCommand, potion, duration);
    }

    private void onPotionCommand(CommandSender sender, CommandContext context) {
        final Player player = (Player) sender;
        final PotionEffect potionEffect = context.get(potion);
        final Integer duration = context.get(this.duration);

        player.sendMessage(Component.text(player.getActiveEffects().toString()));
        player.addEffect(new Potion(
                potionEffect,
                (byte) 0,
                duration * MinecraftServer.TICK_PER_SECOND
        ));
    }

}