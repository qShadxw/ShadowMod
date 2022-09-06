package uk.co.tmdavies.shadowmod.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import uk.co.tmdavies.shadowmod.player.attributes.PlayerManaProvider;

import java.util.function.Supplier;

public class PlayerManaC2SPacket {

    public PlayerManaC2SPacket() {


    }

    public PlayerManaC2SPacket(FriendlyByteBuf buf) {


    }

    public void toBytes(FriendlyByteBuf buf) {


    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {

        NetworkEvent.Context context = supplier.get();

        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();

            player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {

                System.out.println("handle PlayerManaC2SPacket");

                ModMessages.sendToPlayer(new PlayerManaDataSyncS2CPacket(mana.getMana()), player);

            });


        });

        return true;

    }

}
