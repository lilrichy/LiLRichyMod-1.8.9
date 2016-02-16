package com.blogspot.richardreigens.lilrichymod.init;

import com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks.BlockConcrete;
import com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks.DecoConcrete;
import com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks.ItemBlockMeta;
import com.blogspot.richardreigens.lilrichymod.reference.Names;
import com.blogspot.richardreigens.lilrichymod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

/**
 * Created by LiLRichy on 2/15/2016.
 */
public class DecoBlocks {

    public static Block concrete_block = new BlockConcrete(Names.Blocks.CONCRETE, Material.rock);

    public static Block deco_concrete = new DecoConcrete("DecoConcrete", Material.rock,
            Reference.MADE_BY + Reference.LILRICHY, Reference.CRAFT_WITH + Reference.CONCRETE_BLOCKS);

    /**
     * Initial Registry
     * Register the blocks to the game and to ore dictionary
     * if block has sub blocks then use registerOreDicMeta toregister to Ore Dictionary
     */
    public static void register() {
        GameRegistry.registerBlock(concrete_block, concrete_block.getUnlocalizedName().substring(5));
        OreDictionary.registerOre(Names.OreDicNames.CONCRETE, concrete_block);

        GameRegistry.registerBlock(deco_concrete, ItemBlockMeta.class, "DecoConcrete");
        registerOreDicMeta(deco_concrete, Names.OreDicNames.CONCRETE);
    }

    /**
     * Register the block to be rendered as an item.
     */
    public static void registerRenders() {
        //Single Blocks
        registerRender(concrete_block);

        //Blocks with Sub Blocks
        for (int i = 0; i < DecoConcrete.types.length; i++) registerRender(deco_concrete, i);
    }

    /**
     *  -------------------------------------------Do Not Change Below-----------------------------------------------
     */

    /**
     * Register the Item Renderer for a normal Block
     *
     * @param block The block to render as an Item.
     */
    public static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(
                Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5)));
    }

    /**
     * Register a Block with meta Data / Sub Blocks to be rendered as an Item
     * This uses "type=decovar" in the .json files this can be changed to anything as
     * long as it matches the sub block values and the json files.
     *
     * @param block The block to render as an item.
     * @param meta  The meta value of the block.
     */
    public static void registerRender(Block block, int meta) {
        Item item = Item.getItemFromBlock(block);
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(
                Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "type=decovar" + meta));
    }

    /**
     * Register a block's Sub blocks to the Ore Dictionary
     *
     * @param block The Main Block that has the sub types.
     * @param name  The string of the Ore Dictionary Value.
     */
    public static void registerOreDicMeta(Block block, String name) {

        Item item = Item.getItemFromBlock(block);
        ArrayList<ItemStack> list = new ArrayList<ItemStack>();
        block.getSubBlocks(item, null, list);

        for (ItemStack aList : list) OreDictionary.registerOre(name, aList);
    }
}
