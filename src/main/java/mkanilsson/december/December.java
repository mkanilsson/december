package mkanilsson.december;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mkanilsson.december.block.ModBlocks;
import mkanilsson.december.item.ModItems;
import mkanilsson.december.entity.ModEntities;

public class December implements ModInitializer {
    public static final String MOD_ID = "december";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEntities.registerModEntites();
        LootTableInjector.initializeLootTableInjector();

        ModWorldGeneration.generateWorldGen();
    }
}

class LootTableInjector {
    public static void initializeLootTableInjector() {
        LootTableEvents.MODIFY.register((lootTableId, builder, source, wrapper) -> {
            if (EntityType.WARDEN.getLootTableKey().get().equals(lootTableId)) {
                builder.pool(LootPool.builder().rolls(new ConstantLootNumberProvider(1))
                        .with(ItemEntry.builder(ModItems.ENDERITE_INGOT)));
            }
        });

        LootTableEvents.MODIFY.register((lootTableId, builder, source, wrapper) -> {
            if (EntityType.ELDER_GUARDIAN.getLootTableKey().get().equals(lootTableId)) {
                builder.pool(LootPool.builder().rolls(new ConstantLootNumberProvider(1))
                        .with(ItemEntry.builder(ModItems.ELDER_GUARDIAN_STAR)));
            }
        });
    }
}
