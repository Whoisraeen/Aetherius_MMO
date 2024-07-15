package net.raeen.aetheriusmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.raeen.aetheriusmod.quests.*;
import net.raeen.aetheriusmod.events.Event;
import net.raeen.aetheriusmod.events.EventManager;
import net.raeen.aetheriusmod.guild.Guild;
import net.raeen.aetheriusmod.guild.GuildManager;
import net.raeen.aetheriusmod.territory.TerritoryManager;
import net.raeen.aetheriusmod.factions.Faction;
import net.raeen.aetheriusmod.factions.FactionManager;
import net.raeen.aetheriusmod.factions.FactionQuest;
import net.raeen.aetheriusmod.factions.FactionQuestManager;
import net.raeen.aetheriusmod.skills.SkillTreeManager;
import net.raeen.aetheriusmod.housing.*;
import net.raeen.aetheriusmod.combat.*;
import net.raeen.aetheriusmod.dungeons.*;
import net.raeen.aetheriusmod.npc.*;
import net.raeen.aetheriusmod.events.*;
import net.raeen.aetheriusmod.economy.*;
import net.raeen.aetheriusmod.auction.AuctionHouse;
import net.raeen.aetheriusmod.gui.HousingCustomizationScreen;
import net.raeen.aetheriusmod.progression.*;
import net.raeen.aetheriusmod.multiplayer.*;
import net.raeen.aetheriusmod.crafting.*;
import net.raeen.aetheriusmod.pvp.*;
import org.slf4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Mod(AetheriusMod.MODID)
public class AetheriusMod {
    public static final String MODID = "aetheriusmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    private final GuildManager guildManager = new GuildManager();
    private final TerritoryManager territoryManager = new TerritoryManager(guildManager);
    private final QuestManager questManager = new QuestManager();
    private final EventManager eventManager = new EventManager();
    private final FactionManager factionManager = new FactionManager();
    private final FactionQuestManager factionQuestManager = new FactionQuestManager();
    private final SkillTreeManager skillTreeManager = new SkillTreeManager();
    private final HouseManager houseManager = new HouseManager();
    private final CombatManager combatManager = new CombatManager();
    private final StatusEffectManager statusEffectManager = new StatusEffectManager();
    private final DungeonManager dungeonManager = new DungeonManager();
    private final DungeonInstance dungeonMechanics = new DungeonInstance();
    private final NPCManager npcManager = new NPCManager();
    private final QuestAssignment questAssignment = new QuestAssignment(questManager, npcManager);
    private final EventScheduler eventScheduler = new EventScheduler(eventManager);
    private final Economy economy = new Economy();
    private final AuctionHouse auctionHouse = new AuctionHouse(economy);
    private final ComboAttackManager comboAttackManager = new ComboAttackManager();
    private final SpecialAbilityManager specialAbilityManager = new SpecialAbilityManager();
    private final HousingCustomizationScreen housingCustomization = new HousingCustomizationScreen();
    private final FurnitureManager furnitureManager = new FurnitureManager(housingCustomization);
    private final DecorationManager decorationManager = new DecorationManager(housingCustomization);
    private final DynamicInteractionManager dynamicInteractionManager = new DynamicInteractionManager(questManager);
    private final LevelingSystem levelingSystem = new LevelingSystem();
    private final AchievementManager achievementManager = new AchievementManager(levelingSystem.getPlayerProgressions());
    private final TitleManager titleManager = new TitleManager(levelingSystem.getPlayerProgressions());
    private final ChatSystemManager chatSystemManager = new ChatSystemManager();
    private final TradeSystemManager tradeSystemManager = new TradeSystemManager();
    private final PartyManager partyManager = new PartyManager();
    private final BossManager bossManager = new BossManager();
    private final CraftingManager craftingManager = new CraftingManager();
    private final GatheringManager gatheringManager = new GatheringManager();
    private final CraftingStationManager craftingStationManager = new CraftingStationManager();
    private final EconomyManager economyManager = new EconomyManager();
    private final AuctionHouseManager auctionHouseManager = new AuctionHouseManager();
    private final DuelManager duelManager = new DuelManager();
    private final BattlegroundManager battlegroundManager = new BattlegroundManager();
    private final TerritoryWarManager territoryWarManager = new TerritoryWarManager();
    private final RankedPvPManager rankedPvPManager = new RankedPvPManager();

    public AetheriusMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");

        // Example guild and territory setup
        UUID leaderId = UUID.randomUUID();
        Guild guild = guildManager.createGuild(leaderId, "Warriors");
        territoryManager.captureTerritory(guild.getGuildId(), "Valley of Heroes");

        // Example daily quest setup
        DailyQuest quest = new DailyQuest("Goblin Hunt", "Hunt 10 goblins in the forest", leaderId, 100);
        questManager.assignDailyQuest((ServerPlayer) Minecraft.getInstance().player, quest);

        // Example event setup
        Event event = new Event("Treasure Hunt", "Find the hidden treasure", new Date(), new Date(System.currentTimeMillis() + 3600000), 200);
        eventManager.scheduleEvent(event);

        // Example faction setup
        Faction faction = factionManager.createFaction("Guardians");
        faction.addMember(leaderId, "Leader");

        // Example faction quest setup
        FactionQuest factionQuest = new FactionQuest("Defend the Castle", "Defend the castle from invading forces", leaderId, 300);
        factionQuestManager.assignFactionQuest((ServerPlayer) Minecraft.getInstance().player, factionQuest);

        // Example skill tree setup
        SkillTreeManager skillTreeManager = new SkillTreeManager();
        skillTreeManager.createSkillTree(leaderId);
        Skill skill = new Skill("Fireball", "Casts a powerful fireball", 1, 5);
        skillTreeManager.addSkillToPlayer(leaderId, skill);

        // Example house setup
        BlockPos houseLocation = new BlockPos(100, 64, 100);
        houseManager.createHouse(leaderId, houseLocation);

        // Example combat skill setup
        CombatSkill combatSkill = new CombatSkill("Slash", "A powerful slashing attack", 10, 5);
        combatManager.performSpecialAttack((ServerPlayer) Minecraft.getInstance().player, combatSkill, null);

        // Example status effect setup
        StatusEffect poisonEffect = new StatusEffect("Poison", "Deals damage over time", 30, 5);
        statusEffectManager.applyStatusEffect(null, poisonEffect); // Example usage

        // Example dungeon setup
        Dungeon dungeon = new Dungeon("Goblin Cave", new ResourceLocation("goblin_cave"), new BlockPos(200, 64, 200));
        dungeonManager.registerDungeon(dungeon);
        DungeonInstance instance = dungeonManager.createInstance("Goblin Cave", (ServerLevel) Minecraft.getInstance().level, List.of(Minecraft.getInstance().player));
        if (instance != null) {
            dungeonMechanics.spawnMobs((ServerLevel) Minecraft.getInstance().level, instance);
        }

        // Example NPC setup
        NPC npc = npcManager.createNPC("Quest Giver", Minecraft.getInstance().level, VillagerType.PLAINS, new BlockPos(150, 64, 150));
        Dialogue dialogue = new Dialogue("Hello, adventurer!", "Hello!");
        npc.addDialogue(dialogue);
        questAssignment.assignQuest((ServerPlayer) Minecraft.getInstance().player, npc.getUUID(), quest);

        // Schedule periodic events
        eventScheduler.schedulePeriodicEvents();

        // Example combo attack setup
        ComboAttack comboAttack = new ComboAttack("Flurry", List.of(new CombatSkill("Slash", "A powerful slashing attack", 10, 5), new CombatSkill("Thrust", "A quick thrust", 8, 3)));
        comboAttackManager.addComboAttack(comboAttack);

        // Example special ability setup
        SpecialAbility specialAbility = new SpecialAbility("Berserk", "Increases attack speed and damage", 30);
        specialAbilityManager.addAbility(specialAbility);

        // Open housing customization screen
        Minecraft.getInstance().setScreen(new HousingCustomizationScreen(furnitureManager, decorationManager));

        // Example player progression setup
        ServerPlayer player = Minecraft.getInstance().player;
        levelingSystem.addPlayer(player);
        levelingSystem.addExperience(player, 500); // Example experience gain
        achievementManager.awardAchievement(player.getUUID(), new Achievement("First Kill", "Defeat your first enemy"));
        titleManager.awardTitle(player.getUUID(), new Title("Novice", "Begin your adventure"));

        // Example chat message
        chatSystemManager.sendMessage(player, "Hello, World!", ChatChannel.WORLD);

        // Example trade initiation
        tradeSystemManager.initiateTrade(player, Minecraft.getInstance().player);

        // Example party creation
        partyManager.createParty(player);
        partyManager.addMember(player, Minecraft.getInstance().player);

        // Example dungeon boss creation and spawn
        DungeonBoss boss = bossManager.createBoss(EntityType.ZOMBIE, new BlockPos(250, 64, 250), "Fire Breath");
        bossManager.spawnBoss(boss, (ServerLevel) Minecraft.getInstance().level);

        // Register crafting recipes
        RecipeRegistry.registerRecipes(craftingManager);

        // Example crafting station and node setup
        CraftingStation anvil = new CraftingStation("Anvil", new BlockPos(150, 64, 150));
        craftingStationManager.addCraftingStation(anvil);

        GatheringNode ironOre = new GatheringNode("Iron Ore", new BlockPos(175, 64, 175), new ItemStack(Items.IRON_INGOT, 1));
        gatheringManager.addGatheringNode(ironOre);

        // Example economy setup
        economyManager.createAccount(player.getUUID());
        economyManager.deposit(player.getUUID(), 1000.0); // Example deposit

        // Example auction house setup
        ItemStack itemToAuction = new ItemStack(Items.DIAMOND_SWORD);
        auctionHouseManager.createAuction(player, itemToAuction, 500.0);

        // Example duel setup
        duelManager.startDuel(player, Minecraft.getInstance().player);

        // Example battleground setup
        battlegroundManager.startBattleground(List.of(player), List.of(Minecraft.getInstance().player));

        // Example territory war setup
        territoryWarManager.startWar(guild.getGuildId(), UUID.randomUUID());

        // Example ranked PvP setup
        rankedPvPManager.addPlayer(player);
        rankedPvPManager.startRankedMatch(player, Minecraft.getInstance().player);
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
        }
    }
}
