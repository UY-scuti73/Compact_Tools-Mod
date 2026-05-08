package xyz.quazaros.compacttools.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import xyz.quazaros.compacttools.CompactTools;
import xyz.quazaros.compacttools.item.CustomItems.ToolItem;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(CompactTools.MOD_ID);

    public static final DeferredItem<Item> WOODEN_TOOL   = ITEMS.register("wooden_tool",   () -> new ToolItem(Tiers.WOOD,      getProperties("wooden")));
    public static final DeferredItem<Item> STONE_TOOL    = ITEMS.register("stone_tool",    () -> new ToolItem(Tiers.STONE,     getProperties("stone")));
    public static final DeferredItem<Item> IRON_TOOL     = ITEMS.register("iron_tool",     () -> new ToolItem(Tiers.IRON,      getProperties("iron")));
    public static final DeferredItem<Item> GOLDEN_TOOL   = ITEMS.register("golden_tool",   () -> new ToolItem(Tiers.GOLD,      getProperties("golden")));
    public static final DeferredItem<Item> DIAMOND_TOOL  = ITEMS.register("diamond_tool",  () -> new ToolItem(Tiers.DIAMOND,   getProperties("diamond")));
    public static final DeferredItem<Item> NETHERITE_TOOL = ITEMS.register("netherite_tool", () -> new ToolItem(Tiers.NETHERITE, getProperties("netherite")));

    private static Item.Properties getProperties(String type) {
        Item.Properties properties = new Item.Properties();
        if (type.equals("netherite")) properties.fireResistant();
        return properties;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}