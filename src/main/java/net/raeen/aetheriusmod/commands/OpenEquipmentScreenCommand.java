package net.raeen.aetheriusmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.world.entity.player.Player;

public class OpenEquipmentScreenCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("openequipment").executes(context -> {
            Player player = context.getSource().getPlayerOrException();
            // Use the player variable or remove it if not needed
            // ...
            return 1;
        }));
    }
}