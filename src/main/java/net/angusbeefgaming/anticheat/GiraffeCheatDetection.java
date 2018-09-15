package net.angusbeefgaming.anticheat;

import net.angusbeefgaming.anticheat.checks.*;
import net.minecraftforge.common.MinecraftForge;

public class GiraffeCheatDetection {
	
	boolean active;
	
	public GiraffeCheatDetection() {
		System.out.println("GIRAFFE > Giraffe Cheat Detection has been started!");
		active = true;
		registerChecks();
	}
	
	private void registerChecks() {
		MinecraftForge.EVENT_BUS.register(new Reach());
	}
	
	public boolean isActive() { 
		return active;
	}
	
	public void disableDetection() {
		if(active) {
			return;
		}
		active = true;
		System.out.println("GIRAFFE > Cheat Detection has been ENABLED!");
	}
	
	public void enableDetection() {
		if(!active) {
			return;
		}
		active = false;
		System.out.println("GIRAFFE > Cheat Detection has been DISABLED!");
	}
}
