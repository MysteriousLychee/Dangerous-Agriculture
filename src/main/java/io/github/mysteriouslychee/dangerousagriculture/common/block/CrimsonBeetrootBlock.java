package io.github.mysteriouslychee.dangerousagriculture.common.block;

import io.github.mysteriouslychee.dangerousagriculture.core.init.ItemInit;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;

public class CrimsonBeetrootBlock extends BushBlock
{
    public static final IntegerProperty AGE = BlockStateProperties.AGE_3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[] {
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D)};

    public CrimsonBeetrootBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 0));
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos) {
        return state.is(Blocks.CRIMSON_NYLIUM);
    }

    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return PlantType.NETHER;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < 3;
    }

    @Override
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel sLevel, @NotNull BlockPos pos, @NotNull RandomSource rand) {
        getAgeValue(state, sLevel, pos, rand, AGE);
    }

    static void getAgeValue(BlockState state, ServerLevel sLevel, BlockPos pos, RandomSource rand, IntegerProperty age) {
        int i = state.getValue(age);
        if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(sLevel, pos, state, rand.nextInt(10) == 0)) {
            state = state.setValue(age, i + 1);
            sLevel.setBlock(pos, state, 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(sLevel, pos, state);
        }
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(@NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull BlockState state) {
        return new ItemStack(ItemInit.CRIMSON_BEETROOT.get());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
