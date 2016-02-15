package com.blogspot.richardreigens.lilrichymod.blocks.crops;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

/**
 * Created by Rich on 12/1/2015.
 */
public class LiLRichyCrop extends BlockCrops implements IGrowable {
    protected int maxGrowthStage = 7;

    @SideOnly(Side.CLIENT)
//    protected IIcon[] iIcon;

    public LiLRichyCrop(String name) {
        this.setUnlocalizedName(name);
        setTickRandomly(true);
        float f = 0.5F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
        setHardness(0.0F);
        setStepSound(soundTypeGrass);
        disableStats();
    }

    //is the block grass, dirt or farmland
    @Override
    protected boolean canPlaceBlockOn(Block blockThatCanBePlantedOn) {
        return blockThatCanBePlantedOn == Blocks.farmland;
    }

    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        return worldIn.getBlockState(pos) == Blocks.farmland;
    }

    @Override
    public int getRenderType() {
        return 1; // Cross like flowers
    }

   /* //Gets the block's texture. Args: side, meta
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int parSide, int parGrowthStage) {
        return iIcon[parGrowthStage];
    }*/
}
