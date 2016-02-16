package com.blogspot.richardreigens.lilrichymod.init;

import com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks.BlockConcrete;
import com.blogspot.richardreigens.lilrichymod.reference.DecoBlockVarStrings;
import com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks.DecoSubBlocks;
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

    //Concrete
    public static Block concrete_block = new BlockConcrete(Names.Blocks.CONCRETE, Material.rock);

    public static Block deco_concrete = new DecoSubBlocks("DecoConcrete", Material.rock,
            Reference.CRAFT_WITH + Reference.CONCRETE_BLOCKS, DecoBlockVarStrings.concreteTypes);
    //Cottage
    public static Block deco_cottage = new DecoSubBlocks("DecoCottage", Material.wood,
            Reference.CRAFT_WITH + Reference.COTTAGE_BLOCKS, DecoBlockVarStrings.cottageTypes);

    //Lava
    public static Block deco_lava = new DecoSubBlocks("DecoLava", Material.rock,
            Reference.CRAFT_WITH + Reference.LAVA_BLOCKS, DecoBlockVarStrings.lavaTypes);

    //Marble
    public static Block deco_marble = new DecoSubBlocks("DecoMarble", Material.rock,
            Reference.CRAFT_WITH + Reference.MARBLE_BLOCKS, DecoBlockVarStrings.marbleTypes);

    //Metal
    public static Block deco_metal = new DecoSubBlocks("DecoMetal", Material.iron,
            Reference.CRAFT_WITH + Reference.METAL_BLOCKS, DecoBlockVarStrings.metalTypes);

    //Stone
    public static Block deco_stone = new DecoSubBlocks("DecoStone", Material.rock,
            Reference.CRAFT_WITH + Reference.STONE_BLOCKS, DecoBlockVarStrings.stoneTypes);

    /**
     * Initial Registry
     * Register the blocks to the game and to ore dictionary
     * if block has sub blocks then use registerOreDicMeta toregister to Ore Dictionary
     * Decorative blocks should also register Ore Dictionary - SmeltToConcrete to allow them to be
     * smelted back into concrete blocks.
     * Color Versions of Blocks should also Ore Dictionary there main version.
     */
    public static void register() {

        //Concrete
        GameRegistry.registerBlock(concrete_block, concrete_block.getUnlocalizedName().substring(5));
        OreDictionary.registerOre(Names.OreDicNames.CONCRETE, concrete_block);

        GameRegistry.registerBlock(deco_concrete, ItemBlockMeta.class, "DecoConcrete");
        registerOreDicMeta(deco_concrete, Names.OreDicNames.CONCRETE);
        registerOreDicMeta(deco_concrete, Names.OreDicNames.SMELT_TO_CONCRETE);

        //Cottage
        GameRegistry.registerBlock(deco_cottage, ItemBlockMeta.class, "DecoCottage");
        registerOreDicMeta(deco_cottage, Names.OreDicNames.COTTAGE);
        registerOreDicMeta(deco_cottage, Names.OreDicNames.SMELT_TO_CONCRETE);

        //Lava
        GameRegistry.registerBlock(deco_lava, ItemBlockMeta.class, "DecoLava");
        registerOreDicMeta(deco_lava, Names.OreDicNames.LAVA);
        registerOreDicMeta(deco_lava, Names.OreDicNames.SMELT_TO_CONCRETE);

        //Marble
        GameRegistry.registerBlock(deco_marble, ItemBlockMeta.class, "DecoMarble");
        registerOreDicMeta(deco_marble, Names.OreDicNames.MARBLE);
        registerOreDicMeta(deco_marble, Names.OreDicNames.SMELT_TO_CONCRETE);

        //Metal
        GameRegistry.registerBlock(deco_metal, ItemBlockMeta.class, "DecoMetal");
        registerOreDicMeta(deco_metal, Names.OreDicNames.METAL);
        registerOreDicMeta(deco_metal, Names.OreDicNames.SMELT_TO_CONCRETE);

        //Stone
        GameRegistry.registerBlock(deco_stone, ItemBlockMeta.class, "DecoStone");
        registerOreDicMeta(deco_stone, Names.OreDicNames.STONE);
        registerOreDicMeta(deco_stone, Names.OreDicNames.SMELT_TO_CONCRETE);
    }

    /**
     * Register the block to be rendered as an item.
     */
    public static void registerRenders() {

        //Concrete
        registerRender(concrete_block);
        for (int i = 0; i < DecoBlockVarStrings.concreteTypes.length; i++) registerRender(deco_concrete, i);

        //Cottage


        //Lava


        //Marble


        //Metal
        for (int i = 0; i < DecoBlockVarStrings.metalTypes.length; i++) registerRender(deco_metal, i);

        //Stone

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
