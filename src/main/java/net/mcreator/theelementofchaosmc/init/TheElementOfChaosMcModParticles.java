/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theelementofchaosmc.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.theelementofchaosmc.client.particle.FireLaserParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheElementOfChaosMcModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(TheElementOfChaosMcModParticleTypes.FIRE_LASER.get(), FireLaserParticle::provider);
	}
}