package com.blogspot.richardreigens.lilrichymod.blocks.crops;

import com.blogspot.richardreigens.lilrichymod.init.ModItems;
import net.minecraft.item.Item;

/**
 * Created by Rich on 12/2/2015.
 */

public class BeardedAzalea extends LiLRichyCrop {
    public BeardedAzalea(String name) {
        super(name);
        setUnlocalizedName(name);
    }

    @Override
    protected Item getSeed() {
        return ModItems.seedBearedAzailia;
    }

    @Override
    protected Item getCrop() {
        return ModItems.essanceOfBeared;
    }
}
