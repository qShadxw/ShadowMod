package uk.co.tmdavies.shadowmod.utils;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import uk.co.tmdavies.shadowmod.items.ModItems;

public class ModConstants {

    // Essentials
    public static final String MOD_ID = "shadowmod";

    // Tabs
    public static final CreativeModeTab SHADOWMOD_TAB = new CreativeModeTab("shadowmod") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.SHADOW_INGOT.get());
        }
    };

}
