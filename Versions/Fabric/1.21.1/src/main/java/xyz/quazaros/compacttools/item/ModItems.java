package xyz.quazaros.compacttools.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import xyz.quazaros.compacttools.CompactTools;
import xyz.quazaros.compacttools.item.CustomItems.CustomToolItem;

public class ModItems {
    public static final Item WOODEN_TOOL = registerItem("wooden_tool", new CustomToolItem(ToolMaterials.WOOD, getSettings("wood", "wooden_tool")));
    public static final Item STONE_TOOL = registerItem("stone_tool", new CustomToolItem(ToolMaterials.STONE, getSettings("stone", "stone_tool")));
    public static final Item IRON_TOOL = registerItem("iron_tool",  new CustomToolItem(ToolMaterials.IRON, getSettings("iron", "iron_tool")));
    public static final Item GOLDEN_TOOL = registerItem("golden_tool", new CustomToolItem(ToolMaterials.GOLD, getSettings("gold", "golden_tool")));
    public static final Item DIAMOND_TOOL = registerItem("diamond_tool", new CustomToolItem(ToolMaterials.DIAMOND, getSettings("diamond", "diamond_tool")));
    public static final Item NETHERITE_TOOL = registerItem("netherite_tool", new CustomToolItem(ToolMaterials.NETHERITE, getSettings("netherite", "netherite_tool")));

    private static Item.Settings getSettings(String type, String name) {
        Item.Settings settings = new Item.Settings();
        if (type.equals("netherite")) settings.fireproof();
        return settings;
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CompactTools.MOD_ID, name), item);
    }

    public static void registerItems() {
        CompactTools.LOGGER.info("Registering Mod Items For " + CompactTools.MOD_ID);

        registerItemGroupEntries();
    }

    public static void registerItemGroupEntries() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(WOODEN_TOOL);
            entries.add(STONE_TOOL);
            entries.add(IRON_TOOL);
            entries.add(GOLDEN_TOOL);
            entries.add(DIAMOND_TOOL);
            entries.add(NETHERITE_TOOL);
        });
    }
}
