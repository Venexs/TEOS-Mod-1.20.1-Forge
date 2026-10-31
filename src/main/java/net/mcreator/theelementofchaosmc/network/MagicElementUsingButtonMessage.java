package net.mcreator.theelementofchaosmc.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.theelementofchaosmc.procedures.ElementPickerFrontProcedure;
import net.mcreator.theelementofchaosmc.procedures.ElementPickerBackProcedure;
import net.mcreator.theelementofchaosmc.procedures.ElementPickConfirmProcedure;
import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record MagicElementUsingButtonMessage(int buttonID, int x, int y, int z) {
	public MagicElementUsingButtonMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt());
	}

	public static void buffer(MagicElementUsingButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(MagicElementUsingButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> handleButtonAction(context.getSender(), message.buttonID, message.x, message.y, message.z));
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			ElementPickerFrontProcedure.execute(entity);
		}
		if (buttonID == 1) {

			ElementPickerBackProcedure.execute(entity);
		}
		if (buttonID == 2) {

			ElementPickConfirmProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TheElementOfChaosMcMod.addNetworkMessage(MagicElementUsingButtonMessage.class, MagicElementUsingButtonMessage::buffer, MagicElementUsingButtonMessage::new, MagicElementUsingButtonMessage::handler);
	}
}