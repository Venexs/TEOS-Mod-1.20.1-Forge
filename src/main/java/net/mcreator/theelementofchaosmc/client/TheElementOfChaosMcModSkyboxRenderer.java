package net.mcreator.theelementofchaosmc.client;

import org.joml.Matrix4f;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.*;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class TheElementOfChaosMcModSkyboxRenderer {
	private static final ResourceKey ELVEN_WORLD = ResourceKey.create(Registries.DIMENSION, new ResourceLocation("the_element_of_chaos_mc:elven_world"));
	private static final ResourceLocation ELVEN_WORLD_SUN = new ResourceLocation("the_element_of_chaos_mc:textures/whiteholesun.png");
	private static final ResourceLocation ELVEN_WORLD_MOON = new ResourceLocation("the_element_of_chaos_mc:textures/moon_phases.png");

	@SubscribeEvent
	public static void renderSky(RenderLevelStageEvent event) {
		Minecraft mc = Minecraft.getInstance();
		if (mc.player == null)
			return;
		if (event.getStage() != RenderLevelStageEvent.Stage.AFTER_SKY)
			return;
		if (mc.player.level().dimension() == ELVEN_WORLD) {
			renderCustomSun(event, mc.player.level(), ELVEN_WORLD_SUN);
			renderCustomMoon(event, mc.player.level(), ELVEN_WORLD_MOON);
		}
	}

	public static void renderCustomSun(RenderLevelStageEvent event, Level level, ResourceLocation texture) {
		PoseStack posestack = event.getPoseStack();
		posestack.pushPose();
		GlStateManager._enableBlend();
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager._depthMask(false);
		float partialTick = event.getPartialTick();
		float f11 = 1.0F - level.getRainLevel(partialTick);
		RenderSystem.setShaderColor(1, 1, 1, f11);
		posestack.mulPose(Axis.YP.rotationDegrees(-90.0F));
		posestack.mulPose(Axis.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F));
		Matrix4f matrix4f1 = posestack.last().pose();
		float f12 = 30.0F;
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, texture);
		BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
		bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
		bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
		BufferUploader.drawWithShader(bufferbuilder.end());
		RenderSystem.setShaderColor(1, 1, 1, 1);
		GlStateManager._disableBlend();
		RenderSystem.defaultBlendFunc();
		GlStateManager._depthMask(true);
		posestack.popPose();
	}

	public static void renderCustomMoon(RenderLevelStageEvent event, Level level, ResourceLocation texture) {
		PoseStack posestack = event.getPoseStack();
		posestack.pushPose();
		GlStateManager._enableBlend();
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager._depthMask(false);
		float partialTick = event.getPartialTick();
		float f11 = 1.0F - level.getRainLevel(partialTick);
		RenderSystem.setShaderColor(1, 1, 1, f11);
		posestack.mulPose(Axis.YP.rotationDegrees(-90.0F));
		posestack.mulPose(Axis.XP.rotationDegrees(level.getTimeOfDay(partialTick) * 360.0F));
		Matrix4f matrix4f1 = posestack.last().pose();
		float f12 = 20.0F;
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, texture);
		int k = level.getMoonPhase();
		int l = k % 4;
		int i1 = k / 4 % 2;
		float f13 = (float) (l) / 4.0F;
		float f14 = (float) (i1) / 2.0F;
		float f15 = (float) (l + 1) / 4.0F;
		float f16 = (float) (i1 + 1) / 2.0F;
		BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
		bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		bufferbuilder.vertex(matrix4f1, -f12, -100.0F, f12).uv(f15, f16).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, -100.0F, f12).uv(f13, f16).endVertex();
		bufferbuilder.vertex(matrix4f1, f12, -100.0F, -f12).uv(f13, f14).endVertex();
		bufferbuilder.vertex(matrix4f1, -f12, -100.0F, -f12).uv(f15, f14).endVertex();
		BufferUploader.drawWithShader(bufferbuilder.end());
		RenderSystem.setShaderColor(1, 1, 1, 1);
		GlStateManager._disableBlend();
		RenderSystem.defaultBlendFunc();
		GlStateManager._depthMask(true);
		posestack.popPose();
	}

	public static void renderCustomSkybox(RenderLevelStageEvent event, ResourceLocation texture) {
		PoseStack poseStack = event.getPoseStack();
		poseStack.pushPose();
		GlStateManager._enableBlend();
		RenderSystem.defaultBlendFunc();
		GlStateManager._depthMask(false);
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderTexture(0, texture);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		Tesselator tesselator = Tesselator.getInstance();
		float distance = 100.0F;
		float size = 100.0F;
		renderSkyboxQuad(poseStack, tesselator, -size, distance, -size, 1.0F / 4.0F, 1.0F / 3.0F, size, distance, -size, 2.0F / 4.0F, 1.0F / 3.0F, size, distance, size, 2.0F / 4.0F, 0.0F, -size, distance, size, 1.0F / 4.0F, 0.0F);
		renderSkyboxQuad(poseStack, tesselator, -size, -distance, -size, 1.0F / 4.0F, 2.0F / 3.0F, -size, -distance, size, 1.0F / 4.0F, 3.0F / 3.0F, size, -distance, size, 2.0F / 4.0F, 3.0F / 3.0F, size, -distance, -size, 2.0F / 4.0F, 2.0F / 3.0F);
		renderSkyboxQuad(poseStack, tesselator, -distance, -size, size, 0.0F, 2.0F / 3.0F, -distance, -size, -size, 1.0F / 4.0F, 2.0F / 3.0F, -distance, size, -size, 1.0F / 4.0F, 1.0F / 3.0F, -distance, size, size, 0.0F, 1.0F / 3.0F);
		renderSkyboxQuad(poseStack, tesselator, -size, -size, -distance, 1.0F / 4.0F, 2.0F / 3.0F, size, -size, -distance, 2.0F / 4.0F, 2.0F / 3.0F, size, size, -distance, 2.0F / 4.0F, 1.0F / 3.0F, -size, size, -distance, 1.0F / 4.0F, 1.0F / 3.0F);
		renderSkyboxQuad(poseStack, tesselator, distance, -size, -size, 2.0F / 4.0F, 2.0F / 3.0F, distance, -size, size, 3.0F / 4.0F, 2.0F / 3.0F, distance, size, size, 3.0F / 4.0F, 1.0F / 3.0F, distance, size, -size, 2.0F / 4.0F, 1.0F / 3.0F);
		renderSkyboxQuad(poseStack, tesselator, size, -size, distance, 3.0F / 4.0F, 2.0F / 3.0F, -size, -size, distance, 4.0F / 4.0F, 2.0F / 3.0F, -size, size, distance, 4.0F / 4.0F, 1.0F / 3.0F, size, size, distance, 3.0F / 4.0F, 1.0F / 3.0F);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		GlStateManager._depthMask(true);
		GlStateManager._disableBlend();
		poseStack.popPose();
	}

	private static void renderSkyboxQuad(PoseStack poseStack, Tesselator tesselator, float x1, float y1, float z1, float u1, float v1, float x2, float y2, float z2, float u2, float v2, float x3, float y3, float z3, float u3, float v3, float x4,
			float y4, float z4, float u4, float v4) {
		Matrix4f matrix = poseStack.last().pose();
		BufferBuilder buffer = tesselator.getBuilder();
		buffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		buffer.vertex(matrix, x1, y1, z1).uv(u1, v1).endVertex();
		buffer.vertex(matrix, x2, y2, z2).uv(u2, v2).endVertex();
		buffer.vertex(matrix, x3, y3, z3).uv(u3, v3).endVertex();
		buffer.vertex(matrix, x4, y4, z4).uv(u4, v4).endVertex();
		BufferUploader.drawWithShader(buffer.end());
	}
}