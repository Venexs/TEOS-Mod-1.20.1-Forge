/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.theelementofchaosmc.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.theelementofchaosmc.TheElementOfChaosMcMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TheElementOfChaosMcModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheElementOfChaosMcMod.MODID);
	public static final RegistryObject<CreativeModeTab> ELEMENTOF_CHAOS = REGISTRY.register("elementof_chaos",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.the_element_of_chaos_mc.elementof_chaos")).icon(() -> new ItemStack(TheElementOfChaosMcModItems.RED_GEM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(TheElementOfChaosMcModItems.RED_GEM.get());
				tabData.accept(TheElementOfChaosMcModItems.SHAPENED_OBSIDIAN.get());
				tabData.accept(TheElementOfChaosMcModItems.OBSIDIAN_SWORD.get());
				tabData.accept(TheElementOfChaosMcModItems.MANA_SOUL.get());
				tabData.accept(TheElementOfChaosMcModBlocks.MANA_INFUSED_STONE.get().asItem());
				tabData.accept(TheElementOfChaosMcModBlocks.ELEVEN_PORTAL.get().asItem());
				tabData.accept(TheElementOfChaosMcModBlocks.ICESTAIRS.get().asItem());
				tabData.accept(TheElementOfChaosMcModBlocks.ICEBRICKS.get().asItem());
				tabData.accept(TheElementOfChaosMcModBlocks.ICEBRICKSSLABS.get().asItem());
				tabData.accept(TheElementOfChaosMcModBlocks.POLISHED_ICE.get().asItem());
				tabData.accept(TheElementOfChaosMcModBlocks.POLISHED_ICE_SLABS.get().asItem());
				tabData.accept(TheElementOfChaosMcModBlocks.POLISHED_ICE_BRICKS.get().asItem());
				tabData.accept(TheElementOfChaosMcModBlocks.ELVINA_WOOD.get().asItem());
				tabData.accept(TheElementOfChaosMcModBlocks.STRIPPED_ELVINA_WOOD.get().asItem());
				tabData.accept(TheElementOfChaosMcModBlocks.ELVINA_LEAVES.get().asItem());
				tabData.accept(TheElementOfChaosMcModItems.ELVEN_WORLD.get());
			}).withSearchBar().build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(TheElementOfChaosMcModItems.RED_GEM.get());
			tabData.accept(TheElementOfChaosMcModItems.ADVENTURERS_LEATHER_ARMOR_CHESTPLATE.get());
			tabData.accept(TheElementOfChaosMcModItems.ADVENTURERS_LEATHER_ARMOR_BOOTS.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(TheElementOfChaosMcModItems.SHAPENED_OBSIDIAN.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(TheElementOfChaosMcModItems.OBSIDIAN_SWORD.get());
			tabData.accept(TheElementOfChaosMcModItems.BROKEN_RED_GEM.get());
			tabData.accept(TheElementOfChaosMcModItems.ELVEN_WORLD.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(TheElementOfChaosMcModBlocks.ELEVEN_PORTAL.get().asItem());
			tabData.accept(TheElementOfChaosMcModBlocks.ELVINA_LEAVES.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(TheElementOfChaosMcModBlocks.ELVINA_WOOD.get().asItem());
			tabData.accept(TheElementOfChaosMcModBlocks.STRIPPED_ELVINA_WOOD.get().asItem());
		}
	}
}