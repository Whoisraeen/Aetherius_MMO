package net.raeen.aetheriusmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.raeen.aetheriusmod.factions.Faction;
import net.raeen.aetheriusmod.factions.FactionManager;

public class FactionCommands {
    private static final FactionManager factionManager = new FactionManager();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("faction")
                .then(Commands.literal("create")
                        .then(Commands.argument("name", StringArgumentType.string())
                                .executes(context -> {
                                    String name = StringArgumentType.getString(context, "name");
                                    ServerPlayer player = context.getSource().getPlayerOrException();

                                    Faction faction = factionManager.createFaction(name);
                                    faction.addMember(player.getUUID(), "Leader");

                                    context.getSource().sendSuccess(() -> Component.literal("Faction created!"), true);
                                    return 1;
                                })))
                .then(Commands.literal("join")
                        .then(Commands.argument("name", StringArgumentType.string())
                                .executes(context -> {
                                    String name = StringArgumentType.getString(context, "name");
                                    ServerPlayer player = context.getSource().getPlayerOrException();

                                    Faction faction = factionManager.getFaction(name);
                                    if (faction != null) {
                                        faction.addMember(player.getUUID(), "Member");
                                        context.getSource().sendSuccess(() -> Component.literal("Joined faction!"), true);
                                        return 1;
                                    } else {
                                        context.getSource().sendFailure(Component.literal("Faction not found."));
                                        return 0;
                                    }
                                })))
                .then(Commands.literal("leave")
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();
                            Faction faction = factionManager.getFactionByPlayer(player.getUUID());

                            if (faction != null) {
                                faction.removeMember(player.getUUID());
                                context.getSource().sendSuccess(() -> Component.literal("Left faction!"), true);
                                return 1;
                            } else {
                                context.getSource().sendFailure(Component.literal("You are not in a faction."));
                                return 0;
                            }
                        })));
    }
}
