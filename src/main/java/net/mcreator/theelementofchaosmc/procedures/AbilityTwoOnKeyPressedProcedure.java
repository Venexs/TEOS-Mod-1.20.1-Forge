package net.mcreator.theelementofchaosmc.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

public class AbilityTwoOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double lx = 0;
		double ly = 0;
		double lz = 0;
		double i = 0;
		double dx = 0;
		double dz = 0;
		double xOffset = 0;
		double zOffset = 0;
		double rad = 0;
		double radius = 0;
		double rad_angle = 0;
		lx = x;
		ly = y;
		lz = z;
		i = 0;
		rad_angle = 0;
		radius = 3;
		{
			Entity _ent = entity;
			double _tx = x;
			double _ty = (y + 1);
			double _tz = z;
			_ent.teleportTo(_tx, _ty, _tz);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
		}
		for (int _i1 = 0; _i1 < 5; _i1++) {
			for (int _i2 = 0; _i2 < 36; _i2++) {
				world.setBlock(BlockPos.containing(Math.floor(x + 1), Math.floor(y + 0), Math.floor(z + 0)), Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 1), Math.floor(y + 0), Math.floor(z + 0)), Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 0), Math.floor(y + 0), Math.floor(z + 1)), Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 0), Math.floor(y + 0), Math.floor(z - 1)), Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 1), Math.floor(y + 0), Math.floor(z + 1)), Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 1), Math.floor(y + 0), Math.floor(z + 1)), Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 1), Math.floor(y + 0), Math.floor(z + 1)), Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 1), Math.floor(y + 0), Math.floor(z - 1)), Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 1), Math.floor(y + 0), Math.floor(z - 1)), Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 0), Math.floor(y + 0), Math.floor(z - 0)), Blocks.POLISHED_BLACKSTONE_BRICKS.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 3), Math.floor(y + i), Math.floor(z + 0)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 3), Math.floor(y + i), Math.floor(z + 0)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 0), Math.floor(y + i), Math.floor(z + 3)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 0), Math.floor(y + i), Math.floor(z - 3)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 2), Math.floor(y + i), Math.floor(z + 2)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 2), Math.floor(y + i), Math.floor(z - 2)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 2), Math.floor(y + i), Math.floor(z + 2)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 2), Math.floor(y + i), Math.floor(z - 2)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 1), Math.floor(y + i), Math.floor(z + 3)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 1), Math.floor(y + i), Math.floor(z + 3)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 1), Math.floor(y + i), Math.floor(z - 3)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 3), Math.floor(y + i), Math.floor(z + 1)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x + 3), Math.floor(y + i), Math.floor(z - 1)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 3), Math.floor(y + i), Math.floor(z + 1)), Blocks.LAVA.defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(Math.floor(x - 3), Math.floor(y + i), Math.floor(z - 1)), Blocks.LAVA.defaultBlockState(), 3);
			}
			i = i + 1;
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 220, 1));
		TheElementOfChaosMcMod.queueServerWork(200, () -> {
			FireWallRemoveProcedure.execute(world, x, y, z);
		});
	}
}