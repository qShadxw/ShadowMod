package uk.co.tmdavies.shadowmod.tiers;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import uk.co.tmdavies.shadowmod.items.ModItems;

import java.util.function.Supplier;

public enum ShadowTier implements Tier {

    SHADOW_SWORD(5, 5052, 1.0F, 9.0F, 15, () -> {
        return Ingredient.of(ModItems.SHADOW_INGOT.get());
    }),
    SHADOW_PICKAXE(5, 5052, 1.0F, 6F, 15, () -> {
        return Ingredient.of(ModItems.SHADOW_INGOT.get());
    });

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    ShadowTier(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {

        this.level = level;
        this.uses = uses;
        this.speed = speed-4; // Makes actual attribute 0. ((4-4)+speed)
        this.damage = damage; // (1+damage)
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);

    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
