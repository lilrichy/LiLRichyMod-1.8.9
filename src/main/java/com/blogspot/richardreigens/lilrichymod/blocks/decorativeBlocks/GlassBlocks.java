package com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks;

import com.blogspot.richardreigens.lilrichymod.creativeTab.CreativeTabLiLRichyMod;
import com.blogspot.richardreigens.lilrichymod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

/**
 * Created by LiLRichy on 1/26/2016.
 */
public class GlassBlocks extends Block {
    private final String blockToolTip;
    private final String blockCraftTip;

    //Constructor with Tool tip and Crafting tip string
    public GlassBlocks(String name, String toolTip, String craftTip) {
        super(Material.glass);
        this.setHardness(0.5f);
        this.setLightLevel(1.0F);
        this.setStepSound(soundTypeGlass);
        this.setCreativeTab(CreativeTabLiLRichyMod.LR_Tab);
        this.setUnlocalizedName(name);
        this.blockToolTip = toolTip;
        this.blockCraftTip = craftTip;
    }

    //Constructor with Tool tip
    public GlassBlocks(String name, String toolTip) {
        super(Material.glass);
        this.setHardness(0.5f);
        this.setLightLevel(1.0F);
        this.setStepSound(soundTypeGlass);
        this.setCreativeTab(CreativeTabLiLRichyMod.LR_Tab);
        this.setUnlocalizedName(name);
        this.blockToolTip = toolTip;
        this.blockCraftTip = null;
    }

    //Constructor with no tool tips
    public GlassBlocks(String name) {
        super(Material.glass);
        this.setHardness(0.5f);
        this.setLightLevel(1.0F);
        this.setStepSound(soundTypeGlass);
        this.setCreativeTab(CreativeTabLiLRichyMod.LR_Tab);
        this.setUnlocalizedName(name);
        this.blockToolTip = null;
        this.blockCraftTip = null;
    }

    public static String getToolTip(Block block) {
        if (block instanceof GlassBlocks) {
            GlassBlocks n = (GlassBlocks) block;
            return n.blockToolTip;
        } else return null;
    }

    public static Object getCraftTip(Block block) {
        if (block instanceof GlassBlocks) {
            GlassBlocks n = (GlassBlocks) block;
            return n.blockCraftTip;
        } else return null;
    }

 /*   @Override
    public int getRenderBlockPass() {
        return 1;
    }*/

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

  /*  public boolean shouldSideBeRendered1(IBlockAccess blockAccess, int x, int y, int z, int side) {
        BlockPos pos = new BlockPos(x,y,z);
        Block block = blockAccess.getBlockState(pos).getBlock();

        return block == this ? false : super.shouldSideBeRendered(blockAccess,pos,side);
    }*/

    @Override
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return super.shouldSideBeRendered(worldIn, pos, side);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", "glass/" + getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

   /* @Override
    @SideOnly(Side.CLIENT)

    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }*/
}
