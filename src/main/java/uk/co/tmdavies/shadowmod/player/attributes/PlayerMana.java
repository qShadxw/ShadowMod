package uk.co.tmdavies.shadowmod.player.attributes;

import net.minecraft.nbt.CompoundTag;
import uk.co.tmdavies.shadowmod.utils.ModConstants;

public class PlayerMana {

    private int mana = this.MAX_MANA;
    private final int MIN_MANA = ModConstants.MIN_MANA;
    private final int MAX_MANA = ModConstants.MAX_MANA;

    public int getMana() {

        return this.mana;

    }

    public void setMana(int amount) {

        if (amount > this.MAX_MANA) amount = this.MAX_MANA;
        if (amount < this.MIN_MANA) amount = this.MIN_MANA;

        this.mana = amount;

    }

    public void addMana(int amount) {

        if ((this.mana + amount) > this.MAX_MANA) {

            this.mana = this.MAX_MANA;

        } else {

            this.mana += amount;

        }

    }

    public void subMana(int amount) {

        if ((this.mana - amount) < 0) {

            this.mana = 0;

        } else {

            this.mana -= amount;

        }

    }

    public int getMaxMana() {

        return this.MAX_MANA;

    }

    public int getMinMana() {

        return this.MIN_MANA;

    }

    public void copyFrom(PlayerMana source) {

        this.mana = source.mana;

    }

    public void saveNBTData(CompoundTag nbt) {

        nbt.putInt("mana", this.mana);

    }

    public void loadNBTData(CompoundTag nbt) {

        this.mana = nbt.getInt("mana");

    }

}
