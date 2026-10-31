package net.mcreator.theelementofchaosmc.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

public class PolishedIceSlabsBlock extends SlabBlock {
	public PolishedIceSlabsBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(3f, 1f).requiresCorrectToolForDrops());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 7;
	}
}