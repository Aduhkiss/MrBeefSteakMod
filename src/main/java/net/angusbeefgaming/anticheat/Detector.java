package net.angusbeefgaming.anticheat;

import net.angusbeefgaming.Remover;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public abstract class Detector {
	private String detectorName;
	private String author;
	
	public Detector(String detectorName, String author) {
		this.detectorName = detectorName;
		this.author = author;
		System.out.println("GIRAFFE > Registered Detector '" + detectorName + "' by " + author);
	}
	/*
	 * Giraffe Cheat Detector
	 * Written by Atticus Zambrana
	 */
	
	public void flag(EntityPlayer pl) {
		Remover.checkForKick((EntityPlayerMP) pl);
	}
	
	public void report(String message) {
		System.out.println("GIRAFFE > " + message);
	}
}
