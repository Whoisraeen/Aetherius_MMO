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
import net.raeen.aetheriusmod.quests.Quest;
import net.raeen.aetheriusmod.races.Race;
import org.slf4j.Logger;

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
            Race elf = new Race("Elf", new String[]{"Agility", "Magic Proficiency"});
            Race dwarf = new Race("Dwarf", new String[]{"Strength", "Durability"});

            // Define classes
            CharacterClass ranger = new CharacterClass("Forest Ranger", new String[]{"Bow Mastery", "Stealth"});
            CharacterClass warrior = new CharacterClass("Warrior", new String[]{"Sword Mastery", "Shield Defense"});

            // Create characters
            net.raeen.aetheriusmod.character.GameCharacter elfRanger = new net.raeen.aetheriusmod.character.GameCharacter("Legolas", elf, ranger, "Tall and slender with green eyes");
            net.raeen.aetheriusmod.character.GameCharacter dwarfWarrior = new net.raeen.aetheriusmod.character.GameCharacter("Gimli", dwarf, warrior, "Short and stout with a long beard");

            // Set attributes
            elfRanger.setAttribute("Strength", 10);
            elfRanger.setAttribute("Agility", 15);
            dwarfWarrior.setAttribute("Strength", 18);
            dwarfWarrior.setAttribute("Durability", 20);

            // Create quests
            Quest quest1 = new Quest("Goblin Hunt", "Hunt10}