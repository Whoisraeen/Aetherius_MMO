package net.raeen.aetheriusmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.raeen.aetheriusmod.classes.CharacterClass;
import net.raeen.aetheriusmod.items.Armor;
import net.raeen.aetheriusmod.items.Helmet;
import net.raeen.aetheriusmod.quests.Quest;
import net.raeen.aetheriusmod.races.Race;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AetheriusMod.MODID)
public class AetheriusMod {
    public static final String MODID = "aetheriusmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AetheriusMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            // Define races
            Race elf = new Elf();
            Race dwarf = new Dwarf();

            // Define classes
            CharacterClass ranger = new CharacterClass("Forest Ranger", new String[]{"Bow Mastery", "Stealth"});
            CharacterClass warrior = new CharacterClass("Warrior", new String[]{"Sword Mastery", "Shield Defense"});

            // Create characters
            net.raeen.aetheriusmod.character.GameCharacter elfRanger = new GameCharacter("Legolas", elf, ranger, "Tall and slender with green eyes");
            GameCharacter dwarfWarrior = new GameCharacter("Gimli", dwarf, warrior, "Short and stout with a long beard");

            // Equip items
            Helmet helmet = new Helmet("Elf Helmet", "A helmet for elves", 3);
            elfRanger.equipItem(helmet);

            Armor armor = new Armor("Dwarf Armor", "Sturdy armor for dwarves", 5);
            dwarfWarrior.equipItem(armor);

            // Log equipped items
            LOGGER.info("Character: {}", elfRanger.getName());
            LOGGER.info("Equipped Helmet: {}", elfRanger.getEquippedItem("Helmet").getName());

            LOGGER.info("Character: {}", dwarfWarrior.getName());
            LOGGER.info("Equipped Armor: {}", dwarfWarrior.getEquippedItem("Armor").getName());

            // Create quests
            List<String> goblinHuntObjectives = Arrays.asList("Hunt 10 goblins");
            Quest goblinHuntQuest = new Quest("Goblin Hunt", "Hunt 10 goblins in the forest", goblinHuntObjectives, 50, Arrays.asList("Gold Coin"), 100);

            // Accept and complete quests
            elfRanger.acceptQuest(goblinHuntQuest);
            elfRanger.completeQuest(goblinHuntQuest);

            // Verify progression
            LOGGER.info("Character: {}", elfRanger.getName());
            LOGGER.info("Level: {}", elfRanger.getProgression().getLevel());
            LOGGER.info("Experience: {}", elfRanger.getProgression().getExperience());
        }
    }
}