package net.angusbeefgaming.mrbeefsteaksmod.events;

import net.angusbeefgaming.backend.Rank;
import net.angusbeefgaming.backend.UserManager;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NameTags {
    @SubscribeEvent
    public void getName(PlayerEvent.NameFormat event) {
    	Rank playerRank = UserManager.getRank(event.getDisplayname());
    	if(playerRank == Rank.YOUTUBER) {
    		event.setDisplayname("\247c\247lYOUTUBER \247f" + event.getDisplayname());
    	}
    	if(playerRank == Rank.ADMINISTRATOR) {
    		event.setDisplayname("\247c\247lDEVELOPER \247f" + event.getDisplayname());
    	}
    }
}
