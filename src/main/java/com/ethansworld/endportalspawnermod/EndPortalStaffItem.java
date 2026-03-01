package com.ethansworld.endportalspawnermod;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.MenuProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.core.Direction;

public class EndPortalStaffItem extends Item {
    public EndPortalStaffItem() {
        super(new Item.Properties().stacksTo(1).durability(0).setNoRepair());
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
        if (!level.isClientSide()) {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dz = -1; dz <= 1; dz++) {
                    BlockPos portalPos = pos.offset(dx, 0, dz);
                    if (level.getBlockState(portalPos).isAir()) {
                        level.setBlock(portalPos, Blocks.END_PORTAL.defaultBlockState(), 3);
                    }
                }
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
    @Override
    public boolean isBarVisible(ItemStack stack) {
        return false;
    }
}