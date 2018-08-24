package net.angusbeefgaming.mrbeefsteaksmod.cosmetics;

import net.angusbeefgaming.backend.Rank;
import net.angusbeefgaming.backend.UserManager;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class LayerYouTuberAura implements LayerRenderer<AbstractClientPlayer>
{
    private static final ResourceLocation WITHER_ARMOR = new ResourceLocation("textures/entity/wither/wither_armor.png");
    private final RenderPlayer witherRenderer;
    private final ModelPlayer witherModel = new ModelPlayer(0.5F, false);

    public LayerYouTuberAura(RenderPlayer witherRendererIn)
    {
        this.witherRenderer = witherRendererIn;
    }

    public void doRenderLayer(AbstractClientPlayer entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale)
    {
    	if(UserManager.getRank(entitylivingbaseIn.getName()) == Rank.YOUTUBER) {
            GlStateManager.depthMask(!entitylivingbaseIn.isInvisible());
            this.witherRenderer.bindTexture(WITHER_ARMOR);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            float f = (float)entitylivingbaseIn.ticksExisted + partialTicks;
            float f1 = MathHelper.cos(f * 0.02F) * 3.0F;
            float f2 = f * 0.01F;
            GlStateManager.translate(f1, f2, 0.0F);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableBlend();
            float f3 = 0.5F;
            GlStateManager.color(f3, f3, f3, 1.0F);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(1, 1);
            this.witherModel.setLivingAnimations(entitylivingbaseIn, p_177141_2_, p_177141_3_, partialTicks);
            this.witherModel.setModelAttributes(this.witherRenderer.getMainModel());
            this.witherModel.render(entitylivingbaseIn, p_177141_2_, p_177141_3_, p_177141_5_, p_177141_6_, p_177141_7_, scale);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
    	}
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}
