package com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks;

import com.blogspot.richardreigens.lilrichymod.creativeTab.CreativeTabLiLRichyMod;
import net.minecraft.block.Block;
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
public class DecoConcrete extends Block implements IMetaBlockName {

    public static final PropertyEnum TYPE = PropertyEnum.create("type", EnumDecoType.class);
    public static String[] types = {"arrangedConcreteBricks", "concreteBricks", "concreteBricksDark", "concreteRocks", "concreteSquares",
            "concreteTexturedBlocks", "fancyConcreteBlocks", "oldConcreteSquares", "smallConcreteBricks", "smallConcreteTexturedSquares"};


    public DecoConcrete(String name, Material material) {
        super(material);
        this.setHardness(2f);
        this.setStepSound(soundTypeStone);
        this.setCreativeTab(CreativeTabLiLRichyMod.LR_Tab);
        this.setUnlocalizedName(name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumDecoType.DECOVAR0));
    }


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
            default: // 0 and undefined
                type = EnumDecoType.DECOVAR0;
        }
        return getDefaultState().withProperty(TYPE, type);
    }


    @Override
    public int getMetaFromState(IBlockState state) {
        EnumDecoType type = (EnumDecoType) state.getValue(TYPE);
        return type.getID();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[]{TYPE});
    }

    @Override
    public int damageDropped(IBlockState state) {
        EnumDecoType stateValue = (EnumDecoType) state.getValue(TYPE);
        int type = stateValue.getID();
        if (type != 0 && type < types.length)
            return type - 1;
        else
            return 0;
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return types[stack.getItemDamage()];

    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list) {
        for (int i = 0; i < types.length; i++) {
            list.add(new ItemStack(itemIn, 1, i));
        }
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
    }
}