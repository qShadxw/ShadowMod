package uk.co.tmdavies.shadowmod.tiers;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;
import uk.co.tmdavies.shadowmod.items.ModItems;

import java.util.function.Supplier;

public enum ShadowArmourTier implements ArmorMaterial {

    FEATHER("feather", 1024, new int[]{20, 40, 50, 10}, 300, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, () -> {
        return Ingredient.of(ModItems.SHADOW_INGOT.get());
    });

    private final String name;
    private final int durability;
    private final int[] protection;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    ShadowArmourTier(String name, int durability, int[] protection, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {

        this.name = name;
        this.durability = durability;
        this.protection = protection;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterial);

    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public int getDurabilityForSlot(@NotNull EquipmentSlot slot) {
        return this.durability;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.protection[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

}
