package io.github.mysteriouslychee.dangerousagriculture.common.block;

import io.github.mysteriouslychee.dangerousagriculture.core.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class BlackberryBushBlock extends SweetBerryBushBlock
{
    public BlackberryBushBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    private static final DamageSource BLACKBERRY_BUSH = new DamageSource("blackBerryBush");

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull BlockState state) {
        return new ItemStack(ItemInit.BLACKBERRY.get());
    }

    @Override
    public @NotNull InteractionResult use(BlockState state, @NotNull Level lvl, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + lvl.random.nextInt(2);
            popResource(lvl, pos, new ItemStack(ItemInit.BLACKBERRY.get(), j + (flag ? 1 : 0)));
            lvl.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + lvl.random.nextFloat() * 0.4F);
            lvl.setBlock(pos, state.setValue(AGE, 1), 2);
            return InteractionResult.sidedSuccess(lvl.isClientSide);
        } else {
            return super.use(state, lvl, pos, player, hand, result);
        }
    }

    @Override
    public void entityInside(@NotNull BlockState state, @NotNull Level lvl, @NotNull BlockPos pos, @NotNull Entity entity) {
        doBushThings(state, lvl, entity, state.getValue(AGE), BLACKBERRY_BUSH);
    }

    static void doBushThings(BlockState state, Level lvl, Entity entity, Integer value, DamageSource blackberryBush) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE) {
            entity.makeStuckInBlock(state, new Vec3(0.8F, 0.75D, 0.8F));
            if (!lvl.isClientSide && value > 0 && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
                double d0 = Math.abs(entity.getX() - entity.xOld);
                double d1 = Math.abs(entity.getZ() - entity.zOld);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                    entity.hurt(blackberryBush, 1.0F);
                }
            }

        }
    }
}
