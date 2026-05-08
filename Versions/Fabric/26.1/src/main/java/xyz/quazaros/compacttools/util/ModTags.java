package xyz.quazaros.compacttools.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import xyz.quazaros.compacttools.CompactTools;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ALL_MINEABLE = createTag("all_mineable");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(CompactTools.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TOOLS = createTag("tools");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CompactTools.MOD_ID, name));
        }
    }
}