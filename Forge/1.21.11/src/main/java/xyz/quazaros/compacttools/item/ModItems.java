package xyz.quazaros.compacttools.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.quazaros.compacttools.CompactTools;
import xyz.quazaros.compacttools.item.CustomItems.ToolItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CompactTools.MOD_ID);

    public static final RegistryObject<Item> WOODEN_TOOL = ITEMS.register("wooden_tool", () -> new ToolItem(ToolMaterial.WOOD, getProperties("wooden")));
    public static final RegistryObject<Item> STONE_TOOL = ITEMS.register("stone_tool", () -> new ToolItem(ToolMaterial.STONE, getProperties("stone")));
    public static final RegistryObject<Item> COPPER_TOOL = ITEMS.register("copper_tool", () -> new ToolItem(ToolMaterial.COPPER, getProperties("copper")));
    public static final RegistryObject<Item> IRON_TOOL = ITEMS.register("iron_tool", () -> new ToolItem(ToolMaterial.IRON, getProperties("iron")));
    public static final RegistryObject<Item> GOLDEN_TOOL = ITEMS.register("golden_tool", () -> new ToolItem(ToolMaterial.GOLD, getProperties("golden")));
    public static final RegistryObject<Item> DIAMOND_TOOL = ITEMS.register("diamond_tool", () -> new ToolItem(ToolMaterial.DIAMOND, getProperties("diamond")));
    public static final RegistryObject<Item> NETHERITE_TOOL = ITEMS.register("netherite_tool", () -> new ToolItem(ToolMaterial.NETHERITE, getProperties("netherite")));

    private static Item.Properties getProperties(String type) {
        Item.Properties properties = new Item.Properties().enchantable(15).useItemDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, Identifier.m_445280_("compacttools73", type+"_tool")));
        if (type.equals("netherite")) {properties.fireResistant();}
        return properties;
    }

    public static void register(BusGroup eventBus) {ITEMS.register(eventBus);}
}
