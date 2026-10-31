package net.mcreator.theelementofchaosmc.enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.mcreator.theelementofchaosmc.init.TheElementOfChaosMcModItems;

public class MagicBlockEnchantment extends Enchantment {
	private static final EnchantmentCategory ENCHANTMENT_CATEGORY = EnchantmentCategory.create("the_element_of_chaos_mc_magic_block", item -> Ingredient.of(new ItemStack(TheElementOfChaosMcModItems.OBSIDIAN_SWORD.get())).test(new ItemStack(item)));

	public MagicBlockEnchantment() {
		this(EquipmentSlot.values());
	}

	private MagicBlockEnchantment(EquipmentSlot... slots) {
		super(Enchantment.Rarity.UNCOMMON, ENCHANTMENT_CATEGORY, slots);
	}

	@Override
	public int getMinCost(int level) {
		return 1 + level * 10;
	}

	@Override
	public int getMaxCost(int level) {
		return 6 + level * 10;
	}
}