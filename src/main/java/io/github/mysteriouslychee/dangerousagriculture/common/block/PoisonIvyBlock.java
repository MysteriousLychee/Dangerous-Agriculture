package io.github.mysteriouslychee.dangerousagriculture.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class PoisonIvyBlock extends VineBlock {

	public PoisonIvyBlock(Properties properties) {
		super(properties);
	}

	@Override
	public void entityInside(@NotNull BlockState state, Level lvl, @NotNull BlockPos pos, @NotNull Entity entity) {

		if (!lvl.isClientSide && (entity.xOld != entity.getX() || entity.zOld != entity.getZ())) {
			double d0 = Math.abs(entity.getX() - entity.xOld);
			double d1 = Math.abs(entity.getZ() - entity.zOld);
			
			if (d0 >= (double) 0.003F || d1 >= (double) 0.003F) {
				if (entity.isAlive()) {
					LivingEntity livingEntity = (LivingEntity) entity;
					livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0, false, false, false));
				}
			}
		}
	}
}
