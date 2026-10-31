package net.mcreator.theelementofchaosmc.client.screens;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.theelementofchaosmc.procedures.IsElementFireProcedure;
import net.mcreator.theelementofchaosmc.procedures.IsElementAirProcedure;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class MagicUseOverlay {
	private static final ResourceLocation IMAGE_0 = new ResourceLocation("the_element_of_chaos_mc:textures/screens/textspace.png");
	private static final ResourceLocation IMAGE_1 = new ResourceLocation("the_element_of_chaos_mc:textures/screens/textspace.png");
	private static final ResourceLocation IMAGE_2 = new ResourceLocation("the_element_of_chaos_mc:textures/screens/textspace.png");
	private static final ResourceLocation SPRITE_0 = new ResourceLocation("the_element_of_chaos_mc:textures/screens/inventory.png");
	private static final ResourceLocation SPRITE_1 = new ResourceLocation("the_element_of_chaos_mc:textures/screens/inventory.png");
	private static final ResourceLocation SPRITE_2 = new ResourceLocation("the_element_of_chaos_mc:textures/screens/inventory.png");
	private static final ResourceLocation SPRITE_3 = new ResourceLocation("the_element_of_chaos_mc:textures/screens/fire_laser.png");
	private static final ResourceLocation SPRITE_4 = new ResourceLocation("the_element_of_chaos_mc:textures/screens/fire_rock.png");
	private static final ResourceLocation SPRITE_5 = new ResourceLocation("the_element_of_chaos_mc:textures/screens/fire_wall.png");
	private static final ResourceLocation SPRITE_6 = new ResourceLocation("the_element_of_chaos_mc:textures/screens/wind_blade.png");

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (true) {
			event.getGuiGraphics().blit(IMAGE_0, w - 43, h - 69, 0, 0, 8, 8, 8, 8);

			event.getGuiGraphics().blit(IMAGE_1, w - 43, h - 52, 0, 0, 8, 8, 8, 8);

			event.getGuiGraphics().blit(IMAGE_2, w - 43, h - 35, 0, 0, 8, 8, 8, 8);

			event.getGuiGraphics().blit(SPRITE_0, w - 34, h - 69, 0, 0, 16, 16, 16, 16);

			event.getGuiGraphics().blit(SPRITE_1, w - 34, h - 52, 0, 0, 16, 16, 16, 16);

			event.getGuiGraphics().blit(SPRITE_2, w - 34, h - 35, 0, 0, 16, 16, 16, 16);

			if (IsElementFireProcedure.execute(entity)) {
				event.getGuiGraphics().blit(SPRITE_3, w - 32, h - 33, 0, 0, 12, 12, 12, 12);
			}
			if (IsElementFireProcedure.execute(entity)) {
				event.getGuiGraphics().blit(SPRITE_4, w - 32, h - 67, 0, 0, 12, 12, 12, 12);
			}
			if (IsElementFireProcedure.execute(entity)) {
				event.getGuiGraphics().blit(SPRITE_5, w - 32, h - 50, 0, 0, 12, 12, 12, 12);
			}
			if (IsElementAirProcedure.execute(entity)) {
				event.getGuiGraphics().blit(SPRITE_6, w - 34, h - 69, 0, 0, 16, 16, 16, 16);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_element_of_chaos_mc.magic_use.label_x"), w - 42, h - 69, -16777216, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_element_of_chaos_mc.magic_use.label_z"), w - 42, h - 52, -16777216, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.the_element_of_chaos_mc.magic_use.label_c"), w - 42, h - 35, -16777216, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}