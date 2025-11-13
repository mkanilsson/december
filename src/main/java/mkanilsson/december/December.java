package mkanilsson.december;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mkanilsson.december.block.ModBlocks;
import mkanilsson.december.item.ModItems;

public class December implements ModInitializer {
    public static final String MOD_ID = "december";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
