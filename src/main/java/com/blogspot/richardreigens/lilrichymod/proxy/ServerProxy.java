package com.blogspot.richardreigens.lilrichymod.proxy;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Created by Rich on 11/19/2015.
 */
@SideOnly(Side.SERVER)
public class ServerProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
    }

    @Override
    public void preInit() {
    }

    @Override
    public void init() {
    }

    @Override
    public void postInit() {
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return null;
    }
}
