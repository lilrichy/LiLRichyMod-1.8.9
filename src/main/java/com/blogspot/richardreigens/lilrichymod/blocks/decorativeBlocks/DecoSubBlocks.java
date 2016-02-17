package com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks;

import com.blogspot.richardreigens.lilrichymod.creativeTab.CreativeTabLiLRichyMod;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by LiLRichy on 2/15/2016.
 */
public class DecoSubBlocks extends DecorativeBlocks implements IMetaBlockName {

    public static final PropertyEnum TYPE = PropertyEnum.create("type", EnumDecoType.class);

    /**
     * String[] with all types of the sub blocks - should match the names/textures/json files
     */
    public String[] types;


    public DecoSubBlocks(String name, Material material, String toolTip, String[] types) {
        super(name, material, toolTip);
        this.setHardness(2f);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(CreativeTabLiLRichyMod.LR_Tab);
        this.setUnlocalizedName(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumDecoType.DECOVAR0));
        this.types = types;
    }

    public DecoSubBlocks(String name, Material material, String toolTip, String toolTip2, String[] types) {
        super(name, material, toolTip, toolTip2);
        this.setHardness(2f);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(CreativeTabLiLRichyMod.LR_Tab);
        this.setUnlocalizedName(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumDecoType.DECOVAR0));
        this.types = types;
    }

    /**
     * Returns the Blockstate based on the Meta Data
     * Must be Accurate with getMetaFromState
     *
     * @param meta int to get the blockstate from.
     * @return This should be a if/switch with the Enum type.
     */
    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumDecoType type;
        switch (meta) {
            case 1:
                type = EnumDecoType.DECOVAR1;
                break;
            case 2:
                type = EnumDecoType.DECOVAR2;
                break;
            case 3:
                type = EnumDecoType.DECOVAR3;
                break;
            case 4:
                type = EnumDecoType.DECOVAR4;
                break;
            case 5:
                type = EnumDecoType.DECOVAR5;
                break;
            case 6:
                type = EnumDecoType.DECOVAR6;
                break;
            case 7:
                type = EnumDecoType.DECOVAR7;
                break;
            case 8:
                type = EnumDecoType.DECOVAR8;
                break;
            case 9:
                type = EnumDecoType.DECOVAR9;
                break;
            case 10:
                type = EnumDecoType.DECOVAR10;
                break;
            case 11:
                type = EnumDecoType.DECOVAR11;
                break;
            case 12:
                type = EnumDecoType.DECOVAR12;
                break;
            case 13:
                type = EnumDecoType.DECOVAR13;
                break;
            case 14:
                type = EnumDecoType.DECOVAR14;
                break;
            default: // 0 and undefined
                type = EnumDecoType.DECOVAR0;
        }
        return getDefaultState().withProperty(TYPE, type);
    }

    /**
     * Used to get the meta data from a block this must be
     * accurate with getStateFromMeta
     *
     * @param state the block state to get the meta value from
     * @return the Meta value based on the current state.
     */
    @Override
    public int getMetaFromState(IBlockState state) {
        EnumDecoType type = (EnumDecoType) state.getValue(TYPE);
        return type.getID();
    }

    /**
     * Creates the block states / sub blocks.
     *
     * @return
     */
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[]{TYPE});
    }

    /**
     * Override to make sure the block drops the correct meta block
     *
     * @param state the state the block is in
     * @return the meta data of the block state.
     */
    @Override
    public int damageDropped(IBlockState state) {
        EnumDecoType stateValue = (EnumDecoType) state.getValue(TYPE);
        int type = stateValue.getID();
        if (type != 0 && type < types.length)
            return type ;
        else
            return 0;
    }

    /**
     * Returns the types of blocks in a string should use types[] from variables in this class
     *
     * @param stack The stack to compare the meta from the types[]
     * @return
     */
    @Override
    public String getSpecialName(ItemStack stack) {
        return types[stack.getItemDamage()];
    }

    /**
     * Used to get the subBlocks of the main block
     * For loop of the types returning a itemstack with meta from the int of the loop.
     *
     * @param itemIn The Item to get the sub blocks from - I think this should be a block or an item but that;s just me.
     * @param tab    Can be null.
     * @param list   is a Itemstack list with the sub blocks
     */
    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        for (int i = 0; i < types.length; i++) {
            list.add(new ItemStack(itemIn, 1, i));
        }
    }

    /**
     * Used to pick the items when in creative mode.
     * Override this to make The block pick the correct block based on meta data.
     */
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
    }
}