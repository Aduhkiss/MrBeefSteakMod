package net.angusbeefgaming.mrbeefsteaksmod.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

// Make all code in here Client Sided Only!
@SideOnly(Side.CLIENT)
public class ReachDisplay {
	// Atticus' Version of the Reach Display Mod embedded into my mod
	
	// This will also use AntiCheat Code so yeah.
	
	static String reachData = "Hasn't attacked";
	
	// After a certain amount of time, we will clear the last distance.
	static int counter = 0;
	
	@SubscribeEvent
	public static void clear(RenderGameOverlayEvent e) {
        if (e.isCancelable() || e.getType() != ElementType.EXPERIENCE) {
            return;
        }
		if(counter >= 100) {
			reachData = "Hasn't attacked";
			counter = 0;
		}
		else {
			counter++;
		}
	}
	
    @SubscribeEvent
    public static void render(RenderGameOverlayEvent event) {
        if (event.isCancelable() || event.getType() != ElementType.EXPERIENCE) {
            return;
        }
        FontRenderer fRender = Minecraft.getMinecraft().fontRenderer;
        fRender.drawString("\247f" + reachData, 5, 15, 0);
    }
	
    @SubscribeEvent
    public static void onAttack(final AttackEntityEvent event) {
    	EntityPlayer player = event.getEntityPlayer();
    	Entity attacked = event.getTarget();
    	
    	double distance = Math.floor(Math.sqrt(player.getDistanceSq(attacked)));
    	String distanceS = (String.valueOf(distance)).substring(0, 1);
    	
    	reachData = distanceS + " Blocks";
    	counter = 0;
    }
}
