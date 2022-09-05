package uk.co.tmdavies.shadowmod;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import uk.co.tmdavies.shadowmod.blocks.ModBlocks;
import uk.co.tmdavies.shadowmod.events.custom.ManaRegenerationEvent;
import uk.co.tmdavies.shadowmod.networking.ModMessages;
import uk.co.tmdavies.shadowmod.utils.ModConstants;
import uk.co.tmdavies.shadowmod.items.ModItems;
import uk.co.tmdavies.shadowmod.world.feature.ModConfiguredFeatures;
import uk.co.tmdavies.shadowmod.world.feature.ModPlacedFeatures;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Mod(ModConstants.MOD_ID)
public class ShadowMod {

    public static final Logger LOGGER = LogUtils.getLogger();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public ShadowMod() {

        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModConfiguredFeatures.register(modEventBus);
        ModPlacedFeatures.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        Runnable fuckItWeWillDoItLive = () -> {

            MinecraftForge.EVENT_BUS.post(new ManaRegenerationEvent(Minecraft.getInstance().player));

        };

        scheduler.scheduleAtFixedRate(fuckItWeWillDoItLive, 0, 5, TimeUnit.SECONDS);

    }

    public void commonSetup(final FMLCommonSetupEvent event) {

        ModMessages.register();

    }

}
