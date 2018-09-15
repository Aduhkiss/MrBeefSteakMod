package net.angusbeefgaming.anticheat.checks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.angusbeefgaming.anticheat.Detector;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoClicker extends Detector {
	
	private static List<Long> clicks;
	private boolean hasClickedThisTick;

	public AutoClicker() {
		super("AutoClicker", "Atticus Zambrana");
		clicks = new ArrayList<Long>();
		this.hasClickedThisTick = false;
	}
	
    @SubscribeEvent
    public void onMouse(final MouseEvent event) {
        if (event.getButton() != 0) {
            return;
        }
        if (event.isButtonstate() && this.hasClickedThisTick) {
            event.setCanceled(true);
            return;
        }
        if (event.isButtonstate()) {
            this.hasClickedThisTick = true;
            addClick();
        }
    }
    
    @SubscribeEvent
    public void onClientTick(final TickEvent.ClientTickEvent event) {
        this.hasClickedThisTick = false;
        // Should we check for any unusual cps's here?
        int cps = getClicks();
        if(cps >= 12) {//12
        	flag(Minecraft.getMinecraft().world.getPlayerEntityByName(Minecraft.getMinecraft().getSession().getUsername()));
        	report("You are clicking too fast!");
        }
    }
	
    public static void addClick() {
        clicks.add(System.currentTimeMillis());
    }
    
    public static int getClicks() {
        final Iterator<Long> iterator = clicks.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < System.currentTimeMillis() - 1000L) {
                iterator.remove();
            }
        }
        return clicks.size();
    }
}
