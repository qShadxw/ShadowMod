package uk.co.tmdavies.shadowmod.items.custom.pickaxes;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class ShadowPickaxe extends PickaxeItem {

    public ShadowPickaxe(Tier tier, int attackDamageModifier, Properties properties) {
        super(tier, attackDamageModifier, tier.getSpeed(), properties);
    }

}
