package com.blogspot.richardreigens.lilrichymod.handler;

import com.blogspot.richardreigens.lilrichymod.lilrichymod;
import com.blogspot.richardreigens.lilrichymod.reference.Reference;
import com.blogspot.richardreigens.lilrichymod.tileEntity.TileEntityLiLRichyMod;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by Rich on 11/24/2015.
 */

@Sharable
public class PacketDescriptionHandler extends SimpleChannelInboundHandler<FMLProxyPacket> {
    public static final String CHANNEL = Reference.MOD_ID + "Dir";

    static {
        NetworkRegistry.INSTANCE.newChannel(CHANNEL, new PacketDescriptionHandler());
    }

    public static void init() {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception {
        ByteBuf buf = msg.payload();
        int x = buf.readInt();
        int y = buf.readInt();
        int z = buf.readInt();
        BlockPos pos = new BlockPos(x,y,z);
        TileEntity te = lilrichymod.proxy.getClientPlayer().worldObj.getTileEntity(pos);
        if (te instanceof TileEntityLiLRichyMod) {
            ((TileEntityLiLRichyMod) te).readFromPacket(buf);
        }
    }
}
