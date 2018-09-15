package net.angusbeefgaming;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;

public class Remover {
	public static int flags = 0;
	
	public static void checkForKick(EntityPlayerMP pl) {
		if(flags >= 5) {
			// Remove the player from the game
			flags = 0;
			// For the time being, I just have the anticheat shut down the game.
			// Please someone tell me how to simply kick them...
			System.out.println("");
			System.out.println("");
			System.out.println("======== GIRAFFE CHEAT DETECTION ========");
			System.out.println("YOUR GAME HAS BEEN CLOSED DUE TO CHEATING");
			System.out.println("FOUND BY THE GIRRAFE CHEAT DETECTION SYSTEMS.");
			System.out.println("");
			System.out.println("THIS INCIDENT HAS BEEN LOGGED AND REPORTED");
			System.out.println("TO ANTICHEAT BACKEND SERVERS. PLEASE NOTE THAT");
			System.out.println("ANY KIND OF CHEATING IS A BANNABLE OFFENCE!");
			System.out.println("=========================================");
			System.out.println("");
			System.out.println("");
			Minecraft.getMinecraft().shutdown();
		}
		else {
			// Ignore the player, but add a violation to their flags counter
			flags++;
		}
	}
}
