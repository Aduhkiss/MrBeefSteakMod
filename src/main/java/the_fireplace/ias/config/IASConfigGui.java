package the_fireplace.ias.config;

import net.angusbeefgaming.mrbeefsteaksmod.Main;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import the_fireplace.ias.tools.Reference;

/**
 * This is the config gui
 * @author The_Fireplace
 */
public class IASConfigGui extends GuiConfig {

	public IASConfigGui(GuiScreen parentScreen) {
		super(parentScreen, new ConfigElement(Main.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MODID, false, false, GuiConfig.getAbridgedConfigPath(Main.config.toString()));
	}

}
