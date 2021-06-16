package net.blooperores.block.ores.overworld;


import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
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


public class overworldOres {

    public static final Block DERPY_ORE = new derpyOre(FabricBlockSettings.of(Material.STONE).strength(5.0f, 60.f));
    
    public static final Block BOILED_ROCK = new boiledRock(FabricBlockSettings.of(Material.METAL).breakByHand(false).breakByTool(FabricToolTags.PICKAXES,4).sounds(BlockSoundGroup.NETHER_ORE).strength(3.0f, 4.0f));

    private static ConfiguredFeature<?, ?> DERPY_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, DERPY_ORE.getDefaultState(), 4))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(50), YOffset.fixed(64)))))
            .spreadHorizontally()
            .repeat(6);
    
    private static ConfiguredFeature<?, ?> BOILED_ROCK_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, BOILED_ROCK.getDefaultState(), 5))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(10), YOffset.fixed(20)))))
            .spreadHorizontally()
            .repeat(5);


    public static void init(){

        //Register Derpy Ore
        Registry.register(Registry.BLOCK, new Identifier("blooperores", "derpy_ore"), DERPY_ORE);
        Registry.register(Registry.ITEM, new Identifier("blooperores", "derpy_ore"), new BlockItem(DERPY_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));
        
        //Register Boiled Ore
        Registry.register(Registry.BLOCK, new Identifier("blooperores", "boiled_rock"), BOILED_ROCK);
        Registry.register(Registry.ITEM, new Identifier("blooperores", "boiled_rock"), new BlockItem(BOILED_ROCK, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        //Register custom world gen for Derpy Ore.
        RegistryKey<ConfiguredFeature<?, ?>> derpyOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("blooperores", "derpy_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, derpyOreOverworld.getValue(), DERPY_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, derpyOreOverworld);
        
        //Register custom world gen for Boiled Ore.
        RegistryKey<ConfiguredFeature<?, ?>> boiledRockOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("blooperores", "boild_rock"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, boiledRockOverworld.getValue(), BOILED_ROCK_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, boiledRockOverworld);

    }


}
