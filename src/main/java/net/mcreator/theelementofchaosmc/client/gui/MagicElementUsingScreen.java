package net.mcreator.theelementofchaosmc.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.theelementofchaosmc.world.inventory.MagicElementUsingMenu;
import net.mcreator.theelementofchaosmc.procedures.WaterElementPickProcedure;
import net.mcreator.theelementofchaosmc.procedures.FireElementPickProcedure;
import net.mcreator.theelementofchaosmc.procedures.AirElementPickProcedure;
import net.mcreator.theelementofchaosmc.network.MagicElementUsingButtonMessage;
import net.mcreator.theelementofchaosmc.init.TheElementOfChaosMcModScreens;
import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class MagicElementUsingScreen extends AbstractContainerScreen<MagicElementUsingMenu> implements TheElementOfChaosMcModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_empty;
	private Button button_empty1;
	private Button button_confirm;
	private ImageButton imagebutton_outputonlinepngtools_2;
	private static final ResourceLocation BACKGROUND = new ResourceLocation("the_element_of_chaos_mc:textures/screens/magic_element_using.png");

	public MagicElementUsingScreen(MagicElementUsingMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 152;
		this.imageHeight = 175;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.the_element_of_chaos_mc.magic_element_using.label_select_your_magic_ability"), 10, 9, -16777216, false);
		if (FireElementPickProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.the_element_of_chaos_mc.magic_element_using.label_choose_the_element_of_fire_and_l"), 35, 91, -15856114, false);
		if (WaterElementPickProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.the_element_of_chaos_mc.magic_element_using.label_element_of_water"), 35, 91, -12829636, false);
		if (AirElementPickProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.the_element_of_chaos_mc.magic_element_using.label_element_of_air"), 39, 91, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.the_element_of_chaos_mc.magic_element_using.button_empty"), e -> {
			int x = MagicElementUsingScreen.this.x;
			int y = MagicElementUsingScreen.this.y;
			if (true) {
				TheElementOfChaosMcMod.PACKET_HANDLER.sendToServer(new MagicElementUsingButtonMessage(0, x, y, z));
				MagicElementUsingButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 116, this.topPos + 144, 30, 20).build();
		this.addRenderableWidget(button_empty);
		button_empty1 = Button.builder(Component.translatable("gui.the_element_of_chaos_mc.magic_element_using.button_empty1"), e -> {
			int x = MagicElementUsingScreen.this.x;
			int y = MagicElementUsingScreen.this.y;
			if (true) {
				TheElementOfChaosMcMod.PACKET_HANDLER.sendToServer(new MagicElementUsingButtonMessage(1, x, y, z));
				MagicElementUsingButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 144, 30, 20).build();
		this.addRenderableWidget(button_empty1);
		button_confirm = Button.builder(Component.translatable("gui.the_element_of_chaos_mc.magic_element_using.button_confirm"), e -> {
			int x = MagicElementUsingScreen.this.x;
			int y = MagicElementUsingScreen.this.y;
			if (true) {
				TheElementOfChaosMcMod.PACKET_HANDLER.sendToServer(new MagicElementUsingButtonMessage(2, x, y, z));
				MagicElementUsingButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 45, this.topPos + 144, 61, 20).build();
		this.addRenderableWidget(button_confirm);
		imagebutton_outputonlinepngtools_2 = new ImageButton(this.leftPos + -5, this.topPos + 2, 160, 160, 0, 0, 160, new ResourceLocation("the_element_of_chaos_mc:textures/screens/atlas/imagebutton_outputonlinepngtools_2.png"), 160, 320, e -> {
		});
		this.addRenderableWidget(imagebutton_outputonlinepngtools_2);
	}
}