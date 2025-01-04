package xyz.quazaros.compacttools.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import xyz.quazaros.compacttools.CompactTools;
import xyz.quazaros.compacttools.item.CustomItems.ToolItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CompactTools.MOD_ID);

    public static final RegistryObject<Item> WOODEN_TOOL = ITEMS.register("wooden_tool", () -> new ToolItem(ToolMaterial.WOOD, getProperties("wooden")));
    public static final RegistryObject<Item> STONE_TOOL = ITEMS.register("stone_tool", () -> new ToolItem(ToolMaterial.STONE, getProperties("stone")));
    public static final RegistryObject<Item> IRON_TOOL = ITEMS.register("iron_tool", () -> new ToolItem(ToolMaterial.IRON, getProperties("iron")));
    public static final RegistryObject<Item> GOLD_TOOL = ITEMS.register("gold_tool", () -> new ToolItem(ToolMaterial.GOLD, getProperties("gold")));
    public static final RegistryObject<Item> DIAMOND_TOOL = ITEMS.register("diamond_tool", () -> new ToolItem(ToolMaterial.DIAMOND, getProperties("diamond")));
    public static final RegistryObject<Item> NETHERITE_TOOL = ITEMS.register("netherite_tool", () -> new ToolItem(ToolMaterial.NETHERITE, getProperties("netherite")));

    private static Item.Properties getProperties(String type) {
        Item.Properties properties = new Item.Properties().useItemDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, ResourceLocation.parse("compacttools73:"+type+"_tool")));
        if (type.equals("netherite")) {properties.fireResistant();}
        return properties;
    }

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
