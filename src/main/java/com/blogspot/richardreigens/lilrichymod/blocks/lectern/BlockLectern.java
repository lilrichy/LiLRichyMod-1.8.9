package com.blogspot.richardreigens.lilrichymod.blocks.lectern;

import com.blogspot.richardreigens.lilrichymod.creativeTab.CreativeTabLiLRichyMod;
import com.blogspot.richardreigens.lilrichymod.reference.Names;
import com.blogspot.richardreigens.lilrichymod.reference.Reference;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by LiLRichy on 1/26/2016.
 */
public class BlockLectern extends BlockContainer {
//Todo Item Model, Book Renderer, On right click not working
    public BlockLectern() {
        super(Material.wood);
        setHardness(2.0f);
        setResistance(2.0f);
        this.setCreativeTab(CreativeTabLiLRichyMod.LR_Tab);
        //  this.setBlockTextureName(Reference.MOD_ID + ":" + Names.Models.BLOCK_TABLE);
        this.setUnlocalizedName(Names.Models.LECTERN);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityLectern();
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
/*

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
*/

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);

        TileEntityLectern te = getTileEntity(worldIn, pos.getX(), pos.getY(), pos.getZ());
        if (te == null) {
            return true;
        }

        if (te.hasStack()) {
            if (playerIn.isSneaking()) {
                if (!worldIn.isRemote) {
                    float f = worldIn.rand.nextFloat() * 0.8F + 0.1F;
                    float f1 = worldIn.rand.nextFloat() * 0.8F + 0.1F;
                    float f2 = worldIn.rand.nextFloat() * 0.8F + 0.1F;
                    ItemStack newItem = new ItemStack(te.getStack().getItem(), 1, te.getStack().getItemDamage());
                    if (te.getStack().getTagCompound() != null)
                        newItem.setTagCompound((NBTTagCompound) te.getStack().getTagCompound().copy());
                    EntityItem entityitem = new EntityItem(worldIn, pos.getX() + f, pos.getY() + f1, pos.getZ() + f2, newItem);
                    float f3 = 0.05F;
                    entityitem.motionX = (float) worldIn.rand.nextGaussian() * f3;
                    entityitem.motionY = (float) worldIn.rand.nextGaussian() * f3 + 0.2F;
                    entityitem.motionZ = (float) worldIn.rand.nextGaussian() * f3;
                    worldIn.spawnEntityInWorld(entityitem);
                }
                te.setStack(null);
            } else {
                //Open Book
                te.getStack().getItem().onItemRightClick(te.getStack(), worldIn, playerIn);
            }
        } else {
            if (playerIn.getCurrentEquippedItem() != null) {
                if (te.setStack(playerIn.getCurrentEquippedItem())) {
                    playerIn.getCurrentEquippedItem().stackSize--;
                    if (playerIn.getCurrentEquippedItem().stackSize <= 0) {
                        playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, null);
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {

        TileEntityLectern te = getTileEntity(worldIn, pos.getX(), pos.getY(), pos.getZ());
        if (te == null) return;

        if (!worldIn.isRemote) {
            if (te.hasStack()) {
                float f = worldIn.rand.nextFloat() * 0.8F + 0.1F;
                float f1 = worldIn.rand.nextFloat() * 0.8F + 0.1F;
                float f2 = worldIn.rand.nextFloat() * 0.8F + 0.1F;
                ItemStack newItem = new ItemStack(te.getStack().getItem(), 1, te.getStack().getItemDamage());
                if (te.getStack().getTagCompound() != null)
                    newItem.setTagCompound((NBTTagCompound) te.getStack().getTagCompound().copy());
                EntityItem entityitem = new EntityItem(worldIn, pos.getX() + f, pos.getY() + f1, pos.getZ() + f2, newItem);
                float f3 = 0.05F;
                entityitem.motionX = (float) worldIn.rand.nextGaussian() * f3;
                entityitem.motionY = (float) worldIn.rand.nextGaussian() * f3 + 0.2F;
                entityitem.motionZ = (float) worldIn.rand.nextGaussian() * f3;
                worldIn.spawnEntityInWorld(entityitem);
            }
        }
        super.breakBlock(worldIn, pos, state);
    }

    private TileEntityLectern getTileEntity(World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x,y,z);
        TileEntity te = world.getTileEntity(pos);
        if (te != null && te instanceof TileEntityLectern) {
            return (TileEntityLectern) te;
        }
        return null;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        int p = MathHelper.floor_double((placer.rotationYaw * 4F) / 360F + 0.5D) & 3;
        byte byte0 = 3;

        if (p == 0) byte0 = 4;
        if (p == 1) byte0 = 3;
        if (p == 2) byte0 = 2;
        if (p == 3) byte0 = 1;

        worldIn.setBlockState(pos,state,byte0);
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }
}
