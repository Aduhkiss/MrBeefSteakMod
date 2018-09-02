package net.angusbeefgaming.backend.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.minecraft.client.Minecraft;

public class Backend {
	private static final String USER_AGENT = "Mozilla/5.0";
	
	static int tries = 0;
	
	
	/**
	 * Used to get data from Infinity Client Backend Server
	 * Created by Atticus Zambrana
	 * @param url
	 * @throws Exception
	 */
	public static String get(String url) throws Exception {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode;
		try {
			responseCode = con.getResponseCode();
		}
		catch(IOException e) {
			System.out.println("MrBeefSteaks Mod> An Error has occured, and your game has to close.");
			e.printStackTrace();
			Minecraft.getMinecraft().shutdown();
		}
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		return response.toString();
	}
	
	public static String getData(String param) {
		if(tries == 5) {
			System.out.println("MrBeefSteak >> There was an error while contacting the official MrBeefSteak Server. Out of Attempts.");
			return "DEAFULT";
		}
		try {
			return get("https://savory-kiss.glitch.me/" + param);
		} catch (Exception e) {
			System.out.println("MrBeefSteak >> There was an error while contacting the official MrBeefSteak Server. Attempting again...");
			tries++;
			getData(param);
		}
		return null;
	}
}
