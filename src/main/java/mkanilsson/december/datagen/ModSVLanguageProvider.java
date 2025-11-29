package mkanilsson.december.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;

public class ModSVLanguageProvider extends FabricLanguageProvider {
    public ModSVLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<WrapperLookup> registryLookup) {
        super(dataOutput, "sv_se", registryLookup);
    }

    @Override
    public void generateTranslations(WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        add(translationBuilder, Items.ALLIUM, "Saffran");
    }

    private void add(TranslationBuilder builder, Item item, String text) {
        builder.add(item.getTranslationKey(), text);
    }

    private void add(TranslationBuilder builder, Block block, String text) {
        builder.add(block.getTranslationKey(), text);
    }
}
