package net.blooperOres.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class blooperItem {
    public static final Item BLOOPER_ITEM = new Item(new FabricItemSettings().group(ItemGroup.MISC)){
        @Override
        public TypedActionResult<ItemStack> use(World world, PlayerEntity PlayerEntity, Hand hand){
            PlayerEntity.damage(DamageSource.DRAGON_BREATH, 30.f);
            return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, PlayerEntity.getStackInHand(hand));
        }
    };

    public static void register(){
        Registry.register(Registry.ITEM, new Identifier("blooperOres", "blooperItem"), BLOOPER_ITEM);
    }
}
