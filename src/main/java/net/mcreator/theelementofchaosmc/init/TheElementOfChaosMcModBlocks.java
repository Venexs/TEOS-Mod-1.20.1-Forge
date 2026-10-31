/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theelementofchaosmc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.theelementofchaosmc.block.*;
import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

public class TheElementOfChaosMcModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, TheElementOfChaosMcMod.MODID);
	public static final RegistryObject<Block> MANA_INFUSED_STONE;
	public static final RegistryObject<Block> ELEVEN_PORTAL;
	public static final RegistryObject<Block> ICESTAIRS;
	public static final RegistryObject<Block> ICEBRICKS;
	public static final RegistryObject<Block> ICEBRICKSSLABS;
	public static final RegistryObject<Block> POLISHED_ICE;
	public static final RegistryObject<Block> POLISHED_ICE_SLABS;
	public static final RegistryObject<Block> POLISHED_ICE_BRICKS;
	public static final RegistryObject<Block> ELVINA_WOOD;
	public static final RegistryObject<Block> STRIPPED_ELVINA_WOOD;
	public static final RegistryObject<Block> ELVINA_LEAVES;
	public static final RegistryObject<Block> ELVEN_WORLD_PORTAL;
	static {
		MANA_INFUSED_STONE = REGISTRY.register("mana_infused_stone", ManaInfusedStoneBlock::new);
		ELEVEN_PORTAL = REGISTRY.register("eleven_portal", ElevenPortalBlock::new);
		ICESTAIRS = REGISTRY.register("icestairs", IcestairsBlock::new);
		ICEBRICKS = REGISTRY.register("icebricks", IcebricksBlock::new);
		ICEBRICKSSLABS = REGISTRY.register("icebricksslabs", IcebricksslabsBlock::new);
		POLISHED_ICE = REGISTRY.register("polished_ice", PolishedIceBlock::new);
		POLISHED_ICE_SLABS = REGISTRY.register("polished_ice_slabs", PolishedIceSlabsBlock::new);
		POLISHED_ICE_BRICKS = REGISTRY.register("polished_ice_bricks", PolishedIceBricksBlock::new);
		ELVINA_WOOD = REGISTRY.register("elvina_wood", ElvinaWoodBlock::new);
		STRIPPED_ELVINA_WOOD = REGISTRY.register("stripped_elvina_wood", StrippedElvinaWoodBlock::new);
		ELVINA_LEAVES = REGISTRY.register("elvina_leaves", ElvinaLeavesBlock::new);
		ELVEN_WORLD_PORTAL = REGISTRY.register("elven_world_portal", ElvenWorldPortalBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}