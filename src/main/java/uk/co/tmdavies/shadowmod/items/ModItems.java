package uk.co.tmdavies.shadowmod.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import uk.co.tmdavies.shadowmod.tiers.ShadowTier;
import uk.co.tmdavies.shadowmod.utils.ModConstants;

public class ModItems {

    // Registerer
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModConstants.MOD_ID);

    // Items
    public static final RegistryObject<Item> SHADOW_INGOT = ITEMS.register("shadow_ingot",
            () -> new Item(new Item.Properties().fireResistant().tab(ModConstants.SHADOWMOD_TAB)));

    // Weapons
    public static final RegistryObject<Item> SHADOW_SWORD = ITEMS.register("shadow_sword",
            () -> new SwordItem(ShadowTier.SHADOW, 1, 1F,
                    new Item.Properties().fireResistant().tab(ModConstants.SHADOWMOD_TAB)));

    // Tools
    public static final RegistryObject<Item> SHADOW_PICKAXE = ITEMS.register("shadow_pickaxe",
            () -> new PickaxeItem(ShadowTier.SHADOW, 1, 1F,
                    new Item.Properties().fireResistant().tab(ModConstants.SHADOWMOD_TAB)));

    public static void register(IEventBus bus) {

        ITEMS.register(bus);

    }

}
