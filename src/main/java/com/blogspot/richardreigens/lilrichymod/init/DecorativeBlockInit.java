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
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by LiLRichy on 2/15/2016.
 */
public class DecorativeBlockInit {

    public static Block concrete_block;
    public static Block deco_concrete;

    public static void init() {
        concrete_block = new BlockConcrete(Names.Blocks.CONCRETE, Material.rock);

        deco_concrete = new DecoConcrete("DecoConcrete", Material.rock);
    }

    public static void register() {
        GameRegistry.registerBlock(concrete_block, concrete_block.getUnlocalizedName().substring(5));
        OreDictionary.registerOre(Names.OreDicNames.CONCRETE, concrete_block);

        GameRegistry.registerBlock(deco_concrete, ItemBlockMeta.class, "DecoConcrete");
    }

    public static void registerRenders() {
        registerRender(concrete_block, 0);

        for (int i = 0; i < DecoConcrete.types.length; i++) registerRender(deco_concrete, i);
    }

    public static void registerRender(Block block, int meta) {
        Item item = Item.getItemFromBlock(block);
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(
                Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "type=decovar" + meta));
    }
}
