package net.angusbeefgaming.mrbeefsteaksmod.events;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerChat {
	@SubscribeEvent
	public static void onChat(ServerChatEvent e) {
		EntityPlayerMP player = e.getPlayer();
		
		
	}
}
