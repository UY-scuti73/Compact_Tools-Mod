package xyz.quazaros.compacttools.item.CustomItems;

import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.common.Mod;
import xyz.quazaros.compacttools.util.ModTags;

public class ToolItem extends PickaxeItem {
    Tiers material;
    public ToolItem(Tiers pMaterial, Properties pProperties) {
        super(pMaterial, 1, -2.8F, pProperties);
        this.material = pMaterial;
    }

    @Override
    public float getDestroySpeed(ItemStack itemStack, BlockState blockState) {
        if (blockState.is(Blocks.COBWEB)) {
            return 50.0F;
        } else if (blockState.is(Blocks.BAMBOO)) {
            return 1000.0F;
        } else if (blockState.is(ModTags.Blocks.ALL_MINEABLE)) {
            return this.material.getSpeed();
        }
        return super.getDestroySpeed(itemStack, blockState);
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack itemStack, BlockState state) {
        return state.is(ModTags.Blocks.ALL_MINEABLE);
    }
}
