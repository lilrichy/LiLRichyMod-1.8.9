package com.blogspot.richardreigens.lilrichymod.blocks.blockTable;

import com.blogspot.richardreigens.lilrichymod.creativeTab.CreativeTabLiLRichyMod;
import com.blogspot.richardreigens.lilrichymod.handler.GuiHandler;
import com.blogspot.richardreigens.lilrichymod.lilrichymod;
import com.blogspot.richardreigens.lilrichymod.reference.Names;
import com.blogspot.richardreigens.lilrichymod.reference.Reference;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

/**
 * Created by Rich on 12/8/2015.
 */

//Todo Item model
public class BlockTable extends BlockContainer {
    public BlockTable(Material material) {
        super(material);
        this.setUnlocalizedName(Names.Models.BLOCK_TABLE);
        this.setCreativeTab(CreativeTabLiLRichyMod.LR_Tab);
    //    this.setBlockTextureName(Reference.MOD_ID + ":" + Names.Models.BLOCK_TABLE);
        this.setHardness(5f);
        this.setResistance(0.5f);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(lilrichymod.instance, GuiHandler.GuiIDs.BLOCK_TABLE.ordinal(), worldIn,pos.getX(),pos.getY(),pos.getZ());
        }
        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tileEntityBlockTable = worldIn.getTileEntity(pos);
        if (tileEntityBlockTable instanceof IInventory) {

            // For each slot in the inventory
            for (int i = TileEntityBlockTable.FIRST_INPUT_SLOT; i < TileEntityBlockTable.FIRST_INPUT_SLOT + 2; i++) {
                // If the slot is not empty
                if (((IInventory) tileEntityBlockTable).getStackInSlot(i) != null) {
                    // Create a new entity item with the item stack in the slot
                    EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                            ((IInventory) tileEntityBlockTable).getStackInSlot(i));

                    // Apply some random motion to the item
                    float multiplier = 0.1f;
                    float motionX = worldIn.rand.nextFloat() - 0.5f;
                    float motionY = worldIn.rand.nextFloat() - 0.5f;
                    float motionZ = worldIn.rand.nextFloat() - 0.5f;

                    item.motionX = motionX * multiplier;
                    item.motionY = motionY * multiplier;
                    item.motionZ = motionZ * multiplier;

                    // Spawn the item in the world
                    worldIn.spawnEntityInWorld(item);
                }
            }
        }
        super.breakBlock(worldIn, pos, state);
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

   /* @Override
    public boolean renderAsNormalBlock() {
        return false;
    }*/

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {

        int l = MathHelper.floor_double(placer.rotationYaw * 4F / 360F + 0.5D) & 3;
        TileEntityBlockTable te = (TileEntityBlockTable) worldIn.getTileEntity(pos);
        if (te != null) {
            te.direction = l;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        return new TileEntityBlockTable();
    }
}
