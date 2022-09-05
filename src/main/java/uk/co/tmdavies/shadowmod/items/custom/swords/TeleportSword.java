package uk.co.tmdavies.shadowmod.items.custom.swords;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import uk.co.tmdavies.shadowmod.networking.ModMessages;
import uk.co.tmdavies.shadowmod.networking.PlayerManaDataSyncS2CPacket;
import uk.co.tmdavies.shadowmod.player.attributes.PlayerManaProvider;

public class TeleportSword extends SwordItem {

    private final float abilityModifier;
    private final int abilityCost;

    public TeleportSword(Tier tier, float abilityModifier, int abilityCost, int attackDamageModifier, Properties properties) {

        super(tier, attackDamageModifier, tier.getSpeed(), properties);

        this.abilityModifier = abilityModifier;
        this.abilityCost = abilityCost;

    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player player, @NotNull InteractionHand hand) {

        InteractionResultHolder<ItemStack> pass = InteractionResultHolder.pass(player.getItemInHand(hand));

        player.getCapability(PlayerManaProvider.PLAYER_MANA).ifPresent(mana -> {

            if (mana.getMana() < this.abilityCost) return;

            Vec3 vec = player.getLookAngle().scale(this.abilityModifier).add(player.getPosition(this.abilityModifier));
            boolean isAirBlock = world.getBlockState(new BlockPos(vec.x, vec.y, vec.z)).getBlock().asItem().getDescriptionId().equals("block.minecraft.air");
            int loop = 0;
            int loopLimit = (int) (this.abilityModifier+3);

            // Replace this mechanic to checking all the blocks on the way to the destination position, if there is a block in between then return.
            while (!isAirBlock) {

                vec = vec.add(0, 1, 0);

                isAirBlock = world.getBlockState(new BlockPos(vec.x, vec.y, vec.z)).getBlock().asItem().getDescriptionId().equals("block.minecraft.air");

                loop++;

                if (loop == loopLimit) return;

            }

            if (vec.y < world.getMinBuildHeight() || vec.y > world.getMaxBuildHeight()) return; // Below Bedrock or Above Build Height

            player.teleportTo(vec.x, vec.y, vec.z);

            mana.subMana(this.abilityCost);

            player.sendSystemMessage(Component.literal("Mana: " + mana.getMana()));

        });

        return pass;

    }


}
