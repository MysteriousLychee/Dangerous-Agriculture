package io.github.somebodywilldie.dangerousagriculture;

import io.github.somebodywilldie.dangerousagriculture.core.init.BlockInit;
import io.github.somebodywilldie.dangerousagriculture.core.init.ItemInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(DangerousAgriculture.Reference.MOD_ID)
public class DangerousAgriculture
{
    public static final CreativeModeTab DANGEROUS_AGRICULTURE_TAB = new DangerousAgricultureTab("dangerousagriculturetab");

    public DangerousAgriculture() {
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	
        bus.addListener(this::setup);
        bus.addListener(this::enqueueIMC);

        BlockInit.BLOCKS.register(bus);
        ItemInit.ITEMS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }

    private void enqueueIMC(final InterModEnqueueEvent event) { }

    public static class DangerousAgricultureTab extends CreativeModeTab
    {
        public DangerousAgricultureTab(String label) {
            super(label);
        }

        @Override
        public ItemStack makeIcon() {
            return ItemInit.WARPED_CARROT.get().getDefaultInstance();
        }
    }

    public class Reference
    {
        public static final Logger LOGGER = LogManager.getLogger();
        public static final String MOD_ID = "dangerousagriculture";
    }
}
