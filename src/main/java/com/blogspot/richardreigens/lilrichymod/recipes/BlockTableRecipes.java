package com.blogspot.richardreigens.lilrichymod.recipes;

import com.blogspot.richardreigens.lilrichymod.init.DecoBlocks;
import com.blogspot.richardreigens.lilrichymod.init.ModItems;
import com.blogspot.richardreigens.lilrichymod.reference.Names;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Rich on 12/10/2015.
 */

//Todo Switch to varianents = block states
public class BlockTableRecipes {
    private static final BlockTableRecipes recipes = new BlockTableRecipes();
    private HashMap<List<Integer>, ItemStack> result = new HashMap<List<Integer>, ItemStack>();

    public BlockTableRecipes() {
        /**
         * Recipe Lists: (output, slot 1 input, slot 2 input) this is the Main recipes for the Block table
         *Ore Dictionary Recipes - Allow blocks to convert between similar types.
         */
        this.addRecipe(new ItemStack(DecoBlocks.deco_concrete), new ItemStack(DecoBlocks.concrete_block), new ItemStack(ModItems.crushedConcrete));
        for (ItemStack aConcrete : OreDictionary.getOres(Names.OreDicNames.CONCRETE))
            this.addRecipe(new ItemStack(DecoBlocks.deco_concrete), new ItemStack(aConcrete.getItem()), new ItemStack(ModItems.crushedConcrete));


      /**Need to update the Recipies for the following blocks when they are added back to mod*/
        /*
        this.addRecipe(metalsList, new ItemStack(ModBlocks.concrete), new ItemStack(Items.iron_ingot));
        this.addRecipe(marbleList, new ItemStack(ModBlocks.concrete), new ItemStack(Blocks.sandstone));
        this.addRecipe(lavaList, new ItemStack(ModBlocks.concrete), new ItemStack(Blocks.netherrack));
        this.addRecipe(stoneList, new ItemStack(ModBlocks.concrete), new ItemStack(Blocks.stone));
        this.addRecipe(lavaBowlListColor, new ItemStack(ModBlocks.lavaBowl), new ItemStack(ModItems.essanceOfBeared));
        this.addRecipe(metalRobotListColor, new ItemStack(ModBlocks.metalBatteredRobot), new ItemStack(ModItems.essanceOfBeared));

        for (ItemStack aPlanks : OreDictionary.getOres("plankWood"))
            this.addRecipe(cottageList, new ItemStack(ModBlocks.concrete), new ItemStack(aPlanks.getItem()));


        for (ItemStack aMetal : OreDictionary.getOres(Names.OreDicNames.METAL))
            this.addRecipe(metalsList, new ItemStack(aMetal.getItem()), new ItemStack(Items.iron_ingot));
        for (ItemStack aMarble : OreDictionary.getOres(Names.OreDicNames.MARBLE))
            this.addRecipe(marbleList, new ItemStack(aMarble.getItem()), new ItemStack(Blocks.sandstone));
        for (ItemStack aLava : OreDictionary.getOres(Names.OreDicNames.LAVA))
            this.addRecipe(lavaList, new ItemStack(aLava.getItem()), new ItemStack(Blocks.netherrack));
        for (ItemStack aStone : OreDictionary.getOres(Names.OreDicNames.STONE))
            this.addRecipe(stoneList, new ItemStack(aStone.getItem()), new ItemStack(Blocks.stone));
        for (ItemStack aLavaBowl : OreDictionary.getOres(Names.OreDicNames.LAVA_BOWL))
            this.addRecipe(lavaBowlListColor, new ItemStack(aLavaBowl.getItem()), new ItemStack(ModItems.essanceOfBeared));
        for (ItemStack aMetalRobot : OreDictionary.getOres(Names.OreDicNames.METAL_ROBOT))
            this.addRecipe(metalRobotListColor, new ItemStack(aMetalRobot.getItem()), new ItemStack(ModItems.essanceOfBeared));
        for (ItemStack aMinerals : OreDictionary.getOres(Names.OreDicNames.STONE_MINERALS))
            this.addRecipe(stoneMineralsListColors, new ItemStack(aMinerals.getItem()), new ItemStack(ModItems.essanceOfBeared));
        for (ItemStack aGlass : OreDictionary.getOres("blockGlass"))
            this.addRecipe(glassList, new ItemStack(aGlass.getItem()), new ItemStack(ModItems.essanceOfBeared));

        for (ItemStack aCottage : OreDictionary.getOres(Names.OreDicNames.COTTAGE)) {
            for (ItemStack aPlanks : OreDictionary.getOres("plankWood"))
                this.addRecipe(cottageList, new ItemStack(aCottage.getItem()), new ItemStack(aPlanks.getItem()));
        }*/
    }


    /**
     *  This is used to check if the block can be placed in the first slot.
     * @param stack the block trying to be placed into the slot
     * @return True if the block matches and can be placed in the slot
     */
    public static boolean isCraftableBlock(ItemStack stack) {
        //Check if valid block
        if (stack != null) {
            if (stack.isItemEqual(new ItemStack(DecoBlocks.concrete_block))) return true;

            //Ore Dictionary usage
            for (ItemStack iStack : OreDictionary.getOres("blockGlass"))
                if (iStack.isItemEqual(stack)) return true;
            for (ItemStack iStack : OreDictionary.getOres(Names.OreDicNames.STONE))
                if (iStack.isItemEqual(stack)) return true;
            for (ItemStack iStack : OreDictionary.getOres(Names.OreDicNames.STONE_MINERALS))
                if (iStack.isItemEqual(stack)) return true;
            for (ItemStack iStack : OreDictionary.getOres(Names.OreDicNames.CONCRETE))
                if (iStack.isItemEqual(stack)) return true;
            for (ItemStack iStack : OreDictionary.getOres(Names.OreDicNames.METAL))
                if (iStack.isItemEqual(stack)) return true;
            for (ItemStack iStack : OreDictionary.getOres(Names.OreDicNames.MARBLE))
                if (iStack.isItemEqual(stack)) return true;
            for (ItemStack iStack : OreDictionary.getOres(Names.OreDicNames.COTTAGE))
                if (iStack.isItemEqual(stack)) return true;
            for (ItemStack iStack : OreDictionary.getOres(Names.OreDicNames.LAVA))
                if (iStack.isItemEqual(stack)) return true;
            for (ItemStack iStack : OreDictionary.getOres(Names.OreDicNames.LAVA_BOWL))
                if (iStack.isItemEqual(stack)) return true;
            for (ItemStack iStack : OreDictionary.getOres(Names.OreDicNames.METAL_ROBOT))
                if (iStack.isItemEqual(stack)) return true;
        }
        return false;
    }

    /**
     * Checks if a block can be placed into the 2nd slot
     * @param stack the block trying to be placed into the slot
     * @return True if the block matches and can be placed in the slot
     */
    public static boolean isMaterial(ItemStack stack) {
        //Lists of Materials that can be used in the 2nd Slot of the Block Table
        ItemStack[] materialList = {new ItemStack(ModItems.crushedConcrete), new ItemStack(Items.iron_ingot),
                new ItemStack(Blocks.sandstone), new ItemStack(Blocks.netherrack),
                new ItemStack(Blocks.stone)};
        //Todo, new ItemStack(ModItems.essanceOfBeared)};

        for (ItemStack aMatsList : materialList) if (stack.isItemEqual(aMatsList)) return true;

        for (ItemStack aPlanks : OreDictionary.getOres("plankWood"))
            if (stack.getItem() == aPlanks.getItem()) return true;

        return false;
    }

    public static final BlockTableRecipes recipes() {
        return recipes;
    }

    public void addRecipe(ItemStack output, ItemStack... inputs) {
        List<Integer> inputData = new ArrayList<Integer>();
        for (ItemStack stack : inputs) {
            inputData.add(stack.getItem().getIdFromItem(stack.getItem()));
        }
        result.put(inputData, output);
    }

    public ItemStack getCraftingResult(ItemStack... inputs) {
        List<Integer> inputData = new ArrayList<Integer>();
        for (ItemStack stack : inputs) {
            inputData.add(stack.getItem().getIdFromItem(stack.getItem()));
        }
        return result.get(inputData);
    }
}