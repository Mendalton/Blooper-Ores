package net.blooperores.block.ores.end;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;

import java.util.List;

public class galacticOre extends Block {
    public galacticOre(Settings settings) {
        super(settings);
    }

    @Override
        tooltip.add(new TranslatableText("block.blooperores.galactic_ore.tooltip.line_1").formatted(Formatting.DARK_PURPLE));
    }
}
