package mkanilsson.december.item;

import mkanilsson.december.December;
import mkanilsson.december.entity.ModEntities;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.Map;
import java.util.function.Function;

public class ModItems {
    public static final Item MODERN_UNIT = register("modern_unit", Item::new, new Item.Settings());
    public static final Item ENDERITE_INGOT = register("enderite_ingot", Item::new, new Item.Settings());

    public static final Item PRESSED_MODERN_UNIT = register("pressed_modern_unit", Item::new, new Item.Settings());
    public static final Item ELDER_GUARDIAN_STAR = register("elder_guardian_star", Item::new,
            new Item.Settings().rarity(Rarity.RARE));

    public static final Item GINGER_BRED = register("ginger_bread", Item::new,
            new Item.Settings().food(new FoodComponent(1, 1, true)));
    public static final Item LUSSEBULLE = register("lussebulle", Item::new,
            new Item.Settings().food(new FoodComponent(1, 1, true)));
    public static final Item GLÖGG = register("glogg", Item::new,
            new Item.Settings().component(DataComponentTypes.CONSUMABLE, ConsumableComponents.drink().build()));

    public static final TagKey<Item> REPAIRS_ENDERITE_THINGS = TagKey.of(Registries.ITEM.getKey(),
            Identifier.of(December.MOD_ID, "repairs_enderite_things"));

    public static final ToolMaterial ENDERITE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2048,
            12.0f,
            4.0f,
            22,
            REPAIRS_ENDERITE_THINGS);

    public static final Item ENDERITE_PICKAXE = register("enderite_pickaxe", Item::new,
            new Item.Settings().pickaxe(ENDERITE_TOOL_MATERIAL, 1f, 1f));

    public static final Item ENDERITE_SWORD = register("enderite_sword", Item::new,
            new Item.Settings().sword(ENDERITE_TOOL_MATERIAL, 1f, 1f));

    public static final Item ENDERITE_SHOVEL = register("enderite_shovel",
            settings -> new ShovelItem(ENDERITE_TOOL_MATERIAL, 1f, 1f, settings),
            new Item.Settings());

    public static final Item ENDERITE_AXE = register("enderite_axe",
            settings -> new AxeItem(ENDERITE_TOOL_MATERIAL, 1f, 1f, settings),
            new Item.Settings());

    public static final Item ENDERITE_HOE = register("enderite_hoe",
            settings -> new HoeItem(ENDERITE_TOOL_MATERIAL, 1f, 1f, settings),
            new Item.Settings());

    public static final ToolMaterial DIRT_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            1,
            15.0f,
            0.0f,
            1,
            REPAIRS_ENDERITE_THINGS);

    public static final Item DIRT_SHOVEL = register("dirt_shovel",
            settings -> new ShovelItem(DIRT_TOOL_MATERIAL, 1f, 1f, settings),
            new Item.Settings());

    public static final int BASE_DURABILITY = 49;
    public static final RegistryKey<EquipmentAsset> ENDERITE_ARMOR_MATERIAL_KEY = RegistryKey
            .of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(December.MOD_ID, "enderite"));

    public static final ArmorMaterial ENDERITE_ARMOR_MATERIAL = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 4,
                    EquipmentType.CHESTPLATE, 9,
                    EquipmentType.LEGGINGS, 7,
                    EquipmentType.BOOTS, 4,
                    EquipmentType.BODY, 12),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            4.0F,
            0.2F,
            REPAIRS_ENDERITE_THINGS,
            ENDERITE_ARMOR_MATERIAL_KEY);

    public static final Item ENDERITE_HELMET = register(
            "enderite_helmet",
            Item::new,
            new Item.Settings().armor(ENDERITE_ARMOR_MATERIAL, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(BASE_DURABILITY)));

    public static final Item ENDERITE_CHESTPLATE = register("enderite_chestplate",
            Item::new,
            new Item.Settings().armor(ENDERITE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(BASE_DURABILITY)));

    public static final Item ENDERITE_LEGGINGS = register(
            "enderite_leggings",
            Item::new,
            new Item.Settings().armor(ENDERITE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(BASE_DURABILITY)));

    public static final Item ENDERITE_BOOTS = register(
            "enderite_boots",
            Item::new,
            new Item.Settings().armor(ENDERITE_ARMOR_MATERIAL, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(BASE_DURABILITY)));

    public static final Item BIB_SPAWN_EGG = register(
            "bib_spawn_egg",
            SpawnEggItem::new,
            new Item.Settings().spawnEgg(ModEntities.BIB));

    public static final Item HASSE_SPAWN_EGG = register(
            "hasse_spawn_egg",
            SpawnEggItem::new,
            new Item.Settings().spawnEgg(ModEntities.HASSE));

    public static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(December.MOD_ID, name));

        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        December.LOGGER.info("Registering mod items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(MODERN_UNIT);
            entries.add(PRESSED_MODERN_UNIT);
            entries.add(ELDER_GUARDIAN_STAR);
            entries.add(ENDERITE_INGOT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> {
            entries.add(BIB_SPAWN_EGG);
            entries.add(HASSE_SPAWN_EGG);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ENDERITE_PICKAXE);
            entries.add(ENDERITE_AXE);
            entries.add(ENDERITE_HOE);
            entries.add(ENDERITE_SHOVEL);
            entries.add(DIRT_SHOVEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(ENDERITE_SWORD);

            entries.add(ENDERITE_HELMET);
            entries.add(ENDERITE_CHESTPLATE);
            entries.add(ENDERITE_LEGGINGS);
            entries.add(ENDERITE_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(GINGER_BRED);
            entries.add(LUSSEBULLE);
            entries.add(GLÖGG);
        });
    }
}
