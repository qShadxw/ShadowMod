package uk.co.tmdavies.shadowmod.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import uk.co.tmdavies.shadowmod.blocks.ModBlocks;
import uk.co.tmdavies.shadowmod.utils.ModConstants;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, ModConstants.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SHADOW_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.SHADOW_ORE.get().defaultBlockState()),
            OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_SHADOW_ORE.get().defaultBlockState())
    ));

    public static final RegistryObject<ConfiguredFeature<?, ?>> SHADOW_ORE = CONFIGURED_FEATURES.register("shadow_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Objects.requireNonNull(OVERWORLD_SHADOW_ORES.get()), 6))); // how many per vein

    public static final RegistryObject<ConfiguredFeature<?, ?>> DEEPSLATE_SHADOW_ORE = CONFIGURED_FEATURES.register("deepslate_shadow_ore",
            () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(Objects.requireNonNull(OVERWORLD_SHADOW_ORES.get()), 6))); // how many per vein

    public static void register(IEventBus bus) {

        CONFIGURED_FEATURES.register(bus);

    }

}
