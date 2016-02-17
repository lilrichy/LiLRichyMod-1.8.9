package com.blogspot.richardreigens.lilrichymod.items.seeds;

import com.blogspot.richardreigens.lilrichymod.creativeTab.CreativeTabLiLRichyMod;
import com.blogspot.richardreigens.lilrichymod.init.DecoBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;

/**
 * Created by Rich on 12/2/2015.
 */

public class SeedBeardedAzalea extends ItemSeeds {
    public SeedBeardedAzalea(String name) {
        super(DecoBlocks.beardedAzalea, Blocks.farmland);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTabLiLRichyMod.LR_Tab);
    }
}
