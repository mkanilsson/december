package mkanilsson.december.datagen;

import mkanilsson.december.block.ModBlocks;
import mkanilsson.december.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(
                ModBlocks.MODERN_STRUCTURE,
                TexturedModel.END_FOR_TOP_CUBE_COLUMN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MODERN_UNIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERITE_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ENDERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERITE_HOE, Models.HANDHELD);
    }

    @Override
    public String getName() {
        return "DecemberModModelProvider";
    }
}
