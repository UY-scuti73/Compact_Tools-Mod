package xyz.quazaros.compacttools.item.CustomItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import xyz.quazaros.compacttools.util.ModTags;

import java.util.Set;

public class ToolItem extends Item {
    private final ToolMaterial material;
    private final Set<Block> mineableBlocks;
    private final float speed;
    private final float attackSpeed;

    public ToolItem(ToolMaterial material, Properties properties) {
        super(properties.durability(material.durability()));
        this.material = material;
        this.mineableBlocks = Set.of(
                Blocks.COBWEB, Blocks.BAMBOO
        );
        this.speed = 1.0F;
        this.attackSpeed = -2.8F;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 50F;
        } else if (state.is(Blocks.BAMBOO)) {
            return 1000F;
        } else if (state.is(ModTags.Blocks.ALL_MINEABLE)) {
            return material.speed();
        }
        return 1.0F;
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(ModTags.Blocks.ALL_MINEABLE);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!level.isClientSide && state.getDestroySpeed(level, pos) != 0.0F) {
            stack.hurtAndBreak(1, miner, EquipmentSlot.MAINHAND);
        }
        return true;
    }
}
