package net.blooperores.block.ores.end;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.structure.rule.BlockMatchRuleTest;
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

public class endOres {

    public static final Block GALACTIC_ORE = new galacticOre(FabricBlockSettings.of(Material.STONE).strength(14.f, 15.f));



    private static ConfiguredFeature<?, ?> GALACTIC_ORE_END = Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), GALACTIC_ORE.getDefaultState(), 4))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(10), YOffset.fixed(20)))))
            .spreadHorizontally()
            .repeat(4);


    public static void init(){
        Registry.register(Registry.BLOCK, new Identifier("blooperores", "galactic_ore"), GALACTIC_ORE);
        Registry.register(Registry.ITEM, new Identifier("blooperores", "galactic_ore"), new BlockItem(GALACTIC_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));


        RegistryKey<ConfiguredFeature<?, ?>> galacticOreEnd = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("blooperores", "galactic_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, galacticOreEnd.getValue(), GALACTIC_ORE_END);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, galacticOreEnd);


    }
}
