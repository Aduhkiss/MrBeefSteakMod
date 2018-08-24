package net.angusbeefgaming.mrbeefsteaksmod.util;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class ServerUtil {
	private static Server currentServer;
	
	public static Server getServer() {
		return currentServer;
	}
	
    @SubscribeEvent
    public static void playerLoggedIn(final FMLNetworkEvent.ClientConnectedToServerEvent event) {
        if(!Minecraft.getMinecraft().isSingleplayer() && event.getManager().getRemoteAddress().toString().toLowerCase().contains("hypixel.net")) {
        	currentServer = Server.HYPIXEL;
        	System.out.println("You are connected to the Hypixel Network!");
        	return;
        }
        if(!Minecraft.getMinecraft().isSingleplayer() && event.getManager().getRemoteAddress().toString().toLowerCase().contains("mineplex.com")) {
        	currentServer = Server.MINEPLEX;
        	System.out.println("You are connected to the Mineplex Network!");
        	return;
        }
        if(!Minecraft.getMinecraft().isSingleplayer() && event.getManager().getRemoteAddress().toString().toLowerCase().contains("skycade.net")) {
        	currentServer = Server.SKYCADE;
        	System.out.println("You are connected to the Skycade Network!");
        	return;
        }
        System.out.println("You are not connected to a supported Server!");
        currentServer = Server.NONE;
    }
}
