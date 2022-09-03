package uk.co.tmdavies.shadowmod;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import uk.co.tmdavies.shadowmod.blocks.ModBlocks;
import uk.co.tmdavies.shadowmod.events.PlayerListener;
import uk.co.tmdavies.shadowmod.utils.ModConstants;
import uk.co.tmdavies.shadowmod.items.ModItems;

@Mod(ModConstants.MOD_ID)
public class ShadowMod {

    public static final Logger LOGGER = LogUtils.getLogger();

    public ShadowMod() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new PlayerListener());

    }

    private void commonSetup(final FMLCommonSetupEvent event) {

        LOGGER.info("ShadowMod is loading...");

    }

}
