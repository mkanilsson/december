package mkanilsson.december.block;

import java.util.function.Function;

import mkanilsson.december.December;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block MODERN_STRUCTURE = register(
            "modern_structure",
            Block::new,
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.ANCIENT_DEBRIS)
                    .strength(40f, 1200.0f)
                    .requiresTool());

    public static Block register(
            String name,
            Function<AbstractBlock.Settings, Block> factory,
            AbstractBlock.Settings settings) {

        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(December.MOD_ID, name));
        Block block = factory.apply(settings.registryKey(blockKey));

        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(December.MOD_ID, name));
        BlockItem blockItem = new BlockItem(
                block,
                new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
        Registry.register(Registries.ITEM, itemKey, blockItem);

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static void registerModBlocks() {
        December.LOGGER.info("Registering mod blocks");

        // TODO: Figure out what group it should be
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(MODERN_STRUCTURE.asItem());
        });
    }
}
