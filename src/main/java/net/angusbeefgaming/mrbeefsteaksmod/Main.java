package net.angusbeefgaming.mrbeefsteaksmod;

import com.github.mrebhan.ingameaccountswitcher.MR;

import net.angusbeefgaming.anticheat.GiraffeCheatDetection;
import net.angusbeefgaming.backend.Rank;
import net.angusbeefgaming.backend.UserManager;
import net.angusbeefgaming.backend.http.VPN;
import net.angusbeefgaming.mrbeefsteaksmod.command.GirlfriendCommand;
import net.angusbeefgaming.mrbeefsteaksmod.command.RankCommand;
import net.angusbeefgaming.mrbeefsteaksmod.command.ResetCoinsCommand;
import net.angusbeefgaming.mrbeefsteaksmod.command.ResetListsCommand;
import net.angusbeefgaming.mrbeefsteaksmod.events.Coins;
import net.angusbeefgaming.mrbeefsteaksmod.events.MainMenuRank;
import net.angusbeefgaming.mrbeefsteaksmod.events.NameTags;
import net.angusbeefgaming.mrbeefsteaksmod.events.PlayerChat;
import net.angusbeefgaming.mrbeefsteaksmod.events.ReachDisplay;
import net.angusbeefgaming.mrbeefsteaksmod.girlfriend.Girlfriend;
import net.angusbeefgaming.mrbeefsteaksmod.proxy.CommonProxy;
import net.angusbeefgaming.mrbeefsteaksmod.util.ServerUtil;
import net.minecraft.client.Minecraft;
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
	
	// AntiCheat
	private static GiraffeCheatDetection anticheat;
	
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
	
	public static Main getInstance() {
		return instance;
	}
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent e) {
		
		// This might work... (It did work)
		Rank wakeUpPacket = UserManager.getRank("SomeRandomPerson");
		
		MinecraftForge.EVENT_BUS.register(PlayerChat.class);
		MinecraftForge.EVENT_BUS.register(Coins.class);
		MinecraftForge.EVENT_BUS.register(ServerUtil.class);
		
		// VPN Stuff
		VPN.getResultInfo();
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent e) {
		System.out.println("Creating Girlfriend Instance.");
		
		gf = new Girlfriend("Sarah");
		
		ClientCommandHandler.instance.registerCommand((ICommand)new GirlfriendCommand());
		ClientCommandHandler.instance.registerCommand((ICommand)new ResetCoinsCommand());
		ClientCommandHandler.instance.registerCommand((ICommand) new RankCommand());
		ClientCommandHandler.instance.registerCommand((ICommand) new ResetListsCommand());
		
		MR.init();
		MinecraftForge.EVENT_BUS.register(new ClientEvents());
		MinecraftForge.EVENT_BUS.register(new MainMenuRank());
		MinecraftForge.EVENT_BUS.register(NameTags.class);
		MinecraftForge.EVENT_BUS.register(ReachDisplay.class);
		
		Standards.importAccounts();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent e) {
		System.out.println("Welcome to MrBeefSteaks Mod! Created by Atticus Zambrana (MrBeefSteak)");
		
		Main.proxy.postInit();
		
		// VPN Blocker
		
		if(VPN.vpnCheck()) {
			System.out.println("YOUR GAME WAS CLOSED FOR THE REASON: VPN USAGE IS NOT ALLOWED.");
			Minecraft.getMinecraft().shutdown();
		}
		else {
			System.out.println("NO VPN FOUND! YOUR GOOD TO GO!");
		}
		
		// Start the AntiCheat System
		anticheat = new GiraffeCheatDetection();
		
	}
	
	
	public static Girlfriend getGirlfriend() {
		return gf;
	}
	
	// Getter for the AntiCheat
	public static GiraffeCheatDetection getAntiCheat() {
		return anticheat;
	}
	
	public static String getMyVersion() {
		return Reference.VERSION;
	}
}
