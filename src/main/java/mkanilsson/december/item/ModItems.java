package mkanilsson.december.item;

import mkanilsson.december.December;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
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

import java.util.Map;
import java.util.function.Function;

public class ModItems {
    public static final Item MODERN_UNIT = register("modern_unit", Item::new, new Item.Settings());
    public static final Item ENDERITE_INGOT = register("enderite_ingot", Item::new, new Item.Settings());

    public static final TagKey<Item> REPAIRS_ENDERITE_THINGS = TagKey.of(Registries.ITEM.getKey(),
            Identifier.of(December.MOD_ID, "repairs_enderite_things"));

    public static final ToolMaterial ENDERITE_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            2048,
            12.0f,
            4.0f,
            22,
            REPAIRS_ENDERITE_THINGS);

    // TODO: Add recipes
    public static final Item ENDERITE_PICKAXE = register("enderite_pickaxe", Item::new,
            new Item.Settings().pickaxe(ENDERITE_TOOL_MATERIAL, 1f, 1f));
    public static final Item ENDERITE_SWORD = register("enderite_sword", Item::new,
            new Item.Settings().sword(ENDERITE_TOOL_MATERIAL, 1f, 1f));
    public static final Item ENDERITE_SHOVEL = register("enderite_shovel", Item::new,
            new Item.Settings().shovel(ENDERITE_TOOL_MATERIAL, 1f, 1f));
    public static final Item ENDERITE_AXE = register("enderite_axe", Item::new,
            new Item.Settings().axe(ENDERITE_TOOL_MATERIAL, 1f, 1f));
    public static final Item ENDERITE_HOE = register("enderite_hoe", Item::new,
            new Item.Settings().hoe(ENDERITE_TOOL_MATERIAL, 1f, 1f));

    public static final int BASE_DURABILITY = 15;
    public static final RegistryKey<EquipmentAsset> ENDERITE_ARMOR_MATERIAL_KEY = RegistryKey
            .of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(December.MOD_ID, "enderite"));

    public static final ArmorMaterial ENDERITE_ARMOR_MATERIAL = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3),
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

    public static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(December.MOD_ID, name));

        return Items.register(registryKey, factory, settings);
    }

    public static void registerModItems() {
        December.LOGGER.info("Registering mod items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(MODERN_UNIT);
            entries.add(ENDERITE_INGOT);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ENDERITE_PICKAXE);
            entries.add(ENDERITE_AXE);
            entries.add(ENDERITE_HOE);
            entries.add(ENDERITE_SHOVEL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(ENDERITE_SWORD);

            entries.add(ENDERITE_HELMET);
            entries.add(ENDERITE_CHESTPLATE);
            entries.add(ENDERITE_LEGGINGS);
            entries.add(ENDERITE_BOOTS);
        });
    }
}
