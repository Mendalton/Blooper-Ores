package net.blooperOres;

import net.blooperOres.item.blooperItem;
import net.fabricmc.api.ModInitializer;

public class main implements ModInitializer {
    @Override
    public void onInitialize(){
        blooperItem.register();
    }
}
