package uk.co.tmdavies.shadowmod.items.custom.swords;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class TeleportSword extends SwordItem {

    private final float abilityModifier;

    public TeleportSword(Tier tier, float abilityModifier, int attackDamageModifier, Properties properties) {

        super(tier, attackDamageModifier, tier.getSpeed(), properties);

        this.abilityModifier = abilityModifier;

    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, Player player, @NotNull InteractionHand hand) {

        InteractionResultHolder<ItemStack> pass = InteractionResultHolder.pass(player.getItemInHand(hand));

        Vec3 vec = player.getLookAngle().scale(this.abilityModifier).add(player.getPosition(this.abilityModifier));
        int loop = 0;

        if (vec.y < -64 || vec.y > 319) return pass; // Below Bedrock or Above Build Height

        while (!world.getBlockState(new BlockPos(vec.x, vec.y, vec.z)).getBlock().asItem().getDescriptionId().equals("block.minecraft.air")) {

            vec.add(0, 1, 0);

            loop++;

            if (loop == 2) return pass;

        }

        player.teleportTo(vec.x, vec.y, vec.z);

        return pass;

    }


}
