package mkanilsson.december.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import mkanilsson.december.item.ModItems;
import mkanilsson.december.block.ModBlocks;

public class ModENLanguageProvider extends FabricLanguageProvider {
    public ModENLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        add(translationBuilder, ModItems.MODERN_UNIT, "Modern Unit");

        add(translationBuilder, ModItems.ENDERITE_INGOT, "Enderite Ingot");

        add(translationBuilder, ModItems.ENDERITE_AXE, "Enderite Axe");
        add(translationBuilder, ModItems.ENDERITE_HOE, "Enderite Hoe");
        add(translationBuilder, ModItems.ENDERITE_PICKAXE, "Enderite Pickaxe");
        add(translationBuilder, ModItems.ENDERITE_SHOVEL, "Enderite Shovel");
        add(translationBuilder, ModItems.ENDERITE_SWORD, "Enderite Sword");

        add(translationBuilder, ModItems.ENDERITE_HELMET, "Enderite Helmet");
        add(translationBuilder, ModItems.ENDERITE_CHESTPLATE, "Enderite Chestplate");
        add(translationBuilder, ModItems.ENDERITE_LEGGINGS, "Enderite Leggings");
        add(translationBuilder, ModItems.ENDERITE_BOOTS, "Enderite Boots");

        add(translationBuilder, ModBlocks.MODERN_STRUCTURE, "Modern Structure");

        add(translationBuilder, ModItems.DIRT_SHOVEL, "Dirt Shovel");

        add(translationBuilder, ModItems.BIB_SPAWN_EGG, "Bib Spawn Egg");
        add(translationBuilder, ModItems.HASSE_SPAWN_EGG, "Hasse Spawn Egg");

        add(translationBuilder, ModItems.GINGER_BRED, "Pepparkakor");
        add(translationBuilder, ModItems.LUSSEBULLE, "Lussebulle");
        add(translationBuilder, Items.ALLIUM, "Saffron");
    }

    private void add(TranslationBuilder builder, Item item, String text) {
        builder.add(item.getTranslationKey(), text);
    }

    private void add(TranslationBuilder builder, Block block, String text) {
        builder.add(block.getTranslationKey(), text);
    }
}
