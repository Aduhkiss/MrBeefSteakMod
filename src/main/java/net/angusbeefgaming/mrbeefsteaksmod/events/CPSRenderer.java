package net.angusbeefgaming.mrbeefsteaksmod.events;

import org.lwjgl.opengl.GL11;

import net.angusbeefgaming.anticheat.checks.AutoClicker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CPSRenderer {
    
    @SubscribeEvent
    public void onRenderGameOverlay(final RenderGameOverlayEvent event) {
        if (event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE || event.isCancelable()) {
            return;
        }
        if (Minecraft.getMinecraft().currentScreen != null || Minecraft.getMinecraft().gameSettings.showDebugInfo) {
            return;
        }
        final int cps = AutoClicker.getClicks();
        final String text = cps + " Clicks";
        final boolean blendEnabled = GL11.glIsEnabled(3042);
        GL11.glDisable(3042);
        //Gui.drawRect(0, 20, 0 + Minecraft.getMinecraft().fontRenderer.getStringWidth(text) + 4, 20 + 12, 1140850688);
        Minecraft.getMinecraft().fontRenderer.drawString(text, 0 + 4, 25 + 2, -1);
        if (blendEnabled) {
            GL11.glEnable(3042);
        }
    }
}
