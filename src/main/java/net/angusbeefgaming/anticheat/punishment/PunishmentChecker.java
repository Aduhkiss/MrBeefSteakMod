package net.angusbeefgaming.anticheat.punishment;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class PunishmentChecker {
	@SubscribeEvent
	public void onServerJoin(FMLNetworkEvent.ClientConnectedToServerEvent e) {
		// When the player joins a server,
		
		// Make a check to the api and get if the player is currently Giraffe Banned.
		
	}
}
