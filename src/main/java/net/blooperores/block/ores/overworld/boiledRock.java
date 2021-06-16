package net.blooperores.block.ores.overworld;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;

import java.util.List;

public class boiledRock extends Block {
    public boiledRock(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(new TranslatableText("block.blooperores.boiled_rock.tooltip").formatted(Formatting.GREEN));
    }
}
