package net.blooperores.block.ores.nether;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
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

    public static final Block BOURLITE_ORE = new bourliteOre(FabricBlockSettings.of(Material.STONE).strength(4.8f, 30.2f));

    private static ConfiguredFeature<?, ?> BOURLITE_ORE_NETHER = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_NETHER, BOURLITE_ORE.getDefaultState(), 5))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(50), YOffset.fixed(64)))))
            .spreadHorizontally()
            .repeat(6);

    public static void init(){

        Registry.register(Registry.BLOCK, new Identifier("blooperores", "bourlite_ore"), BOURLITE_ORE);
        Registry.register(Registry.ITEM, new Identifier("blooperores", "bourlite_ore"), new BlockItem(BOURLITE_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        RegistryKey<ConfiguredFeature<?, ?>> bourliteOreNether = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("blooperores", "bourlite_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, bourliteOreNether.getValue(), BOURLITE_ORE_NETHER);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, bourliteOreNether);
    }
}
