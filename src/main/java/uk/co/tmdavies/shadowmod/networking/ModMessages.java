package uk.co.tmdavies.shadowmod.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import uk.co.tmdavies.shadowmod.utils.ModConstants;

public class ModMessages {

    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {

        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(ModConstants.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(PlayerManaDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(PlayerManaDataSyncS2CPacket::new)
                .encoder(PlayerManaDataSyncS2CPacket::toBytes)
                .consumerMainThread(PlayerManaDataSyncS2CPacket::handle)
                .add();

    }

    public static <MSG> void sendToServer(MSG message) {

        INSTANCE.sendToServer(message);

    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {

        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);

    }

}
