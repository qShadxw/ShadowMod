package uk.co.tmdavies.shadowmod.blocks;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import uk.co.tmdavies.shadowmod.items.ModItems;
import uk.co.tmdavies.shadowmod.utils.ModConstants;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ModConstants.MOD_ID);

    // Ores
    public static final RegistryObject<Block> SHADOW_ORE = registerBlock("shadow_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6F).sound(SoundType.STONE).requiresCorrectToolForDrops()),
            ModConstants.SHADOWMOD_TAB);
    public static final RegistryObject<Block> DEEPSLATE_SHADOW_ORE = registerBlock("deepslate_shadow_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                    .strength(7F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()),
            ModConstants.SHADOWMOD_TAB);

    // Blocks
    public static final RegistryObject<Block> SHADOW_BLOCK = registerBlock("shadow_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(8F).sound(SoundType.METAL).requiresCorrectToolForDrops()),
            ModConstants.SHADOWMOD_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {

        RegistryObject<T> register = BLOCKS.register(name, block);

        registerBlockItem(name, register, tab);

        return register;

    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));

    }

    public static void register(IEventBus bus) {

        BLOCKS.register(bus);

    }

}
