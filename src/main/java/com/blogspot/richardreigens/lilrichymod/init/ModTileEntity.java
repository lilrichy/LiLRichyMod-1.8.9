package com.blogspot.richardreigens.lilrichymod.init;

import com.blogspot.richardreigens.lilrichymod.blocks.advancedPlayerDetector.BlockAdvancedDetector;
import com.blogspot.richardreigens.lilrichymod.blocks.blockTable.BlockTable;
import com.blogspot.richardreigens.lilrichymod.blocks.blockTable.TileEntityBlockTable;
import com.blogspot.richardreigens.lilrichymod.blocks.lectern.BlockLectern;
import com.blogspot.richardreigens.lilrichymod.blocks.playerDetector.BlockPlayerDetector;
import com.blogspot.richardreigens.lilrichymod.reference.Names;
import com.blogspot.richardreigens.lilrichymod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Rich on 11/23/2015.
 */
public class ModTileEntity {

    public static final BlockPlayerDetector playerDetector = new BlockPlayerDetector(Material.anvil);
    public static final BlockAdvancedDetector advancedDetector = new BlockAdvancedDetector(Material.anvil);
    public static final BlockTable blockTable = new BlockTable(Material.rock);
    public static final BlockLectern lectern = new BlockLectern();

    public static void Init() {
       /* if (ConfigurationHandler.loadPlayerDetector) {
            GameRegistry.registerBlock(playerDetector, Names.Blocks.PLAYER_DETECTOR);
            GameRegistry.registerTileEntity(TEPlayerDetector.class, Names.TileEntities.PLAYER_DETECTOR);
        }

        if (ConfigurationHandler.loadAdvancedDetector) {
            GameRegistry.registerBlock(advancedDetector, Names.Blocks.ADVANCED_DETECTOR);
            GameRegistry.registerTileEntity(TileEntityAdvancedDetector.class, Names.TileEntities.ADVANCED_DETECTOR);
        }*/

      /*  GameRegistry.registerBlock(lectern, Names.Models.LECTERN);
        GameRegistry.registerTileEntity(TileEntityLectern.class, Names.Models.LECTERN);*/

        GameRegistry.registerBlock(blockTable, blockTable.getUnlocalizedName().substring(5));
        GameRegistry.registerTileEntity(TileEntityBlockTable.class, Names.Models.BLOCK_TABLE);
    }

    public static void registerRenders() {
        registerRender(blockTable);
    }

    public static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(
                Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5)));
    }
}