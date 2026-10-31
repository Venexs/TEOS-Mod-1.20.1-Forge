package net.mcreator.theelementofchaosmc.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.theelementofchaosmc.init.TheElementOfChaosMcModParticleTypes;

import java.util.Comparator;

public class AbilityThreeOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double x_offset = 0;
		double y_offset = 0;
		double z_offset = 0;
		x_offset = entity.getLookAngle().x;
		y_offset = entity.getLookAngle().y + 1.5;
		z_offset = entity.getLookAngle().z;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.PLAYERS, (float) 0.5, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.PLAYERS, (float) 0.5, 1, false);
			}
		}
		for (int _i1 = 0; _i1 < 20; _i1++) {
			x_offset = x_offset + entity.getLookAngle().x;
			y_offset = y_offset + entity.getLookAngle().y;
			z_offset = z_offset + entity.getLookAngle().z;
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TheElementOfChaosMcModParticleTypes.FIRE_LASER.get()), (x + x_offset), (y + y_offset), (z + z_offset), 1, 0, 0, 0, 0);
			{
				final Vec3 _center = new Vec3((x + x_offset), (y + y_offset), (z + z_offset));
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(0.75 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.ON_FIRE)), 6);
				}
			}
		}
	}
}