package uk.co.tmdavies.shadowmod.networking;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import uk.co.tmdavies.shadowmod.client.data.ClientPlayerManaData;

import java.util.function.Supplier;

public class PlayerManaDataSyncS2CPacket {

    private final int mana;

    public PlayerManaDataSyncS2CPacket(int mana) {

        this.mana = mana;

    }

    public PlayerManaDataSyncS2CPacket(FriendlyByteBuf buf) {

        this.mana = buf.readInt();

    }

    public void toBytes(FriendlyByteBuf buf) {

        buf.writeInt(mana);

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {

        NetworkEvent.Context context = supplier.get();

        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            System.out.println("handle PlayerManDataSyncS2CPacket");
            ClientPlayerManaData.set(mana);
        });

        return true;

    }

}
