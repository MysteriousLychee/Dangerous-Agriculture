package io.github.somebodywilldie.dangerousagriculture.common.util;

import io.github.somebodywilldie.dangerousagriculture.DangerousAgriculture;
import io.github.somebodywilldie.dangerousagriculture.core.init.BlockInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = DangerousAgriculture.Reference.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber
{
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.PEPPER_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.WARPED_CARROTS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.CRIMSON_BEETROOTS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlockInit.BLACKBERRY_BUSH.get(), RenderType.cutout());
    }
}
