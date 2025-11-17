package mkanilsson.december.datagen;

import java.util.concurrent.CompletableFuture;

import mkanilsson.december.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModItems.REPAIRS_ENDERITE_THINGS)
                .add(ModItems.ENDERITE_INGOT);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ENDERITE_HELMET)
                .add(ModItems.ENDERITE_CHESTPLATE)
                .add(ModItems.ENDERITE_LEGGINGS)
                .add(ModItems.ENDERITE_BOOTS);

    }
}
