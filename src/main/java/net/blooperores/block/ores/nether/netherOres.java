package net.blooperores.block.ores.nether;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class netherOres {

    public static final Block BOURLITE_ORE = new bourliteOre(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.NETHER_ORE).strength(3, 7.2f));

    public static final Block DEVILISH_ORE = new devilish_ore(FabricBlockSettings.of(Material.STONE).sounds(BlockSoundGroup.NETHER_ORE).strength(2, 500.0f));

    public static final Item RAW_BOURLITE = new rawBourlite(new Item.Settings().group(ItemGroup.MISC));

    private static ConfiguredFeature<?, ?> BOURLITE_ORE_NETHER = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_NETHER, BOURLITE_ORE.getDefaultState(), 5))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(50), YOffset.fixed(64)))))
            .spreadHorizontally()
            .repeat(7);

    private static ConfiguredFeature<?, ?> DEVILISH_ORE_NETHER = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_NETHER, DEVILISH_ORE.getDefaultState(), 6))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(20), YOffset.fixed(40)))))
            .spreadHorizontally()
            .repeat(5);

    public static void init(){

        Registry.register(Registry.BLOCK, new Identifier("blooperores", "bourlite_ore"), BOURLITE_ORE);
        Registry.register(Registry.ITEM, new Identifier("blooperores", "bourlite_ore"), new BlockItem(BOURLITE_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.BLOCK, new Identifier("blooperores", "devilish_ore"), DEVILISH_ORE);
        Registry.register(Registry.ITEM, new Identifier("blooperores", "devilish_ore"), new BlockItem(DEVILISH_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        Registry.register(Registry.ITEM, new Identifier("blooperores", "raw_bourlite"), RAW_BOURLITE);

        RegistryKey<ConfiguredFeature<?, ?>> bourliteOreNether = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("blooperores", "bourlite_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, bourliteOreNether.getValue(), BOURLITE_ORE_NETHER);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, bourliteOreNether);

        RegistryKey<ConfiguredFeature<?, ?>> devilishOreNether = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("blooperores", "devilish_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, devilishOreNether.getValue(), DEVILISH_ORE_NETHER);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, devilishOreNether);
    }
}
