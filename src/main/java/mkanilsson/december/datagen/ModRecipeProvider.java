package mkanilsson.december.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import mkanilsson.december.block.ModBlocks;
import mkanilsson.december.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                offerSmelting(
                        List.of(ModBlocks.MODERN_STRUCTURE.asItem()),
                        RecipeCategory.TOOLS,
                        ModItems.MODERN_UNIT,
                        1.0f,
                        500,
                        "modern_structure_to_modern_unit");

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERITE_PICKAXE)
                        .pattern("III")
                        .pattern(" S ")
                        .pattern(" S ")
                        .input('I', ModItems.ENDERITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.ENDERITE_INGOT),
                                conditionsFromItem(ModItems.ENDERITE_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERITE_AXE)
                        .pattern("II")
                        .pattern("SI")
                        .pattern("S ")
                        .input('I', ModItems.ENDERITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.ENDERITE_INGOT),
                                conditionsFromItem(ModItems.ENDERITE_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERITE_SHOVEL)
                        .pattern("I")
                        .pattern("S")
                        .pattern("S")
                        .input('I', ModItems.ENDERITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.ENDERITE_INGOT),
                                conditionsFromItem(ModItems.ENDERITE_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERITE_SWORD)
                        .pattern("I")
                        .pattern("I")
                        .pattern("S")
                        .input('I', ModItems.ENDERITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.ENDERITE_INGOT),
                                conditionsFromItem(ModItems.ENDERITE_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERITE_HOE)
                        .pattern("II")
                        .pattern("S ")
                        .pattern("S ")
                        .input('I', ModItems.ENDERITE_INGOT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(ModItems.ENDERITE_INGOT),
                                conditionsFromItem(ModItems.ENDERITE_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERITE_HELMET)
                        .pattern("III")
                        .pattern("I I")
                        .input('I', ModItems.ENDERITE_INGOT)
                        .criterion(hasItem(ModItems.ENDERITE_INGOT),
                                conditionsFromItem(ModItems.ENDERITE_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERITE_CHESTPLATE)
                        .pattern("I I")
                        .pattern("III")
                        .pattern("III")
                        .input('I', ModItems.ENDERITE_INGOT)
                        .criterion(hasItem(ModItems.ENDERITE_INGOT),
                                conditionsFromItem(ModItems.ENDERITE_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERITE_LEGGINGS)
                        .pattern("III")
                        .pattern("I I")
                        .pattern("I I")
                        .input('I', ModItems.ENDERITE_INGOT)
                        .criterion(hasItem(ModItems.ENDERITE_INGOT),
                                conditionsFromItem(ModItems.ENDERITE_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERITE_BOOTS)
                        .pattern("I I")
                        .pattern("I I")
                        .input('I', ModItems.ENDERITE_INGOT)
                        .criterion(hasItem(ModItems.ENDERITE_INGOT),
                                conditionsFromItem(ModItems.ENDERITE_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.DIRT_SHOVEL)
                        .pattern("D")
                        .pattern("S")
                        .pattern("S")
                        .input('D', Items.DIRT)
                        .input('S', Items.STICK)
                        .criterion(hasItem(Items.DIRT),
                                conditionsFromItem(Items.DIRT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.FOOD, ModItems.LUSSEBULLE, 4)
                        .input(Items.WHEAT)
                        .input(Items.SUGAR)
                        .input(Items.ALLIUM)
                        .criterion(hasItem(Items.WHEAT),
                                conditionsFromItem(Items.SUGAR))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.FOOD, ModItems.GINGER_BRED, 4)
                        .input(Items.COOKIE)
                        .input(Items.BROWN_DYE)
                        .criterion(hasItem(Items.BROWN_DYE),
                                conditionsFromItem(Items.COOKIE))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.FOOD, ModItems.GLÖGG, 4)
                        .input(Items.WATER_BUCKET)
                        .input(Items.SUGAR)
                        .input(Items.MELON_SEEDS)
                        .criterion(hasItem(Items.WATER_BUCKET),
                                conditionsFromItem(Items.APPLE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.PRESSED_MODERN_UNIT)
                        .pattern("MM")
                        .pattern("MM")
                        .input('M', ModItems.MODERN_UNIT)
                        .criterion(hasItem(ModItems.MODERN_UNIT),
                                conditionsFromItem(ModItems.MODERN_UNIT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ENDERITE_INGOT, 10)
                        .pattern("PPP")
                        .pattern("EPN")
                        .pattern("PPP")
                        .input('P', ModItems.PRESSED_MODERN_UNIT)
                        .input('E', ModItems.ELDER_GUARDIAN_STAR)
                        .input('N', Items.NETHER_STAR)
                        .criterion(hasItem(ModItems.ELDER_GUARDIAN_STAR),
                                conditionsFromItem(ModItems.ELDER_GUARDIAN_STAR))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
