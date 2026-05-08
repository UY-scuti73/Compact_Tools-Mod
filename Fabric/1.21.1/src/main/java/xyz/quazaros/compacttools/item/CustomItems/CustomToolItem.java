package xyz.quazaros.compacttools.item.CustomItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import xyz.quazaros.compacttools.util.ModTags;

import java.util.Set;

public class CustomToolItem extends ToolItem {
    private final ToolMaterial material;
    private final TagKey<Block> effectiveTag;

    public CustomToolItem(ToolMaterial material, Settings settings) {
        super(material, settings.maxDamage(material.getDurability()));
        this.material = material;
        this.effectiveTag = ModTags.Blocks.ALL_MINEABLE;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return material.getEnchantability();
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB)) {
            return 50F;
        } else if (state.isOf(Blocks.BAMBOO)) {
            return 1000F;
        } else if (state.isIn(effectiveTag)) {
            return material.getMiningSpeedMultiplier();
        }
        return 1.0F;
    }

    @Override
    public boolean isCorrectForDrops(ItemStack itemStack, BlockState state) {
        if (!state.isIn(ModTags.Blocks.ALL_MINEABLE)) {return false;}

        ToolMaterial material = this.getMaterial();

        if (state.isIn(BlockTags.NEEDS_DIAMOND_TOOL)) {
            return material == ToolMaterials.DIAMOND || material == ToolMaterials.NETHERITE;
        }
        if (state.isIn(BlockTags.NEEDS_IRON_TOOL)) {
            return material == ToolMaterials.IRON || material == ToolMaterials.DIAMOND || material == ToolMaterials.NETHERITE;
        }
        if (state.isIn(BlockTags.NEEDS_STONE_TOOL)) {
            return material != ToolMaterials.WOOD && material != ToolMaterials.GOLD;
        }

        return true;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity user) {
        return !state.isAir();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient() && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, EquipmentSlot.MAINHAND);
        }
        return true;
    }
}
