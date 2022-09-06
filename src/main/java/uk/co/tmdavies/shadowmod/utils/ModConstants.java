package uk.co.tmdavies.shadowmod.utils;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import uk.co.tmdavies.shadowmod.items.ModItems;

public class ModConstants {

    // Essentials
    public static final String MOD_ID = "shadowmod";

    // Tabs
    public static final CreativeModeTab SHADOWMOD_TAB = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SHADOW_INGOT.get());
        }
    };

    // Generation
    public static final int DEFAULT_GENERATION_FREQUENCY = 20;
    public static final int DEBUG_GENERATION_FREQUENCY = 240;

    // Mana
    public static final int MAX_MANA = 10;
    public static final int MIN_MANA = 0;

}
