package net.angusbeefgaming.mrbeefsteaksmod.proxy;

import net.angusbeefgaming.mrbeefsteaksmod.cosmetics.LayerStaffAura;
import net.angusbeefgaming.mrbeefsteaksmod.cosmetics.LayerYouTuberAura;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	@Override
	public
	void postInit() {
		Minecraft.getMinecraft().gameSettings.setModelPartEnabled(EnumPlayerModelParts.CAPE, true);
		
        for (final RenderPlayer render : Minecraft.getMinecraft().getRenderManager().getSkinMap().values()) {
        	
            render.addLayer((LayerRenderer) new LayerStaffAura(render));
            render.addLayer((LayerRenderer) new LayerYouTuberAura(render));
        }
		
	}
	
}
