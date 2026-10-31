/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theelementofchaosmc.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.theelementofchaosmc.network.AbilityTwoMessage;
import net.mcreator.theelementofchaosmc.network.AbilityThreeMessage;
import net.mcreator.theelementofchaosmc.network.AbilityOneMessage;
import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TheElementOfChaosMcModKeyMappings {
	public static final KeyMapping LEFT_ARROW_KEY = new KeyMapping("key.the_element_of_chaos_mc.left_arrow_key", GLFW.GLFW_KEY_LEFT, "key.category.the_element_of_chaos_mc.gameplay");
	public static final KeyMapping ABILITY_ONE = new KeyMapping("key.the_element_of_chaos_mc.ability_one", GLFW.GLFW_KEY_X, "key.category.the_element_of_chaos_mc.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheElementOfChaosMcMod.PACKET_HANDLER.sendToServer(new AbilityOneMessage(0, 0));
				AbilityOneMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_TWO = new KeyMapping("key.the_element_of_chaos_mc.ability_two", GLFW.GLFW_KEY_Z, "key.category.the_element_of_chaos_mc.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheElementOfChaosMcMod.PACKET_HANDLER.sendToServer(new AbilityTwoMessage(0, 0));
				AbilityTwoMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping ABILITY_THREE = new KeyMapping("key.the_element_of_chaos_mc.ability_three", GLFW.GLFW_KEY_C, "key.category.the_element_of_chaos_mc.misc") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TheElementOfChaosMcMod.PACKET_HANDLER.sendToServer(new AbilityThreeMessage(0, 0));
				AbilityThreeMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(LEFT_ARROW_KEY);
		event.register(ABILITY_ONE);
		event.register(ABILITY_TWO);
		event.register(ABILITY_THREE);
	}

	@Mod.EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				ABILITY_ONE.consumeClick();
				ABILITY_TWO.consumeClick();
				ABILITY_THREE.consumeClick();
			}
		}
	}
}