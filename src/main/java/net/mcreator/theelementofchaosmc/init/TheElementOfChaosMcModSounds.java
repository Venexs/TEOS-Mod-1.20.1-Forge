/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theelementofchaosmc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

public class TheElementOfChaosMcModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TheElementOfChaosMcMod.MODID);
	public static final RegistryObject<SoundEvent> WIND_EXPLOSION = REGISTRY.register("wind_explosion", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_element_of_chaos_mc", "wind_explosion")));
	public static final RegistryObject<SoundEvent> WIND_SLICE = REGISTRY.register("wind_slice", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("the_element_of_chaos_mc", "wind_slice")));
}