/*
package com.blogspot.richardreigens.lilrichymod.blocks.crops;

import com.blogspot.richardreigens.lilrichymod.init.ModItems;
import com.blogspot.richardreigens.lilrichymod.reference.Reference;
import net.minecraft.item.Item;

*/
/**
 * Created by Rich on 12/2/2015.
 *//*

public class BeardedAzalea extends LiLRichyCrop {
    public BeardedAzalea(String name) {
        super(name);
        // Basic block setup
        setUnlocalizedName(name);
        //setBlockTextureName(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    @Override
    protected Item getSeed() {
       return ModItems.seedBearedAzailia;
    }

    @Override
    protected Item getCrop() {
     return ModItems.essanceOfBeared;
    }

   */
/* @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        iIcon = new IIcon[maxGrowthStage + 1];
        // seems that crops like to have 8 growth icons, but okay to repeat actual texture if you want
        // to make generic should loop to maxGrowthStage
        iIcon[0] = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "_stage_0");
        iIcon[1] = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "_stage_1");
        iIcon[2] = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "_stage_2");
        iIcon[3] = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "_stage_3");
        iIcon[4] = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "_stage_4");
        iIcon[5] = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "_stage_5");
        iIcon[6] = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "_stage_6");
        iIcon[7] = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())) + "_stage_7");
    }

    @SideOnly(Side.CLIENT)
    public String getItemIconName() {
        return String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
    }
*//*

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":crops/", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}*/
