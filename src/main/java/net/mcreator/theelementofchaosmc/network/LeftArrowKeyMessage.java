package net.mcreator.theelementofchaosmc.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.network.FriendlyByteBuf;

import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public record LeftArrowKeyMessage(int type, int pressedms) {
	public LeftArrowKeyMessage(FriendlyByteBuf buffer) {
		this(buffer.readInt(), buffer.readInt());
	}

	public static void buffer(LeftArrowKeyMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(LeftArrowKeyMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
		});
		context.setPacketHandled(true);
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TheElementOfChaosMcMod.addNetworkMessage(LeftArrowKeyMessage.class, LeftArrowKeyMessage::buffer, LeftArrowKeyMessage::new, LeftArrowKeyMessage::handler);
	}
}