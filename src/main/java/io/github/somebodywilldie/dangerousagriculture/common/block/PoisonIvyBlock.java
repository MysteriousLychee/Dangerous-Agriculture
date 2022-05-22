package io.github.somebodywilldie.dangerousagriculture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class PoisonIvyBlock extends VineBlock {

	public static final DamageSource POISON_IVY_DAMAGE_SRC = new DamageSource("poisonIvyBlock");
	
	public PoisonIvyBlock(Properties properties) {
		super(properties);
	}
	
	@Override
    public void entityInside(BlockState state, Level lvl, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.BEE) {
        	
        	// TODO Make into switch case to determine when to stuck the entity in block
            entity.makeStuckInBlock(state, new Vec3((double)0.8F, 0.75D, (double)0.8F));
            
            if (!lvl.isClientSide && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
                double d0 = Math.abs(entity.getX() - entity.xOld);
                double d1 = Math.abs(entity.getZ() - entity.zOld);
                if (d0 >= (double)0.003F || d1 >= (double)0.003F) {
                    entity.hurt(POISON_IVY_DAMAGE_SRC, 1.0F);
                }
            }
        }
    }
	
}
