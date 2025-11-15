package mkanilsson.december;

import mkanilsson.december.datagen.ModBlockLootTableProvider;
import mkanilsson.december.datagen.ModBlockTagProvider;
import mkanilsson.december.datagen.ModItemTagProvider;
import mkanilsson.december.datagen.ModModelProvider;
import mkanilsson.december.datagen.ModRecipeProvider;
import mkanilsson.december.datagen.ModRegistryDataGenerator;
import mkanilsson.december.datagen.ModLanguageProvider;
import mkanilsson.december.block.ModBlocks;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.minecraft.world.gen.feature.OreFeatureConfig.Target;

import java.util.List;

public class DecemberDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModRecipeProvider::new);
        pack.addProvider(ModRegistryDataGenerator::new);
        pack.addProvider(ModLanguageProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::configure);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::configure);
    }
}

class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> MODERN_STRUCTURE_KEY = registerKey("modern_structure");

    public static void configure(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<Target> endModernStructure = List
                .of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.MODERN_STRUCTURE.getDefaultState()));
        context.register(MODERN_STRUCTURE_KEY,
                new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(endModernStructure, 5, 1.0f)));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(December.MOD_ID, name));
    }
}

class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> MODERN_STRUCTURE_PLACED_KEY = registerKey("modern_structure_placed");

    public static void configure(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        context.register(MODERN_STRUCTURE_PLACED_KEY,
                new PlacedFeature(configuredFeatures.getOrThrow(ModConfiguredFeatures.MODERN_STRUCTURE_KEY),
                        ModOrePlacement.modifiersWithCount(14,
                                HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(December.MOD_ID, name));
    }

}

class ModOrePlacement {
    public static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
        return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
}

class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.MODERN_STRUCTURE_PLACED_KEY);
    }
}

class ModWorldGeneration {
    public static void generateWorldGen() {
        ModOreGeneration.generateOres();
    }
}
