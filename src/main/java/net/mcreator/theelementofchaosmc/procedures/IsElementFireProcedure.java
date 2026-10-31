package net.mcreator.theelementofchaosmc.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.theelementofchaosmc.network.TheElementOfChaosMcModVariables;

public class IsElementFireProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getCapability(TheElementOfChaosMcModVariables.PLAYER_VARIABLES).orElseGet(TheElementOfChaosMcModVariables.PlayerVariables::new).magic_type == 0) {
			return true;
		}
		return false;
	}
}