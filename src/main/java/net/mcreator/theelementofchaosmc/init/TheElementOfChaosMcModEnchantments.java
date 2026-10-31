/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theelementofchaosmc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.theelementofchaosmc.enchantment.MagicBlockEnchantment;
import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

public class TheElementOfChaosMcModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, TheElementOfChaosMcMod.MODID);
	public static final RegistryObject<Enchantment> MAGIC_BLOCK = REGISTRY.register("magic_block", MagicBlockEnchantment::new);
}