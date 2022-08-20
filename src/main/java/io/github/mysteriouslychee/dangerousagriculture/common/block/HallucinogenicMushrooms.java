package io.github.mysteriouslychee.dangerousagriculture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HallucinogenicMushrooms extends MushroomBlock {

    private static final VoxelShape SHAPE = makeShape();

    public HallucinogenicMushrooms(Properties properties) {
        super(properties, () -> TreeFeatures.HUGE_BROWN_MUSHROOM);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.isSolidRender(getter, pos); // TODO Make it so mushrooms can be placed on grass.
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }

    public static VoxelShape makeShape(){

        VoxelShape shape = Shapes.empty();

        shape = Shapes.join(shape, Shapes.box(0.6875, 0, 0.6875, 0.75, 0.3125, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.3125, 0.5625, 0.875, 0.375, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0.25, 0.5625, 0.5625, 0.3125, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.875, 0.25, 0.5625, 0.9375, 0.3125, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.25, 0.875, 0.875, 0.3125, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.25, 0.5, 0.875, 0.3125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.5625, 0.25, 0.25, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.25, 0.5, 0.3125, 0.3125, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.1875, 0.5, 0.125, 0.25, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.1875, 0.5, 0.375, 0.25, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.1875, 0.6875, 0.3125, 0.25, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.1875, 0.4375, 0.3125, 0.25, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0, 0.1875, 0.5625, 0.1875, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.1875, 0.125, 0.625, 0.25, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.125, 0.4375, 0.1875, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 0.125, 0.125, 0.6875, 0.1875, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.125, 0.3125, 0.625, 0.1875, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.125, 0.0625, 0.625, 0.1875, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0, 0.0625, 0.9375, 0.4375, 0.9375), BooleanOp.OR);

        return shape;
    }
}
