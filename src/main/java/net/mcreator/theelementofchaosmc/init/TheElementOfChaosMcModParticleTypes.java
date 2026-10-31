/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theelementofchaosmc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

public class TheElementOfChaosMcModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TheElementOfChaosMcMod.MODID);
	public static final RegistryObject<SimpleParticleType> FIRE_LASER = REGISTRY.register("fire_laser", () -> new SimpleParticleType(true));
}