package net.mcreator.theelementofchaosmc.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.theelementofchaosmc.network.TheElementOfChaosMcModVariables;

public class FireElementPickProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getCapability(TheElementOfChaosMcModVariables.PLAYER_VARIABLES).orElseGet(TheElementOfChaosMcModVariables.PlayerVariables::new).element_pick == 0) {
			return true;
		}
		return false;
	}
}