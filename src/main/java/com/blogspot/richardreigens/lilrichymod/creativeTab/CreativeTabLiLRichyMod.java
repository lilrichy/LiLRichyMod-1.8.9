package com.blogspot.richardreigens.lilrichymod.creativeTab;

import com.blogspot.richardreigens.lilrichymod.init.DecorativeBlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.blogspot.richardreigens.lilrichymod.reference.Reference.MOD_ID;

/**
 * Created by Rich on 11/20/2015.
 */
public class CreativeTabLiLRichyMod {
    public static final CreativeTabs LR_Tab = new CreativeTabs(MOD_ID.toLowerCase()) {
        @SideOnly(Side.CLIENT)
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(DecorativeBlockInit.concrete_block);
        }
    };
    //Todo Item not rendered in creative tab
}