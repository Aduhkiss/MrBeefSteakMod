package net.angusbeefgaming.mrbeefsteaksmod.events;

import net.angusbeefgaming.backend.Rank;
import net.angusbeefgaming.backend.UserManager;
import net.angusbeefgaming.backend.http.Backend;
import net.angusbeefgaming.mrbeefsteaksmod.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class MainMenuRank {
	boolean hasData = false;
	String latest = "";
	
	@SubscribeEvent
	public void onTick(TickEvent.RenderTickEvent t) {
		GuiScreen screen = Minecraft.getMinecraft().currentScreen;
		if (screen instanceof GuiMainMenu) {
			if(UserManager.getRank(Minecraft.getMinecraft().getSession().getUsername()) == Rank.DEFAULT) return;
			if(UserManager.getRank(Minecraft.getMinecraft().getSession().getUsername()) == Rank.YOUTUBER) {
				screen.drawCenteredString(Minecraft.getMinecraft().fontRenderer, I18n.format("\247f\247lYou are a, \247c\247lYOUTUBER") +".", screen.width / 2, screen.height / 5 + 48 + 72 + 12 + 55, 0xFFCC8888);	
			}
			if(UserManager.getRank(Minecraft.getMinecraft().getSession().getUsername()) == Rank.ADMINISTRATOR) {
				screen.drawCenteredString(Minecraft.getMinecraft().fontRenderer, I18n.format("\247f\247lYou are a, \247c\247lDEVELOPER") +".", screen.width / 2, screen.height / 5 + 48 + 72 + 12 + 55, 0xFFCC8888);	
			}
		}
	}
}
