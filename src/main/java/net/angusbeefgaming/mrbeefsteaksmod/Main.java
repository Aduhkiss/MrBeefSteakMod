package net.angusbeefgaming.mrbeefsteaksmod;

import com.github.mrebhan.ingameaccountswitcher.MR;

import net.angusbeefgaming.backend.UserManager;
import net.angusbeefgaming.mrbeefsteaksmod.command.GirlfriendCommand;
import net.angusbeefgaming.mrbeefsteaksmod.command.RankCommand;
import net.angusbeefgaming.mrbeefsteaksmod.command.ResetCoinsCommand;
import net.angusbeefgaming.mrbeefsteaksmod.events.Coins;
import net.angusbeefgaming.mrbeefsteaksmod.events.MainMenuRank;
import net.angusbeefgaming.mrbeefsteaksmod.events.NameTags;
import net.angusbeefgaming.mrbeefsteaksmod.events.PlayerChat;
import net.angusbeefgaming.mrbeefsteaksmod.girlfriend.Girlfriend;
import net.angusbeefgaming.mrbeefsteaksmod.proxy.CommonProxy;
import net.angusbeefgaming.mrbeefsteaksmod.util.ServerUtil;
import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import the_fireplace.ias.config.ConfigValues;
import the_fireplace.ias.events.ClientEvents;
import the_fireplace.iasencrypt.Standards;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, clientSideOnly = true)
public class Main {
	// Test
	@Instance
	public static Main instance;
	
	public static Girlfriend gf;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static Configuration config;
	private static Property CASESENSITIVE_PROPERTY;
	private static Property ENABLERELOG_PROPERTY;

	public static void syncConfig(){
		ConfigValues.CASESENSITIVE = CASESENSITIVE_PROPERTY.getBoolean();
		ConfigValues.ENABLERELOG = ENABLERELOG_PROPERTY.getBoolean();
		if(config.hasChanged())
			config.save();
	}
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e) {
		// Config Ranks
		UserManager.setupAccountStore();
		
		MinecraftForge.EVENT_BUS.register(PlayerChat.class);
		MinecraftForge.EVENT_BUS.register(Coins.class);
		MinecraftForge.EVENT_BUS.register(ServerUtil.class);
		
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent e) {
		System.out.println("Creating Girlfriend Instance.");
		
		gf = new Girlfriend("Sarah");
		
		ClientCommandHandler.instance.registerCommand((ICommand)new GirlfriendCommand());
		ClientCommandHandler.instance.registerCommand((ICommand)new ResetCoinsCommand());
		ClientCommandHandler.instance.registerCommand((ICommand) new RankCommand());
		
		MR.init();
		MinecraftForge.EVENT_BUS.register(new ClientEvents());
		
		MinecraftForge.EVENT_BUS.register(new MainMenuRank());
		MinecraftForge.EVENT_BUS.register(new NameTags());
		
		Standards.importAccounts();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e) {
		System.out.println("Welcome to MrBeefSteaks Mod! Created by Atticus Zambrana (MrBeefSteak)");
		
		Main.proxy.postInit();
	}
	
	
	public static Girlfriend getGirlfriend() {
		return gf;
	}
}
