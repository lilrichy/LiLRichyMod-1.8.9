package com.blogspot.richardreigens.lilrichymod.init;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by Rich on 12/2/2015.
 */
public class WorldGenLiLRichy implements IWorldGenerator {
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        switch (world.provider.getDimensionId()) {
            case 0:
              //  generateSurface(world, x, z, random);
                break;
            case -1:
                generateNether(world, x, z, random);
                break;
            case 1:
                generateEnd(world, x, z, random);
                break;
            default:
               // generateSurface(world, x, z, random);
        }
    }

    private void generateEnd(World world, int x, int z, Random random) {
    }

    private void generateNether(World world, int x, int z, Random random) {
    }

   /* private void generateSurface(World world, int x, int z, Random random) {
        if (random.nextInt(3) == 1) {
            int randX = x + random.nextInt(16);
            int randZ = z + random.nextInt(16);
            int randY = world.getActualHeight();
            BlockPos pos = new BlockPos(randX,randY,randZ);
            if (world.isAirBlock(pos) && ModBlocks.beardedAzalea.canBlockStay(world, randX, randY, randZ))
                world.setBlockState(pos, ModBlocks.beardedAzalea.getDefaultState());
        }
    }*/
}