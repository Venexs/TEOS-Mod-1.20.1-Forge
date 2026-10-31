package net.mcreator.theelementofchaosmc.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class ManaInfusedStoneBlock extends Block {
	public ManaInfusedStoneBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.DEEPSLATE).strength(5f, 1f).lightLevel(blockstate -> 2).requiresCorrectToolForDrops().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).replaceable());
	}
}