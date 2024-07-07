package net.raeen.aetheriusmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.raeen.aetheriusmod.gui.EquipmentScreen;

public class OpenEquipmentScreenCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("openequipment").executes(context -> {
            Player player = context.getSource().getPlayerOrException();
            // ...
            return 1;
        }));
    }
}