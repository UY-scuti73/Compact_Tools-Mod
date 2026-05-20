package xyz.quazaros.compacttools.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import xyz.quazaros.compacttools.CompactTools;
import xyz.quazaros.compacttools.item.CustomItems.CustomToolItem;

public class ModItems {

    public static Item WOODEN_TOOL;
    public static Item STONE_TOOL;
    public static Item COPPER_TOOL;
    public static Item IRON_TOOL;
    public static Item GOLDEN_TOOL;
    public static Item DIAMOND_TOOL;
    public static Item NETHERITE_TOOL;

    private static Item.Properties getSettings(String type, String name) {
        Item.Properties props = new Item.Properties()
                .stacksTo(1)
                .enchantable(15)
                .setId(ResourceKey.create(Registries.ITEM,
                        Identifier.fromNamespaceAndPath(CompactTools.MOD_ID, name)));
        if (type.equals("netherite")) props = props.fireResistant();
        return props;
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(CompactTools.MOD_ID, name), item);
    }

    public static void registerItems() {
        WOODEN_TOOL   = registerItem("wooden_tool",   new CustomToolItem(ToolMaterial.WOOD,     getSettings("wood",      "wooden_tool")));
        STONE_TOOL    = registerItem("stone_tool",    new CustomToolItem(ToolMaterial.STONE,    getSettings("stone",     "stone_tool")));
        COPPER_TOOL   = registerItem("copper_tool",   new CustomToolItem(ToolMaterial.COPPER,   getSettings("copper",    "copper_tool")));
        IRON_TOOL     = registerItem("iron_tool",     new CustomToolItem(ToolMaterial.IRON,     getSettings("iron",      "iron_tool")));
        GOLDEN_TOOL   = registerItem("golden_tool",   new CustomToolItem(ToolMaterial.GOLD,     getSettings("gold",      "golden_tool")));
        DIAMOND_TOOL  = registerItem("diamond_tool",  new CustomToolItem(ToolMaterial.DIAMOND,  getSettings("diamond",   "diamond_tool")));
        NETHERITE_TOOL = registerItem("netherite_tool", new CustomToolItem(ToolMaterial.NETHERITE, getSettings("netherite", "netherite_tool")));

        CompactTools.LOGGER.info("Registering Mod Items For " + CompactTools.MOD_ID);
        registerItemGroupEntries();
    }

    public static void registerItemGroupEntries() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.accept(WOODEN_TOOL);
            entries.accept(STONE_TOOL);
            entries.accept(COPPER_TOOL);
            entries.accept(IRON_TOOL);
            entries.accept(GOLDEN_TOOL);
            entries.accept(DIAMOND_TOOL);
            entries.accept(NETHERITE_TOOL);
        });
    }
}