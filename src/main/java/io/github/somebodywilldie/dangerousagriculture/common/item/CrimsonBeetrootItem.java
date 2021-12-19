package io.github.somebodywilldie.dangerousagriculture.common.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class CrimsonBeetrootItem extends BlockItem
{
    public CrimsonBeetrootItem(Block block, Properties properties) {
        super(block, properties);
    }

    private void setPlayerOnFire(int secondsOnFire, Entity entity) {
        entity.setSecondsOnFire(secondsOnFire);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level lvl, LivingEntity livingEntity) {
        ItemStack itemStack = super.finishUsingItem(stack, lvl, livingEntity);
        setPlayerOnFire(10, livingEntity);
        return itemStack;
    }
}
