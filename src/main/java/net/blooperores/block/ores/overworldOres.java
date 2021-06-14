package net.blooperores.block.ores;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.BlockView;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

import java.util.List;

public class overworldOres{

    public static final Block DERPY_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(5.0f, 60.f));

    private static ConfiguredFeature<?, ?> DERPY_ORE_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, DERPY_ORE.getDefaultState(), 3))
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.fixed(50), YOffset.fixed(64)))))
            .spreadHorizontally()
            .repeat(6);



    public static void init(){

        //Register Item
        Registry.register(Registry.BLOCK, new Identifier("blooperores", "derpy_ore"), DERPY_ORE);
        Registry.register(Registry.ITEM, new Identifier("blooperores", "derpy_ore"), new BlockItem(DERPY_ORE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

        //Register custom world generation for ore.
        RegistryKey<ConfiguredFeature<?, ?>> derpyOreOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("blooperores", "derpy_ore"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, derpyOreOverworld.getValue(), DERPY_ORE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, derpyOreOverworld);

    }

    //this does not work :(
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack itemStack, BlockView word, List<Text> tooltip, TooltipContext tooltipContext){
        tooltip.add(new TranslatableText("block.blooperores.derpy_ore.tooltip"));
    }

}
