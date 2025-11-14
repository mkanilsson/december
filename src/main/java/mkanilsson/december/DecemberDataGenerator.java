package mkanilsson.december;

import mkanilsson.december.datagen.ModBlockLootTableProvider;
import mkanilsson.december.datagen.ModBlockTagProvider;
import mkanilsson.december.datagen.ModItemTagProvider;
import mkanilsson.december.datagen.ModModelProvider;
import mkanilsson.december.datagen.ModRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DecemberDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModBlockLootTableProvider::new);
        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModRecipeProvider::new);
    }
}
