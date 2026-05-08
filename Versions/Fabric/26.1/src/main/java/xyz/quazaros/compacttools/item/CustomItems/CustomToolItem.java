package xyz.quazaros.compacttools.item.CustomItems;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import xyz.quazaros.compacttools.util.ModTags;

public class CustomToolItem extends Item {
    private final ToolMaterial material;

    public CustomToolItem(ToolMaterial material, Item.Properties settings) {
        super(settings.durability(material.durability()));
        this.material = material;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 15.0F;
        } else if (state.is(Blocks.BAMBOO)) {
            return 1000.0F;
        } else if (state.is(ModTags.Blocks.ALL_MINEABLE)) {
            // Note: speed() -> miningSpeed()
            return this.material.speed();
        }
        return 1.0F;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        if (!state.is(ModTags.Blocks.ALL_MINEABLE)) {
            return false;
        }
        // Note: incorrectBlocksForDrops() is the tag check
        return !state.is(this.material.incorrectBlocksForDrops());
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity miner) {
        // world.isClient() vs world.isClientSide()
        if (!world.isClientSide() && state.getDestroySpeed(world, pos) != 0.0F) {
            stack.hurtAndBreak(1, miner, EquipmentSlot.MAINHAND);
        }
        return true;
    }
}