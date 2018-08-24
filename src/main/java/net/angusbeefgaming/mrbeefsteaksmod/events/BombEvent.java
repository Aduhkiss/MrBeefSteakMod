package net.angusbeefgaming.mrbeefsteaksmod.events;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BombEvent {
	@SubscribeEvent
	public static void creeperClick(PlayerInteractEvent e) {
		if(e.getEntity().getName().equals("Creeper")) {
			EntityCreeper c = (EntityCreeper) e.getEntity();
			
			c.setFire(10);
		}
	}
}
