package uk.co.tmdavies.shadowmod.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import uk.co.tmdavies.shadowmod.client.hud.PlayerManaHudOverlay;
import uk.co.tmdavies.shadowmod.utils.ModConstants;

public class ClientListener {

    @Mod.EventBusSubscriber(modid = ModConstants.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

        @SubscribeEvent
        public static void registerGUIOverlays(RegisterGuiOverlaysEvent event) {

            event.registerAboveAll("mana", PlayerManaHudOverlay.HUD_MANA);

        }

    }

}
