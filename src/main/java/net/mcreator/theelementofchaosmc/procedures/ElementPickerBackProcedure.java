package net.mcreator.theelementofchaosmc.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.theelementofchaosmc.network.TheElementOfChaosMcModVariables;

public class ElementPickerBackProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(TheElementOfChaosMcModVariables.PLAYER_VARIABLES).orElseGet(TheElementOfChaosMcModVariables.PlayerVariables::new).element_pick == -1) {
			{
				var _playerVars = entity.getCapability(TheElementOfChaosMcModVariables.PLAYER_VARIABLES).orElse(null);
				if (_playerVars != null) {
					_playerVars.element_pick = 2;
					_playerVars.markSyncDirty();
				}
			}
		}
		{
			var _playerVars = entity.getCapability(TheElementOfChaosMcModVariables.PLAYER_VARIABLES).orElse(null);
			if (_playerVars != null) {
				_playerVars.element_pick = entity.getCapability(TheElementOfChaosMcModVariables.PLAYER_VARIABLES).orElseGet(TheElementOfChaosMcModVariables.PlayerVariables::new).element_pick - 1;
				_playerVars.markSyncDirty();
			}
		}
	}
}