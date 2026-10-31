/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theelementofchaosmc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.theelementofchaosmc.entity.WindBladeEntity;
import net.mcreator.theelementofchaosmc.entity.FireRockEntity;
import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheElementOfChaosMcModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TheElementOfChaosMcMod.MODID);
	public static final RegistryObject<EntityType<FireRockEntity>> FIRE_ROCK = register("fire_rock",
			EntityType.Builder.<FireRockEntity>of(FireRockEntity::new, MobCategory.MISC).setCustomClientFactory(FireRockEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<WindBladeEntity>> WIND_BLADE = register("wind_blade",
			EntityType.Builder.<WindBladeEntity>of(WindBladeEntity::new, MobCategory.MISC).setCustomClientFactory(WindBladeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}
}