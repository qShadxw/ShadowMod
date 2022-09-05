package uk.co.tmdavies.shadowmod.events;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import uk.co.tmdavies.shadowmod.events.custom.ManaRegenerationEvent;
import uk.co.tmdavies.shadowmod.networking.ModMessages;
import uk.co.tmdavies.shadowmod.networking.PlayerManaDataSyncS2CPacket;
import uk.co.tmdavies.shadowmod.player.attributes.PlayerMana;
import uk.co.tmdavies.shadowmod.player.attributes.PlayerManaProvider;
import uk.co.tmdavies.shadowmod.utils.ModConstants;

@Mod.EventBusSubscriber(modid = ModConstants.MOD_ID)
public class PlayerListener {

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {

        event.register(PlayerMana.class);

    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {

        if (!(event.getObject() instanceof Player player)) return;
        if (player.getCapability(PlayerManaProvider.PLAYER_MANA).isPresent()) return;

        event.addCapability(new ResourceLocation(ModConstants.MOD_ID, "properties"), new PlayerManaProvider());

    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {

        if (event.isWasDeath()) {

            // Old Player Object
            event.getOriginal().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(oldStore -> {

                // New Player Object
                event.getEntity().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(newStore -> {

                    newStore.copyFrom(oldStore);

                });

            });

        }

    }

    @SubscribeEvent
    public static void onManaRegeneration(ManaRegenerationEvent event) {

        if (event.getPlayer() == null) return;

        event.getPlayer().getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {

            mana.addMana(2);

        });

    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {

        if (event.getLevel().isClientSide()) return;
        if (!(event.getEntity() instanceof ServerPlayer player)) return;

        player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {
            ModMessages.sendToPlayer(new PlayerManaDataSyncS2CPacket(mana.getMana()), player);
        });

    }

}
