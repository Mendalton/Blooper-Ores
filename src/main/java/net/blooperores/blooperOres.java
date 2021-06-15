package net.blooperores;

import net.blooperores.block.ores.overworld.overworldOres;
import net.blooperores.item.blooperItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
public class blooperOres implements ModInitializer {

    public static final String MODID = "blooperores" ;

    public static final Item BLOOPER_ITEM = new blooperItem(new Item.Settings().group(ItemGroup.MISC));
    @Override
    public void onInitialize(){
        Registry.register(Registry.ITEM, new Identifier(MODID, "blooper_item"), BLOOPER_ITEM);
        overworldOres.init();
    }

}
