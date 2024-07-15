package net.raeen.aetheriusmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.raeen.aetheriusmod.combat.CombatManager;
import net.raeen.aetheriusmod.combat.CombatSkill;

public class CombatCommands {
    private static final CombatManager combatManager = new CombatManager();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("combat")
                .then(Commands.literal("special")
                        .then(Commands.argument("skill", StringArgumentType.string())
                                .executes(context -> {
                                    String skillName = StringArgumentType.getString(context, "skill");
                                    ServerPlayer player = context.getSource().getPlayerOrException();

                                    CombatSkill skill = new CombatSkill(skillName, "A special attack", 10, 5);
                                    combatManager.performSpecialAttack(player, skill, null); // Example usage

                                    context.getSource().sendSuccess(() -> Component.literal("Performed special attack!"), true);
                                    return 1;
                                })))
                .then(Commands.literal("block")
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();
                            combatManager.blockAttack(player);
                            context.getSource().sendSuccess(() -> Component.literal("Blocking attack!"), true);
                            return 1;
                        }))
                .then(Commands.literal("dodge")
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();
                            combatManager.dodgeAttack(player);
                            context.getSource().sendSuccess(() -> Component.literal("Dodging attack!"), true);
                            return 1;
                        })));
    }
}
