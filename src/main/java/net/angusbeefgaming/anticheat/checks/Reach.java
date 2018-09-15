package net.angusbeefgaming.anticheat.checks;

import net.angusbeefgaming.anticheat.Detector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Reach extends Detector {
	
    public Reach() {
		super("Reach", "Atticus Zambrana");
	}

	@SubscribeEvent
    public void onAttack(final AttackEntityEvent event) {
    	EntityPlayer player = event.getEntityPlayer();
    	Entity attacked = event.getTarget();
    	
    	double distance = Math.floor(Math.sqrt(player.getDistanceSq(attacked)));
    	
    	if(distance >= 4.5) {
    		// Player flagged the detector
    		flag(event.getEntityPlayer());
    		report("Player Suspected of Reach.");
    	}
    }
}
