package io.github.mysteriouslychee.dangerousagriculture.common.block;

import io.github.mysteriouslychee.dangerousagriculture.common.util.MathHelper;
import io.github.mysteriouslychee.dangerousagriculture.core.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

public class TntBerryBush extends SweetBerryBushBlock {

    public TntBerryBush(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, Integer.valueOf(0)));
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(ItemInit.TNT_BERRY.get());
    }

    @Override
    public InteractionResult use(BlockState state, Level lvl, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            int j = 1 + lvl.random.nextInt(2);
            popResource(lvl, pos, new ItemStack(ItemInit.TNT_BERRY.get(), j + (flag ? 1 : 0)));
            lvl.playSound((Player)null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + lvl.random.nextFloat() * 0.4F);
            lvl.setBlock(pos, state.setValue(AGE, Integer.valueOf(1)), 2);

            if (MathHelper.getRandomInt(0, 50) <= 3) {
                PrimedTnt primedtnt = new PrimedTnt(lvl, (double)pos.getX() + MathHelper.getRandomDouble(-1, 1), (double)pos.getY(), (double)pos.getZ() + MathHelper.getRandomDouble(-1, 1), null);
                lvl.addFreshEntity(primedtnt);
                lvl.playSound((Player)null, primedtnt.getX(), primedtnt.getY(), primedtnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
                lvl.gameEvent(null, GameEvent.PRIME_FUSE, pos);
            }

            return InteractionResult.sidedSuccess(lvl.isClientSide);
        } else {
            return super.use(state, lvl, pos, player, hand, result);
        }
    }

    @Override
    public void entityInside(BlockState state, Level lvl, BlockPos pos, Entity entity) {

        if (MathHelper.getRandomInt(0, 1000) <= 7 && state.getValue(AGE) > 2) {
            if (entity instanceof PrimedTnt || entity instanceof ItemEntity)
                return;
            PrimedTnt primedtnt = new PrimedTnt(lvl, (double)pos.getX() + MathHelper.getRandomDouble(-1, 1), (double)pos.getY(), (double)pos.getZ() + MathHelper.getRandomDouble(-1, 1), null);
            lvl.addFreshEntity(primedtnt);
            lvl.playSound((Player)null, primedtnt.getX(), primedtnt.getY(), primedtnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
            lvl.gameEvent(null, GameEvent.PRIME_FUSE, pos);
        }
        else if (MathHelper.getRandomInt(0, 1000) <= 5 && state.getValue(AGE) == 2) {
            if (entity instanceof PrimedTnt || entity instanceof ItemEntity)
                return;
            PrimedTnt primedtnt = new PrimedTnt(lvl, (double)pos.getX() + MathHelper.getRandomDouble(-1, 1), (double)pos.getY(), (double)pos.getZ() + MathHelper.getRandomDouble(-1, 1), null);
            lvl.addFreshEntity(primedtnt);
            lvl.playSound((Player)null, primedtnt.getX(), primedtnt.getY(), primedtnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
            lvl.gameEvent(null, GameEvent.PRIME_FUSE, pos);
        }
        else if (MathHelper.getRandomInt(0, 1000) <= 1 && state.getValue(AGE) < 2) {
            if (entity instanceof PrimedTnt || entity instanceof ItemEntity)
                return;
            PrimedTnt primedtnt = new PrimedTnt(lvl, (double)pos.getX() + MathHelper.getRandomDouble(-1, 1), (double)pos.getY(), (double)pos.getZ() + MathHelper.getRandomDouble(-1, 1), null);
            lvl.addFreshEntity(primedtnt);
            lvl.playSound((Player)null, primedtnt.getX(), primedtnt.getY(), primedtnt.getZ(), SoundEvents.TNT_PRIMED, SoundSource.BLOCKS, 1.0F, 1.0F);
            lvl.gameEvent(null, GameEvent.PRIME_FUSE, pos);
        }
        else { }
    }
}
