/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theelementofchaosmc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.theelementofchaosmc.item.*;
import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

public class TheElementOfChaosMcModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, TheElementOfChaosMcMod.MODID);
	public static final RegistryObject<Item> RED_GEM;
	public static final RegistryObject<Item> SHAPENED_OBSIDIAN;
	public static final RegistryObject<Item> OBSIDIAN_SWORD;
	public static final RegistryObject<Item> ADVENTURERS_LEATHER_ARMOR_CHESTPLATE;
	public static final RegistryObject<Item> ADVENTURERS_LEATHER_ARMOR_BOOTS;
	public static final RegistryObject<Item> BROKEN_RED_GEM;
	public static final RegistryObject<Item> MANA_SOUL;
	public static final RegistryObject<Item> MANA_INFUSED_STONE;
	public static final RegistryObject<Item> ELEVEN_PORTAL;
	public static final RegistryObject<Item> ICESTAIRS;
	public static final RegistryObject<Item> ICEBRICKS;
	public static final RegistryObject<Item> ICEBRICKSSLABS;
	public static final RegistryObject<Item> POLISHED_ICE;
	public static final RegistryObject<Item> POLISHED_ICE_SLABS;
	public static final RegistryObject<Item> POLISHED_ICE_BRICKS;
	public static final RegistryObject<Item> ELVINA_WOOD;
	public static final RegistryObject<Item> STRIPPED_ELVINA_WOOD;
	public static final RegistryObject<Item> ELVINA_LEAVES;
	public static final RegistryObject<Item> ELVEN_WORLD;
	public static final RegistryObject<Item> WIND_BLADE_PROJECTILE;
	static {
		RED_GEM = REGISTRY.register("red_gem", RedGemItem::new);
		SHAPENED_OBSIDIAN = REGISTRY.register("shapened_obsidian", ShapenedObsidianItem::new);
		OBSIDIAN_SWORD = REGISTRY.register("obsidian_sword", ObsidianSwordItem::new);
		ADVENTURERS_LEATHER_ARMOR_CHESTPLATE = REGISTRY.register("adventurers_leather_armor_chestplate", AdventurersLeatherArmorItem.Chestplate::new);
		ADVENTURERS_LEATHER_ARMOR_BOOTS = REGISTRY.register("adventurers_leather_armor_boots", AdventurersLeatherArmorItem.Boots::new);
		BROKEN_RED_GEM = REGISTRY.register("broken_red_gem", BrokenRedGemItem::new);
		MANA_SOUL = REGISTRY.register("mana_soul", ManaSoulItem::new);
		MANA_INFUSED_STONE = block(TheElementOfChaosMcModBlocks.MANA_INFUSED_STONE, new Item.Properties().rarity(Rarity.RARE));
		ELEVEN_PORTAL = block(TheElementOfChaosMcModBlocks.ELEVEN_PORTAL, new Item.Properties().rarity(Rarity.EPIC).fireResistant());
		ICESTAIRS = block(TheElementOfChaosMcModBlocks.ICESTAIRS);
		ICEBRICKS = block(TheElementOfChaosMcModBlocks.ICEBRICKS, new Item.Properties().rarity(Rarity.UNCOMMON).fireResistant());
		ICEBRICKSSLABS = block(TheElementOfChaosMcModBlocks.ICEBRICKSSLABS, new Item.Properties().rarity(Rarity.UNCOMMON));
		POLISHED_ICE = block(TheElementOfChaosMcModBlocks.POLISHED_ICE, new Item.Properties().rarity(Rarity.UNCOMMON));
		POLISHED_ICE_SLABS = block(TheElementOfChaosMcModBlocks.POLISHED_ICE_SLABS, new Item.Properties().rarity(Rarity.UNCOMMON));
		POLISHED_ICE_BRICKS = block(TheElementOfChaosMcModBlocks.POLISHED_ICE_BRICKS);
		ELVINA_WOOD = block(TheElementOfChaosMcModBlocks.ELVINA_WOOD);
		STRIPPED_ELVINA_WOOD = block(TheElementOfChaosMcModBlocks.STRIPPED_ELVINA_WOOD);
		ELVINA_LEAVES = block(TheElementOfChaosMcModBlocks.ELVINA_LEAVES);
		ELVEN_WORLD = REGISTRY.register("elven_world", ElvenWorldItem::new);
		WIND_BLADE_PROJECTILE = REGISTRY.register("wind_blade_projectile", WindBladeProjectileItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return block(block, new Item.Properties());
	}

	private static RegistryObject<Item> block(RegistryObject<Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}