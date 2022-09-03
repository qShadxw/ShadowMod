package uk.co.tmdavies.shadowmod.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import uk.co.tmdavies.shadowmod.utils.ModConstants;

import java.util.List;

public class ModPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ModConstants.MOD_ID);

    public static final RegistryObject<PlacedFeature> SHADOW_ORE_PLACED = PLACED_FEATURE.register("shadow_ore_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.SHADOW_ORE.getHolder().get(),
                    commonOrePlacement(20, // frequency
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(55)))));

    // Utils
    public static List<PlacementModifier> orePlacement(PlacementModifier modifier, PlacementModifier modifier2) {

        return List.of(modifier, InSquarePlacement.spread(), modifier2, BiomeFilter.biome());

    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier modifier) {

        return orePlacement(CountPlacement.of(count), modifier);

    }

    public static List<PlacementModifier> rareOrePlacement(int count, PlacementModifier modifier) {

        return orePlacement(RarityFilter.onAverageOnceEvery(count), modifier);

    }

    public static void register(IEventBus bus) {

        PLACED_FEATURE.register(bus);

    }

}
