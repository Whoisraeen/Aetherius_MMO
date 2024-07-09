package net.raeen.aetheriusmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.raeen.aetheriusmod.dungeons.Dungeon;
import net.raeen.aetheriusmod.dungeons.DungeonManager;

import java.util.List;

public class DungeonCommands {
    private static final DungeonManager dungeonManager = new DungeonManager();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("dungeon")
                .then(Commands.literal("register")
                        .then(Commands.argument("name", StringArgumentType.string())
                                .then(Commands.argument("layout", StringArgumentType.string())
                                        .executes(context -> {
                                            String name = StringArgumentType.getString(context, "name");
                                            String layout = StringArgumentType.getString(context, "layout");
                                            ServerPlayer player = context.getSource().getPlayerOrException();

                                            Dungeon dungeon = new Dungeon(name, new ResourceLocation(layout), player.blockPosition());
                                            dungeonManager.registerDungeon(dungeon);

                                            context.getSource().sendSuccess(Component.literal("Dungeon registered!"), true);
                                            return 1;
                                        }))))
                .then(Commands.literal("createInstance")
                        .then(Commands.argument("name", StringArgumentType.string())
                                .executes(context -> {
                                    String name = StringArgumentType.getString(context, "name");
                                    ServerPlayer player = context.getSource().getPlayerOrException();
                                    ServerLevel world = player.getLevel();

                                    DungeonInstance instance = dungeonManager.createInstance(name, world, List.of(player));
                                    if (instance != null) {
                                        context.getSource().sendSuccess(Component.literal("Dungeon instance created!"), true);
                                        return 1;
                                    } else {
                                        context.getSource().sendFailure(Component.literal("Failed to create dungeon instance."));
                                        return 0;
                                    }
                                }))));
    }
}
