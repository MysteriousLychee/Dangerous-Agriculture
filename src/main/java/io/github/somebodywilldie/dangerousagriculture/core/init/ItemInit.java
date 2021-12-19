package io.github.somebodywilldie.dangerousagriculture.core.init;

import io.github.somebodywilldie.dangerousagriculture.DangerousAgriculture;
import io.github.somebodywilldie.dangerousagriculture.common.item.CrimsonBeetrootItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DangerousAgriculture.Reference.MOD_ID);

    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper", () -> new Item(new Item.Properties().tab(DangerousAgriculture.DANGEROUS_AGRICULTURE_TAB).food(new FoodProperties.Builder().alwaysEat().fast().nutrition(2).saturationMod(3).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 400, 1), 1.0f).build())));
    public static final RegistryObject<Item> PEPPER_SEEDS = ITEMS.register("pepper_seeds", () -> new BlockItem(BlockInit.PEPPER_BUSH.get(), new Item.Properties().tab(DangerousAgriculture.DANGEROUS_AGRICULTURE_TAB)));
    public static final RegistryObject<Item> WARPED_CARROT = ITEMS.register("warped_carrot", () -> new BlockItem(BlockInit.WARPED_CARROTS.get(), new Item.Properties().tab(DangerousAgriculture.DANGEROUS_AGRICULTURE_TAB).food(new FoodProperties.Builder().nutrition(3).saturationMod(2).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 800, 1), 1.0f).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 400, 1), 0.2f).effect(() -> new MobEffectInstance(MobEffects.POISON, 200, 2), 0.1f).effect(() -> new MobEffectInstance(MobEffects.JUMP, 1000, 1), 0.8f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 800, 2), 0.6f).build())));
    public static final RegistryObject<Item> WARPED_CARROT_SHAVED = ITEMS.register("warped_carrot_shaved", () -> new Item(new Item.Properties().tab(DangerousAgriculture.DANGEROUS_AGRICULTURE_TAB).food(new FoodProperties.Builder().nutrition(3).saturationMod(2).effect(() -> new MobEffectInstance(MobEffects.JUMP, 700, 1), 0.7f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600, 1), 0.95f).effect(() -> new MobEffectInstance(MobEffects.BLINDNESS, 200, 1), 0.1f).build())));
    public static final RegistryObject<Item> BLADE = ITEMS.register("blade", () -> new Item(new Item.Properties().tab(DangerousAgriculture.DANGEROUS_AGRICULTURE_TAB)));
    public static final RegistryObject<Item> CRIMSON_BEETROOT = ITEMS.register("crimson_beetroot", () -> new CrimsonBeetrootItem(BlockInit.CRIMSON_BEETROOTS.get(), new Item.Properties().tab(DangerousAgriculture.DANGEROUS_AGRICULTURE_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(4).build())));
    public static final RegistryObject<Item> BLACKBERRY = ITEMS.register("blackberry", () -> new BlockItem(BlockInit.BLACKBERRY_BUSH.get(), new Item.Properties().tab(DangerousAgriculture.DANGEROUS_AGRICULTURE_TAB).food(new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(2).build())));
}
