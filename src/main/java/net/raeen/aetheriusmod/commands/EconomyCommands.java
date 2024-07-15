package net.raeen.aetheriusmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.raeen.aetheriusmod.economy.Economy;

import java.util.UUID;
import java.util.function.Supplier;

public class EconomyCommands {
    private static final Economy economy = new Economy();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("economy")
                .then(Commands.literal("balance")
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();
                            context.getSource().sendSuccess(() -> Component.literal("Balance: " + economy.getBalance(player.getUUID())), true);
                            return 1;
                        }))
                .then(Commands.literal("add")
                        .then(Commands.argument("amount", DoubleArgumentType.doubleArg())
                                .executes(context -> {
                                    double amount = DoubleArgumentType.getDouble(context, "amount");
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    economy.updateBalance(player.getUUID(), amount);
                                    context.getSource().sendSuccess(() -> Component.literal("Added " + amount + " to your balance."), true);
                                    return 1;
                                })))
                .then(Commands.literal("deduct")
                        .then(Commands.argument("amount", DoubleArgumentType.doubleArg())
                                .executes(context -> {
                                    double amount = DoubleArgumentType.getDouble(context, "amount");
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    if (economy.deductBalance(player.getUUID(), amount)) {
                                        context.getSource().sendSuccess(() -> Component.literal("Deducted " + amount + " from your balance."), true);
                                    } else {
                                        context.getSource().sendFailure(Component.literal("Insufficient funds."));
                                    }
                                    return 1;
                                }))));
    }
}

