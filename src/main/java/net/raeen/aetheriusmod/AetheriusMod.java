package net.raeen.aetheriusmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.raeen.aetheriusmod.classes.CharacterClass;
import net.raeen.aetheriusmod.classes.Mage;
import net.raeen.aetheriusmod.commands.OpenEquipmentScreenCommand;
import net.raeen.aetheriusmod.gui.TitleScreen;
import net.raeen.aetheriusmod.races.Dwarf;
import net.raeen.aetheriusmod.races.Elf;
import net.raeen.aetheriusmod.races.Orc;
import net.raeen.aetheriusmod.races.Race;
import net.raeen.aetheriusmod.character.GameCharacter;
import net.raeen.aetheriusmod.quests.*;
import net.raeen.aetheriusmod.items.*;
import net.raeen.aetheriusmod.social.*;
import net.raeen.aetheriusmod.mobs.*;
import net.raeen.aetheriusmod.biomes.*;
import net.raeen.aetheriusmod.dungeons.*;
import net.raeen.aetheriusmod.mounts.*;
import net.raeen.aetheriusmod.pets.*;
import net.raeen.aetheriusmod.housing.*;
import net.raeen.aetheriusmod.events.*;
import net.raeen.aetheriusmod.achievements.*;
import net.raeen.aetheriusmod.titles.*;
import net.raeen.aetheriusmod.cosmetics.*;
import net.raeen.aetheriusmod.combat.*;
import net.raeen.aetheriusmod.lore.*;
import net.raeen.aetheriusmod.economy.*;
import net.raeen.aetheriusmod.pvp.*;
import net.raeen.aetheriusmod.environment.*;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;

@Mod(AetheriusMod.MODID)
public class AetheriusMod {
    public static final String MODID = "aetheriusmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AetheriusMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(net.minecraftforge.eventbus.api.Event event) {
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public static class ClientModEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        LOGGER.info("HELLO FROM CLIENT SETUP");
        LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

        // Set the title screen
        AetheriusMod.setScreen(new TitleScreen());
    }

    // Add this method to the AetheriusMod class
    public static void setScreen(Screen screen) {
        Minecraft.getInstance().setScreen(screen);
    }
}

    private static void setScreen(TitleScreen titleScreen) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
        OpenEquipmentScreenCommand.register(event.getServer().getCommands().getDispatcher());
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
            Race orc = new Orc();  // New race

            // Define classes
            CharacterClass ranger = new CharacterClass("Forest Ranger", new String[]{"Bow Mastery", "Stealth"});
            CharacterClass warrior = new CharacterClass("Warrior", new String[]{"Sword Mastery", "Shield Defense"});
            CharacterClass mage = new Mage();  // New class

            // Create characters
            GameCharacter elfRanger = new GameCharacter("Legolas", elf, ranger, "Tall and slender with green eyes");
            GameCharacter dwarfWarrior = new GameCharacter("Gimli", dwarf, warrior, "Short and stout with a long beard");
            GameCharacter orcMage = new GameCharacter("Thrall", orc, mage, "Tall and muscular with green skin");  // New character

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

            // Initialize social systems
            Guild guild = new Guild("Fellowship");
            guild.addMember("Legolas");
            guild.addMember("Gimli");

            TradeSystem tradeSystem = new TradeSystem();
            tradeSystem.addTradeOffer("Legolas", helmet);
            tradeSystem.addTradeOffer("Gimli", armor);

            ChatInterface chatInterface = new ChatInterface();
            chatInterface.addMessage("Hello world!", "World");

            // Log guild members
            LOGGER.info("Guild: {}", guild.getName());
            LOGGER.info("Members: {}", guild.getMembers());

            // Log trade offers
            LOGGER.info("Trade offer from Legolas: {}", tradeSystem.getTradeOffer("Legolas").getName());
            LOGGER.info("Trade offer from Gimli: {}", tradeSystem.getTradeOffer("Gimli").getName());

            // Log chat messages
            LOGGER.info("World Chat: {}", chatInterface.getWorldChat());

            // Initialize mobs and biomes
            MobRegistry mobRegistry = new MobRegistry();
            BiomeRegistry biomeRegistry = new BiomeRegistry(mobRegistry);

            for (Biome biome : biomeRegistry.getBiomes()) {
                LOGGER.info("Biome: {}", biome.getName());
                for (Mob mob : biome.getMobs()) {
                    LOGGER.info("Mob: {} in {}", mob.getName(), biome.getName());
                }
            }

            // Initialize dungeons
            DungeonManager dungeonManager = new DungeonManager();
            DungeonInstance goblinCaveInstance = dungeonManager.createDungeonInstance("Goblin Cave", Arrays.asList(elfRanger, dwarfWarrior));

            LOGGER.info("Dungeon: {}", goblinCaveInstance.getName());
            for (GameCharacter participant : goblinCaveInstance.getParticipants()) {
                LOGGER.info("Participant: {}", participant.getName());
            }

            // Initialize mounts and pets
            Mount horse = new Mount("Horse", 10);
            Pet dragonPet = new Pet("Dragon", "Fire Breath");

            // Initialize player housing
            PlayerHouse legolasHouse = new PlayerHouse("Legolas", "Rivendell", 10);

            // Initialize events and contests
            Event treasureHunt = new Event("Treasure Hunt", "Find the hidden treasure", 100);

            // Initialize achievements and titles
            Achievement dragonSlayer = new Achievement("Dragon Slayer", "Defeat the dragon", 50);
            Title champion = new Title("Champion", "Win 10 battles");

            // Initialize cosmetic shop
            CosmeticItem fancyHat = new CosmeticItem("Fancy Hat", "A very fancy hat", 100);
            CosmeticShop cosmeticShop = new CosmeticShop();
            cosmeticShop.updateItems(Arrays.asList(fancyHat));

            // Initialize combat system
            CombatSystem combatSystem = new CombatSystem();
            combatSystem.applyStatusEffect(dwarfWarrior, new StatusEffect("Poisoned", "Damage Over Time", 10));

            // Initialize lore
            Lore lore = new Lore();
            LOGGER.info("Lore: {}", lore.getLore("Elf"));

            // Initialize economy system
            EconomySystem economySystem = new EconomySystem();
            economySystem.addPlayer("Legolas");
            economySystem.updateBalance("Legolas", 200);
            LOGGER.info("Legolas' Balance: {}", economySystem.getBalance("Legolas"));

            // Initialize PvP system
            PvPSystem pvpSystem = new PvPSystem();
            pvpSystem.initiateDuel(elfRanger, dwarfWarrior);

            // Initialize environment
            WeatherSystem weatherSystem = new WeatherSystem();
            weatherSystem.changeWeather("Rainy");
            LOGGER.info("Current Weather: {}", weatherSystem.getCurrentWeather());

            DayNightCycle dayNightCycle = new DayNightCycle();
            dayNightCycle.changeTimeOfDay("Night");
            LOGGER.info("Time of Day: {}", dayNightCycle.getTimeOfDay());
        }
    }
}