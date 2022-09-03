package uk.co.tmdavies.shadowmod.items.custom.swords;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ShadowSword extends SwordItem {

    public ShadowSword(Tier tier, int attackDamageModifier, Properties properties) {
        super(tier, attackDamageModifier, tier.getSpeed(), properties);
    }

}
