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
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
