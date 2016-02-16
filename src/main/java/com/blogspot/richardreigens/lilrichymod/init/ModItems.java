package com.blogspot.richardreigens.lilrichymod.init;

import com.blogspot.richardreigens.lilrichymod.items.ItemLiLRichyMod;
import com.blogspot.richardreigens.lilrichymod.reference.Names;
import com.blogspot.richardreigens.lilrichymod.reference.Reference;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Rich on 11/19/2015.
 */
// TODO: 2/16/2016 Add rest of items
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
   // public static final ItemLiLRichyMod deathSock = new ItemDeathSock(Names.Items.DEATH_SOCK);
    public static final ItemLiLRichyMod concreteMix = new ItemLiLRichyMod(Names.Items.CONCRETE_MIX);
    public static final ItemLiLRichyMod crushedConcrete = new ItemLiLRichyMod(Names.Items.CRUSHED_CONCRETE);
 //   public static final ItemSeeds seedBearedAzailia = new SeedBeardedAzalea(Names.Crops.BEARDED_AZALEA_SEED);
    public static final ItemLiLRichyMod essanceOfBeared = new ItemLiLRichyMod(Names.Items.ESSENCE_OF_BEARED);

    /**
     * Initial Registry
     */
    public static void init() {
       // GameRegistry.registerItem(deathSock, Names.Items.DEATH_SOCK);
        GameRegistry.registerItem(concreteMix, Names.Items.CONCRETE_MIX);
        GameRegistry.registerItem(crushedConcrete, Names.Items.CRUSHED_CONCRETE);
        //GameRegistry.registerItem(seedBearedAzailia, Names.Crops.BEARDED_AZALEA_SEED);
        GameRegistry.registerItem(essanceOfBeared, Names.Items.ESSENCE_OF_BEARED);
    }

    /**
     * Register the block to be rendered as an item.
     */
    public static void registerRenders() {
        registerItemRenderer(concreteMix);
        registerItemRenderer(crushedConcrete);
        registerItemRenderer(essanceOfBeared);
    }

    /**
     *  -------------------------------------------Do Not Change Below-----------------------------------------------
     */

    /**
     * Register the Item Renderer
     * @param item
     */
    public static void registerItemRenderer(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(
                Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5)));
    }

}