package net.angusbeefgaming.anticheat.checks;

import java.util.Iterator;
import java.util.List;

import net.angusbeefgaming.anticheat.Detector;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoClicker extends Detector {
	
	private static List<Long> clicks;
	private boolean hasClickedThisTick;

	public AutoClicker() {
		super("AutoClicker", "Atticus Zambrana");
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
        System.out.println("DEBUG: " + getClicks());
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
