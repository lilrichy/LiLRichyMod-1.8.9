package com.blogspot.richardreigens.lilrichymod.items;

import com.blogspot.richardreigens.lilrichymod.creativeTab.CreativeTabLiLRichyMod;
import net.minecraft.item.Item;

/**
 * Created by Rich on 11/19/2015.
 */
public class ItemLiLRichyMod extends Item {
    public ItemLiLRichyMod(String Name) {
        super();
        this.setUnlocalizedName(Name);
        this.maxStackSize = 64;
        this.setCreativeTab(CreativeTabLiLRichyMod.LR_Tab);
        this.setNoRepair();
    }

}
