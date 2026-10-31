package net.mcreator.theelementofchaosmc.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.theelementofchaosmc.procedures.RedGemItemInInventoryTickProcedure;
import net.mcreator.theelementofchaosmc.procedures.RedGemItemInHandTickProcedure;

public class RedGemItem extends Item {
	public RedGemItem() {
		super(new Item.Properties());
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return true;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			RedGemItemInHandTickProcedure.execute(entity);
		RedGemItemInInventoryTickProcedure.execute(world, entity);
	}
}