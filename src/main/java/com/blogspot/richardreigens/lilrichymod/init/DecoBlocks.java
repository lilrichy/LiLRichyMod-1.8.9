package com.blogspot.richardreigens.lilrichymod.init;

import com.blogspot.richardreigens.lilrichymod.blocks.crops.BeardedAzalea;
import com.blogspot.richardreigens.lilrichymod.blocks.crops.CropItemBlock;
import com.blogspot.richardreigens.lilrichymod.blocks.crops.LiLRichyCrop;
import com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks.BlockConcrete;
import com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks.DecoSubBlocks;
import com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks.GlassBlocks;
import com.blogspot.richardreigens.lilrichymod.blocks.decorativeBlocks.ItemBlockMeta;
import com.blogspot.richardreigens.lilrichymod.reference.DecoBlockVarStrings;
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
    //Crops
    public static final LiLRichyCrop beardedAzalea = new BeardedAzalea(Names.Crops.BEARDED_AZALEA);

    //Concrete
    public static Block concrete_block = new BlockConcrete(Names.Blocks.CONCRETE, Material.rock);

    public static Block deco_concrete = new DecoSubBlocks("DecoConcrete", Material.rock,
            Names.CraftingToolTips.CRAFT_WITH, Names.CraftingToolTips.CONCRETE_BLOCKS, DecoBlockVarStrings.concreteTypes, DecoBlockVarStrings.concreteTypes.length);
    //Cottage
    public static Block deco_cottage = new DecoSubBlocks("DecoCottage", Material.wood,
            Names.CraftingToolTips.CRAFT_WITH, Names.CraftingToolTips.COTTAGE_BLOCKS, DecoBlockVarStrings.cottageTypes, DecoBlockVarStrings.cottageTypes.length);

    //Lava
    public static Block deco_lava = new DecoSubBlocks("DecoLava", Material.rock,
            Names.CraftingToolTips.CRAFT_WITH, Names.CraftingToolTips.LAVA_BLOCKS, DecoBlockVarStrings.lavaTypes, DecoBlockVarStrings.lavaTypes.length);
    public static Block deco_lavaBowlColors = new DecoSubBlocks("DecoLavaBowlColors", Material.rock,
            Names.CraftingToolTips.CRAFT_WITH, Names.CraftingToolTips.LAVA_BOWL_COLORS, DecoBlockVarStrings.lavaBowlTypes, DecoBlockVarStrings.lavaBowlTypes.length);

    //Marble
    public static Block deco_marble = new DecoSubBlocks("DecoMarble", Material.rock,
            Names.CraftingToolTips.CRAFT_WITH, Names.CraftingToolTips.MARBLE_BLOCKS, DecoBlockVarStrings.marbleTypes, DecoBlockVarStrings.marbleTypes.length);

    //Metal
    public static Block deco_metal = new DecoSubBlocks("DecoMetal", Material.iron,
            Names.CraftingToolTips.CRAFT_WITH, Names.CraftingToolTips.METAL_BLOCKS, DecoBlockVarStrings.metalTypes, DecoBlockVarStrings.metalTypes.length);
    public static Block deco_metalRobotColors = new DecoSubBlocks("DecoMetalRobotColors", Material.iron,
            Names.CraftingToolTips.CRAFT_WITH, Names.CraftingToolTips.METAL_ROBOT_COLORS, DecoBlockVarStrings.metalRobotTypes, DecoBlockVarStrings.metalRobotTypes.length);

    //Stone
    public static Block deco_stone = new DecoSubBlocks("DecoStone", Material.rock,
            Names.CraftingToolTips.CRAFT_WITH, Names.CraftingToolTips.STONE_BLOCKS, DecoBlockVarStrings.stoneTypes, DecoBlockVarStrings.stoneTypes.length);
    public static Block deco_stoneMineralsColors = new DecoSubBlocks("DecoStoneMineralsColors", Material.rock,
            Names.CraftingToolTips.CRAFT_WITH, Names.CraftingToolTips.STONE_MINERALS_COLORS_CRAFT, DecoBlockVarStrings.stoneMineralsTypes, DecoBlockVarStrings.stoneMineralsTypes.length);

    //Glass
    public static Block deco_ClearGlass = new GlassBlocks("DecoClearGlass", Material.glass,
            Names.CraftingToolTips.CRAFT_WITH, Names.CraftingToolTips.GLASS_CLEAR, DecoBlockVarStrings.clearGlassTypes, DecoBlockVarStrings.clearGlassTypes.length);

    /**
     * Initial Registry
     * Register the blocks to the game and to ore dictionary
     * if block has sub blocks then use registerOreDicMeta toregister to Ore Dictionary
     * Decorative blocks should also register Ore Dictionary - SmeltToConcrete to allow them to be
     * smelted back into concrete blocks.
     * Color Versions of Blocks should also Ore Dictionary there main version.
     */
    public static void register() {
        //Crops
        GameRegistry.registerBlock(beardedAzalea, CropItemBlock.class, beardedAzalea.getUnlocalizedName().substring(5));

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
        GameRegistry.registerBlock(deco_lavaBowlColors, ItemBlockMeta.class, "DecoLavaBowlColors");
        registerOreDicMeta(deco_lavaBowlColors, Names.OreDicNames.LAVA_BOWL);
        registerOreDicMeta(deco_lavaBowlColors, Names.OreDicNames.LAVA);
        registerOreDicMeta(deco_lavaBowlColors, Names.OreDicNames.SMELT_TO_CONCRETE);

        //Marble
        GameRegistry.registerBlock(deco_marble, ItemBlockMeta.class, "DecoMarble");
        registerOreDicMeta(deco_marble, Names.OreDicNames.MARBLE);
        registerOreDicMeta(deco_marble, Names.OreDicNames.SMELT_TO_CONCRETE);

        //Metal
        GameRegistry.registerBlock(deco_metal, ItemBlockMeta.class, "DecoMetal");
        registerOreDicMeta(deco_metal, Names.OreDicNames.METAL);
        registerOreDicMeta(deco_metal, Names.OreDicNames.SMELT_TO_CONCRETE);
        GameRegistry.registerBlock(deco_metalRobotColors, ItemBlockMeta.class, "DecoMetalRobotColors");
        registerOreDicMeta(deco_metalRobotColors, Names.OreDicNames.METAL_ROBOT);
        registerOreDicMeta(deco_metalRobotColors, Names.OreDicNames.METAL);
        registerOreDicMeta(deco_metalRobotColors, Names.OreDicNames.SMELT_TO_CONCRETE);

        //Stone
        GameRegistry.registerBlock(deco_stone, ItemBlockMeta.class, "DecoStone");
        registerOreDicMeta(deco_stone, Names.OreDicNames.STONE);
        registerOreDicMeta(deco_stone, Names.OreDicNames.SMELT_TO_CONCRETE);
        GameRegistry.registerBlock(deco_stoneMineralsColors, ItemBlockMeta.class, "DecoStoneMineralsColors");
        registerOreDicMeta(deco_stoneMineralsColors, Names.OreDicNames.STONE_MINERALS);
        registerOreDicMeta(deco_stoneMineralsColors, Names.OreDicNames.STONE);
        registerOreDicMeta(deco_stoneMineralsColors, Names.OreDicNames.SMELT_TO_CONCRETE);

        //Glass
        GameRegistry.registerBlock(deco_ClearGlass, ItemBlockMeta.class, "DecoClearGlass");
        registerOreDicMeta(deco_ClearGlass, Names.OreDicNames.GLASS_CLEAR);
        registerOreDicMeta(deco_ClearGlass, "blockGlass");
    }

    /**
     * Register the block to be rendered as an item.
     */
    public static void registerRenders() {

        //Crops
        registerRender(beardedAzalea);

        //Concrete
        registerRender(concrete_block);
        for (int i = 0; i < DecoBlockVarStrings.concreteTypes.length; i++) registerRender(deco_concrete, i);

        //Cottage
        for (int i = 0; i < DecoBlockVarStrings.cottageTypes.length; i++) registerRender(deco_cottage, i);

        //Lava
        for (int i = 0; i < DecoBlockVarStrings.lavaTypes.length; i++) registerRender(deco_lava, i);
        for (int i = 0; i < DecoBlockVarStrings.lavaBowlTypes.length; i++) registerRender(deco_lavaBowlColors, i);

        //Marble
        for (int i = 0; i < DecoBlockVarStrings.marbleTypes.length; i++) registerRender(deco_marble, i);

        //Metal
        for (int i = 0; i < DecoBlockVarStrings.metalTypes.length; i++) registerRender(deco_metal, i);
        for (int i = 0; i < DecoBlockVarStrings.metalRobotTypes.length; i++) registerRender(deco_metalRobotColors, i);

        //Stone
        for (int i = 0; i < DecoBlockVarStrings.stoneTypes.length; i++) registerRender(deco_stone, i);
        for (int i = 0; i < DecoBlockVarStrings.stoneMineralsTypes.length; i++)
            registerRender(deco_stoneMineralsColors, i);

        //Glass
        for (int i = 0; i < DecoBlockVarStrings.clearGlassTypes.length; i++) registerRender(deco_ClearGlass, i);
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
                Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "type="+meta));
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
