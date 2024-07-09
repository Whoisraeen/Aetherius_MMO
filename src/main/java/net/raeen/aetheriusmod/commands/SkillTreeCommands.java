package net.raeen.aetheriusmod.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.raeen.aetheriusmod.skills.Skill;
import net.raeen.aetheriusmod.skills.SkillTreeManager;

public class SkillTreeCommands {
    private static final SkillTreeManager skillTreeManager = new SkillTreeManager();

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("skill")
                        .then(Commands.literal("add")
                                .then(Commands.argument("name", StringArgumentType.string())
                                        .then(Commands.argument("description", StringArgumentType.string())
                                                .then(Commands.argument("levelRequirement", IntegerArgumentType.integer())
                                                        .then(Commands.argument("maxLevel", IntegerArgumentType.integer())
                                                                .executes(context -> {
                                                                    String name = StringArgumentType.getString(context, "name");
                                                                    String description = StringArgumentType.getString(context, "description");
                                                                    int levelRequirement = IntegerArgumentType.getInteger(context, "levelRequirement");
                                                                    int maxLevel = IntegerArgumentType.getInteger(context, "maxLevel");
                                                                    ServerPlayer player = context.getSource().getPlayerOrException();

                                                                    Skill skill = new Skill(name, description, levelRequirement, maxLevel);
                                                                    skillTreeManager.addSkillToPlayer(player.getUUID(), skill);

                                                                    context.getSource().sendSuccess(Component.literal("Skill added!"), true);
                                                                    return 1;
                                                                })))))))
                .then(Commands.literal("levelup")
                        .then(Commands.argument("name", StringArgumentType.string())
                                .executes(context -> {
                                    String name = StringArgumentType.getString(context, "name");
                                    ServerPlayer player = context.getSource().getPlayerOrException();

                                    skillTreeManager.levelUpSkill(player.getUUID(), name);
                                    context.getSource().sendSuccess(Component.literal("Skill leveled up!"), true);
                                    return 1;
                                }))));
    }
}
