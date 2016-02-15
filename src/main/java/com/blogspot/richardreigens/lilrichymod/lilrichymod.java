package com.blogspot.richardreigens.lilrichymod;

import com.blogspot.richardreigens.lilrichymod.handler.ConfigurationHandler;
import com.blogspot.richardreigens.lilrichymod.handler.GuiHandler;
import com.blogspot.richardreigens.lilrichymod.handler.PacketDescriptionHandler;
import com.blogspot.richardreigens.lilrichymod.handler.network.NetworkHandler;
import com.blogspot.richardreigens.lilrichymod.init.DecorativeBlockInit;
import com.blogspot.richardreigens.lilrichymod.proxy.CommonProxy;
import com.blogspot.richardreigens.lilrichymod.reference.Reference;
import com.blogspot.richardreigens.lilrichymod.utility.LogHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
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
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        LogHelper.info("LILRICHY MOD IS BOOTING UP!!!!!!!!!");

        //  ModItems.init();
        LogHelper.info("Items Loading");

        // ModBlocks.init();
        // ModBlocksGlass.init();

        DecorativeBlockInit.init();
        DecorativeBlockInit.register();
        proxy.registerRenderers();
        LogHelper.info("Blocks Loading");

        //  ModTileEntity.Init();
        LogHelper.info("Tile Entity's Loading");

        PacketDescriptionHandler.init();
        LogHelper.info("Packet Description Handler Loading");

        //GameRegistry.registerWorldGenerator(new WorldGenLiLRichy(), 0);
        //LogHelper.info("World Gen Loading");

        NetworkHandler.init();

        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        LogHelper.info("GUI Handler Loading");


        LogHelper.info("Pre Initialization Complete");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
       // proxy.registerRenderers();
       // Recipes.init();
        LogHelper.info("Recipes Loading");
        LogHelper.info("Initialization Complete");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info("Post Initialization Complete");
        LogHelper.info("LiLRichy Mod Loaded!");
    }
}