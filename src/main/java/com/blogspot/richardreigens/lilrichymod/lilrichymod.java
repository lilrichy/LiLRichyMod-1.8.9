package com.blogspot.richardreigens.lilrichymod;

import com.blogspot.richardreigens.lilrichymod.handler.ConfigurationHandler;
import com.blogspot.richardreigens.lilrichymod.handler.GuiHandler;
import com.blogspot.richardreigens.lilrichymod.handler.PacketDescriptionHandler;
import com.blogspot.richardreigens.lilrichymod.handler.network.NetworkHandler;
import com.blogspot.richardreigens.lilrichymod.init.DecoBlocks;
import com.blogspot.richardreigens.lilrichymod.init.ModItems;
import com.blogspot.richardreigens.lilrichymod.init.ModTileEntity;
import com.blogspot.richardreigens.lilrichymod.proxy.CommonProxy;
import com.blogspot.richardreigens.lilrichymod.recipes.Recipes;
import com.blogspot.richardreigens.lilrichymod.reference.Reference;
import com.blogspot.richardreigens.lilrichymod.utility.LogHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * Created by Rich on 11/18/2015.
 */

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class lilrichymod {
    @Mod.Instance(Reference.MOD_ID)
    public static lilrichymod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LogHelper.info("LILRICHY MOD IS BOOTING UP!!!!!!!!!");

        //Config File
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());

        //Mod Items
        LogHelper.info("Items Loading");
        ModItems.init();

        //Mod Blocks
        LogHelper.info("Blocks Loading");
        DecoBlocks.register();
        // ModBlocks.init();
        // ModBlocksGlass.init();

        //Mod Tile Entities
        ModTileEntity.Init();
        LogHelper.info("Tile Entity's Loading");

        //Network Handlers
        PacketDescriptionHandler.init();
        NetworkHandler.init();
        LogHelper.info("Handler Loading");

        //Gui
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        LogHelper.info("GUI Handler Loading");

        //Register Renderers for Items and Blocks
        proxy.registerRenderers();

        LogHelper.info("Pre Initialization Complete");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //Recipes - All recipes are loaded from Sub Classes of this file.
        Recipes.init();
        LogHelper.info("Recipes Loading");

        LogHelper.info("Initialization Complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info("Post Initialization Complete");

        LogHelper.info("LiLRichy Mod Loaded!");
    }
}