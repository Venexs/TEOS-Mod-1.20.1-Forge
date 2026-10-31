package net.mcreator.theelementofchaosmc.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.NonNullList;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.theelementofchaosmc.init.TheElementOfChaosMcModItems;

import java.util.List;

public class RedGemItemInInventoryTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 1) {
			if (hasEntityInInventory(entity, new ItemStack(TheElementOfChaosMcModItems.RED_GEM.get()))) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth(10);
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 2, false, false));
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60, 1, false, false));
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(TheElementOfChaosMcModItems.RED_GEM.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(TheElementOfChaosMcModItems.BROKEN_RED_GEM.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (world instanceof ServerLevel _level) {
					_level.getServer().getPlayerList().broadcastSystemMessage(Component.literal("The Demon in the Red Gem has been released and now... It has taken your body"), false);
				}
				if (entity instanceof ServerPlayer _player) {
					Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("the_element_of_chaos_mc:demon_kronos_inhabit"));
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player) {
			Inventory inventory = player.getInventory();
			List<NonNullList<ItemStack>> compartments = com.google.common.collect.ImmutableList.of(inventory.items, inventory.armor, inventory.offhand);
			for (List<ItemStack> list : compartments) {
				for (ItemStack itemstack2 : list) {
					if (!itemstack2.isEmpty() && ItemStack.isSameItem(itemstack2, itemstack)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}