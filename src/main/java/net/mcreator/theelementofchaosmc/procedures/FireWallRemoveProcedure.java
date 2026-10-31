package net.mcreator.theelementofchaosmc.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class FireWallRemoveProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double rad_angle = 0;
		double i = 0;
		double lx = 0;
		double radius = 0;
		double ly = 0;
		double lz = 0;
		lx = x;
		ly = y;
		lz = z;
		i = 0;
		rad_angle = 0;
		radius = 3;
		for (int _i1 = 0; _i1 < 5; _i1++) {
			for (int _i2 = 0; _i2 < 36; _i2++) {
				world.setBlock(BlockPos.containing(Math.floor(x + 3), Math.floor(y + i), Math.floor(z + 0)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 3), Math.floor(y + i), Math.floor(z + 0)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 0), Math.floor(y + i), Math.floor(z + 3)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 0), Math.floor(y + i), Math.floor(z - 3)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 2), Math.floor(y + i), Math.floor(z + 2)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 2), Math.floor(y + i), Math.floor(z - 2)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 2), Math.floor(y + i), Math.floor(z + 2)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 2), Math.floor(y + i), Math.floor(z - 2)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 1), Math.floor(y + i), Math.floor(z + 3)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 1), Math.floor(y + i), Math.floor(z + 3)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 1), Math.floor(y + i), Math.floor(z - 3)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 3), Math.floor(y + i), Math.floor(z + 1)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 3), Math.floor(y + i), Math.floor(z - 1)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 3), Math.floor(y + i), Math.floor(z + 1)), Blocks.AIR.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 3), Math.floor(y + i), Math.floor(z - 1)), Blocks.AIR.defaultBlockState(), 3);
			}
			i = i + 1;
		}
	}
}