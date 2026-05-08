package xyz.quazaros.compacttools.item.CustomItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import xyz.quazaros.compacttools.util.ModTags;

public class ToolItem extends DiggerItem {
    public ToolItem(ToolMaterial pMaterial, Properties pProperties) {
        super(pMaterial, ModTags.Blocks.ALL_MINEABLE, 1.0F, -2.8f, pProperties);
    }

    @Override
    public float getDestroySpeed(ItemStack itemStack, BlockState blockState) {
        if (blockState.is(Blocks.COBWEB)) {
            return 50.0F;
        } else if (blockState.is(Blocks.BAMBOO)) {
            return 1000.0F;
        }
        return super.getDestroySpeed(itemStack, blockState);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack itemStack, BlockState state) {
        return state.is(ModTags.Blocks.ALL_MINEABLE);
    }
}
