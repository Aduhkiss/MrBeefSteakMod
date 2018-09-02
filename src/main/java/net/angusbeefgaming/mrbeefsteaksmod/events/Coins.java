package net.angusbeefgaming.mrbeefsteaksmod.events;

import net.angusbeefgaming.mrbeefsteaksmod.util.Server;
import net.angusbeefgaming.mrbeefsteaksmod.util.ServerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Coins {
	public static int totalCoins = 0;
    @SubscribeEvent
    public static void xd(ClientChatReceivedEvent event) {
    	if(!(ServerUtil.getServer() == Server.HYPIXEL)) return;
    	
        String message = event.getMessage().getUnformattedText();
        //message is the message which the client receives.
        if(message.startsWith("+") && message.contains("coins") && !message.endsWith("for being generous")) {
            //Checks if the coin message you got isn't the tip message 
            String[] splittedMessage = message.split("coins");
            message = splittedMessage[0].replace("+", "");
            message = message.replace(" ", "");
            int coins = Integer.parseInt(message);
            totalCoins = totalCoins + coins;
            return;
        }
    }
    
    @SubscribeEvent
    public static void render(RenderGameOverlayEvent event) {
    	if(!(ServerUtil.getServer() == Server.HYPIXEL)) return;
        if (event.isCancelable() || event.getType() != ElementType.EXPERIENCE) {
            return;
        }
        FontRenderer fRender = Minecraft.getMinecraft().fontRenderer;
        fRender.drawString("\2476\247lCoins Earned: " + totalCoins, 5, 5, 0);
    }
}
